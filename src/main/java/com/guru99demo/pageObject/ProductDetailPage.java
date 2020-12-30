package com.guru99demo.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99demo.helper.assertions.VerificationHelper;
import com.guru99demo.helper.browserConfiguration.config.ObjectReader;
import com.guru99demo.helper.logger.LoggerHelper;
import com.guru99demo.helper.wait.WaitHelper;
import com.guru99demo.testBase.TestBase;

public class ProductDetailPage {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(ProductDetailPage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath="//span[text()='Sony Xperia']")
	WebElement sonyXperia;
	
	@FindBy(css = "span.regular-price span")
	WebElement actualPrice;
	
	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		/*waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(sonyXperia, ObjectReader.reader.getExplicitWait());*/
		TestBase.logExtentReport("ProductDetalPage object created");
	}
	
	public String actualPriceofProduct(){
		return new VerificationHelper(driver).getTextFromElement(actualPrice);
		
	}
}
