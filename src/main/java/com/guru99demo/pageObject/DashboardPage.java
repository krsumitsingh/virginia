package com.guru99demo.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99demo.helper.alert.AlertHelper;
import com.guru99demo.helper.assertions.VerificationHelper;
import com.guru99demo.helper.javaScript.JavaScriptHelper;
import com.guru99demo.helper.logger.LoggerHelper;
import com.guru99demo.helper.wait.WaitHelper;
import com.guru99demo.testBase.TestBase;

public class DashboardPage {
	
	private WebDriver driver;

	private Logger log = LoggerHelper.getLogger(DashboardPage.class);
	

	WaitHelper waithelper;
	JavaScriptHelper javascripthelper;
	VerificationHelper verificationhelper;
	AlertHelper alertHelper;
	
	@FindBy(css="li.success-msg")
	WebElement accountCreateMsg;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(driver);
		javascripthelper = new JavaScriptHelper(driver);
		verificationhelper = new VerificationHelper(driver);
		alertHelper = new AlertHelper(driver);
		TestBase.logExtentReport("Dashboard Page Object Created");
	}
	
	public boolean verifyAccountCreationMessage() {
		return new VerificationHelper(driver).elementIsDisplayed(accountCreateMsg);
	}

}
