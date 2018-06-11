package com.fintecher.contract.util;
/**
 * @Author wxc
 * @Data 2018/2/6 15:30
 * @Description
 */
public enum ContractCode {
	// 处理成功 code
	SUCC00000("SUCC00000","处理结束！"),
	SUCC00001("SUCC00001","合同生成成功"),
	SUCC00002("SUCC00002","合同参数验证完成!"),
	SUCC00003("SUCC00003","合同签章成功!"),
	SUCC00004("SUCC00004","查询成功!"),
	SUCC00005("SUCC00005","合同生成并且签章上传成功!"),
	SUCC00006("SUCC00006","异步生成调用成功！"),
	
	SUCC10003("SUCC10003","合同数据生成成功"),
	SUCC20001("SUCC20001","获取合同参数列表成功！"),
	
	// 处理中code
	EXEC00001("EXEC00001","合同数据生成处理中"),
	EXEC00002("EXEC00002","合同生成中"),
	EXEC00003("EXEC00003","CA签章处理中"),
	
	// 异常code
	EXCE00001("EXCE00001","合同参数不全"),
	EXCE00002("EXCE00002","合同参数核对异常"),
	EXCE00003("EXCE00003","合同合同生成异常"),
	EXCE00004("EXCE00004","合同CA签章异常"),
	EXCE00005("EXCE00005","没有找到合同生成策略"),
	EXCE00006("EXCE00006","合同参数为空，请传入相应参数对象"),
	EXCE00007("EXCE00007","合同生成类型编号不匹配"),
	EXCE00008("EXCE00008","JSONObject转实体类异常"),
	EXCE00009("EXCE00009","接口参数核对异常"),
	EXCE00010("EXCE00010","接口异常"),
	EXCE00011("EXCE00011","签章合同上传时异常"),
	EXCE00012("EXCE00012","唯一参数uniqueCode重复"),
	EXCE00013("EXCE00013","更新合同批次状态异常！"),
	EXCE00014("EXCE00014","合同未完整生成或签章！"),
	
	// 验证
	EXCE10007("EXCE10007","合同生成类型编号不匹配"),
	EXCE10008("EXCE10008","签章通道维护中，暂时没有可用的签章通道"),
	EXCE10009("EXCE10009","合同数据验证时，没有匹配到相应的策略"),
	EXCE10010("EXCE10010","合同数据验证时，没有查询到相应的模板信息"),
	EXCE10011("EXCE10011","请确认生成策略为同步生成/异步生成！"),
	EXCE10012("EXCE10012","未查询到异常的批次信息！"),
	EXCE10013("EXCE10012","未查询到异常的合同信息！"),
	
	//
	EXCE20001("EXCE20001","合同批次信息保存异常!"),
	EXCE20002("EXCE20002","合同基本信息保存异常!"),
	EXCE20003("EXCE20003","合同批次信息不存在!"),
	EXCE40001("EXCE40001","获取合同签章位置失败!"),

	// 合同组
	EXECCG00001("EXECCG00001","该合同组，不存在！"),
	EXECCG00002("EXECCG00002","该合同组，缺少参数！"),
	EXECCG00003("EXECCG00003","该合同组，参数转移异常，参数不合法！")
	
	;
	
	ContractCode(String code, String info){
		this.code=code;
		this.info=info;
	}
	
	 private String code;  // 返回code 
     private String info;	// 返回说明
     
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}  
     
}
 