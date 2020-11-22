package com.guru99demo.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99demo.helper.assertions.VerificationHelper;
import com.guru99demo.helper.browserConfiguration.config.ObjectReader;
import com.guru99demo.helper.javaScript.JavaScriptHelper;
import com.guru99demo.helper.logger.LoggerHelper;
import com.guru99demo.helper.wait.WaitHelper;
import com.guru99demo.testBase.TestBase;

public class AddToCart {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(AddToCart.class);
	JavaScriptHelper javascripthelper;
	WaitHelper waitHelper;

	@FindBy(xpath = "//input[contains(@class,'input-text qty')]")
	public WebElement addToCartQty;
	
	@FindBy(xpath = "//span[text()='Update']")
	public WebElement updateShoppingCart;
	
	@FindBy(xpath="//p[contains(@class,'item-msg error')]")
	public WebElement expectedErrorMessage;
	
	@FindBy(xpath="//span[text()='Empty Cart']")
	public WebElement emptyCart;
	
	@FindBy(xpath="//h1[text()='Shopping Cart is Empty']")
	public WebElement emptyCartErrorMsg;
	
	

	public AddToCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		javascripthelper = new JavaScriptHelper(driver);
		waitHelper = new WaitHelper(driver);
		TestBase.logExtentReport("AddToCart object created");
	}

	public void editShoppingCartQty(WebElement element, String Qty) {
		element.sendKeys(Keys.CONTROL + "a");
		log.info("update the qty to : " + Qty);
		TestBase.logExtentReport("update the qty to : " + Qty);
		element.sendKeys(Qty);
	}

	public void updateShoppingCartQty(WebElement element) {
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		String text=new VerificationHelper(driver).getTextFromElement(element);
		log.info("clickin on : " + text);
		TestBase.logExtentReport("clickin on : " + text);
		javascripthelper.clickElement(element);
		
	}

	public String errorMessage(WebElement element){
		return new VerificationHelper(driver).getTextFromElement(element);
	}
	
	public void emptyShoppingCart(WebElement element) {
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		String text=new VerificationHelper(driver).getTextFromElement(element);
		log.info("clickin on : " + text);
		TestBase.logExtentReport("clickin on : " + text);
		javascripthelper.clickElement(element);
		
	}
	
}
