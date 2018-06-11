package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description: 调拨出入库模型
 * @Date: Created on 2018/3/14 13:47
 * @Modified By:
 */

@Data
public class AllocationRecordModel {
    @ApiModelProperty(value = "调拨申请ID")
    private Long allocationOrderId;

    @ApiModelProperty(value = "车辆ID")
    private Long vehicleId;

    @ApiModelProperty(value = "调拨申请日期")
    private Date applyTime;

    @ApiModelProperty(value = "处理状态")
    private Long handleStatus;

    @ApiModelProperty(value = "处理日期")
    private Date handleTime;

    @ApiModelProperty(value = "处理人")
    private String handler;

    @ApiModelProperty(value = "调拨单号")
    private String allocationOrderNumber;

    @ApiModelProperty(value = "调出门店")
    private String outCompanyName;

    @ApiModelProperty(value = "调入门店")
    private String inCompanyName;

    @ApiModelProperty(value = "车辆品牌")
    private String brand;

    @ApiModelProperty(value = "车系")
    private String series;

    @ApiModelProperty(value = "车辆型号")
    private String model;

    @ApiModelProperty(value = "车身颜色")
    private String color;

    @ApiModelProperty(value = "车牌号")
    private String plateNumber;

    @ApiModelProperty(value = "车架号")
    private String frameNumber;

    @ApiModelProperty(value = "发动机号")
    private String engineNumber;

    @ApiModelProperty(value = "合格证号")
    private String certificateNumber;

    @ApiModelProperty(value = "车辆隶属")
    private String subjection;

    @ApiModelProperty(value = "停放库位")
    private String parkPlace;

    @ApiModelProperty(value = "上牌日期")
    private Date plateDate;

    @ApiModelProperty(value = "厂商")
    private String manufacturer;

    @ApiModelProperty(value = "车况")
    private Long condition;

    @ApiModelProperty(value = "里程表值")
    private Integer odometerNumber;

    @ApiModelProperty(value = "GPS状态")
    private Long gpsStatus;

    @ApiModelProperty(value = "情况描述")
    private String description;
}
