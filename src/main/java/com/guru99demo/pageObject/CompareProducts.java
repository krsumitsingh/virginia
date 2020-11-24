package com.guru99demo.pageObject;

import java.util.LinkedList;
import java.util.List;

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
import com.guru99demo.helper.window.WindowHelper;
import com.guru99demo.testBase.TestBase;

public class CompareProducts {

	private WebDriver driver;

	private Logger log = LoggerHelper.getLogger(CompareProducts.class);
	WindowHelper windowhelper;
	JavaScriptHelper javascripthelper;
	public static String actualCompareProductLabel = "Compare Products";

	@FindBy(xpath = "//h1[text()='Compare Products']")
	public WebElement compareProductLabel;
	
	@FindBy(xpath = "//span[text()='Close Window']")
	public WebElement closeBtn;
	

	public CompareProducts(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		windowhelper = new WindowHelper(driver);
		javascripthelper = new JavaScriptHelper(driver);
		TestBase.logExtentReport("Compare Products Page Object Created");
	}

	public String Message(WebElement element) {
		return new VerificationHelper(driver).getTextFromElement(element);
	}

	public void compareProductAdded(List<WebElement> totalProducts) {
		// List<String> productnames = new LinkedList<>();
		for (int i = 0; i < totalProducts.size(); i++) {
			String productNames = totalProducts.get(i).getAttribute("title");
			log.info("The prodcucts added for comparison are..." + productNames);
			TestBase.logExtentReport("The prodcucts added for comparison are..." + productNames);
		}		
	}
	
	public void closeCompareProducts(){
		javascripthelper.scrollIntoViewAndClick(closeBtn);
		//windowhelper.switchToParentWindow();		
	}
	
	
	
	
	
	
	
	

}
