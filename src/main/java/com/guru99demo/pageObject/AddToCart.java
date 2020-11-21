package com.guru99demo.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99demo.helper.assertions.VerificationHelper;
import com.guru99demo.helper.javaScript.JavaScriptHelper;
import com.guru99demo.helper.logger.LoggerHelper;
import com.guru99demo.testBase.TestBase;

public class AddToCart {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(AddToCart.class);
	JavaScriptHelper javascripthelper;

	@FindBy(xpath = "//input[contains(@class,'input-text qty')]")
	public WebElement addToCartQty;
	
	@FindBy(xpath = "//span[text()='Update']")
	public WebElement updateShoppingCart;

	public AddToCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		javascripthelper = new JavaScriptHelper(driver);
		TestBase.logExtentReport("AddToCart object created");
	}

	public void editShoppingCartQty(WebElement element, String Qty) {
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Qty);
	}

	public void updateShoppingCartQty(WebElement element) {
		String text=new VerificationHelper(driver).getTextFromElement(element);
		log.info("clickin on : " + text);
		TestBase.logExtentReport("clickin on : " + text);
		javascripthelper.clickElement(element);
		
	}

}
