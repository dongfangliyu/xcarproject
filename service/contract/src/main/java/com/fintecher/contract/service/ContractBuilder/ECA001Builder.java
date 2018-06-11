package com.fintecher.contract.service.ContractBuilder;

import com.fintecher.contract.service.ContractGeneratorService;
import com.fintecher.contract.util.ContractCode;
import com.fintecher.contract.util.ContractEnum;
import com.fintecher.contract.vo.ContractModel.ECA001Model;
import com.fintecher.contract.vo.JsonModel;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author wxc
 * @Data 2018/2/6 14:37 
 * @Description 借款协议模板（测试）
 */
@Component
public class ECA001Builder implements ContractBuilder{

    private ECA001Model eCA001Model;//合同对应的model
    private ContractEnum contractEnum = ContractEnum.EC_A001;//合同对应的枚举

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
            JSONObject fromContractDataJson = JSONObject.fromObject(param.get("contractDataJson"));
            contractDataJson.put("map", fromContractDataJson);
            contractDataJson.put("cust_ic", fromContractDataJson.get("custIc"));
            contractDataJson.put("cust_mobile", fromContractDataJson.get("mobileNo"));
            contractDataJson.put("cust_nm", fromContractDataJson.get("custName"));
            contractDataJson.put("email", fromContractDataJson.get("email"));
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
        return ContractEnum.EC_A001;
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
        eCA001Model = new ECA001Model();
        eCA001Model = (ECA001Model) JSONObject.toBean(param, ECA001Model.class);
        return eCA001Model.verificationParam(param);
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
