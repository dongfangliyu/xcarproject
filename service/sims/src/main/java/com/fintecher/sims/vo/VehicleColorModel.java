package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/16 17:34
 * @Modified By：
 */
@Data
public class VehicleColorModel {
    @ApiModelProperty(value = "颜色ID")
    private Long id;
    @ApiModelProperty(value = "颜色编码")
    private String code;
    @ApiModelProperty(value = "颜色名称")
    private String name;
}
