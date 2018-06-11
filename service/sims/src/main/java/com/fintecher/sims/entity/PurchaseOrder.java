package com.fintecher.sims.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description: 采购单实体
 * @Date: Created on 2018/3/16 17:04
 * @Modified By:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "采购单实体")
@EqualsAndHashCode(callSuper = false)
@Table(name = "invoicing_purchase_order")
public class PurchaseOrder extends BaseEntity {
    @ApiModelProperty(value = "采购单号")
    @Column(name = "purchase_number")
    private String purchaseNumber;

    @ApiModelProperty(value = "采购类型")
    @Column(name = "purchase_type")
    private Long purchaseType;

    @ApiModelProperty(value = "交货地点")
    @Column(name = "delivery_place")
    private String deliveryPlace;

    @ApiModelProperty(value = "供应商ID")
    @Column(name = "supplier_id")
    private Long supplierId;

    @ApiModelProperty(value = "开票方式")
    @Column(name = "billing_way")
    private Long billingWay;

    @ApiModelProperty(value = "付款方式")
    @Column(name = "pay_way")
    private Long payWay;

    @ApiModelProperty(value = "总指导价")
    @Column(name = "total_guidance_price")
    private BigDecimal totalGuidancePrice;

    @ApiModelProperty(value = "总进价")
    @Column(name = "total_purchase_price")
    private BigDecimal totalPurchasePrice;

    @ApiModelProperty(value = "已付金额")
    @Column(name = "has_pay_amount")
    private BigDecimal hasPayAmount;

    @ApiModelProperty(value = "剩余金额")
    @Column(name = "surplus_amount")
    private BigDecimal surplusAmount;

    @ApiModelProperty(value = "打印次数")
    @Column(name = "print_number")
    private BigDecimal printNumber;

    @ApiModelProperty(value = "备注")
    @Column(name = "remark")
    private BigDecimal remark;

    @ApiModelProperty(value = "申请人")
    @Column(name = "applicant")
    private Long applicant;

    @ApiModelProperty(value = "申请时间")
    @Column(name = "apply_time")
    private Date applyTime;

    @ApiModelProperty(value = "申请状态")
    @Column(name = "apply_status")
    private Long applyStatus;

    @ApiModelProperty(value = "最后操作人")
    @Column(name = "updater")
    private Long updater;

    @ApiModelProperty(value = "最后操作时间")
    @Column(name = "update_time")
    private Date updateTime;
}
