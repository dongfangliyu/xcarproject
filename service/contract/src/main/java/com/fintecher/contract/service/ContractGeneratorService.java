package com.fintecher.contract.service;

import com.fintecher.contract.vo.JsonModel;

import java.util.Map;

/**
 * @Author wxc
 * @Data 2018/2/2 15:09
 * @Description
 */
public interface ContractGeneratorService {

    /**
     * 合同生成方法
     * @param variablesMap
     * @param channel
     * @return
     */
     JsonModel generate(Map<String,Object> variablesMap,String modeCode ,String channel);

    /**
     * TODO
     * 参数验证
     */
}
