package com.guru99demo.pageObject;

import java.util.Random;
import java.util.UUID;

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
	Random randomGenerator = new Random();

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
	
	// Generate a random email
    //final String randomEmail = randomEmail();

	public void clickCreateAnAccount() {
		log.info("user clicks create account...");
		javascripthelper.clickElement(createAnAccountBtn);
		TestBase.logExtentReport("user clicks create account..");
	}

	public void setFirstName() {
		firstName.click();
		log.info("entering firstName.." + ObjectReader.reader.getFirstName());
		TestBase.logExtentReport("entering firstName.." + ObjectReader.reader.getFirstName());
		this.firstName.sendKeys(ObjectReader.reader.getFirstName());
	}

	public void setLastName() {
		log.info("entering lastName.." + ObjectReader.reader.getLastName());
		TestBase.logExtentReport("entering lastName.." + ObjectReader.reader.getLastName());
		this.lastName.sendKeys(ObjectReader.reader.getLastName());
	}

	public void setEmailAddress() {
		int randomInt=randomGenerator.nextInt(1000);
		log.info("entering emailAddress.." +randomInt+ObjectReader.reader.getEmailAddress());
		TestBase.logExtentReport("entering emailAddress.." +randomInt+ObjectReader.reader.getEmailAddress());
		this.emailAddress.sendKeys(randomInt+ObjectReader.reader.getEmailAddress());
	}
	
	

	public void setPassword() {
		log.info("entering password.." + ObjectReader.reader.getPwd());
		TestBase.logExtentReport("entering password.." + ObjectReader.reader.getPwd());
		this.password.sendKeys(ObjectReader.reader.getPwd());
	}

	public void setConfirmPassword() {
		log.info("confirming password.." + ObjectReader.reader.getConfirmPwd());
		TestBase.logExtentReport("confirming password.." + ObjectReader.reader.getConfirmPwd());
		this.confirmPassword.sendKeys(ObjectReader.reader.getConfirmPwd());
	}


	public void clickRegister() {
		log.info("user clicks register...");
		javascripthelper.clickElement(registerBtn);
		TestBase.logExtentReport("user clicks register..");
	}
	
	
	/* private static String randomEmail() {
	        return "random-" + UUID.randomUUID().toString() + "@example.com";
	    }*/
	 
	 
	
}
