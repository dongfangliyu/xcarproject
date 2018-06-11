package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 门店采购需求多条件查询model
 * @Date: Created on 2018/3/15 17:51
 * @Modified_By:
 */

@Data
public class QueryPurchaseRequisitionModel {

    @ApiModelProperty(value = "门店名称")
    private Long companyName;

    @ApiModelProperty(value = "车辆品牌")
    private String vehicleBrand;

    @ApiModelProperty(value = "车辆系列")
    private String vehicleSeries;

    @ApiModelProperty(value = "车辆型号")
    private String vehicleModel;

    @ApiModelProperty(value = "车辆颜色")
    private String color;

    @ApiModelProperty(value = "数量")
    private Integer number;

    @ApiModelProperty(value = "创建人(外键)")
    private Long approveRealName;

    @ApiModelProperty(value = "创建时间")
    private Date approveTime;

}
