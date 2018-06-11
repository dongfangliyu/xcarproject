package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/16 17:55
 * @Modified By：
 */
@Data
public class VehicleParamTypeModel {
    @ApiModelProperty(value = "车辆参数类型ID")
    private Long id;

    @ApiModelProperty(value = "类型名称")
    private String name;
}
