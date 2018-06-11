package com.fintecher.contract.service.Impl;

import com.fintecher.contract.entity.ContractBatch;
import com.fintecher.contract.entity.ContractInfo;
import com.fintecher.contract.entity.ContractRecord;
import com.fintecher.contract.mapper.ContractInfoMapper;
import com.fintecher.contract.service.*;
import com.fintecher.contract.service.ContractBuilder.ContractBuilder;
import com.fintecher.contract.util.*;
import com.fintecher.contract.vo.ContractParams;
import com.fintecher.contract.vo.ContractResourceModel;
import com.fintecher.contract.vo.JsonModel;
import com.fintecher.contract.vo.ResultJson;
import com.fintecher.util.ZWDateUtil;
import com.github.pagehelper.StringUtil;
import io.swagger.annotations.Scope;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.mapper.entity.Example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * @Author wxc
 * @Data 2018/2/2 11:39
 * @Description 合同生成实现类
 */
@Service
public class ContractServiceImpl implements ContractService {
    private Logger logger = LoggerFactory.getLogger(ContractServiceImpl.class);
    private static final String CHEDAI = "CHEDAI";

    @Autowired
    private ContractGeneratorService contractGeneratorService;

    @Autowired
    private ContractInfoService contractInfoService;

    @Autowired
    private ContractBatchService contractBatchService;

    @Autowired
    private ContractFactory contractFactory;

    @Autowired
    private ContractRecordService contractRecordService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ContractInfoMapper contractInfoMapper;

