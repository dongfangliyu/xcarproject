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
 * @System:车贷金融系统
 * @Auther: dwx
 * @Description:全额销售汽车合同model
 * @Date:Created on 2018/2/22 13:18
 * @Modified By:
 */
@ApiModel("汽车全款销售合同")
@JsonIgnoreProperties(ignoreUnknown = true)//解析json数据
@Data
public class FullSalesModel extends SuperModel {

    @ApiModelProperty(value = "合同编号")
    @Valid
    @NotBlank(message = "合同编号不能为空")
    private String contractNum;

    @ApiModelProperty(value="购车方(甲方)")
    @Valid
    @NotBlank(message="甲方人名字不能为空")
    private String custName;

    @ApiModelProperty(value="甲方联系地址")
    @Valid
    @NotBlank(message="甲方人联系地址不能为空")
    private String custContactAdd;

    @ApiModelProperty(value="甲方联系电话")
    @Valid
    @NotBlank(message="甲方人联系电话不能为空")
    private String custPhone;

    @ApiModelProperty(value="甲方邮政编码")
    @Valid
    @NotBlank(message="甲方人邮政编码不能为空")
    private String postalCode;

    @ApiModelProperty(value="甲方证件名称")
    @Valid
    @NotBlank(message="甲方人证件名称不能为空")
    private String custIdName;

    @ApiModelProperty(value="甲方证件号码")
    @Valid
    @NotBlank(message="甲方人证件号码不能为空")
    private String custId;

    @ApiModelProperty(value="乙方邮政编码")
    private String theSecondCode;

    @ApiModelProperty(value="乙方传真")
    private String theSecondFax;

    @ApiModelProperty(value="负责经办人名称")
    @Valid
    @NotBlank(message="负责经办人名称不能为空")
    private String theSecondLeader;

    @ApiModelProperty(value="负责经办人联系电话")
    @Valid
    @NotBlank(message="负责经办人联系电话不能为空")
    private String theSecondLeaderNumber;

    @ApiModelProperty(value="品牌")
    @Valid
    @NotBlank(message="汽车品牌不能为空")
    private String carLogo;

    @ApiModelProperty(value="型号")
    @Valid
    @NotBlank(message="汽车型号不能为空")
    private String modelName;

    @ApiModelProperty(value="车身颜色")
    @Valid
    @NotBlank(message="车身颜色不能为空")
    private String carColor;

    @ApiModelProperty(value="配置")
    @Valid
    @NotBlank(message="汽车配置不能为空")
    private String carConfiguration;

    @ApiModelProperty(value="单价(人民币)")
    @Valid
    @NotBlank(message="汽车单价不能为空")
    private String vehicleAmount;

    @ApiModelProperty(value="数量")
    @Valid
    @NotBlank(message="汽车数量不能为空")
    private String carSellNumber;

    @ApiModelProperty(value="小计")
    @Valid
    @NotBlank(message="小计不能为空")
    private String carPriceSum;

    @ApiModelProperty(value="合计总价(人民币)")
    @Valid
    @NotBlank(message="合计总价不能为空")
    private String carSum;

    @ApiModelProperty(value="交车地点")
    @Valid
    @NotBlank(message="交车地点不能为空")
    private String addressForService;

    @ApiModelProperty(value="金额百分比")
    private String percentagePrice;

    @ApiModelProperty(value="签约日应缴金额")
    private String carBePayment;

    @ApiModelProperty(value="剩余全部金额")
    private String carPayment;

    @ApiModelProperty(value="合同定金")
    private String carBargain;

    @ApiModelProperty(value="分期付款应付百分比")
    private String carPercent;

    @ApiModelProperty(value="分期付款应付百分比金额")
    private String carPercentPrice;

    @ApiModelProperty(value="上牌")
    private String carLicenseFee;

    @ApiModelProperty(value="办理保险")
    private String carInsuranceFee;

    @ApiModelProperty(value="代缴购置税")
    private String carPurchaseFax;

    @ApiModelProperty(value="代缴车船税")
    private String carBoatFax;

    @ApiModelProperty(value="按揭贷款")
    private String carMortgage;

    @ApiModelProperty(value="车辆装潢")
    private String carDecoration;

    @ApiModelProperty(value="代缴其他相关费用")
    private String chargeOther;

    @ApiModelProperty(value="其他")
    private String another;

    @Override
    public JsonModel verificationParam(JSONObject param) {
        return BeanValidators.validate(this);
    }

    @Override
    public String toString() {
        return "FullSalesModel{" +
                "custName='" + custName + '\'' +
                ", custContactAdd='" + custContactAdd + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", custIdName='" + custIdName + '\'' +
                ", custId='" + custId + '\'' +
                ", theSecondCode='" + theSecondCode + '\'' +
                ", theSecondFax='" + theSecondFax + '\'' +
                ", theSecondLeader='" + theSecondLeader + '\'' +
                ", theSecondLeaderNumber='" + theSecondLeaderNumber + '\'' +
                ", carLogo='" + carLogo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", carColor='" + carColor + '\'' +
                ", carConfiguration='" + carConfiguration + '\'' +
                ", vehicleAmount ='" + vehicleAmount + '\'' +
                ", carSellNumber='" + carSellNumber + '\'' +
                ", carPriceSum='" + carPriceSum + '\'' +
                ", carSum='" + carSum + '\'' +
                ", addressForService='" + addressForService + '\'' +
                ", percentagePrice='" + percentagePrice + '\'' +
                ", carBePayment='" + carBePayment + '\'' +
                ", carPayment='" + carPayment + '\'' +
                ", carBargain='" + carBargain + '\'' +
                ", carLicenceFee='" + carLicenseFee + '\'' +
                ", carInsuranceFee='" + carInsuranceFee + '\'' +
                ", carPurchaseFax='" + carPurchaseFax + '\'' +
                ", carBoatFax='" + carBoatFax + '\'' +
                ", carMortgage='" + carMortgage + '\'' +
                ", carDecoration='" + carDecoration + '\'' +
                ", chargeOther='" + chargeOther + '\'' +
                ", another='" + another + '\'' +
                '}';
    }
}

