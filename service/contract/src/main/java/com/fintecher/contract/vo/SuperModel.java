package com.fintecher.contract.vo;

import com.fintecher.contract.util.ContractCode;
import net.sf.json.JSONObject;

/**
 * @Author wxc
 * @Data 2018/2/6 16:04
 * @Description 合同的公共实体类型
 */
public abstract class SuperModel {
	
	/**
	 * 验证参数
	* @Title: verificationParam 
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param param
	* @param @return    设定文件 
	* @return JsonModel    返回类型 
	* @throws
	 */
	public JsonModel verificationParam(JSONObject param){
		JsonModel jm = new JsonModel();
		jm.setCode(ContractCode.SUCC00002.getCode());
		jm.setInfo(ContractCode.SUCC00002.getInfo());
		return jm;
	}
	
	/**
	 * 验证参数   为空 返回指定空的信息
	* @Title: valdateIsNull 
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param param
	* @param @return    设定文件 
	* @return JsonModel    返回类型 
	* @throws
	 */
	public JsonModel valdateIsNull(String resultInfo, JsonModel jm) {
		jm.setCode(ContractCode.EXCE00001.getCode());
		jm.setInfo(ContractCode.EXCE00001.getInfo()+":"+resultInfo);
		return jm;
	}
}
 