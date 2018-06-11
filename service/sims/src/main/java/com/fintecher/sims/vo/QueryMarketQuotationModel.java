package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 市场行情查询model
 * @Date: Created on 2018/3/15 16:32
 * @Modified_By:
 */

@Data
public class QueryMarketQuotationModel {

    @ApiModelProperty(value = "供应商名称")
    private String supplier;

    @ApiModelProperty(value = "品牌")
    private String vehicleBrand;

    @ApiModelProperty(value = "车系")
    private String vehicleSeries;

    @ApiModelProperty(value = "车辆型号")
    private String vehicleModel;

    @ApiModelProperty(value = "指导价")
    private BigDecimal guidancePrice;

    @ApiModelProperty(value = "采购价")
    private BigDecimal purchasePrice;

    @ApiModelProperty(value = "创建时间")
    private Date operateTime;

}
