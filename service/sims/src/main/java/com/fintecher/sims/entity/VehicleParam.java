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
 * @Date:Created on 2018/3/14 16:52
 * @Modified By：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "车辆参数")
@EqualsAndHashCode(callSuper = false)
@Table(name = "invoicing_vehicle_param")
public class VehicleParam extends BaseEntity {

    @ApiModelProperty(value = "参数类型id")
    private Long paramTypeId;

    @ApiModelProperty(value = "参数名称")
    private String name;

    @ApiModelProperty(value = "参数值")
    private String value;

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
