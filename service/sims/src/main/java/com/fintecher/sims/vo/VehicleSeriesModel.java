package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/21 9:50
 * @Modified By：
 */
@Data
public class VehicleSeriesModel {
    @ApiModelProperty(value = "车辆系列id")
    private Long id;
    @ApiModelProperty(value = "车辆品牌id")
    private Long brandId;
    @ApiModelProperty(value = "系列名称")
    private String seriesName;
    @ApiModelProperty(value = "车型")
    private Integer models;
}
