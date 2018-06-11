package com.fintecher.contract.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/4/2 16:21
 * @Modified By：
 */
@Data
public class ContractResourceModel {
    @ApiModelProperty(value = "订单id")
    private Long orderId;
    @ApiModelProperty(value = "合同地址url")
    private List<String> materialUrls;
}
