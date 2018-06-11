package com.fintecher.contract.util.caUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;


/**
 * 功能说明：文件 与base64位 相互转化
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
public class TransformUtil {

	private static Logger log= LoggerFactory.getLogger(TransformUtil.class);
	/**
	 * 读取图章或文件,转化为 base64格式的字符串
	 * @param path
	 * @return base64格式的字符串
	 */
	public static String readImageOrFile(String path) {
		File file = new File(path);
		
		log.info("读取本地文件实际目录为："+path);
		log.info("读取本地文件实际目录是否存在："+file.exists());
		//若本地文件不存在
		if(!file.exists()){
			log.info("文件不存在：" + path);
		}
		InputStream stream=null;
		try {
			stream = new FileInputStream(file);
			byte[] bt = new byte[stream.available()];
			stream.read(bt);
			String encode = new String(Base64.encode(bt));
			return encode;
		} catch (FileNotFoundException e) {
			log.error("", e);
		} catch (IOException e) {
			log.error("", e);
		}finally{
			if(stream!=null){
				try {
					stream.close();
				} catch (IOException e) {
				}
			}
		}
		return null;
	}
	
	
	
	/**
	 * 将base64格式的字符串 转化为文件输出
	 * @param doc base64格式的字符串   outputFile 输出地址
	 * @return   文件
	 */
	public static File getFileFromBytes(String doc, String outputFile) {
		
		byte[] b=Base64.decode(doc);
		
		File ret = null;
		BufferedOutputStream stream = null;
		try {
			ret = new File(outputFile);
			FileOutputStream fstream = new FileOutputStream(ret);
			stream = new BufferedOutputStream(fstream);
			stream.write(b);
		} catch (Exception e) {
			log.error("", e);
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
				}
			}
		}
		return ret;
	}
	/** 
     * 从输入流中获取字节数组 
     * @param inputStream 
     * @return 
     * @throws IOException 
     */  
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
}
