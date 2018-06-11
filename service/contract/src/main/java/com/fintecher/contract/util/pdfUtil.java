package com.fintecher.contract.util;

import com.github.pagehelper.StringUtil;
import freemarker.template.TemplateException;
import net.sf.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 生成pdf
 * @author wangcy
 *
 */
public class pdfUtil {
	
	public static void generator(String savePath,String templateName,Map<String,Object> variables) throws IOException, TemplateException{
		// 生成html
//		logger.info("生成 html");
		String htmlStr = HtmlGenerator.htmlGenerate(templateName, variables);
		OutputStream out = new FileOutputStream(savePath);
//		logger.info("生成 pdf");
//      获取图片保存路径
		String picturename=null;
		if(variables.containsKey("picture")){
			if(StringUtil.isEmpty(variables.get("picture").toString()) || "null".equals(variables.get("picture").toString())){
				picturename="";

			}else{
				JSONObject pic=(JSONObject) (variables.get("picture"));
				if(pic.containsKey("pictureDirectoryName")){
					picturename=pic.getString("pictureDirectoryName");
				}
			}
		}
		PdfGenerator.generate(htmlStr, out, picturename);
		
//		logger.info("生成 pdf -------------- ok ");
	}
//	public static void main(String[] args) {
//		Map<String,Object> variables = new HashMap<String, Object>();
//		Map<String,Object> map = new HashMap<String, Object>();
//		JSONObject jsonObject=new JSONObject();
//		JSONObject jsonObject1=new JSONObject();
//
//		jsonObject.put("custName","");
//		jsonObject.put("custIc","");
//		jsonObject.put("invest_rate","");
//		jsonObject.put("repayment_purpose","");
//		jsonObject.put("borrowerBank","");
//		jsonObject.put("borrowerAccount","");
//		jsonObject.put("borrowerCard","");
//		jsonObject.put("periods","");
//		jsonObject.put("duetime_type","");
//		jsonObject.put("email","");
//		jsonObject.put("icAddress","");
//		jsonObject1.put("investorsName","");
//		jsonObject1.put("investorsIc","");
//		jsonObject1.put("principal","");
//		jsonObject1.put("principalRMB","");
//		jsonObject1.put("investorsAccount","");
//		jsonObject1.put("investorsCard","");
//		jsonObject1.put("currentDate","");
//		jsonObject1.put("investorsBank","");
//		jsonObject.put("name", "周先生");
//		jsonObject.put("contractAmt", "20000.00");
//		jsonObject.put("bankPath", "江苏省苏州市中国银行吴中银行支行");
//		jsonObject.put("accountName", "中国银行");
//		jsonObject.put("accountNumber", "621462000001547847");
//		map.put("name", "周先生");
//		map.put("contractAmt", "20000.00");
//		map.put("bankPath", "江苏省苏州市中国银行吴中银行支行");
//		map.put("accountName", "中国银行");
//		map.put("accountNumber", "621462000001547847");
//		variables.put("map", map);
//		map.put("name", "周先生");
//		map.put("contractAmt", "20000.00");
//		map.put("bankPath", "江苏省苏州市中国银行吴中银行支行");
//		map.put("accountName", "中国银行");
//		map.put("accountNumber", "621462000001547847");
//		map.put("custName","周先生");
//		map.put("custIc","中国银行");
//		variables.put("key1", "");
//		variables.put("map", map);
//		variables.put("map1", jsonObject1);
//		variables.put("icaddress", "");
//		variables.put("number","2016-050454");
//		variables.put("email","feixinwei123@zmail.com");
//		variables.put("mobile","15106216176");
//		map.put("companyName","苏州中资联投资管理有限公司");
//		map.put("year", "2017");
//		map.put("month", "05");
//		map.put("day", "25");
//		map.put("contractName", "居间服务协议");
//		map.put("wechatBankName", "中国工商银行");
//		map.put("realName", "费新玮");
//		map.put("bankCardNo", "6222021102010743824");
//		map.put("certNo", "320502199107240035");
//		map.put("mobileNo", "15952411145");
//		try {
//			generator("c:/数字证书服务协议（易保全）.pdf", "ec/aletterOfCreditForInquiry.ftl", map);
////			generator("d:/e2.pdf", "creditConsultAndManageServiceProtocol.ftl", new HashMap<String, Object>());
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (TemplateException e) {
//			e.printStackTrace();
//		}
//	}


	/**
	 * @return
	 */
	private static List getDatas() {
		List list = new ArrayList();
		for(int i = 1 ;i < 49; i ++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("persiod", ""+i);
			map.put("date", "2016-06-03");
			map.put("prical", "200."+i);
			map.put("interest", "20."+i);
			map.put("amt", "220."+i);
			map.put("surAmt", "1000."+i);
			list.add(map);
		}
		return list;
	}
}
