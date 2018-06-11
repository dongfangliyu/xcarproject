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

@ApiModel("贷我走注册协议V2.3")
@JsonIgnoreProperties(ignoreUnknown = true)//解析json数据
@Data
public class ECA001Model extends SuperModel {
	
	@ApiModelProperty(value="客户名字")
	@Valid
	@NotBlank(message="客户名字不能为空")
	private String custName;
	
	@ApiModelProperty(value="身份证")
	@Valid
	@NotBlank(message="身份证不能为空")
	private String custIc;
	
	@ApiModelProperty(value="邮箱")
	private String email;
	
	@ApiModelProperty(value="手机号")
	@Valid
	@NotBlank(message="手机号不能为空")
	private String mobileNo;

	
	@Override
	public JsonModel verificationParam(JSONObject param) {
		return BeanValidators.validate(this);
	}

	@Override
	public String toString() {
		return "ECA001Model [custName=" + custName + ", custIc=" + custIc
				+ ", email=" + email + ", mobileNo=" + mobileNo + "]";
	}
	
}
