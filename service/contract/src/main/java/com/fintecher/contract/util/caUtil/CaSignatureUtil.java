package com.fintecher.contract.util.caUtil;


import com.fintecher.contract.util.ConstantSysParam;
import com.fintecher.contract.util.ContractCode;
import com.fintecher.contract.util.HttpServiceUtil;
import com.fintecher.contract.vo.JsonModel;
import com.github.pagehelper.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;


/**
 * 功能说明：合同签章工具类
 * chuanqi 2015-11-5
 * @param jsonParms json 格式参数
 * @return 该方法的返回值的类型，含义   
 * @throws  该方法可能抛出的异常，异常的类型、含义。
 * 最后修改时间：最后修改时间
 * 修改人：
 * 修改内容：
 * 修改注意点：
 * @throws IOException 
 */
public class CaSignatureUtil {

	private static Logger logger = LoggerFactory.getLogger(CaSignatureUtil.class);
	
	/**
	 * 合同签章
	 * @param contractNumber 合同编号
//	 * @param contractType 合同类型  01 出借人协议 02 借款人协议  03 借款协议
//	 * @param efCustIC 投资人身份证号码
//	 * @param crmCustIC 借款人身份证号码
	 * @param contractPath 合同路径
	 * @param orderId 订单id
	 */
	public static boolean caSignature(String contractNumber,String contractPath,String orderId,String contractName,String ftpPath,List<Map<String, Object>> signatures,String appcode,String channel) {
		 
		boolean flag=false;
		//将文件转换为流形式
		String doc=TransformUtil.readImageOrFile(contractPath);
		// 去CA签章
		JSONObject jsonCA = new JSONObject();
		jsonCA.put("title","合同签章");
		jsonCA.put("docNum",contractNumber);
		jsonCA.put("reqSource","erp");
		jsonCA.put("channel",channel);
		jsonCA.put("orderNum",orderId);
		jsonCA.put("doc",doc);
		jsonCA.put("docType","pdf");
		jsonCA.put("docName",contractNumber);
		jsonCA.put("signatures",signatures);
		//System.out.println(signatures.toString());
		JSONObject CAJson = new JSONObject();
		CAJson.put("jsonParms", jsonCA);
		logger.warn("开始请求CA签章,crm_apply_id："+orderId+"，请求参数为：。。。"+contractNumber);
//		FileOutputStream bbb;
//		try {
//		bbb = new FileOutputStream("/home/"+contractName+DateUtil.getCurrentTime("yyyyMMddhhmm")+orderId);
//		bbb.write(CAJson.toString().getBytes());
//		bbb.flush();
//		bbb.close();
//		} catch (Exception e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//		}
		// TODO: 2018/2/26  
//		String result = HttpServiceUtil.sendPost(SysConfig.getProperty("v3ServiceXfireWebServiceCAIntactSignPath"), CAJson);
		String result = null;
		JSONObject caResult = JSONObject.fromObject(result);
//		System.out.println("caResult==>>>"+caResult);
		
		if("1".equals(caResult.getString("responseCode")) ){
			logger.warn("合同签章成功，crm_apply_id："+orderId+"，合同编号为：。。。"+contractNumber);
			String resultDoc= (String) caResult.get("uuid");
			byte[] b =new byte[1024];
			if (ConstantSysParam.CA_CHANNEL_DEFAULT.equals(channel)) {
				try {
					URL url = new URL(resultDoc);
					logger.warn("url========"+url);
					HttpURLConnection conn = (HttpURLConnection)url.openConnection();    
			          //设置超时间为3秒  
		            conn.setConnectTimeout(3*10000);
		            //防止屏蔽程序抓取而返回403错误  
		            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");  
		            //得到输入流
		            InputStream inputStream = conn.getInputStream();
		            //获取自己数组  
		            b =TransformUtil.readInputStream(inputStream);
				} catch (Exception e) {
					e.printStackTrace();
					logger.error(e.getMessage(),e);
				}
			}else{
				b = Base64.decode(resultDoc);
			}
			InputStream contractInput = new ByteArrayInputStream(b); 
			//调用ftp工具类上传文件
			// TODO: 2018/2/26  
//			FtpOperation.uploadFile(ftpPath, contractName, contractInput);
	 		flag=true;
	/*try {
				FileOutputStream fileStream = new FileOutputStream("D:/"+contractName);
				fileStream.write(b);
				fileStream.flush();fileStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}*/
		}else{
			logger.warn("合同签章失败，crm_apply_id："+orderId+"，合同编号为："+contractNumber+"CA返回的错误信息为："+(String) caResult.get("info"));
			flag=false;
//			throw new WebApplicationException(caResult.toString(),Response.status(Status.BAD_REQUEST).entity(caResult).build());
			
		}
		
		return flag;
	}

	
	/**
	 * 合同签章
	 * @param contractNumber 合同编号
//	 * @param contractType 合同类型  01 出借人协议 02 借款人协议  03 借款协议
//	 * @param efCustIC 投资人身份证号码
//	 * @param crmCustIC 借款人身份证号码
	 * @param contractPath 合同路径
	 * @param orderId 订单id
	 */
	public static boolean caSignaturePL(String contractNumber,String contractPath,String orderId,String contractName,String ftpPath,List<Map<String, Object>> signatures,String appcode,String channel) {
		 
		    
		//找到下载的PDF文件
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(contractPath);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String  ftppath= "capdf";
		String FtpContractName = null;
//		String  FtpContractName = DateUtil.getCurrentTime(DateUtil.STYLE_2)+RandomNumberUtil.getNumber(0)+".pdf";
		// 上传至FTP
		boolean flag = true;
//		boolean flag = FtpOperation.uploadFile(ftppath,FtpContractName, inputStream, null);
		
		boolean flags=false;
		if(flag){
			// 去CA签章
			JSONArray jaona = new JSONArray(); 
			JSONObject jsonCA = new JSONObject();
			jsonCA.put("title","合同签章");
			jsonCA.put("docNum",contractNumber);
			jsonCA.put("reqSource","erp");
			jsonCA.put("channel",channel);
			jsonCA.put("orderNum",orderId);
			jsonCA.put("doc",FtpContractName);
			jsonCA.put("path", ftppath);
			jsonCA.put("docType","pdf");
			jsonCA.put("docName",contractNumber);
			jsonCA.put("signatures",signatures);
			JSONObject CAJson = new JSONObject();
			jaona.add(jsonCA);
			CAJson.put("jsonParms", jaona);
			CAJson.put("ignoreError", "false");
			logger.warn("开始请求CA签章,crm_apply_id："+orderId+"，请求参数为：。。。"+contractNumber);

			System.out.println("====="+CAJson.toString());
			// TODO: 2018/2/26  
			String result = null;
//			String result = HttpUtil.sendPost(SysConfig.getProperty("v3ServiceXfireWebServiceCABatchIntactSignPath"), new Object[]{CAJson});
//			ResponseEntity entity = RestReqUtil.reqPyConnection(url, reqMap, method);
//			result = entity.getBody().toString();
			JSONObject caResult = JSONObject.fromObject(result);
			try {
				if((boolean) caResult.get("success")){
					logger.warn("合同签章成功，crm_apply_id："+orderId+"，合同编号为：。。。"+contractNumber);
					JSONArray resultCA= JSONArray.fromObject(caResult.get("signatureRespItemVoList"));
					for (int i = 0; i < resultCA.size(); i++) {
						JSONObject contractftp=(JSONObject) resultCA.get(i);
						if("1".equals(contractftp.get("responseCode"))){
							String downloadoath = contractftp.getString("path")+"/";
							String contractNewName = contractftp.getString("newFileName");
							String contractFtpPath = contractPath.substring(0, 88);
							//下载ftp上的模版文件
							// TODO: 2018/2/26  
//							FtpOperation.getDataFiles(downloadoath+contractNewName,contractFtpPath, contractName);
							//找到下载的PDF文件
							FileInputStream inputStreams = new FileInputStream(contractPath);
							byte[] b =new byte[1024];
							 b =TransformUtil.readInputStream(inputStreams);
							InputStream contractInput = new ByteArrayInputStream(b); 
							//调用ftp工具类上传文件
							// TODO: 2018/2/26  
//							FtpOperation.uploadFile(ftpPath, contractName, contractInput);
							 try {
									FileOutputStream fileStream = new FileOutputStream("D:/"+contractName);
									fileStream.write(b);
									fileStream.flush();
									fileStream.close();
								} catch (FileNotFoundException e) {
									e.printStackTrace();
								} catch (IOException e) {
									e.printStackTrace();
								}
						}
					}
				}else{
					logger.warn("合同签章失败，crm_apply_id："+orderId+"，合同编号为："+contractNumber+"CA返回的错误信息为："+(String) caResult.get("info"));
					flags=false;
				}
			} catch (Exception e) {
				logger.warn("合同签章失败，crm_apply_id："+orderId+"，合同编号为："+contractNumber+"CA返回的错误信息为："+(String) caResult.get("info"));
				flags=false;

			}
		}
		return flags;
	}
	
	
	/**
	 * 根据合同类型获取盖章位置
	 * 
	 * @param contractType 合同类型  01 出借人协议 02 借款人协议  03 借款协议
	 * @param efCustIC 投资人身份证号码
	 * @param crmCustIC 借款人
	 *  
	 */
	public static List<Map<String, Object>> getlistSignatures(String contractType, String efCustIC, String crmCustIC, JSONArray investorsArray, String channel) {
		List<Map<String, Object>> listSignatures = new ArrayList<Map<String, Object>>();
		//当合同类型为01时
		if(contractType.endsWith("01")){
			Map<String, Object> mapSignature1 = new HashMap<String, Object>();
			mapSignature1.put("userType", 0);
			mapSignature1.put("userCode", efCustIC); 
			mapSignature1.put("page", 3);
			mapSignature1.put("positionX", 125);
			mapSignature1.put("positionY", 600);
			
			Map<String, Object> mapSignature2 = new HashMap<String, Object>();
			mapSignature2.put("userType", 1);
			mapSignature2.put("userCode", "58550169-4");
			mapSignature2.put("page", 3);
	 	   	mapSignature2.put("positionX", 110);
	 	   	mapSignature2.put("positionY", 500);   
			
	 	   	Map<String, Object> mapSignature3 = new HashMap<String, Object>();
	 	   	mapSignature3.put("userType", 1);
	 	   	mapSignature3.put("userCode", "30198142-0");
	 	   	mapSignature3.put("page", 3);
	 	   	mapSignature3.put("positionX", 110);
	 	   	mapSignature3.put("positionY", 400);  
			listSignatures.add(mapSignature1); 
		 	listSignatures.add(mapSignature2);
		 	listSignatures.add(mapSignature3);
		 	
		}else if(contractType.endsWith("02")){
			//易保全
			if (ConstantSysParam.CA_CHANNEL_DEFAULT.equals(channel)) {
				List<Map<String, Object>> positionList2 = new ArrayList<Map<String, Object>>();
				List<Map<String, Object>> positionList3 = new ArrayList<Map<String, Object>>();
				List<Map<String, Object>> positionList4 = new ArrayList<Map<String, Object>>();
				/*第一页的位置信息*/
				Map<String, Object> position21 = new HashMap<String, Object>(); 
				Map<String, Object> position22 = new HashMap<String, Object>(); 
				Map<String, Object> position31 = new HashMap<String, Object>(); 
				/*第二页的位置信息*/
				Map<String, Object> position32 = new HashMap<String, Object>(); 
				Map<String, Object> position41 = new HashMap<String, Object>(); 
				Map<String, Object> position42 = new HashMap<String, Object>(); 
				/**
				 * 第2页
				 */
				Map<String, Object> mapSignature2 = new HashMap<String, Object>();
				mapSignature2.put("userType", 1);
				mapSignature2.put("userCode", "30203664-X");//苏州中资联信息咨询有限公司
				position22.put("page", 2);
				position22.put("positionY", 0.8);   
				position22.put("positionX", 0.5);
				
				Map<String, Object> mapSignature3 = new HashMap<String, Object>();
				mapSignature3.put("userType", 1);
				mapSignature3.put("userCode", "30198142-0");//苏州中资联信用管理有限公司
				position32.put("page", 2);
				position32.put("positionY", 0.95);  
				position32.put("positionX", 0.2);
				
				
				Map<String, Object> mapSignature4 = new HashMap<String, Object>();
				mapSignature4.put("userType", 1);
				mapSignature4.put("userCode", "58550169-4");//苏州中资联投资管理有限公司
				position42.put("page", 2);
				position42.put("positionY", 0.95);  
				position42.put("positionX", 0.5);
				/**
				 * 第1页
				 */
				position21.put("page", 1);
				position21.put("positionY", 0.5);   
				position21.put("positionX", 0.6);
				
				position31.put("page", 1);
				position31.put("positionY", 0.7);  
				position31.put("positionX", 0.3);
				
				
				position41.put("page", 1);
				position41.put("positionY", 0.7);  
				position41.put("positionX", 0.6);
				
				positionList2.add(position21);
				positionList2.add(position22);
				mapSignature2.put("position", positionList2);
				positionList3.add(position31);
				positionList3.add(position32);
				mapSignature3.put("position", positionList3);
				positionList4.add(position41);
				positionList4.add(position42);
				mapSignature4.put("position", positionList4);
				listSignatures.add(mapSignature2);
				listSignatures.add(mapSignature3);
				listSignatures.add(mapSignature4);
			}else{
				/**
				 * 第2页
				 */
				Map<String, Object> mapSignature2 = new HashMap<String, Object>();
				mapSignature2.put("userType", 1);
				mapSignature2.put("userCode", "30203664-X");
				mapSignature2.put("page", 2);
				mapSignature2.put("positionY", 125);   
				mapSignature2.put("positionX", 320);
				
				Map<String, Object> mapSignature3 = new HashMap<String, Object>();
				mapSignature3.put("userType", 1);
				mapSignature3.put("userCode", "30198142-0");
				mapSignature3.put("page", 2);
				mapSignature3.put("positionY", 20);  
				mapSignature3.put("positionX", 120);
				
				
				Map<String, Object> mapSignature4 = new HashMap<String, Object>();
				mapSignature4.put("userType", 1);
				mapSignature4.put("userCode", "58550169-4");
				mapSignature4.put("page", 2);
				mapSignature4.put("positionY", 20);  
				mapSignature4.put("positionX", 320);
				/**
				 * 第1页
				 */
				Map<String, Object> mapSignature22 = new HashMap<String, Object>();
				mapSignature22.put("userType", 1);
				mapSignature22.put("userCode", "30203664-X");
				mapSignature22.put("page", 1);
				mapSignature22.put("positionY", 225);   
				mapSignature22.put("positionX", 320);
				
				Map<String, Object> mapSignature23 = new HashMap<String, Object>();
				mapSignature23.put("userType", 1);
				mapSignature23.put("userCode", "30198142-0");
				mapSignature23.put("page", 1);
				mapSignature23.put("positionY", 120);  
				mapSignature23.put("positionX", 120);
				
				
				Map<String, Object> mapSignature24 = new HashMap<String, Object>();
				mapSignature24.put("userType", 1);
				mapSignature24.put("userCode", "58550169-4");
				mapSignature24.put("page", 1);
				mapSignature24.put("positionY", 120);  
				mapSignature24.put("positionX", 320);
				
				listSignatures.add(mapSignature2);
				listSignatures.add(mapSignature3);
				listSignatures.add(mapSignature4);
				listSignatures.add(mapSignature22);
				listSignatures.add(mapSignature23);
				listSignatures.add(mapSignature24);
			}
			
		}else if(contractType.endsWith("03")){
			//去掉重复的数据
			JSONArray tempArray=new JSONArray();
			tempArray.add(investorsArray.get(0));
			for (int i = 0; i < investorsArray.size(); i++) {
				boolean repeat = false;
				JSONObject baseJson = investorsArray.getJSONObject(i);
				String investorsIc = baseJson.getString("investorsIc");
				for (int k = 0; k < tempArray.size(); k++) {
					JSONObject temp = tempArray.getJSONObject(k);
					String tempinvestorsIc = temp.getString("investorsIc");
					if (tempinvestorsIc.equals(investorsIc)) {
						repeat = true;
					}
				}
				if (!repeat) {
					tempArray.add(investorsArray.get(i));
				}
			}
			//易保全
			if (ConstantSysParam.CA_CHANNEL_DEFAULT.equals(channel)) {
				double initalpositionX=0.20;
				double initalpositionY=0.59;
				int count=investorsArray.size();
				initalpositionY=initalpositionY+0.0185*(count-1);
				if(initalpositionY<0)initalpositionY=0;
				double n=0;
				int m=0;
				double ny=0;
				double nyn=0;
				for (int i = 0; i < tempArray.size(); i++) {
					if (i==5 || i==10 || i==15 || i==20 || i==25 || i==30 || i==35 || i==40) {
						initalpositionX=0.2;m=0;
					}
					if (i>4)	n=0.05;	//6个投资人另起一行
					if (i>9) 	n=0.1;	//11个投资人另起一行
					if (i>14) 	n=0.15;	//19个投资人另起一行
					if (i>19)	n=0.2;	//26个投资人另起一行
					if (i>24)	n=0.25;	//26个投资人另起一行
					if (i>29)	n=0.3;	//26个投资人另起一行
					if (i>34)	n=0.35;	//26个投资人另起一行
					JSONObject investorsJson = (JSONObject) tempArray.get(i);
					String investorsIc = investorsJson.getString("investorsIc");
					String investorsMobile = investorsJson.getString("investorsMobile");
					String investorsName = investorsJson.getString("investorsName");
					/**
					 * 第3页
					 */
					// 投资人章
					Map<String, Object> mapSignature3 = new HashMap<String, Object>(); 
					List<Map<String, Object>> positionList = new ArrayList<Map<String, Object>>();
					Map<String, Object> position3 = new HashMap<String, Object>(); 
					Map<String, Object> position2 = new HashMap<String, Object>(); 
					mapSignature3.put("userType", 0);
					mapSignature3.put("userCode", investorsIc);
					/*CA开户需要的参数 begin*/
					mapSignature3.put("reqSource","erp");
					mapSignature3.put("papersType", "身份证");
					mapSignature3.put("idCardNum", investorsIc);
					mapSignature3.put("mobile", investorsMobile);
					mapSignature3.put("fullName", investorsName);
					mapSignature3.put("Signature","");
					mapSignature3.put("email","");
					/*CA开户需要的参数 end*/
					position3.put("page", 3);
					if (count>15) {
						position3.put("page", 4);
					}
					position3.put("positionX", initalpositionX+0.13*m);
					position3.put("positionY", 0.45+n);
					/**
					 * 第2页
					 */
					
					/*CA开户需要的参数 end*/
					position2.put("page", 2);
					position2.put("positionX", initalpositionX+0.13*m);
					position2.put("positionY", initalpositionY+n);
					if (count>15) {
						initalpositionY=0.5;
						position2.put("page", 3);
						position2.put("positionY", initalpositionY+n);
					}
					/*if ((Double)mapSignature1.get("positionY")>1) {
						ny=0.5;
						if (i>14)	nyn=0.05;	//26个投资人另起一行
						if (i>19)	nyn=0.1;	//26个投资人另起一行
						if (i>24)	nyn=0.15;	//26个投资人另起一行
						if (i>29)	nyn=0.2;	//26个投资人另起一行
						if (i>34)	nyn=0.25;	//26个投资人另起一行
						mapSignature1.put("page", 3);
						mapSignature1.put("positionY", ny+nyn);
						if (count>20) {
							mapSignature1.put("positionY", ny+n);
						}
					}*/
					positionList.add(position2);
					positionList.add(position3);
					mapSignature3.put("position", positionList);
					listSignatures.add(mapSignature3);
					
					m++;
				}
			}else{
				int initalpositionX=148;
				int initalpositionY=405;
				int count=investorsArray.size();
				initalpositionY=initalpositionY-18*(count-1);
				if(initalpositionY<0)initalpositionY=0;
				int n=0;
				int m=0;
				int ny=0;
				int nyn=0;
				for (int i = 0; i < tempArray.size(); i++) {
					if (i==3 || i==7 || i==11 || i==15 || i==19 || i==23 || i==27 || i==31) {
						initalpositionX=23;m=0;
					}
					if (i>2)	n=40;	//3个投资人另起一行
					if (i>6) 	n=80;	//12个投资人另起一行
					if (i>10) 	n=120;	//19个投资人另起一行
					if (i>14)	n=160;	//26个投资人另起一行
					if (i>18)	n=200;	//26个投资人另起一行
					if (i>22)	n=240;	//26个投资人另起一行
					if (i>26)	n=280;	//26个投资人另起一行
					if (i>30)	n=320;	//26个投资人另起一行
					JSONObject investorsJson = (JSONObject) tempArray.get(i);
					String investorsIc = investorsJson.getString("investorsIc");
					String investorsMobile = investorsJson.getString("investorsMobile");
					String investorsName = investorsJson.getString("investorsName");
					/**
					 * 第3页
					 */
					// 投资人章
					Map<String, Object> mapSignature3 = new HashMap<String, Object>(); 
					mapSignature3.put("userType", 0);
					mapSignature3.put("userCode", investorsIc);
					/*CA开户需要的参数 begin*/
					mapSignature3.put("reqSource","erp");
					mapSignature3.put("papersType", "身份证");
					mapSignature3.put("idCardNum", investorsIc);
					mapSignature3.put("mobile", investorsMobile);
					mapSignature3.put("fullName", investorsName);
					mapSignature3.put("Signature","");
					mapSignature3.put("email","");
					/*CA开户需要的参数 end*/
					mapSignature3.put("page", 3);
					if (count>12) {
						mapSignature3.put("page", 4);
					}
					mapSignature3.put("positionX", initalpositionX+125*m);
					mapSignature3.put("positionY", 405-n);
					/**
					 * 第2页
					 */
					// 投资人章
					Map<String, Object> mapSignature1 = new HashMap<String, Object>();
					mapSignature1.put("userType", 0);
					mapSignature1.put("userCode", investorsIc);
					/*CA开户需要的参数 begin*/
					mapSignature1.put("reqSource","erp");
					mapSignature1.put("papersType", "身份证");
					mapSignature1.put("idCardNum", investorsIc);
					mapSignature1.put("mobile", investorsMobile);
					mapSignature1.put("fullName", investorsName);
					mapSignature1.put("Signature","");
					mapSignature1.put("email","");
					/*CA开户需要的参数 end*/
					mapSignature1.put("page", 2);
					mapSignature1.put("positionX", initalpositionX+125*m);
					mapSignature1.put("positionY", initalpositionY-60-n);
					
					if ((Integer)mapSignature1.get("positionY")<17) {
						ny=540;
						if (i>14)	nyn=40;	//26个投资人另起一行
						if (i>18)	nyn=80;	//26个投资人另起一行
						if (i>22)	nyn=120;	//26个投资人另起一行
						if (i>26)	nyn=120;	//26个投资人另起一行
						if (i>30)	nyn=120;	//26个投资人另起一行
						mapSignature1.put("page", 3);
						mapSignature1.put("positionY", ny-nyn);
						if (count>12) {
							mapSignature1.put("positionY", ny-n);
						}
					}
					
					listSignatures.add(mapSignature1);
					listSignatures.add(mapSignature3);
					
					m++;
				}
			}
		}else if(contractType.endsWith("04")){
			//投资人章
			Map<String, Object> mapSignature1 = new HashMap<String, Object>();
			mapSignature1.put("userType", 0);
			mapSignature1.put("userCode", efCustIC); 
			mapSignature1.put("page", 2);
			mapSignature1.put("positionX", 80);
			mapSignature1.put("positionY", 240); 
			//借款人章
	 	   	Map<String, Object> mapSignature2 = new HashMap<String, Object>();
	 	   	mapSignature2.put("userType", 0);
	 	   	mapSignature2.put("userCode", crmCustIC);
	 	   	mapSignature2.put("page", 2);
	 	   	mapSignature2.put("positionX", 470);
	 	   	mapSignature2.put("positionY", 240);   
			
	 	   	listSignatures.add(mapSignature1); 
	 	   	listSignatures.add(mapSignature2);
			
			
		}else if(contractType.endsWith("05")){
			if (ConstantSysParam.CA_CHANNEL_DEFAULT.equals(channel)) {
				//借款人章
		 	   	Map<String, Object> mapSignature2 = new HashMap<String, Object>();
		 	    mapSignature2.put("userType", 1);
		 	    mapSignature2.put("userCode", "30198142-0");
		 	   	mapSignature2.put("page", 1);
		 	   	mapSignature2.put("positionX", 0.7);
		 	   	mapSignature2.put("positionY", 0.5);   
				
		 	   	listSignatures.add(mapSignature2);
			}else{
				//借款人章
				Map<String, Object> mapSignature2 = new HashMap<String, Object>();
				mapSignature2.put("userType", 1);
				mapSignature2.put("userCode", "30198142-0");
				mapSignature2.put("page", 1);
				mapSignature2.put("positionX", 420);
				mapSignature2.put("positionY", 450);   
				
				listSignatures.add(mapSignature2);
			}
		}
		else if(contractType.endsWith("06")){
			//借款人章
	 	   	Map<String, Object> mapSignature2 = new HashMap<String, Object>();
	 	    mapSignature2.put("userType", 1);
	 	    mapSignature2.put("userCode", "30198142-0");
	 	   	mapSignature2.put("page", 2);
	 	   	mapSignature2.put("positionX", 420);
	 	   	mapSignature2.put("positionY", 450);   
			
	 	   	listSignatures.add(mapSignature2);
		}
		return listSignatures;
	}
	
	
	public static void main(String[] args) throws Exception {
		String a="[{\"id\":\"402897e15b6f97b0015b6fa16f2c000d\",\"index\":1,\"investorsMobile\":\"13201612152\",\"currentDate\":\"2017-04-17\",\"investorsName\":\"邵测一\",\"ef_orders_id\":\"402897e15b6f97b0015b6fa16f46000e\",\"investorsIc\":\"330481199201085213\",\"ef_fective_amt\":3110},"
				+ "{\"id\":\"402897e15b6f97b0015b6fa16f2c000d\",\"index\":1,\"investorsMobile\":\"13201612152\",\"currentDate\":\"2017-04-17\",\"investorsName\":\"邵测一\",\"ef_orders_id\":\"402897e15b6f97b0015b6fa16f46000e\",\"investorsIc\":\"330481199201085213\",\"ef_fective_amt\":3110},"
				+ "{\"id\":\"402897e15b6f97b0015b6fa16f2c000d\",\"index\":1,\"investorsMobile\":\"13201612152\",\"currentDate\":\"2017-04-17\",\"investorsName\":\"邵测一\",\"ef_orders_id\":\"402897e15b6f97b0015b6fa16f46000e\",\"investorsIc\":\"330481199201085213\",\"ef_fective_amt\":3110},"
				+ "{\"id\":\"402897e15b6f97b0015b6fa16f2c000d\",\"index\":1,\"investorsMobile\":\"13201612152\",\"currentDate\":\"2017-04-17\",\"investorsName\":\"邵测一\",\"ef_orders_id\":\"402897e15b6f97b0015b6fa16f46000e\",\"investorsIc\":\"330481199201085213\",\"ef_fective_amt\":3110},"
				+ "{\"id\":\"402897e15b6f97b0015b6fa16f2c000d\",\"index\":1,\"investorsMobile\":\"13201612152\",\"currentDate\":\"2017-04-17\",\"investorsName\":\"邵测一\",\"ef_orders_id\":\"402897e15b6f97b0015b6fa16f46000e\",\"investorsIc\":\"330481199201085213\",\"ef_fective_amt\":3110},"
				+ "{\"id\":\"402897e15b6f97b0015b6fa16f2c000d\",\"index\":1,\"investorsMobile\":\"13201612152\",\"currentDate\":\"2017-04-17\",\"investorsName\":\"邵测二\",\"ef_orders_id\":\"402897e15b6f97b0015b6fa16f46000e\",\"investorsIc\":\"330481199201085213\",\"ef_fective_amt\":3110},"
				+ "{\"id\":\"402897e15b6f97b0015b6fa16f2c000d\",\"index\":1,\"investorsMobile\":\"13201612152\",\"currentDate\":\"2017-04-17\",\"investorsName\":\"邵测二\",\"ef_orders_id\":\"402897e15b6f97b0015b6fa16f46000e\",\"investorsIc\":\"330481199201085213\",\"ef_fective_amt\":3110},"
				+ "{\"id\":\"402897e15b6f97b0015b6fa16f2c000d\",\"index\":1,\"investorsMobile\":\"13201612152\",\"currentDate\":\"2017-04-17\",\"investorsName\":\"邵测二\",\"ef_orders_id\":\"402897e15b6f97b0015b6fa16f46000e\",\"investorsIc\":\"330481199201085213\",\"ef_fective_amt\":3110},"
				+ "{\"id\":\"402897e15b6f97b0015b6fa16f2c000d\",\"index\":1,\"investorsMobile\":\"13201612152\",\"currentDate\":\"2017-04-17\",\"investorsName\":\"邵测二\",\"ef_orders_id\":\"402897e15b6f97b0015b6fa16f46000e\",\"investorsIc\":\"330481199201085213\",\"ef_fective_amt\":3110},"
				+ "{\"id\":\"402897e15b6f97b0015b6fa16f2c000d\",\"index\":1,\"investorsMobile\":\"13201612152\",\"currentDate\":\"2017-04-17\",\"investorsName\":\"邵测二\",\"ef_orders_id\":\"402897e15b6f97b0015b6fa16f46000e\",\"investorsIc\":\"330481199201085213\",\"ef_fective_amt\":3110},"
				+ "{\"id\":\"402897e15b6f97b0015b6fa16f2c000d\",\"index\":1,\"investorsMobile\":\"13201612152\",\"currentDate\":\"2017-04-17\",\"investorsName\":\"邵测二\",\"ef_orders_id\":\"402897e15b6f97b0015b6fa16f46000e\",\"investorsIc\":\"330481199201085213\",\"ef_fective_amt\":3110},"
				+ "{\"id\":\"402897e15b6f97b0015b6fa16f2c000d\",\"index\":1,\"investorsMobile\":\"13201612152\",\"currentDate\":\"2017-04-17\",\"investorsName\":\"邵测一\",\"ef_orders_id\":\"402897e15b6f97b0015b6fa16f46000e\",\"investorsIc\":\"330481199201085213\",\"ef_fective_amt\":3110}]";
		String a1="[{\"id\":\"402897e15b6f97b0015b6fa16f2c000d\",\"index\":1,\"investorsMobile\":\"13201612152\",\"currentDate\":\"2017-04-17\",\"investorsName\":\"邵测一\",\"ef_orders_id\":\"402897e15b6f97b0015b6fa16f46000e\",\"investorsIc\":\"330481199201085213\",\"ef_fective_amt\":3110}]";
		JSONArray array = JSONArray.fromObject(a);
		List<Map<String, Object>> listSignatures = CaSignatureUtil.getlistSignatures( "03", "", "",array,ConstantSysParam.CA_CHANNEL_DEFAULT);
		// 获取合同协议号的流水号
		String key = "cwtest"+new Random().nextInt(99999999);
//		String channel = RedisCacheUtil.getCAChannel();
		String channel = ConstantSysParam.CA_CHANNEL_DEFAULT;
		CaSignatureUtil.caSignature(key, "D:/atest/借款协议.pdf", "ff8080815542943d015542eaf128024a","借款协议.pdf","ERPV3/533422198905003181/CONTRACT/2c908a885a8df581015a9385b27f04d5/20170417/",listSignatures,null,channel);
//		CaSignatureUtil.caSignature(key, "D:/atest/居间服务协议.pdf", "ff8080815542943d015542eaf128024a","居间服务协议.pdf","ERPV3/533422198905003181/CONTRACT/2c908a885a8df581015a9385b27f04d5/20170417/",listSignatures,null,ConstantSysParam.CA_CHANNEL_DEFAULT);
		 
	}
	
