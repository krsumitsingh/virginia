package com.guru99demo.helper.javaScript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.guru99demo.helper.logger.LoggerHelper;

public class JavaScriptHelper {
	
	private WebDriver driver;

	private Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);

	public JavaScriptHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * execute java script with single argument
	 * @param script
	 * @return
	 */
	public Object executeScript(String script){
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		Object response =  exe.executeScript(script);	
		return response;
	}
	
	/**
	 * execute java script with multiple argument
	 * @param script
	 * @param args
	 * @return
	 */
	public Object executeScript(String script, Object...args){
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		Object response= exe.executeScript(script,args);		
		return response;
	}
	
	/**
	 * scroll to element based on coordinates method
	 * @param element
	 */
	public void scrollToElement(WebElement element){
		log.info("scroll to element: "+element.getText());
		executeScript("window.ScrollTo(arguments[0],arguments[1])",element.getLocation().x,element.getLocation().y );		
	}
	
	/**
	 * scroll to element based on coordinates and click
	 * @param element
	 */
	public void scrollToElementAndClick(WebElement element){
		log.info("scroll to element and click: "+element.getText());
		scrollToElement(element);
		element.click();
	}
		
	/**
	 * scroll to element directly method
	 * @param element
	 */
	public void scrollIntoView(WebElement element){
		log.info("scroll to element: "+element.getText());
		executeScript("arguments[0].scrollIntoView()",element);	
	}

	/**
	 * scroll to element directly and click method
	 * @param element
	 */
	public void scrollIntoViewAndClick(WebElement element){
		log.info("scroll to element and click element: "+element.getText());
		scrollIntoView(element);
		element.click();
	}
	
	/**
	 * scroll Down Vertically method
	 */
	public void scrollDownVertically(){
		log.info("scroll down vertically");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
	/**
	 * scroll Up Vertically method
	 */
	public void scrollUpVertically(){
		log.info("scroll up vertically");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		
	}
	
	/**
	 * scroll Up By Pixel method
	 * @param Pixel
	 */
	public void scrollUpByPixel(int Pixel){
		executeScript("window.scrollBY(0,-"+Pixel+")");
	}
	
	/**
	 * scroll Down By Pixel method
	 * @param Pixel
	 */
	public void scrollDownByPixel(int Pixel){
		executeScript("window.scrollBY(0,"+Pixel+")");
	}
	
	/**
	 * zoom In By Percentage method 
	 */
	public void zoomInByPercentage(){
		executeScript("document.body.style.zoom='90%'");
	}
	
	/**
	 * zoom out By Percentage method
	 */
	public void zoomOutByPercentage(){
		executeScript("document.body.style.zoom='100%'");
	}
	
	/**
	 * Click on the element method
	 * @param element
	 */
	public void clickElement(WebElement element){
		executeScript("arguments[0].click();", element);
	}
	
	
	
}
