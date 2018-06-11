package com.fintecher.contract.service.policy;

import com.fintecher.contract.service.ContractBuilder.ContractBuilder;
import net.sf.json.JSONObject;
import org.springframework.core.PriorityOrdered;

/**
 * @Author wxc
 * @Data 2018/2/6 13:41 
 * @Description 合同匹配策略接口
 */
public interface ContractGeneratorPolicy extends PriorityOrdered {
    /**
     * 通过参数判断是否能匹配对应的处理类
     * @param param
     * @param modeCode
     * @return
     */
    public boolean match(JSONObject param, String modeCode);

    /**
     * 获得匹配的策略处理类
     * @param param
     * @param modeCode
     * @return 策略处理类
     */
    public ContractBuilder get(JSONObject param, String modeCode);
}
