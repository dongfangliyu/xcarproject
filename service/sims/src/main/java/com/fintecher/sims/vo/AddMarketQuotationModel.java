package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 市场行情填报
 * @Date: Created on 2018/3/15 17:23
 * @Modified_By:
 */

@Data
public class AddMarketQuotationModel {

    @ApiModelProperty(value = "供应商ID(外键)")
    private Long supplierId;

    @ApiModelProperty(value = "车辆品牌ID(外键)")
    private Long vehicleBrandId;

    @ApiModelProperty(value = "车辆系列ID(外键)")
    private Long vehicleSeriesId;

    @ApiModelProperty(value = "车辆型号ID(外键)")
    private Long vehicleModelId;

    @ApiModelProperty(value = "指导价")
    private BigDecimal guidancePrice;

    @ApiModelProperty(value = "采购价")
    private BigDecimal purchasePrice;

    @ApiModelProperty(value = "备注")
    private String remark;

}
