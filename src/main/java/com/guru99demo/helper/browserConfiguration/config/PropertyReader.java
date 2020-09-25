package com.guru99demo.helper.browserConfiguration.config;

import java.io.FileInputStream;
import java.util.Properties;
import com.guru99demo.helper.browserConfiguration.BrowserType;
import com.guru99demo.helper.resource.ResourceHelper;

public class PropertyReader implements ConfigReader {
	
	public static Properties OR;
	
    private static FileInputStream file;
    
	public PropertyReader() {
		
		try {
			file = new FileInputStream(ResourceHelper.getResourcePath("resources/configFile/config.properties"));
			OR = new Properties();
			OR.load(file);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getImpliciteWait() {
		return Integer.parseInt(OR.getProperty("IMPLICITWAIT"));
		
	}

	public int getExplicitWait() {
		return Integer.parseInt(OR.getProperty("EXPLICITWAIT"));
	}

	public int getPageLoadTime() {
		return Integer.parseInt(OR.getProperty("PAGELOADTIME"));
	}

	public BrowserType getBrowserType() {
		return BrowserType.valueOf(OR.getProperty("browserType"));
	}

	public String getUrl() {	
		if(System.getProperty("url")!=null){
			return System.getProperty("url");		
		}
		return OR.getProperty("applicationUrl");
	}

	public String getUserName() {
		return OR.getProperty("userId");
	}

	public String getPassword() {
		return OR.getProperty("password");
	}
	
	
	

}
