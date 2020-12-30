package com.guru99demo.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99demo.helper.assertions.VerificationHelper;
import com.guru99demo.helper.javaScript.JavaScriptHelper;
import com.guru99demo.helper.logger.LoggerHelper;
import com.guru99demo.testBase.TestBase;

public class HomePage {
		
	private WebDriver driver;

	private Logger log = LoggerHelper.getLogger(HomePage.class);
	
	JavaScriptHelper javascripthelper;
	
	@FindBy(xpath = "//body/div[1]/div[1]/div[3]/div[1]/div[4]/ul[1]/li[1]/a[1]")
	WebElement myAccountLink;
	
	@FindBy(css = "div.page-title h1")
	WebElement createAccountMsg;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		javascripthelper = new JavaScriptHelper(driver);
		TestBase.logExtentReport("HomePage Object Created");
	}
	
	
	public MyAccountPage clickMyAccountLink(){
		log.info("user clicks on my account link...");
		javascripthelper.clickElement(myAccountLink);
		TestBase.logExtentReport("my account link clicked...");
		return new MyAccountPage(driver);
	}
	
	public boolean verifyMsg() {
		return new VerificationHelper(driver).elementIsDisplayed(createAccountMsg);
	}
	
	

}
