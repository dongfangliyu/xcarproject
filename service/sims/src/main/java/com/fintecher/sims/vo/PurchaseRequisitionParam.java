package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description: 采购需求参数
 * @Date: Created on 2018/3/16 14:43
 * @Modified By:
 */

@Data
public class PurchaseRequisitionParam {
    @ApiModelProperty(value = "门店ID")
    private Long companyId;

    @ApiModelProperty(value = "车型ID")
    private Long vehicleModelId;

    @ApiModelProperty(value = "颜色")
    private String color;

    @ApiModelProperty(value = "数量")
    private Integer number;

    @ApiModelProperty(value = "备注")
    private String remark;
}
