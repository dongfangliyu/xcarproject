package com.fintecher.contract.vo.ContractModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fintecher.contract.util.jsonValidation.BeanValidators;
import com.fintecher.contract.vo.JsonModel;
import com.fintecher.contract.vo.SuperModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.sf.json.JSONObject;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;

/**
 * @Author wxc
 * @Data 2018/2/7 17:54
 * @Description 直租-汽车融资租赁合同model
 */
@ApiModel("直租-汽车融资租赁合同")
@JsonIgnoreProperties(ignoreUnknown = true)//解析json数据
@Data
public class DirectRentModel extends SuperModel{

    @ApiModelProperty(value = "合同编号")
    @Valid
    @NotBlank(message = "合同编号不能为空")
    private String contractNum;

    @ApiModelProperty(value = "签约日")
    @Valid
    @NotBlank(message = "签约日不能为空")
    private String signingDay;

    @ApiModelProperty(value="承租人")
    @Valid
    @NotBlank(message="承租人名字不能为空")
    private String custName;

    @ApiModelProperty(value="承租人身份证号码")
    @Valid
    @NotBlank(message="承租人身份证号码不能为空")
    private String custId;

    @ApiModelProperty(value="承租人住所地址")
    @Valid
//    @NotBlank(message="承租人住所地址不能为空")
    private String custIdAdd;

    @ApiModelProperty(value="承租人联系地址")
    @Valid
    @NotBlank(message="承租人联系地址不能为空")
    private String custContactAdd;

    @ApiModelProperty(value="承租人电话")
    @Valid
    @NotBlank(message="承租人电话不能为空")
    private String custPhone;

    @ApiModelProperty(value="担保人姓名")
    @Valid
    @NotBlank(message="担保人姓名不能为空")
    private String guarantorName;

    @ApiModelProperty(value="担保人身份证号码")
    @Valid
    @NotBlank(message="担保人身份证号码不能为空")
    private String guarantorId;

    @ApiModelProperty(value="担保人住所地址")
    @Valid
//    @NotBlank(message="担保人住所地址不能为空")
    private String guarantorIdAdd;

    @ApiModelProperty(value="担保人联系地址")
    @Valid
    @NotBlank(message="担保人联系地址不能为空")
    private String guarantorContactAdd;

    @ApiModelProperty(value="担保人电话")
    @Valid
    @NotBlank(message="担保人电话不能为空")
    private String guarantorPhone;

    @ApiModelProperty(value="租赁车辆车型")
    @Valid
    @NotBlank(message="租赁车辆车型不能为空")
    private String modelName;

    @ApiModelProperty(value="出卖人/销售")
    @Valid
    @NotBlank(message="出卖人/销售不能为空")
    private String seller;

    @ApiModelProperty(value="车辆外部颜色")
    @Valid
//    @NotBlank(message="车辆外部颜色不能为空")
    private String carOuterColor;

    @ApiModelProperty(value="车辆内部颜色")
    @Valid
//    @NotBlank(message="车辆内部颜色不能为空")
    private String carInsideColor;

    @ApiModelProperty(value="车架号")
    @Valid
    @NotBlank(message="车架号不能为空")
    private String carNum;

    @ApiModelProperty(value="发动机号码")
    @Valid
    @NotBlank(message="发动机号码不能为空")
    private String engineNum;

    @ApiModelProperty(value="租赁总价")
    @Valid
    @NotBlank(message="租赁总价不能为空")
    private String financingAmount;

    @ApiModelProperty(value="购车款")
    @Valid
    @NotBlank(message="购车款不能为空")
    private String vehicleAmount;

    @ApiModelProperty(value="购置税")
    @Valid
    @NotBlank(message="购置税不能为空")
    private String purchaseTax;

    @ApiModelProperty(value="牌照费")
    @Valid
    @NotBlank(message="牌照费不能为空")
    private String installLicenseFee;

    @ApiModelProperty(value="保险费")
    @Valid
    @NotBlank(message="保险费不能为空")
    private String insuranceExpenses;

    @ApiModelProperty(value = "车船税")
    @Valid
//    @NotBlank(message="车船税不能为空")
    private String travelTax;

    @ApiModelProperty(value = "上牌杂费")
    @Valid
//    @NotBlank(message="上牌杂费不能为空")
    private String carMiscellaneousFees;

