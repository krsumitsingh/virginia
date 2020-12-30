package com.guru99demo.helper.browserConfiguration.config;

import com.guru99demo.helper.browserConfiguration.BrowserType;

public interface ConfigReader {
	
	public int getImpliciteWait();
	public int getExplicitWait();
	public int getPageLoadTime();
	public BrowserType getBrowserType();
	public String getUrl();
	public String getUserName();
	public String getPassword();
	public String getQty();
	public String getFirstName();
	public String getLastName();
	public String getEmailAddress();
	public String getPwd();
	public String getConfirmPwd();
	public String getMessage();
	
}
