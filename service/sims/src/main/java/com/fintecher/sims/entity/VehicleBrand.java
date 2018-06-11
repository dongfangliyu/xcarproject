package com.fintecher.sims.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
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
 * @Date:Created on 2018/3/13
 * @Modified By：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "车辆品牌")
@EqualsAndHashCode(callSuper = false)
@Table(name = "invoicing_vehicle_brand")
public class VehicleBrand extends BaseEntity{
    @ApiModelProperty(value = "父级ID(自关联)")
    private Long parentId;

    @ApiModelProperty(value = "品牌名称")
    private String name;

    @ApiModelProperty(value = "品牌备注")
    private String remark;

    @ApiModelProperty(value = "创建人(外键)")
    private Long operator;

    @ApiModelProperty(value = "创建时间")
    private Date operateTime;

    @ApiModelProperty(value = "最后操作人(外键)")
    private Long updater;

    @ApiModelProperty(value = "最后操作时间")
    private Date updateTime ;




}
