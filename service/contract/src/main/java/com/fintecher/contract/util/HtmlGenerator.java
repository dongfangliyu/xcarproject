package com.fintecher.contract.util;

import com.fintecher.contract.config.freeMaker.FreemarkerConfiguration;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;


/**
 * 根据模板 生成 html 生成工具类
 * @author wangcy
 *
 */
public class HtmlGenerator {
	
	public static String htmlGenerate(String template, Map<String,Object> variables) throws IOException, TemplateException {
		Configuration config = FreemarkerConfiguration.getConfiguation();
		config.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
		config.setDefaultEncoding("utf-8");
		config.setCacheStorage(new freemarker.cache.MruCacheStorage(20, 250)); //对模板的缓存进行一个设置
		Template tp = config.getTemplate(template);
		StringWriter stringWriter = new StringWriter();  
		BufferedWriter writer = new BufferedWriter(stringWriter);  
		tp.setEncoding("UTF-8");
		tp.process(variables, writer);  
		String htmlStr = stringWriter.toString();
		writer.flush();  
		writer.close();
		return htmlStr;
	}
	
	
	public static String blankHtmlGenerate(String path) throws IOException, TemplateException {
		Configuration config = FreemarkerConfiguration.getHtmlConfiguation();
		config.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
		config.setDefaultEncoding("utf-8");
		Template tp = config.getTemplate(path);
//		FileWriterWithEncoding out = new FileWriterWithEncoding(path,"UTF-8");
//		StringWriter stringWriter = new StringWriter();
//		BufferedWriter writer = new BufferedWriter(stringWriter);
		tp.setEncoding("UTF-8");
		return tp.toString();
	}
	
//	public static void main(String[] args) {
//		Configuration config = FreemarkerConfiguration.getConfiguation();
//		config.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
//		config.setDefaultEncoding("utf-8");
//		try {
//			Template tp = config.getTemplate("commitment.ftl");
//			System.out.println(tp);
//		} catch (TemplateNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MalformedTemplateNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

}
