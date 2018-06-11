package com.fintecher.sims.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description: 车辆素材内容实体
 * @Date: Created on 2018/3/6 17:21
 * @Modified By:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "车辆素材内容")
@EqualsAndHashCode(callSuper = false)
@Table(name = "invoicing_material_item")
public class MaterialItem extends BaseEntity {
    @ApiModelProperty(value = "车辆素材类别ID")
    @Column(name = "material_category_id")
    private Long materialCategoryId;

    @ApiModelProperty(value = "素材名称")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "是否必传")
    @Column(name = "is_necessary")
    private Integer isNecessary;

    @ApiModelProperty(value = "创建人")
    @Column(name = "operator")
    private Long operator;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "operate_time")
    private Date operateTime;

    @ApiModelProperty(value = "最后操作人")
    @Column(name = "updater")
    private Long updater;

    @ApiModelProperty(value = "最后操作时间")
    @Column(name = "update_time")
    private Date updateTime;
}