    @ApiModelProperty(value="GPS费用+年费")
    @Valid
    @NotBlank(message="GPS费用+年费不能为空")
    private String gpsFee;

    @ApiModelProperty(value="租赁期限(年)")
    @Valid
    @NotBlank(message="租赁期限(年)不能为空")
    private String years;

    @ApiModelProperty(value="租赁期限开始时间(年月日)")
    @Valid
    @NotBlank(message="租赁期限开始时间(年月日)不能为空")
    private String yearsStart;

    @ApiModelProperty(value="租赁期限结束时间(年月日)")
    @Valid
    @NotBlank(message="租赁期限结束时间(年月日)不能为空")
    private String yearsEnd;

    @ApiModelProperty(value="每期租金")
    @Valid
//    @NotBlank(message="每期租金不能为空")
    private String eachRent;

    @ApiModelProperty(value="租金合计")
    @Valid
//    @NotBlank(message="租金合计不能为空")
    private String rentAmount;

    @ApiModelProperty(value="租金支付日")
    @Valid
    @NotBlank(message="租金支付日不能为空")
    private String paymentDay;

    @ApiModelProperty(value="首期租金支付日")
    @Valid
    @NotBlank(message="首期租金支付日不能为空")
    private String paymentFirstDay;

    @ApiModelProperty(value="第二期租金支付日")
    @Valid
    @NotBlank(message="第二期租金支付日不能为空")
    private String paymentSecondDay;

    @ApiModelProperty(value="首付款")
    @Valid
    @NotBlank(message="首付款不能为空")
    private String initialPayment;

    @ApiModelProperty(value="保证金")
    @Valid
//    @NotBlank(message="保证金不能为空")
    private String depositCash;

    @ApiModelProperty(value="手续费")
    @Valid
//    @NotBlank(message="手续费不能为空")
    private String manageCost;

    @ApiModelProperty(value="期数")
    @Valid
    @NotBlank(message="期数不能为空")
    private String periods;

    @ApiModelProperty(value="保险期限")
    @Valid
//    @NotBlank(message="保险期限不能为空")
    private String termInsurance;

    @Override
    public JsonModel verificationParam(JSONObject param) {
        return BeanValidators.validate(this);
    }

    @Override
    public String toString() {
        return "DirectRentModel [" +
                "custName='" + custName + '\'' +
                ", custId='" + custId + '\'' +
                ", custIdAdd='" + custIdAdd + '\'' +
                ", custContactAdd='" + custContactAdd + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", guarantorName='" + guarantorName + '\'' +
                ", guarantorId='" + guarantorId + '\'' +
                ", guarantorIdAdd='" + guarantorIdAdd + '\'' +
                ", guarantorContactAdd='" + guarantorContactAdd + '\'' +
                ", guarantorPhone='" + guarantorPhone + '\'' +
                ", modelName='" + modelName + '\'' +
                ", seller='" + seller + '\'' +
                ", carOuterColor='" + carOuterColor + '\'' +
                ", carInsideColor='" + carInsideColor + '\'' +
                ", carNum='" + carNum + '\'' +
                ", engineNum='" + engineNum + '\'' +
                ", financingAmount='" + financingAmount + '\'' +
                ", vehicleAmount='" + vehicleAmount + '\'' +
                ", purchaseTax='" + purchaseTax + '\'' +
                ", installLicenseFee='" + installLicenseFee + '\'' +
                ", insuranceExpenses='" + insuranceExpenses + '\'' +
                ", travelTax='" + travelTax + '\'' +
                ", carMiscellaneousFees='" + carMiscellaneousFees + '\'' +
                ", gpsFee='" + gpsFee + '\'' +
                ", years='" + years + '\'' +
                ", yearsStart='" + yearsStart + '\'' +
                ", yearsEnd='" + yearsEnd + '\'' +
                ", eachRent='" + eachRent + '\'' +
                ", rentAmount='" + rentAmount + '\'' +
                ", paymentDay='" + paymentDay + '\'' +
                ", paymentFirstDay='" + paymentFirstDay + '\'' +
                ", paymentSecondDay='" + paymentSecondDay + '\'' +
                ", initialPayment='" + initialPayment + '\'' +
                ", depositCash='" + depositCash + '\'' +
                ", manageCost='" + manageCost + '\'' +
                ", periods='" + periods + '\'' +
                ", termInsurance='" + termInsurance + '\'' +
                ']';
    }
}
