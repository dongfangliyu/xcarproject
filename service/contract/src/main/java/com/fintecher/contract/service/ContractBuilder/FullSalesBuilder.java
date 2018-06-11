package com.fintecher.contract.service.ContractBuilder;

import com.fintecher.contract.service.ContractGeneratorService;
import com.fintecher.contract.util.ContractCode;
import com.fintecher.contract.util.ContractEnum;
import com.fintecher.contract.vo.ContractModel.FullSalesModel;
import com.fintecher.contract.vo.JsonModel;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @System:
 * @Auther: DangWenXiang
 * @Description:
 * @Date:Created on 2018/2/22 15:04
 * @Modified By:
 */
@Component
public class FullSalesBuilder implements ContractBuilder{
    private FullSalesModel fullSalesModel;//合同对应model类
    private ContractEnum contractEnum=ContractEnum.FULL_SALES;//合同对应的枚举
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
            contractDataJson.put("map",fromObject);
            contractDataJson.put("contractNum",fromObject.get("contractNum"));
            contractDataJson.put("custName",fromObject.get("custName"));
            contractDataJson.put("custContactAdd",fromObject.get("custContactAdd"));
            contractDataJson.put("custPhone",fromObject.get("custPhone"));
            contractDataJson.put("postalCode",fromObject.get("postalCode"));
            contractDataJson.put("custIdName",fromObject.get("custIdName"));
            contractDataJson.put("custId",fromObject.get("custId"));
            contractDataJson.put("theSecondCode",fromObject.get("theSecondCode"));
            contractDataJson.put("theSecondFax",fromObject.get("theSecondFax"));
            contractDataJson.put("theSecondLeader",fromObject.get("theSecondLeader"));
            contractDataJson.put("theSecondLeaderNumber",fromObject.get("theSecondLeaderNumber"));
            contractDataJson.put("carLogo",fromObject.get("carLogo"));
            contractDataJson.put("modelName",fromObject.get("modelName"));
            contractDataJson.put("carColor",fromObject.get("carColor"));
            contractDataJson.put("carConfiguration",fromObject.get("carConfiguration"));
            contractDataJson.put("vehicleAmount",fromObject.get("vehicleAmount"));
            contractDataJson.put("carSellNumber",fromObject.get("carSellNumber"));
            contractDataJson.put("carPriceSum",fromObject.get("carPriceSum"));
            contractDataJson.put("carSum",fromObject.get("carSum"));
            contractDataJson.put("addressForService",fromObject.get("addressForService"));
            contractDataJson.put("percentagePrice",fromObject.get("percentagePrice"));
            contractDataJson.put("carBePayment",fromObject.get("carBePayment"));
            contractDataJson.put("carPayment",fromObject.get("carPayment"));
            contractDataJson.put("carBargain",fromObject.get("carBargain"));
            contractDataJson.put("carPercent",fromObject.get("carPercent"));
            contractDataJson.put("carPercentPrice",fromObject.get("carPercentPrice"));
            contractDataJson.put("carLicenseFee",fromObject.get("carLicenseFee"));
            contractDataJson.put("carInsuranceFee",fromObject.get("carInsuranceFee"));
            contractDataJson.put("carPurchaseFax",fromObject.get("carPurchaseFax"));
            contractDataJson.put("carBoatFax",fromObject.get("carBoatFax"));
            contractDataJson.put("carMortgage",fromObject.get("carMortgage"));
            contractDataJson.put("carDecoration",fromObject.get("carDecoration"));
            contractDataJson.put("chargeOther",fromObject.get("chargeOther"));
            contractDataJson.put("another",fromObject.get("another"));
            param.put("contractDataJson",contractDataJson);
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
        return ContractEnum.FULL_SALES;
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
        fullSalesModel=new FullSalesModel();
        fullSalesModel = (FullSalesModel) JSONObject.toBean(param, FullSalesModel.class);
        return fullSalesModel.verificationParam(param);
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
    public List<Map<String, Object>> getPosition(String channel, Map<String, Object> variablesMap)
    {
        return null;
    }
}