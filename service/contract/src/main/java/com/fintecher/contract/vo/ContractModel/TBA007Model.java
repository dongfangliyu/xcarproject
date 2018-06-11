//package com.fintecher.contract.vo.ContractModel;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import org.hibernate.validator.constraints.NotBlank;
//
//import javax.validation.Valid;
//
//@ApiModel("风险备用金服务协议")
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class TBA007Model{
//
//
//	@ApiModelProperty(value="客户姓名")
//	@Valid
//	@NotBlank(message="客户姓名参数不能为空")
//	private String custName;
//
//	@ApiModelProperty(value="证件号")
//	@Valid
//	@NotBlank(message="证件号参数不能为空")
//	private String custIc;
//
//
//	public String getCustName() {
//		return custName;
//	}
//
//
//
//
//	public void setCustName(String custName) {
//		this.custName = custName;
//	}
//
//
//
//	public String getCustIc() {
//		return custIc;
//	}
//
//
//
//
//	public void setCustIc(String custIc) {
//		this.custIc = custIc;
//	}
////	public JsonModel verificationParam(JSONObject param) {
////		return BeanValidators.validate(this);
////	}
//
//}
