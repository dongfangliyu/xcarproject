package com.fintecher.sims.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description:
 * @Date: Created on 2018/3/13 11:23
 * @Modified_By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "invoicing_vehicle")
@ApiModel(description = "车辆信息")
public class Vehicle extends BaseEntity {

    @ApiModelProperty(value = "车辆系列ID(外键)")
    private Long vehicleSeriesId;

    @ApiModelProperty(value = "车辆品牌ID(外键)")
    private Long vehicleBrandId;

    @ApiModelProperty(value = "车辆型号ID(外键)")
    private Long vehicleModelId;

    @ApiModelProperty(value = "厂商ID(外键)")
    private Long manufacturerId;

    @ApiModelProperty(value = "采购单ID(外键)")
    private Long purchaseOrderId;

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

    @ApiModelProperty(value = "生产日期")
    private Date productionDate;

    @ApiModelProperty(value = "车牌号码")
    private String plateNumber;

    @ApiModelProperty(value = "上牌日期")
    private Date plateDate;

    @ApiModelProperty(value = "排放标准")
    private String emissionStandard;

    @ApiModelProperty(value = "合格证号")
    private String certificateNumber;

    @ApiModelProperty(value = "停放公司（停放库位）")
    private Long parkCompanyId;

    @ApiModelProperty(value = "里程表数")
    private Integer odometerNumber;

    @ApiModelProperty(value = "GPS状态(外键：数据字典)")
    private Long gpsStatus;

    @ApiModelProperty(value = "车辆隶属")
    private String subjection;

    @ApiModelProperty(value = "发动机号")
    private String engineNumber;

    @ApiModelProperty(value = "车辆性质(外键：数据字典)")
    private Long properties;

    @ApiModelProperty(value = "车况(外键：数据字典)")
    private Long vehicleCondition;

    @ApiModelProperty(value = "车况异常说明")
    private String abnormalExplain;

    @ApiModelProperty(value = "车辆状态(外键：数据字典)")
    private Long vehicleStatus;

    @ApiModelProperty(value = "停放状态(外键：数据字典)")
    private Long parkStatus;

    @ApiModelProperty(value = "部门code")
    private String departmentCode;

    @ApiModelProperty(value = "部门ID(外键)")
    private Long departmentId;

    @ApiModelProperty(value = "销售日期")
    private Date saleDate;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建人(外键)")
    private Long operator;

    @ApiModelProperty(value = "创建时间")
    private Date operateTime;

    @ApiModelProperty(value = "最后操作人(外键)")
    private Long updater;

    @ApiModelProperty(value = "最后操作时间")
    private Date updateTime;


}
