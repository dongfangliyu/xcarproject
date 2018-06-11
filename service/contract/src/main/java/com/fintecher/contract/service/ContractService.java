package com.fintecher.contract.service;

import com.fintecher.contract.entity.ContractInfo;
import com.fintecher.contract.vo.ContractParams;
import com.fintecher.contract.vo.ResultJson;

/**
 * @Author wxc
 * @Data 2018/2/2 11:39
 * @Description 合同创建
 */
public interface ContractService {

    /**
     * 创建合同
     * @param contractParams
     * @return
     */
    ResultJson buildContracts(ContractParams contractParams);

    /**
     * 创建单个合同
     * @param orderId
     * @return
     */
    ResultJson buildContract(Long orderId,String arr);
    /**
     * 带参数预览合同
     * @param contractId
     * @return
     */
    String previewContract(Long contractId);

    /**
     * 不带参数的pdf合同预览
     * @param enumCode
     * @return
     */
    String createBlankContract(String enumCode);

    /**
     * @System:
     * @Auther: dwx
     * @Description:通过 订单id查询此订单是否已经生成合同
     * @Modified By：
     */
    ContractInfo getContractNum(Long orderId);
}
