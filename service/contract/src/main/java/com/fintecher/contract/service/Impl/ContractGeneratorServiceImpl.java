package com.fintecher.contract.service.Impl;

import com.fintecher.contract.entity.ContractInfo;
import com.fintecher.contract.service.ContractBuilder.ContractBuilder;
import com.fintecher.contract.service.ContractGeneratorService;
import com.fintecher.contract.service.ContractInfoService;
import com.fintecher.contract.util.Constant;
import com.fintecher.contract.util.ContractCode;
import com.fintecher.contract.util.ContractFactory;
import com.fintecher.contract.util.CreatePdfUtil;
import com.fintecher.contract.util.caUtil.CaSignatureUtil;
import com.fintecher.contract.vo.JsonModel;
import com.fintecher.util.ZWStringUtils;
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

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * @Author wxc
 * @Data 2018/2/2 15:13
 * @Description
 */
@Service
public class ContractGeneratorServiceImpl implements ContractGeneratorService{

    private Logger logger = LoggerFactory.getLogger(ContractGeneratorServiceImpl.class);

    @Autowired
    ContractInfoService contractInfoService;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private ContractFactory contractFactory;

    @Override
    public JsonModel generate(Map<String, Object> variablesMap,String modeCode, String channel) {
        try{
            JsonModel jm = new JsonModel();
            JSONObject jb = JSONObject.fromObject(variablesMap.get("contractDataJson"));
            variablesMap.put("contractDataJson", jb.toString());
            //获取合同对象
            ContractInfo contractInfo = (ContractInfo)JSONObject.toBean(JSONObject.fromObject(variablesMap), ContractInfo.class);
            //获取合同参数
            Map<String, Object> contParam = null;
            if(ZWStringUtils.isEmpty(variablesMap.get("contractDataJson")) || "null".equals(variablesMap.get("contractDataJson"))){
                contParam = new HashMap<String,Object>();
            } else {
                contParam = JSONObject.fromObject(variablesMap.get("contractDataJson"));
            }

            String directoryFileName = "";// pdf临时文件目录
            String directoryName = "";// pdf目录
            String ret = "";

            String docNumber = contractInfo.getContractNumber();
            contParam.put("contractPrimaryKey", docNumber);
            logger.info("第一步生成PDF-begin");
            ret = CreatePdfUtil.generatorPdfUpload(JSONObject.fromObject(contParam), contParam, contractInfo.getPdfUrl(),
                    contractInfo.getContractName(),contractInfo.getContractTemplateUrl());
            logger.info("第一步生成PDF-end" + ret);

            //临时目录
            File directory_tem = new File("");// 参数为空
            String courseFile = directory_tem.getCanonicalPath();
            //生成的pdf文件地址
            String pdfUrl = courseFile.concat(File.separator).concat(contractInfo.getPdfUrl());


            //判断是否需要CA签章进行签章
            ContractBuilder contractBuilder = contractFactory.generateEnum(modeCode);
            if(contractBuilder.isNeedCa()){

                //获取对应签章的位置
                List<Map<String, Object>> signatures = contractBuilder.getPosition(channel, contParam);

                logger.info("生成签章--begin");
                JsonModel jsonModel = CaSignatureUtil.newCaSignature(pdfUrl,docNumber,channel,signatures,contractInfo.getCaPdfUrl(),"签章_"+contractInfo.getOrderNumber());
                logger.info("生成签章--end");
            }

            //文件上传
            File file = null;
            FileInputStream input = null;
//            //创建一个新的restemplate，使用自动装配时报错
//            RestTemplate restTemplate = new RestTemplate();
            try{
                file = new File(pdfUrl);
                FileSystemResource resource = new FileSystemResource(file);
                MultiValueMap<String,Object> param = new LinkedMultiValueMap<>();
//                input = new FileInputStream(file);
                param.add("file",resource);
//                MultipartFile multipartFile = new MockMultipartFile("file",
//                        file.getName(), "text/plain", IOUtils.toByteArray(input));
                logger.info("第二步上传pdf文件-begin");
                ResponseEntity<String> responseEntity = restTemplate.postForEntity(Constant.FILE_SERVICE_URL.concat("addUploadFileUrl"),param,String.class);
                logger.info("第二步上传pdf文件-end");

                //将服务器地址更新至数据库
                contractInfo.setPdfUrl(Arrays.asList(responseEntity.toString().split(",")).get(1));
                contractInfoService.updateSelective(contractInfo);

                // 删除文件
                logger.info("删除临时文件-begin");
                File deleteFile = new File(pdfUrl);
                if (deleteFile.exists()) {
                    deleteFile.delete();
                }
                logger.info("删除临时文件-end");

                //临时目录
                directoryName = courseFile.concat(File.separator).concat(contractInfo.getPdfUrl().substring(0,pdfUrl.lastIndexOf(File.separator)+1));
                // 删除目录
                logger.info("删除临时目录-begin");
                File directory = new File(directoryName);
                if (directory.exists()) {
                    directory.deleteOnExit();
                }
                logger.info("删除临时目录-end");

            } catch (Exception e){
                e.printStackTrace();
            } finally {
                //关闭流
                if (input != null) {
                    try {
                        input.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                //删除文件
                if (file != null) {
                    file.delete();
                }
            }
            if(!Objects.isNull(ret)){
                jm.setCode(ContractCode.SUCC00001.getCode());
                jm.setInfo(ContractCode.SUCC00001.getInfo());
                return jm;
            }
            return jm;
        }catch (Exception e){
            JsonModel jm = new JsonModel();
            jm.setCode(ContractCode.EXCE00003.getCode());
            jm.setInfo(ContractCode.EXCE00003.getInfo());
            e.printStackTrace();
            return jm;
        }
    }
}
