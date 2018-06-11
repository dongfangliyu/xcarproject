package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description: 采购车辆参数
 * @Date: Created on 2018/3/19 10:04
 * @Modified By:
 */

@Data
public class PuchaseVehicleParam {
    @ApiModelProperty(value = "车型ID")
    private Long vehicleModelId;

    @ApiModelProperty(value = "颜色")
    private String color;

    @ApiModelProperty(value = "数量")
    private Integer number;

    @ApiModelProperty(value = "指导价")
    private BigDecimal guidancePrice;

    @ApiModelProperty(value = "进价")
    private BigDecimal purchasePrice;
}