    @Override
    public ResultJson buildContract(Long orderId,String contectEnum) {
        try {
            ContractParams contractParams = new ContractParams();
            contractParams.setOrderId(orderId);
            MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
            param.add("orderId", orderId);
            param.add("contectEnum", contectEnum);
            ResponseEntity responseResult =restTemplate.postForEntity("http://service-manage/productOrder/findContectJsonDate",param,JSONObject.class);
            net.sf.json.JSONObject obj = (JSONObject)responseResult.getBody();
            obj = obj.getJSONObject("object");
            ResultJson result = new ResultJson();//返回结果

            //渠道信息,测试用，固定
            String channelCode = "000023-0002";
            String channelName = "易保全111";
            String channelStatus = "1";
            contractParams.setChanelCode(channelCode);

            // ===== 生成批次号信息 ============
            ContractBatch contractBatch = createContractBatch(contractParams);


            // ===== 生成合同相关信息,并且验证参数 =================
            JsonModel jm = createOneContract(contractBatch, obj,orderId);

            // =========== 生成合同 =================== start
            List<ContractInfo> contractInfos = (List<ContractInfo>) jm.getObject();//拿到合同信息
            try {
                Example example = new Example(ContractBatch.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("relationNumber", contractParams.getOrderNumber());
                List<ContractBatch> batchList = contractBatchService.selectByExample(example);
                // TODO: 2018/2/5 判断合同批次是否失效
//                batchList.forEach(batch -> {
//                    if("".equalsIgnoreCase(batch.getTypeCode())){
//                        batch.setStatus("3");
//                        contractBatchService.update(batch);
//                    }
//                });
                //保存批次号
                contractBatchService.save(contractBatch);
                //保存合同信息
                contractInfos.forEach(contractInfo -> {
                    contractInfo.setContractBatchId(String.valueOf(contractBatch.getId()));
                    contractInfoService.save(contractInfo);
                });
            } catch (Exception e) {
                logger.error(e.getMessage());
                e.printStackTrace();
                result.setCode(ContractCode.EXCE20002.getCode());
                result.setInfo(ContractCode.EXCE20002.getInfo() + "-" + e.getMessage());
                return result;
            }

            //遍历合同信息
            int pdfCount = 0;
            int caCount = 0;
            int succPdfCount = 0;
            int succCaCount = 0;
            int faiSignCount = 0;
            List<JSONObject> jsonParms = new ArrayList<JSONObject>();
            JSONObject jsonCA = new JSONObject();
            JSONObject json = new JSONObject();
            for (ContractInfo contractInfo : contractInfos) {
                // 开始处理时间
                contractInfo.setCreateTime(ZWDateUtil.getDateTime());//开始生成时间
                // PDF计划数量累加
                pdfCount++;
                //判断是否需要签章  CA计划数量累加
                if (contractFactory.generateEnum(contractInfo.getContractEnum()).isNeedCa()) {
                    caCount++;
                }

                //生成合同记录
                ContractRecord contractRecord = new ContractRecord();
                contractRecord.setPdfStatus("1"); // record状态:0:本次需要重新创建,1：本次不需要重新创建
                contractRecord.setCreateTime(ZWDateUtil.getDateTime());//记录创建时间
                contractRecord.setContractNumber(contractInfo.getContractNumber());//合同编号
                //同步生成合同
                try {
                    jm = ContractFactory.getInstance().generate(JSONObject.fromObject(contractInfo),contractInfo.getContractEnum(),contractBatch.getCaChannel());
//                    jm = contractGeneratorService.generate((Map<String, Object>) JSONObject.toBean(JSONObject.fromObject(contractInfo), Map.class),
//                            contractBatch.getCaChannel());
                    //需要签章
                    if (contractFactory.generateEnum(contractInfo.getContractEnum()).isNeedCa()) {
                        // recordCA状态:0:本次需要重新创建,1：本次不需要创建
                        contractRecord.setCaStatus("1");
                        // CA成功
                        if (jm != null && ContractCode.SUCC00005.getCode().equals(jm.getCode())) {
                            succPdfCount++;
                            succCaCount++;
                            contractInfo.setCaStatus(ContractInfo.STATUS_TRUE);
                            contractInfo.setPdfStatus(ContractInfo.STATUS_TRUE);
                            contractInfo.setContractPdfStatus(ContractInfo.PDF_SUC);
                            contractInfo.setContractCaStatus(ContractInfo.CA_SUC);
                            contractInfo.setStatus("3");// 0:数据生成中,1:合同生产中,2:CA签章中，3:批次完成，4:作废/失效
                            // FTP上传成功
                            contractBatch.setFtpStatus("1");
                        }
                        // PDF生成成功，CA失败
                        else if (jm != null && ContractCode.EXCE00004.getCode().equals(jm.getCode())) {
                            succPdfCount++;
                            contractInfo.setCaStatus(ContractInfo.STATUS_TRUE);
                            contractInfo.setPdfStatus(ContractInfo.STATUS_TRUE);
                            contractInfo.setContractPdfStatus(ContractInfo.PDF_SUC);
                            contractInfo.setContractCaStatus(ContractInfo.CA_EXEC);// 签章异常
                            contractInfo.setStatus("2");// 0:数据生成中,1:合同生产中,2:CA签章中，3:批次完成，4:作废/失效
                            // FTP上传成功
                            contractBatch.setFtpStatus("0");
                        } else {// 异常：标记生成PDF或CA均异常
                            contractInfo.setPdfStatus(ContractInfo.STATUS_FALSE);
                            contractInfo.setContractPdfStatus(ContractInfo.PDF_FALSE);
                            contractInfo.setContractCaStatus(ContractInfo.CA_EXEC);// 签章异常
                            contractInfo.setStatus("5");// 0:数据生成中,1:合同生产中,2:CA签章中，3:批次完成，4:作废/失效,5:异常
                            // PDF上传失败
                            contractBatch.setFtpStatus("0");
                        }
                        // 返回状态
                        contractRecord.setCaResult(jm.getCode() + ":" + jm.getInfo());
                    } else {// 不需要签章
                        // record状态:0:本次需要重新创建,1：本次不需要创建
                        contractRecord.setCaStatus("0");
                        contractInfo.setContractCaStatus(ContractInfo.CA_FALSE);// 不需要签章
                        // PDF生成成功
                        if (jm != null && ContractCode.SUCC00001.getCode().equals(jm.getCode())) {
                            succPdfCount++;
                            contractInfo.setPdfStatus(ContractInfo.STATUS_TRUE);
                            contractInfo.setContractPdfStatus(ContractInfo.PDF_SUC);
                            contractInfo.setStatus("3");// 0:数据生成中,1:合同生产中,2:CA签章中，3:批次完成，4:作废/失效,5:异常
                            // FTP上传成功
                            contractBatch.setFtpStatus("1");
                        } else
                        // 异常：标记生成PDF
                        {
                            contractInfo.setPdfStatus(ContractInfo.STATUS_FALSE);
                            contractInfo.setContractPdfStatus(ContractInfo.PDF_FALSE);
                            contractInfo.setStatus("5");// 0:数据生成中,1:合同生产中,2:CA签章中，3:批次完成，4:作废/失效,5:异常
                            // FTP上传失败
                            contractBatch.setFtpStatus("0");
                        }
                        // 返回状态
                        contractRecord.setPdfResult(jm.getCode() + ":" + jm.getInfo());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    contractInfo.setContractPdfStatus(ContractInfo.PDF_EXEC);
                    contractInfo.setContractCaStatus(ContractInfo.CA_EXEC);
                    contractInfo.setPdfStatus(ContractInfo.STATUS_FALSE);
                }
                contractInfo.setFinishTime(ZWDateUtil.getNowDateTime().toString());//合同生成结束时间
//                contractInfoService.update(contractInfo);//更新合同信息
                contractRecord.setContractInfoId(contractInfo.getId().toString());//合同信息ID保存
                contractRecordService.save(contractRecord);//保存合同生成记录
            }
            // =========== 生成合同 =================== end

            //重新查找数据库中已经更新的pdf的服务器文件地址
            Example example = new Example(ContractInfo.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("contractBatchId",contractBatch.getId());
            List<ContractInfo> list = contractInfoService.selectByExample(example);

            JSONObject resultJson = new JSONObject();
            resultJson.put("contractBatch", contractBatch);
            resultJson.put("contractStatus",contractInfos);
            resultJson.put("contractInfo", list);
            result.setResultJson(resultJson);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成合同信息和验证相关的参数
     *
     * @param cb
     * @param obj
     * @return
     */
    private JsonModel createOneContract(ContractBatch cb, JSONObject obj,Long orderId) {
        JsonModel jm = new JsonModel();
        List<ContractInfo> cis = new ArrayList<>();
        ContractInfo contractInfo = new ContractInfo();

        String contractNumber = ZWDateUtil.getDate() + "-" + "0" + Math.round(Math.random() * 10);//测试用，合同编号生成规则待定

        contractInfo.setContractNumber(contractNumber);//合同编号
        contractInfo.setContractBatchId("");//批次号id，为null
        //获取模板信息
        String contractEnum = obj.getString("contractEnum");

        //获取对应的合同构建类
        ContractBuilder contractBuilder = contractFactory.generateEnum(contractEnum);
        if (Objects.isNull(contractBuilder)) {
            jm.setCode(ContractCode.EXCE10009.getCode());
            jm.setInfo(ContractCode.EXCE10009.getInfo() + "-" + contractEnum);
            return jm;
        }
        //获取对应的合同枚举
        ContractEnum ce = contractBuilder.getContractEnum();
        if (Objects.isNull(ce)) {
            jm.setCode(ContractCode.EXCE10010.getCode());
            jm.setInfo(ContractCode.EXCE10010.getInfo() + "-" + contractEnum);
            return jm;
        }
        contractInfo.setContractEnum(contractEnum); //设置模板信息
        contractInfo.setContractTemplateUrl(ce.getTemplateName());//模板url
        contractInfo.setPdfStatus("1");//是否生成pdf文件

        //是否需要CA签章
        contractInfo.setPdfStatus("0"); // pdf 生成状态
        contractInfo.setCaStatus(ContractInfo.STATUS_FALSE); // ca 生成状态
        JSONObject contractDataJson = obj.getJSONObject("contractDataJson");

        // 验证必要参数是否为空
      /*  if (!contractDataJson.toString().isEmpty()) {
            JsonModel dataJsonModel = contractBuilder.verificationParam(contractDataJson);
            if (!ContractCode.SUCC00002.getCode().equals(dataJsonModel.getCode())) {
                jm.setCode(dataJsonModel.getCode());
                jm.setInfo(dataJsonModel.getInfo() + "-" + contractDataJson + "-" + contractEnum);
                return jm;
            }
            contractInfo.setContractDataJson(contractDataJson.toString());//合同生成数据
        }*/
        contractInfo.setContractDataJson(contractDataJson.toString());//合同生成数据
        contractInfo.setCreateTime(ZWDateUtil.getDateTime());//生成时间
        contractInfo.setStatus("0");//批次状态	0:数据生成中,1:批次处理异常:,2:批次完成，3:作废/失效
        contractInfo.setIsasyncSign(cb.getIsasyncSign());//是否异步签章
        contractInfo.setOrderNumber(obj.get("uniqueCode").toString());//业务编号
        contractInfo.setContractName(ce.getName());//合同名称
        contractInfo.setOrderId(orderId);

        //合同和签章地址
        String pdfUrl = CHEDAI.concat(File.separator).concat(ZWDateUtil.getDate()).concat(File.separator).concat(cb.getRelationNumber()).concat(
                contractEnum).concat(File.separator).concat(contractInfo.getContractName()).concat(".pdf");
        String caPdfUrl = CHEDAI.concat(File.separator).concat(ZWDateUtil.getDate()).concat(File.separator).concat(cb.getRelationNumber()).concat(
                contractEnum).concat(File.separator).concat("ca").concat(File.separator).concat(contractInfo.getContractName()).concat(".pdf");
        if (contractBuilder.isNeedCa()) {
            contractInfo.setCaPdfUrl(caPdfUrl); // 签章pdf 生成地址
        }
        contractInfo.setPdfUrl(pdfUrl);//合同地址
        //是否需要签章
        if (contractBuilder.isNeedCa()) {
            contractInfo.setContractCaStatus(ContractInfo.CA_LOADING);
        } else {
            contractInfo.setContractCaStatus(ContractInfo.CA_FALSE);
        }
        cis.add(contractInfo);
        jm.setCode(ContractCode.SUCC10003.getCode());
        jm.setInfo(ContractCode.SUCC10003.getInfo());
        jm.setObject(cis);
        return jm;
    }

    @Override
    public ResultJson buildContracts(ContractParams contractParams) {
        try {

            net.sf.json.JSONArray arr = net.sf.json.JSONArray.fromObject(contractParams.getArr());
            ResultJson result = new ResultJson();//返回结果

            //渠道信息,测试用，固定
            String channelCode = "000023-0002";
            String channelName = "易保全111";
            String channelStatus = "1";
            contractParams.setChanelCode(channelCode);

            // ===== 生成批次号信息 ============
            ContractBatch contractBatch = createContractBatch(contractParams);

            // ===== 生成合同相关信息,并且验证参数 =================
            JsonModel jm = createContractInfo(contractBatch, arr);

            // =========== 生成合同 =================== start
            List<ContractInfo> contractInfos = (List<ContractInfo>) jm.getObject();//拿到合同信息
            try {
                Example example = new Example(ContractBatch.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("relationNumber", contractParams.getOrderNumber());
                List<ContractBatch> batchList = contractBatchService.selectByExample(example);
                // TODO: 2018/2/5 判断合同批次是否失效
//                batchList.forEach(batch -> {
//                    if("".equalsIgnoreCase(batch.getTypeCode())){
//                        batch.setStatus("3");
//                        contractBatchService.update(batch);
//                    }
//                });
                //保存批次号
                contractBatchService.save(contractBatch);
                //保存合同信息
                contractInfos.forEach(contractInfo -> {
                    contractInfo.setContractBatchId(String.valueOf(contractBatch.getId()));
                    contractInfoService.save(contractInfo);
                });
            } catch (Exception e) {
                logger.error(e.getMessage());
                e.printStackTrace();
                result.setCode(ContractCode.EXCE20002.getCode());
                result.setInfo(ContractCode.EXCE20002.getInfo() + "-" + e.getMessage());
                return result;
            }

            //遍历合同信息
            int pdfCount = 0;
            int caCount = 0;
            int succPdfCount = 0;
            int succCaCount = 0;
            int faiSignCount = 0;
            List<JSONObject> jsonParms = new ArrayList<JSONObject>();
            JSONObject jsonCA = new JSONObject();
            JSONObject json = new JSONObject();
            for (ContractInfo contractInfo : contractInfos) {
                // 开始处理时间
                contractInfo.setCreateTime(ZWDateUtil.getDateTime());//开始生成时间
                // PDF计划数量累加
                pdfCount++;
                //判断是否需要签章  CA计划数量累加
                if (contractFactory.generateEnum(contractInfo.getContractEnum()).isNeedCa()) {
                    caCount++;
                }

                //生成合同记录
                ContractRecord contractRecord = new ContractRecord();
                contractRecord.setPdfStatus("1"); // record状态:0:本次需要重新创建,1：本次不需要重新创建
                contractRecord.setCreateTime(ZWDateUtil.getDateTime());//记录创建时间
                contractRecord.setContractNumber(contractInfo.getContractNumber());//合同编号
                //同步生成合同
                try {
                    jm = ContractFactory.getInstance().generate(JSONObject.fromObject(contractInfo),contractInfo.getContractEnum(),contractBatch.getCaChannel());
//                    jm = contractGeneratorService.generate((Map<String, Object>) JSONObject.toBean(JSONObject.fromObject(contractInfo), Map.class),
//                            contractBatch.getCaChannel());
                    //需要签章
                    if (contractFactory.generateEnum(contractInfo.getContractEnum()).isNeedCa()) {
                        // recordCA状态:0:本次需要重新创建,1：本次不需要创建
                        contractRecord.setCaStatus("1");
                        // CA成功
                        if (jm != null && ContractCode.SUCC00005.getCode().equals(jm.getCode())) {
                            succPdfCount++;
                            succCaCount++;
                            contractInfo.setCaStatus(ContractInfo.STATUS_TRUE);
                            contractInfo.setPdfStatus(ContractInfo.STATUS_TRUE);
                            contractInfo.setContractPdfStatus(ContractInfo.PDF_SUC);
                            contractInfo.setContractCaStatus(ContractInfo.CA_SUC);
                            contractInfo.setStatus("3");// 0:数据生成中,1:合同生产中,2:CA签章中，3:批次完成，4:作废/失效
                            // FTP上传成功
                            contractBatch.setFtpStatus("1");
                        }
                        // PDF生成成功，CA失败
                        else if (jm != null && ContractCode.EXCE00004.getCode().equals(jm.getCode())) {
                            succPdfCount++;
                            contractInfo.setCaStatus(ContractInfo.STATUS_TRUE);
                            contractInfo.setPdfStatus(ContractInfo.STATUS_TRUE);
                            contractInfo.setContractPdfStatus(ContractInfo.PDF_SUC);
                            contractInfo.setContractCaStatus(ContractInfo.CA_EXEC);// 签章异常
                            contractInfo.setStatus("2");// 0:数据生成中,1:合同生产中,2:CA签章中，3:批次完成，4:作废/失效
                            // FTP上传成功
                            contractBatch.setFtpStatus("0");
                        } else {// 异常：标记生成PDF或CA均异常
                            contractInfo.setPdfStatus(ContractInfo.STATUS_FALSE);
                            contractInfo.setContractPdfStatus(ContractInfo.PDF_FALSE);
                            contractInfo.setContractCaStatus(ContractInfo.CA_EXEC);// 签章异常
                            contractInfo.setStatus("5");// 0:数据生成中,1:合同生产中,2:CA签章中，3:批次完成，4:作废/失效,5:异常
                            // PDF上传失败
                            contractBatch.setFtpStatus("0");
                        }
                        // 返回状态
                        contractRecord.setCaResult(jm.getCode() + ":" + jm.getInfo());
                    } else {// 不需要签章
                        // record状态:0:本次需要重新创建,1：本次不需要创建
                        contractRecord.setCaStatus("0");
                        contractInfo.setContractCaStatus(ContractInfo.CA_FALSE);// 不需要签章
                        // PDF生成成功
                        if (jm != null && ContractCode.SUCC00001.getCode().equals(jm.getCode())) {
                            succPdfCount++;
                            contractInfo.setPdfStatus(ContractInfo.STATUS_TRUE);
                            contractInfo.setContractPdfStatus(ContractInfo.PDF_SUC);
                            contractInfo.setStatus("3");// 0:数据生成中,1:合同生产中,2:CA签章中，3:批次完成，4:作废/失效,5:异常
                            // FTP上传成功
                            contractBatch.setFtpStatus("1");
                        } else
                        // 异常：标记生成PDF
                        {
                            contractInfo.setPdfStatus(ContractInfo.STATUS_FALSE);
                            contractInfo.setContractPdfStatus(ContractInfo.PDF_FALSE);
                            contractInfo.setStatus("5");// 0:数据生成中,1:合同生产中,2:CA签章中，3:批次完成，4:作废/失效,5:异常
                            // FTP上传失败
                            contractBatch.setFtpStatus("0");
                        }
                        // 返回状态
                        contractRecord.setPdfResult(jm.getCode() + ":" + jm.getInfo());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    contractInfo.setContractPdfStatus(ContractInfo.PDF_EXEC);
                    contractInfo.setContractCaStatus(ContractInfo.CA_EXEC);
                    contractInfo.setPdfStatus(ContractInfo.STATUS_FALSE);
                }
                contractInfo.setFinishTime(ZWDateUtil.getNowDateTime().toString());//合同生成结束时间
//                contractInfoService.update(contractInfo);//更新合同信息
                contractRecord.setContractInfoId(contractInfo.getId().toString());//合同信息ID保存
                contractRecordService.save(contractRecord);//保存合同生成记录
            }
            // =========== 生成合同 =================== end

            //重新查找数据库中已经更新的pdf的服务器文件地址
            Example example = new Example(ContractInfo.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("contractBatchId",contractBatch.getId());
            List<ContractInfo> list = contractInfoService.selectByExample(example);

            JSONObject resultJson = new JSONObject();
            resultJson.put("contractBatch", contractBatch);
            resultJson.put("contractStatus",contractInfos);
            resultJson.put("contractInfo", list);
            result.setResultJson(resultJson);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成合同批次号
     *
     * @param contractParams
     * @return
     */
    private ContractBatch createContractBatch(ContractParams contractParams) {
        ContractBatch cb = new ContractBatch();
        cb.setBatchNumber(UUID.randomUUID().toString() + ZWDateUtil.getNowDateTime());//合同批次号
        cb.setRelationNumber(contractParams.getOrderId().toString());//订单ID
        cb.setCreateTime(ZWDateUtil.getDateTime());//创建时间
        cb.setCaChannel(contractParams.getChanelCode());//渠道code
        cb.setIssync(contractParams.getIssync());//是否同步生成
        cb.setIsasyncSign(contractParams.getIsasyncSign());//是否异步签章
        return cb;
    }

    /**
     * 生成合同信息和验证相关的参数
     *
     * @param cb
     * @param arr
     * @return
     */
    private JsonModel createContractInfo(ContractBatch cb, JSONArray arr) {
        JsonModel jm = new JsonModel();
        List<ContractInfo> cis = new ArrayList<>();
        for (Object object : arr) {// 合同信息
            ContractInfo contractInfo = new ContractInfo();

            JSONObject model = JSONObject.fromObject(object);

            String contractNumber = ZWDateUtil.getDate() + "-" + "0" + Math.round(Math.random() * 10);//测试用，合同编号生成规则待定

            contractInfo.setContractNumber(contractNumber);//合同编号
            contractInfo.setContractBatchId("");//批次号id，为null
            //获取模板信息
            String contractEnum = model.getString("contractEnum");

            //获取对应的合同构建类
            ContractBuilder contractBuilder = contractFactory.generateEnum(contractEnum);
            if (Objects.isNull(contractBuilder)) {
                jm.setCode(ContractCode.EXCE10009.getCode());
                jm.setInfo(ContractCode.EXCE10009.getInfo() + "-" + contractEnum);
                return jm;
            }
            //获取对应的合同枚举
            ContractEnum ce = contractBuilder.getContractEnum();
            if (Objects.isNull(ce)) {
                jm.setCode(ContractCode.EXCE10010.getCode());
                jm.setInfo(ContractCode.EXCE10010.getInfo() + "-" + contractEnum);
                return jm;
            }
            contractInfo.setContractEnum(contractEnum); //设置模板信息
            contractInfo.setContractTemplateUrl(ce.getTemplateName());//模板url
            contractInfo.setPdfStatus("1");//是否生成pdf文件

            //是否需要CA签章
            contractInfo.setPdfStatus("0"); // pdf 生成状态
            contractInfo.setCaStatus(ContractInfo.STATUS_FALSE); // ca 生成状态
            JSONObject contractDataJson = model.getJSONObject("contractDataJson");

            // 验证必要参数是否为空
            if (!contractDataJson.toString().isEmpty()) {
                JsonModel dataJsonModel = contractBuilder.verificationParam(contractDataJson);
                if (!ContractCode.SUCC00002.getCode().equals(dataJsonModel.getCode())) {
                    jm.setCode(dataJsonModel.getCode());
                    jm.setInfo(dataJsonModel.getInfo() + "-" + contractDataJson + "-" + contractEnum);
                    return jm;
                }
                contractInfo.setContractDataJson(contractDataJson.toString());//合同生成数据
            }

            contractInfo.setCreateTime(ZWDateUtil.getDateTime());//生成时间
            contractInfo.setStatus("0");//批次状态	0:数据生成中,1:批次处理异常:,2:批次完成，3:作废/失效
            contractInfo.setIsasyncSign(cb.getIsasyncSign());//是否异步签章
            contractInfo.setOrderNumber(model.get("uniqueCode").toString());//业务编号
            contractInfo.setContractName(ce.getName());//合同名称

            //合同和签章地址
            String pdfUrl = CHEDAI.concat(File.separator).concat(ZWDateUtil.getDate()).concat(File.separator).concat(cb.getRelationNumber()).concat(
                    contractEnum).concat(File.separator).concat(contractInfo.getContractName()).concat(".pdf");
            String caPdfUrl = CHEDAI.concat(File.separator).concat(ZWDateUtil.getDate()).concat(File.separator).concat(cb.getRelationNumber()).concat(
                    contractEnum).concat(File.separator).concat("ca").concat(File.separator).concat(contractInfo.getContractName()).concat(".pdf");
            if (contractBuilder.isNeedCa()) {
                contractInfo.setCaPdfUrl(caPdfUrl); // 签章pdf 生成地址
            }
            contractInfo.setPdfUrl(pdfUrl);//合同地址
            //是否需要签章
            if (contractBuilder.isNeedCa()) {
                contractInfo.setContractCaStatus(ContractInfo.CA_LOADING);
            } else {
                contractInfo.setContractCaStatus(ContractInfo.CA_FALSE);
            }
            cis.add(contractInfo);
        }
        jm.setCode(ContractCode.SUCC10003.getCode());
        jm.setInfo(ContractCode.SUCC10003.getInfo());
        jm.setObject(cis);
        return jm;
    }

    @Override
    public String previewContract(Long contractId) {
        try {
            String html = null;
            ContractInfo ci = contractInfoService.findById(contractId);
            if (Objects.isNull(ci)) {
                html = "根据所传id没有查到相应合同信息记录";
                return html;
            }

            ContractBuilder cb = ContractFactory.getInstance().generateEnum(ci.getContractEnum());
//            String template = cb.getContractEnum().getTemplateName();
//            if (template.equals("fromFTP")) {
//                html = "合同模版的预览请从服务器上直接下载预览";
//                return html;
//
//            }
            // 合同参数
            Map<String, Object> contParam = null;
            if (StringUtil.isEmpty(ci.getContractDataJson())) {
                contParam = new HashMap<String, Object>();
            } else {
//                JSONObject contractParam = cb.reBuildParam(ci.getContractDataJson());
                JSONObject params = JSONObject.fromObject(ci.getContractDataJson());
                contParam = params;
            }

            // TODO: 2018/2/5 放入用户图片
//            JSONObject custPicture = new JSONObject();
//            String upload_url = new String();
//            if (params.containsKey("picture")) {
//                if (ChkUtil.isEmpty(params.get("picture").toString())
//                        || "null".equals(params.get("picture").toString())) {
//                    upload_url = "";
//                } else {
//                    custPicture = (JSONObject) params.get("picture");
//                    // 获取客户图片路径
//                    upload_url = custPicture.getString("upload_url") != null ? custPicture.get("upload_url").toString()
//                            : "";
//                    String pictureName = upload_url.substring(44, upload_url.lastIndexOf(".") + 4);
//                    custPicture.put("pictureName", pictureName);
//                }
//                params.put("custPicture", custPicture);
//            }
            String docNumber = ci.getContractNumber();
            contParam.put("contractPrimaryKey", docNumber);
            html = HtmlGenerator.htmlGenerate(ci.getContractTemplateUrl(), contParam);
            return html;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String createBlankContract(String enumCode) {
        File file = null;
        OutputStream out = null;
        FileSystemResource resource = null;
        MultiValueMap<String,Object> param = null;
        try{
            //获取合同创建类
            ContractBuilder contractBuilder = contractFactory.generateEnum(enumCode);
            //获取合同枚举
            ContractEnum contractEnum = contractBuilder.getContractEnum();
            //替换模板名称为html
            String temp = contractEnum.getTemplateName().replace(".ftl",".html");
            //使用html生成
            String htmlContent = HtmlGenerator.blankHtmlGenerate(temp);
            //创建目录
            File directory_tem = new File("");// 参数为空
            // 项目根目录
            String courseFile = directory_tem.getCanonicalPath();
            //临时保存目录
            String systemPath = courseFile.concat(File.separator).concat("pdfHtml").concat(File.separator);
            // 合同临时保存路径
            String directoryName = systemPath.concat("cd").concat(File.separator);
            // 找到文件夹目录，如不存在就创建
            File directory = new File(directoryName);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            out = new FileOutputStream(systemPath.concat(temp));
            //生成pdf
            PdfGenerator.generate(htmlContent, out, null);
            //pdf模板上传
            String pdfUrl = null;//pdf文件路径
            file = new File(systemPath.concat(temp));//找到文件
            resource = new FileSystemResource(file);
            param = new LinkedMultiValueMap<>();
            param.add("file",resource);//上传文件参数
            ResponseEntity<String> result = restTemplate.postForEntity(Constant.FILE_SERVICE_URL.concat("addUploadFileUrl"),param,String.class);
            JSONObject jsonObject = JSONObject.fromObject(result);
            //删除临时pdf文件
            File deleteFile = new File(systemPath.concat(temp));
            if (deleteFile.exists()) {
                deleteFile.delete();
            }
            //删除临时目录
            File deleDirect = new File(directoryName);
            if (deleDirect.exists()) {
                deleDirect.deleteOnExit();
            }
            //判断文件上传状态
            if(jsonObject.get("statusCodeValue").equals(200)){
                pdfUrl = Arrays.asList(result.toString().split(",")).get(1);
                return pdfUrl;
            } else {
                return pdfUrl;
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            try{
                if(Objects.isNull(out)){
                    out.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                if (Objects.isNull(file)){
                    file.delete();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public ContractInfo getContractNum(Long orderId){
        return contractInfoMapper.getContractNum(orderId);
    }

}
