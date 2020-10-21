package com.guru99demo.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99demo.helper.assertions.AssertionHelper;
import com.guru99demo.helper.assertions.VerificationHelper;
import com.guru99demo.helper.logger.LoggerHelper;

public class ProductCategoryPage {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(ProductCategoryPage.class);
	
	public String homepageText = "Welcome, Deryl Adler! ";
	
	@FindBy(css="p.welcome-msg")
	WebElement homePageText;
	
	public ProductCategoryPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
				
	}
	
	
	
	public boolean verifySuccessLoginMsg(){
		return new VerificationHelper(driver).elementIsDisplayed(homePageText);
	}
	
	
}
