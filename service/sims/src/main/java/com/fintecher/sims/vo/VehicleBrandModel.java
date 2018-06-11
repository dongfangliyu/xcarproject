package com.fintecher.sims.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/21 10:25
 * @Modified By：
 */
@Data
public class VehicleBrandModel {
    @ApiModelProperty(value = "品牌名称")
    private String brandName;
}
