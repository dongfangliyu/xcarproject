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
@ApiModel(description = "车辆系列")
@EqualsAndHashCode(callSuper = false)
@Table(name = "invoicing_vehicle_series")
public class VehicleSeries extends BaseEntity {
    @ApiModelProperty(value = "父级ID(自关联)")
    private Long parentId;

    @ApiModelProperty(value = "车辆品牌ID(外键)")
    private Long vehicleBrandId;

    @ApiModelProperty(value = "系列名称")
    private String name;

    @ApiModelProperty(value = "车型(外键：数据字典)")
    private Integer models;

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
