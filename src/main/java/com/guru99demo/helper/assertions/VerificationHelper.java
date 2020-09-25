package com.guru99demo.helper.assertions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 import com.guru99demo.helper.logger.LoggerHelper;

public class VerificationHelper {

	private WebDriver driver;

	private Logger log = LoggerHelper.getLogger(VerificationHelper.class);

	public VerificationHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method will check if element is displayed 
	 * @param element
	 * @return
	 */
	public boolean elementIsDisplayed(WebElement element){
		try{	
			element.isDisplayed();
			log.info("element is displayed "+element.getText());
			return true;
		}catch(Exception e){
			log.error("element not  displayed", e.getCause());
			return false;
		}	
	}
	
	/**
	 * This method will check if element is not displayed
	 * @param element
	 * @return
	 */
	public boolean elementIsNotDisplayed(WebElement element){
		try{
			element.isDisplayed();
			log.info("element is displayed "+element.getText());
			return false;
		}catch(Exception e){
			log.info("element not displayed");
			return true;
		}	
	}
	
	/**
	 * This method will fetch the text of an element
	 * @param element
	 */
	public String getTextFromElement(WebElement element){
		boolean status = false;
		if(null==element){
			log.info("element is null");
			return null;
		}
		status = elementIsDisplayed(element);
		if(status){
			return element.getText();		
		}
		else{
			return null;
		}
	}
	
	/**
	 * This method will fetch the attribute of an element
	 * @param element,name
	 */
	public String getAttributeFromElement(WebElement element, String name){
		boolean status = false;
		if(null==element){
			log.info("element is null");
			return null;
		}
		status = elementIsDisplayed(element);
		if(status){
			return element.getAttribute(name);		
		}
		else{
			return null;
		}
	}
	
	/**
	 * This method will return the title
	 * @return
	 */
	public String getTitle(){
		log.info("The tile of the page is: "+driver.getTitle());
		return driver.getTitle();
	}





}
