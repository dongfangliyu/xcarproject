package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/15 14:54
 * @Modified By：
 */
@Data
public class VehicleParamModel {
    @ApiModelProperty(value = "参数id")
    private Long id;

    @ApiModelProperty(value = "型号id")
    private Long modelId;

    @ApiModelProperty(value = "参数名称")
    private String paramName;

    @ApiModelProperty(value = "参数类型")
    private String paramTypeName;

    @ApiModelProperty(value = "参数值")
    private String paramValue;
}
