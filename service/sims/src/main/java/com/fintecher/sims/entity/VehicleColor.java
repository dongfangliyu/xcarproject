package com.fintecher.sims.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.Date;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/15 16:02
 * @Modified By：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "invoicing_vehicle_color")
@ApiModel(description = "车辆颜色")
public class VehicleColor extends BaseEntity {
    @ApiModelProperty(value = "车辆型号ID(外键)")
    private Long vehicleModelId;

    @ApiModelProperty(value = "颜色名称")
    private String name;

    @ApiModelProperty(value = "颜色代码")
    private String code;

    @ApiModelProperty(value = "创建人(外键)")
    private Long operator;

    @ApiModelProperty(value = "创建时间")
    private Date operateTime;


}
