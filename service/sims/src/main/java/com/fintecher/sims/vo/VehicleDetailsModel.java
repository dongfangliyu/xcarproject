package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.omg.CORBA.NO_IMPLEMENT;

import java.util.Date;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description: 车辆明细模型
 * @Date: Created on 2018/3/13 19:36
 * @Modified By:
 */

@Data
public class VehicleDetailsModel {
    @ApiModelProperty(value = "车辆ID")
    private Long vehicleId;

    @ApiModelProperty(value = "车辆品牌")
    private String brand;

    @ApiModelProperty(value = "车系")
    private String series;

    @ApiModelProperty(value = "车辆型号")
    private String model;

    @ApiModelProperty(value = "车身颜色")
    private String color;

    @ApiModelProperty(value = "车架号")
    private String frameNumber;

    @ApiModelProperty(value = "合格证号")
    private String certificateNumber;

    @ApiModelProperty(value = "发动机号")
    private String engineNumber;

    @ApiModelProperty(value = "出厂日期")
    private Date productionDate;
}
