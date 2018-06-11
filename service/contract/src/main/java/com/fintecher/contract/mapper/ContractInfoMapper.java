package com.fintecher.contract.mapper;

import com.fintecher.contract.entity.ContractInfo;
import com.fintecher.contract.util.MyMapper;
import com.fintecher.contract.vo.ContractParams;
import org.apache.ibatis.annotations.Param;

/**
 * @Author wxc
 * @Data 2018/2/5 10:40
 * @Description
 */
public interface ContractInfoMapper extends MyMapper<ContractInfo> {

    ContractInfo getContractNum(@Param("orderId")Long orderId);
}
