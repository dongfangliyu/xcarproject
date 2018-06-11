package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description: 新增采购单参数
 * @Date: Created on 2018/3/16 17:37
 * @Modified By:
 */

@Data
public class PurchaseOrderParam {
    @ApiModelProperty(value = "采购单号")
    private String purchaseNumber;

    @ApiModelProperty(value = "采购类型")
    private Long purchaseType;

    @ApiModelProperty(value = "交货地点")
    private String deliveryPlace;

    @ApiModelProperty(value = "开票方式")
    private Long billingWay;

    @ApiModelProperty(value = "供应商ID")
    private Long supplierId;

    @ApiModelProperty(value = "付款方式")
    private Long payWay;

    @ApiModelProperty(value = "总指导价")
    private BigDecimal totalGuidancePrice;

    @ApiModelProperty(value = "总进价")
    private BigDecimal totalPurchasePrice;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "采购车辆集合")
    List<PuchaseVehicleParam> params;
}
