package com.fintecher.sims.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/20 16:07
 * @Modified By：
 */
@Data
public class VehicleVoModel {
    @ApiModelProperty(value = "车辆id")
    private Long id;
    @ApiModelProperty(value = "车辆系列id")
    private  Long seriesId;
    @ApiModelProperty(value = "车辆品牌id")
    private Long brandId;
    @ApiModelProperty(value = "车辆型号id")
    private Long modelId;
    @ApiModelProperty(value = "厂商id")
    private Long manufacturerId;
    @ApiModelProperty(value = "车架号")
    private String frameNumber;
    @ApiModelProperty(value = "车辆指导价")
    private BigDecimal guidancePrice;
    @ApiModelProperty(value = "车辆进价")
    private BigDecimal purchasePrice;
    @ApiModelProperty(value = "车辆颜色")
    private String color;
    @ApiModelProperty(value = "车辆销售价")
    private BigDecimal sellingPrice;
}
