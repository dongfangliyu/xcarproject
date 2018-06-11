package com.fintecher.sims.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 市场行情
 * @Date: Created on 2018/3/15 16:20
 * @Modified_By:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "invoicing_market_quotation")
@ApiModel(description = "市场行情")
public class MarketQuotation extends BaseEntity {

    @ApiModelProperty(value = "供应商ID(外键)")
    private Long supplierId;

    @ApiModelProperty(value = "车辆品牌ID(外键)")
    private Long vehicleBrandId;

    @ApiModelProperty(value = "车辆系列ID(外键)")
    private Long vehicleSeriesId;

    @ApiModelProperty(value = "车辆型号ID(外键)")
    private Long vehicleModelId;

    @ApiModelProperty(value = "指导价")
    private BigDecimal guidancePrice;

    @ApiModelProperty(value = "采购价")
    private BigDecimal purchasePrice;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建人(外键)")
    private Long operator;

    @ApiModelProperty(value = "创建时间")
    private Date operateTime;

    @ApiModelProperty(value = "最后操作人(外键)")
    private Long updater;

    @ApiModelProperty(value = "最后操作时间")
    private Date updateTime;

}
