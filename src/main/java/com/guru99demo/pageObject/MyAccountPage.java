package com.guru99demo.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.guru99demo.helper.alert.AlertHelper;
import com.guru99demo.helper.assertions.VerificationHelper;
import com.guru99demo.helper.browserConfiguration.config.ObjectReader;
import com.guru99demo.helper.javaScript.JavaScriptHelper;
import com.guru99demo.helper.logger.LoggerHelper;
import com.guru99demo.helper.wait.WaitHelper;
import com.guru99demo.testBase.TestBase;

public class MyAccountPage extends TestBase {

	private WebDriver driver;

	private Logger log = LoggerHelper.getLogger(MyAccountPage.class);

	WaitHelper waithelper;
	JavaScriptHelper javascripthelper;
	VerificationHelper verificationhelper;
	AlertHelper alertHelper;

	@FindBy(xpath = "//span[text()='Create an Account']")
	WebElement createAnAccountBtn;

	@FindBy(xpath = "//input[@id='firstname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='lastname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='email_address']")
	WebElement emailAddress;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='confirmation']")
	WebElement confirmPassword;

	@FindBy(xpath = "//button[@title='Register']")
	WebElement registerBtn;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(driver);
		javascripthelper = new JavaScriptHelper(driver);
		verificationhelper = new VerificationHelper(driver);
		alertHelper = new AlertHelper(driver);
		TestBase.logExtentReport("My Account Page Object Created");

	}

	public void clickCreateAnAccount() {
		log.info("user clicks on the Log In link...");
		javascripthelper.clickElement(createAnAccountBtn);
		TestBase.logExtentReport("Log In link clicked..");
	}

	public void setFirstName() {
		log.info("entering firstName.." + ObjectReader.reader.getFirstName());
		TestBase.logExtentReport("entering firstName.." + ObjectReader.reader.getFirstName());
		this.firstName.sendKeys(ObjectReader.reader.getFirstName());
	}

	public void setLastName() {
		log.info("entering lastName.." + ObjectReader.reader.getLastName());
		TestBase.logExtentReport("entering lastName.." + ObjectReader.reader.getLastName());
		this.firstName.sendKeys(ObjectReader.reader.getLastName());
	}

	public void setEmailAddress() {
		log.info("entering emailAddress.." + ObjectReader.reader.getEmailAddress());
		TestBase.logExtentReport("entering emailAddress.." + ObjectReader.reader.getEmailAddress());
		this.firstName.sendKeys(ObjectReader.reader.getEmailAddress());
	}

	public void setPassword() {
		log.info("entering password.." + ObjectReader.reader.getPwd());
		TestBase.logExtentReport("entering password.." + ObjectReader.reader.getPwd());
		this.firstName.sendKeys(ObjectReader.reader.getPwd());
	}

	public void setConfirmPassword() {
		log.info("confirming password.." + ObjectReader.reader.getConfirmPwd());
		TestBase.logExtentReport("confirming password.." + ObjectReader.reader.getConfirmPwd());
		this.firstName.sendKeys(ObjectReader.reader.getConfirmPwd());
	}

}
