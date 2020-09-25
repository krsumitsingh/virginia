package com.guru99demo.helper.logger;

import org.apache.log4j.*;

import com.guru99demo.helper.resource.ResourceHelper;

public class LoggerHelper {
	
	private static boolean root = false;
	
	public static Logger getLogger(Class cls){
		if(root){
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure(ResourceHelper.getResourcePath("resources/configFile/log4j.properties"));
		root=true;
		return Logger.getLogger(cls);		
	}

	/****************************************************************************************
	/**
	 * TO test the logger method working or not
	 * @param args
	 */
	/*public static void main(String[] args) {
	Logger log=	LoggerHelper.getLogger(LoggerHelper.class);
		log.info("Log is configured");
	}*/
}
