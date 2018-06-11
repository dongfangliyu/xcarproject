package com.fintecher.contract.service.ContractBuilder;

import com.fintecher.contract.util.ContractEnum;
import com.fintecher.contract.vo.JsonModel;
import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @Author wxc
 * @Data 2018/2/2 14:52
 * @Description 合同创建接口
 */
public interface ContractBuilder {

    /**
     * 生成合同的方法
     * @param param
     * @param modeCode
     * @param uniqueCode
     * @return
     */
     JsonModel build(JSONObject param, String modeCode, String uniqueCode);

    /**
     * 获取对应的合同
     * @return
     */
    ContractEnum getContractEnum();

    /**
     * 获取签章状态
     * @return
     */
    boolean isNeedCa();

    /**
     * 验证合同参数信息
     * @param param
     * @return
     */
    JsonModel verificationParam(JSONObject param);


    /**
     * 获取ca签章的签章位置
     * @param channel
     * @param variablesMap
     * @return
     */
    public List<Map<String, Object>> getPosition(String channel, Map<String,Object> variablesMap);
}
