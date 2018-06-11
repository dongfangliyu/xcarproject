package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 库存-车辆管理-车辆信息多条件查询结果
 * @Date: Created on 2018/3/13 13:50
 * @Modified_By:
 */

@Data
public class QueryVehicleInfoModel {

    @ApiModelProperty(value = "车辆ID")
    private Long id;

    @ApiModelProperty(value = "车牌号码")
    private String plateNumber;

    @ApiModelProperty(value = "车架号")
    private String frameNumber;

    @ApiModelProperty(value = "发动机号")
    private String engineNumber;

    @ApiModelProperty(value = "里程表数")
    private Integer odometerNumber;

    @ApiModelProperty(value = "车辆品牌")
    private String vehicleBrand;

    @ApiModelProperty(value = "车辆系列")
    private String vehicleSeries;

    @ApiModelProperty(value = "车辆颜色")
    private String color;

    @ApiModelProperty(value = "所在仓库")
    private String parkCompany;

    @ApiModelProperty(value = "车辆状态(外键：数据字典)")
    private Long vehicleStatus;

    @ApiModelProperty(value = "GPS状态(外键：数据字典)")
    private Long gpsStatus;

    @ApiModelProperty(value = "车辆隶属")
    private String subjection;

    @ApiModelProperty(value = "车辆性质(外键：数据字典)")
    private Long properties;

    @ApiModelProperty(value = "销售日期")
    private Date saleDate;

    @ApiModelProperty(value = "交强险到期日")
    private Date date1;

    @ApiModelProperty(value = "商业险到期日")
    private Date date2;












}