	/**
	 * 新合同签章
	* @Title: newCaSignature 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @autor sky
	* @param @param pdfUrl	未签章合同地址（pdf 原地址
	* @param @param docNum	合同编号（每次必须唯一，并且每次都唯一
	* @param @param channel 签章通道（天威：000023-0001，易宝全：000023-0002
	* @param @param position 签章的章印信息
	* @param @param caPdfUrl 签章过的pdf 路径
	* @param @param contractName	生成的合同名称
	* @param @return    设定文件 
	* @return JsonModel    返回类型 
	* @throws
	 */
	public static JsonModel newCaSignature(String pdfUrl, String docNum, String channel, List position, String caPdfUrl, String contractName){
		
		// 返回参数
		JsonModel jm = new JsonModel();
		
		logger.info("从本地PDF文件进行签章操作：" +pdfUrl);
		// 获取本地文件流
		String doc=TransformUtil.readImageOrFile(pdfUrl);
		if(StringUtil.isEmpty(doc)){
			logger.info("读取本地PDF文件doc异常，返回空异常：" +doc);
		}
		// 去CA签章
		JSONObject jsonCA = new JSONObject();
		jsonCA.put("title","合同签章");
		jsonCA.put("docNum",docNum);
		jsonCA.put("reqSource","erp");
		jsonCA.put("channel",channel);
		jsonCA.put("orderNum",docNum);
		jsonCA.put("docType","pdf");
		jsonCA.put("docName",docNum);
		jsonCA.put("signatures",JSONArray.fromObject(position));
		jsonCA.put("doc",doc);
		JSONObject CAJson = new JSONObject();
		CAJson.put("jsonParms", jsonCA);
		String result = null;
		try {
			result = HttpServiceUtil.sendPost("v3ServiceXfireWebServiceCAIntactSignPath", CAJson);
			logger.debug("CA盖章结果:======"+result);
		} catch (Exception e1) {
			jm.setCode(ContractCode.EXCE00004.getCode());
			jm.setInfo(ContractCode.EXCE00004.getInfo()+"-");
			return jm;
		}
		JSONObject caResult = JSONObject.fromObject(result);
		if("1".equals(caResult.getString("responseCode"))){
			jm.setCode(ContractCode.SUCC00003.getCode());
			jm.setInfo(ContractCode.SUCC00003.getInfo());
			String resultDoc= (String) caResult.get("uuid");
			byte[] b =new byte[1024];
			if (ConstantSysParam.CA_CHANNEL_DEFAULT.equals(channel)) {
				try {
					URL url = new URL(resultDoc);
					HttpURLConnection conn = (HttpURLConnection)url.openConnection();    
			          //设置超时间为3秒  
		            conn.setConnectTimeout(3*10000);
		            //防止屏蔽程序抓取而返回403错误  
		            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");  
		            //得到输入流
		            InputStream inputStream = conn.getInputStream();
		            //获取自己数组  
		            b =TransformUtil.readInputStream(inputStream);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				b = Base64.decode(resultDoc);
			}
			InputStream contractInput = new ByteArrayInputStream(b); 
	 		
			try {  
		        // ============ 正式环境用，上传到服务器 ====================
		        //上传文件
				String caPdfNewName = caPdfUrl.substring(caPdfUrl.lastIndexOf("/")+1);
				String caPdfNewUrl = caPdfUrl.substring(0, caPdfUrl.lastIndexOf("/")+1);
				logger.debug("准备上传盖过章的合同："+result);
				// TODO: 2018/2/26  上传ca签章过的pdf文件
//		        FtpOperation.uploadFile(caPdfNewUrl, caPdfNewName, contractInput);
				jm.setCode(ContractCode.SUCC00005.getCode());
				jm.setInfo(ContractCode.SUCC00005.getInfo());
		    } catch (Exception e) {  
		        e.printStackTrace(); 
		        jm.setCode(ContractCode.EXCE00011.getCode());
				jm.setInfo(ContractCode.EXCE00011.getInfo()+"-"+e.getMessage());
				return jm;
		    }finally {
		    	 try {
					contractInput.close();
				} catch (IOException e) {
				}
			}     
		}else{
			jm.setCode(ContractCode.EXCE00004.getCode());
			jm.setInfo(result);
			return jm;
		}
		
		return jm;
	}
	
}
