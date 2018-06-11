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
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/13
 * @Modified By：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "车辆型号")
@EqualsAndHashCode(callSuper = false)
@Table(name = "invoicing_vehicle_model")

public class VehicleModel extends BaseEntity {
    @ApiModelProperty(value = "车辆系列id")
    private Long vehicleSeriesId;

    @ApiModelProperty(value = "型号名称")
    private String name;

    @ApiModelProperty(value = "型号代码")
    private String code;

    @ApiModelProperty(value = "颜色")
    private String color;

    @ApiModelProperty(value = "参考价")
    private BigDecimal referencePrice;

    @ApiModelProperty(value = "指导价")
    private BigDecimal guidancePrice;

    @ApiModelProperty(value = "排量")
    private String displacement;

    @ApiModelProperty(value = "排放标准")
    private String standard;

    @ApiModelProperty(value = "配置")
    private String configure;
    @ApiModelProperty(value = "汽车厂商id")
    private Long manufacturerId;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建人")
    private Long operator;

    @ApiModelProperty(value = "创建时间")
    private Date operateTime;

    @ApiModelProperty(value = "最后操作人")
    private Long updater;

    @ApiModelProperty(value = "最后操作时间")
    private Date updateTime;


}
