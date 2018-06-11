package com.fintecher.contract.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author wxc
 * @Data 2018/2/2 11:26
 * @Description 前端传合同参数
 */
@Data
public class ContractParams {

    @ApiModelProperty(value = "合同信息集合")
    private String arr;

    @ApiModelProperty(value = "订单编号")
    private String orderNumber;

    @ApiModelProperty(value = "产品类型")
    private Integer productType;

    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    @ApiModelProperty(value = "订单ID")
    private Long orderId;

    @ApiModelProperty(value = "唯一识别码")
    private String uniqueCode;

    @ApiModelProperty(value = "账户类型")
    private Integer accountType;

    @ApiModelProperty(value = "身份证")
    private String idCard;

    @ApiModelProperty(value = "同步还是异步")
    private String issync;

    @ApiModelProperty(value = "是否异步签章")
    private String isasyncSign;

    @ApiModelProperty(value = "模板名称")
    private String templateName;

    @ApiModelProperty(value = "签章code")
    private String chanelCode;
}
