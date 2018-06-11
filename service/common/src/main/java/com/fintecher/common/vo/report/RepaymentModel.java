package com.fintecher.common.vo.report;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @System: 车贷金融
 * @Auther: xiaqun
 * @Description: 月还款报表模型
 * @Date: Created on 2018/1/12 14:44
 * @Modified By:
 */

@Data
public class RepaymentModel {
    @ApiModelProperty(notes = "客户名")
    private String personalName;

    @ApiModelProperty(notes = "合同号")
    private String contractNumber;

    @ApiModelProperty(notes = "证件号码")
    private String idCardNumber;

    @ApiModelProperty(notes = "手机号码")
    private String phone;

    @ApiModelProperty(notes = "银行名称")
    private String bankName;

    @ApiModelProperty(notes = "银行卡号")
    private String bankCardNumber;

    @ApiModelProperty(notes = "租赁期数")
    private Integer periods;

    @ApiModelProperty(notes = "融资额")
    private BigDecimal financingAmount = new BigDecimal(0);

    @ApiModelProperty(notes = "首付款")
    private BigDecimal initialPayment = new BigDecimal(0);

    @ApiModelProperty(notes = "保证金")
    private BigDecimal depositCash = new BigDecimal(0);

    @ApiModelProperty(notes = "购置税")
    private BigDecimal purchaseTax = new BigDecimal(0);

    @ApiModelProperty(notes = "路桥费")
    private BigDecimal tollFee = new BigDecimal(0);

    @ApiModelProperty(notes = "保险费")
    private BigDecimal insuranceExpenses = new BigDecimal(0);

    @ApiModelProperty(notes = "结算通道")
    private Integer channel;

    @ApiModelProperty(notes = "已还期数")
    private Integer repaidPeriods;

    @ApiModelProperty(notes = "剩余期数")
    private Integer surplusPeriods;

    @ApiModelProperty(notes = "月还款额")
    private BigDecimal monthRepayment = new BigDecimal(0);

    @ApiModelProperty(notes = "已还款总额")
    private BigDecimal totalRepayment = new BigDecimal(0);

    @ApiModelProperty(notes = "剩余还款总额")
    private BigDecimal surplusRepayment = new BigDecimal(0);

    @ApiModelProperty(notes = "租金总额")
    private BigDecimal rent = new BigDecimal(0);

    @ApiModelProperty(notes = "租赁状态")
    private Integer status;
}
