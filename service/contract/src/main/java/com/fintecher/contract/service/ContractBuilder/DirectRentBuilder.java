package com.fintecher.contract.service.ContractBuilder;

import com.fintecher.contract.service.ContractGeneratorService;
import com.fintecher.contract.util.ContractCode;
import com.fintecher.contract.util.ContractEnum;
import com.fintecher.contract.vo.ContractModel.DirectRentModel;
import com.fintecher.contract.vo.JsonModel;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author wxc
 * @Data 2018/2/8 10:32
 * @Description 直租-汽车融资租赁合同构建类
 */
@Component
public class DirectRentBuilder implements ContractBuilder{

    private DirectRentModel directRentModel;//合同对应的model
    private ContractEnum contractEnum = ContractEnum.DIRECT_RENT;//合同对应的枚举

    @Autowired
    private ContractGeneratorService contractGeneratorService;


    @Override
    public JsonModel build(JSONObject param, String modeCode, String uniqueCode) {
        JsonModel jm = new JsonModel();
        //默认 返回code 成功
        jm.setCode("SUCCESS");
        jm.setInfo("合同生成成功！");

        //编辑参数
        JSONObject contractDataJson = new JSONObject();
        //验证modeCode是否正常
        if (valdateModeCode(modeCode)) {
            JSONObject fromObject = JSONObject.fromObject(param.get("contractDataJson"));
            contractDataJson.put("map", fromObject);
            contractDataJson.put("contractNum",fromObject.get("contractNum"));
            contractDataJson.put("signingDay",fromObject.get("signingDay"));
            contractDataJson.put("custName",fromObject.get("custName"));
            contractDataJson.put("custId",fromObject.get("custId"));
            contractDataJson.put("custIdAdd",fromObject.get("custIdAdd"));
            contractDataJson.put("custContactAdd",fromObject.get("custContactAdd"));
            contractDataJson.put("custPhone",fromObject.get("custPhone"));
            contractDataJson.put("guarantorName",fromObject.get("guarantorName"));
            contractDataJson.put("guarantorId",fromObject.get("guarantorId"));
            contractDataJson.put("guarantorIdAdd",fromObject.get("guarantorIdAdd"));
            contractDataJson.put("guarantorContactAdd",fromObject.get("guarantorContactAdd"));
            contractDataJson.put("guarantorPhone",fromObject.get("guarantorPhone"));
            contractDataJson.put("modelName",fromObject.get("modelName"));
            contractDataJson.put("seller",fromObject.get("seller"));
            contractDataJson.put("carOuterColor",fromObject.get("carOuterColor"));
            contractDataJson.put("carInsideColor",fromObject.get("carInsideColor"));
            contractDataJson.put("carNum",fromObject.get("carNum"));
            contractDataJson.put("engineNum",fromObject.get("engineNum"));
            contractDataJson.put("financingAmount",fromObject.get("financingAmount"));
            contractDataJson.put("vehicleAmount",fromObject.get("vehicleAmount"));
            contractDataJson.put("purchaseTax",fromObject.get("purchaseTax"));
            contractDataJson.put("installLicenseFee",fromObject.get("installLicenseFee"));
            contractDataJson.put("insuranceExpenses",fromObject.get("insuranceExpenses"));
            contractDataJson.put("travelTax",fromObject.get("travelTax"));
            contractDataJson.put("carMiscellaneousFees",fromObject.get("carMiscellaneousFees"));
            contractDataJson.put("gpsFee",fromObject.get("gpsFee"));
            contractDataJson.put("years",fromObject.get("years"));
            contractDataJson.put("yearsStart",fromObject.get("yearsStart"));
            contractDataJson.put("yearsEnd",fromObject.get("yearsEnd"));
            contractDataJson.put("eachRent",fromObject.get("eachRent"));
            contractDataJson.put("rentAmount",fromObject.get("rentAmount"));
            contractDataJson.put("paymentDay",fromObject.get("paymentDay"));
            contractDataJson.put("paymentFirstDay",fromObject.get("paymentFirstDay"));
            contractDataJson.put("paymentSecondDay",fromObject.get("paymentSecondDay"));
            contractDataJson.put("initialPayment",fromObject.get("initialPayment"));
            contractDataJson.put("depositCash",fromObject.get("depositCash"));
            contractDataJson.put("manageCost",fromObject.get("manageCost"));
            contractDataJson.put("periods",fromObject.get("periods"));
            contractDataJson.put("termInsurance",fromObject.get("termInsurance"));
            param.put("contractDataJson", contractDataJson);
            return contractGeneratorService.generate((Map<String, Object>) JSONObject.toBean(param, Map.class),modeCode, uniqueCode);
        }
        else {
            jm.setCode(ContractCode.EXCE00007.getCode());
            jm.setInfo(ContractCode.EXCE00007.getInfo());
        }
        return jm;
    }

    /**
     * 获取合同枚举
     * @return
     */
    @Override
    public ContractEnum getContractEnum() {
        return ContractEnum.DIRECT_RENT;
    }

    /**
     * 获取是否需要CA状态
     * @return
     */
    @Override
    public boolean isNeedCa() {
        return false;
    }

    /**
     * 验证合同参数
     */
    @Override
    public JsonModel verificationParam(JSONObject param) {
        directRentModel = new DirectRentModel();
        directRentModel = (DirectRentModel) JSONObject.toBean(param, DirectRentModel.class);
        return directRentModel.verificationParam(param);
    }

    /**
     * 验证枚举model
     * @param modeCode
     * @return
     */
    public boolean valdateModeCode(String modeCode) {
        if (modeCode.equals(contractEnum.getCode()))
            return true;
        return false;
    }

    @Override
    public List<Map<String, Object>> getPosition(String channel, Map<String, Object> variablesMap) {
        return null;
    }
}
