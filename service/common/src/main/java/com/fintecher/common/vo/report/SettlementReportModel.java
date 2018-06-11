package com.fintecher.common.vo.report;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @System: 车贷金融
 * @Auther: xiaqun
 * @Description: 清结算日报表模型
 * @Date: Created on 2018/1/9 11:30
 * @Modified By:
 */

@Data
public class SettlementReportModel {
    @ApiModelProperty(notes = "公司名称")
    private String companyName;

    @ApiModelProperty(notes = "公司ID")
    private Long companyId;

    @ApiModelProperty(notes = "日期")
    private Date date;

    @ApiModelProperty(notes = "客户名")
    private String personalName;

    @ApiModelProperty(notes = "保证金")
    private BigDecimal depositCash = new BigDecimal(0);

    @ApiModelProperty(notes = "首付")
    private BigDecimal initialPayment = new BigDecimal(0);

    @ApiModelProperty(notes = "购置税")
    private BigDecimal purchaseTax = new BigDecimal(0);

    @ApiModelProperty(notes = "保险")
    private BigDecimal insuranceExpenses = new BigDecimal(0);

    @ApiModelProperty(notes = "杂费")
    private BigDecimal otherFee = new BigDecimal(0);

    @ApiModelProperty(notes = "月租本金")
    private BigDecimal principalReceived = new BigDecimal(0);

    @ApiModelProperty(notes = "月租利息")
    private BigDecimal interestReceived = new BigDecimal(0);

    @ApiModelProperty(notes = "罚息")
    private BigDecimal penaltyReceived = new BigDecimal(0);

    @ApiModelProperty(notes = "手续费")
    private BigDecimal param = new BigDecimal(0);

    @ApiModelProperty(notes = "小计")
    private BigDecimal sum;

    @ApiModelProperty(notes = "通道")
    private Integer type;

    public BigDecimal getSum() {
        return this.depositCash
                .add(this.initialPayment)
                .add(this.purchaseTax)
                .add(this.insuranceExpenses)
                .add(this.otherFee)
                .add(this.principalReceived)
                .add(this.interestReceived)
                .add(this.penaltyReceived)
                .add(this.param);
    }
}
