package com.fintecher.contract.config.freeMaker;

import freemarker.template.Configuration;

public class FreemarkerConfiguration {

private static Configuration config = null;
private static Configuration htmlConfig = null;
	
	/**
	 * Static initialization.
	 * 
	 * Initialize the configuration of Freemarker.
	 */
	static{
		config = new Configuration();
		config.setClassForTemplateLoading(FreemarkerConfiguration.class, "/template/");
	}
	
	public static Configuration getConfiguation(){
		return config;
	}
	
	static{
		htmlConfig = new Configuration();
		htmlConfig.setClassForTemplateLoading(FreemarkerConfiguration.class, "/htmlTemplate/");
	}
	
	public static Configuration getHtmlConfiguation(){
		return htmlConfig;
	}
	
}
