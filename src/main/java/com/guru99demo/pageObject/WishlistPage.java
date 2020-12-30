package com.guru99demo.pageObject;

import java.util.Random;

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

public class WishlistPage {
	
	private WebDriver driver;

	private Logger log = LoggerHelper.getLogger(WishlistPage.class);
	
	WaitHelper waithelper;
	JavaScriptHelper javascripthelper;
	VerificationHelper verificationhelper;
	AlertHelper alertHelper;
	Random randomGenerator = new Random();
	
	@FindBy(xpath="//li[@class='success-msg']//span")
	public WebElement myWishlistMsg;
	
	@FindBy(xpath="//button[@title='Share Wishlist']")
	public WebElement shareWishlistBtn;
	
	@FindBy(xpath="//div[@class='page-title']")
	public WebElement wishlistShare;
	
	@FindBy(xpath="//textarea[@name='emails']")
	public WebElement emailTextBox;
		
	@FindBy(xpath="//textarea[@id='message']")
	public WebElement messageTextBox;
	
	
	
	
	
	
	public WishlistPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(driver);
		javascripthelper = new JavaScriptHelper(driver);
		verificationhelper = new VerificationHelper(driver);
		alertHelper = new AlertHelper(driver);
		TestBase.logExtentReport("Wishlist Page Object Created");

	}
	
	
	public boolean verifyWishlistMsg(WebElement element) {
		return new VerificationHelper(driver).elementIsDisplayed(element);
	}
	
	public void clickShareWishlist(WebElement element){
		String text=new VerificationHelper(driver).getTextFromElement(element);
		log.info("clickin on : " + text);
		TestBase.logExtentReport("clickin on : " + text);
		javascripthelper.clickElement(element);
	}
	
	public void setEmailAddress() {
		int randomInt=randomGenerator.nextInt(1000);
		log.info("entering emailAddress.." +randomInt+ObjectReader.reader.getEmailAddress());
		TestBase.logExtentReport("entering emailAddress.." +randomInt+ObjectReader.reader.getEmailAddress());
		emailTextBox.sendKeys(randomInt+ObjectReader.reader.getEmailAddress());
	}
	
	public void setMessage() {
		log.info("entering message.."+ObjectReader.reader.getMessage());
		TestBase.logExtentReport("entering message.." +ObjectReader.reader.getMessage());
		messageTextBox.sendKeys(ObjectReader.reader.getMessage());
	}
	
	
}
