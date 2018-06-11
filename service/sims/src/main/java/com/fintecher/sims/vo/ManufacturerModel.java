package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/16 17:00
 * @Modified By：
 */
@Data
public class ManufacturerModel  {
    @ApiModelProperty(value = "厂商id")
    private Long id;
    @ApiModelProperty(value = "厂商名称")
    private String name;
    @ApiModelProperty(value = "是否删除")
    private Integer isDelete;
}
