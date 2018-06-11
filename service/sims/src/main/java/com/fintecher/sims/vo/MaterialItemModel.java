package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description: 车辆素材模型
 * @Date: Created on 2018/3/7 17:48
 * @Modified By:
 */

@Data
public class MaterialItemModel {
    @ApiModelProperty(value = "素材ID")
    private Long id;

    @ApiModelProperty(value = "素材类别ID")
    private Long materialCategoryId;

    @ApiModelProperty(value = "素材名称")
    private String name;

    @ApiModelProperty(value = "是否必传")
    private Integer isNecessary;
}
