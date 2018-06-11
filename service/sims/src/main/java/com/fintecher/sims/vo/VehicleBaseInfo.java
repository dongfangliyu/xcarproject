package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class VehicleBaseInfo {


    @ApiModelProperty(value = "厂牌型号")
    private String models;

    @ApiModelProperty(value = "车架号")
    private String frameNumber;

    @ApiModelProperty(value = "车辆颜色")
    private String color;

    @ApiModelProperty(value = "生产日期")
    private Date productionDate;

    @ApiModelProperty(value = "车牌号码")
    private String plateNumber;

    @ApiModelProperty(value = "排放标准")
    private String emissionStandard;

    @ApiModelProperty(value = "上牌日期")
    private Date plateDate;

    @ApiModelProperty(value = "合格证号")
    private String certificateNumber;

    @ApiModelProperty(value = "停放公司（停放库位）")
    private String parkCompany;

    @ApiModelProperty(value = "车辆隶属")
    private String subjection;

    @ApiModelProperty(value = "发动机号")
    private String engineNumber;

    @ApiModelProperty(value = "入库日期")
    private Date date1;

    @ApiModelProperty(value = "里程表数")
    private Integer odometerNumber;

    @ApiModelProperty(value = "厂商")
    private String manufacturer;

    @ApiModelProperty(value = "GPS状态(外键：数据字典)")
    private Long gpsStatus;

    @ApiModelProperty(value = "车辆性质(外键：数据字典)")
    private Long properties;

    @ApiModelProperty(value = "车况(外键：数据字典)")
    private Long condition;


}
