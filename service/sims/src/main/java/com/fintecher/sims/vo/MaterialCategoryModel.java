package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description: 车辆素材类别模型
 * @Date: Created on 2018/3/6 18:06
 * @Modified By:
 */

@Data
public class MaterialCategoryModel {
    @ApiModelProperty(value = "素材类别ID")
    private Long id;

    @ApiModelProperty(value = "素材类别名称")
    private String name;
}
