package com.guru99demo.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99demo.helper.logger.LoggerHelper;

public class HomePage {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(HomePage.class);
    
	@FindBy(xpath="//h2[text()='Guru99 Bank']")
	WebElement homepageTitle;

	
	HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//HomePage homepage = new HomePage(driver);
		
	}
	
	
}
