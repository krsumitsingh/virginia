package com.guru99demo.helper.switchFrame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.guru99demo.helper.logger.LoggerHelper;

public final class FrameHelper {
	private WebDriver driver;

	private Logger log = LoggerHelper.getLogger(FrameHelper.class);
	
	public FrameHelper(WebDriver driver){
		this.driver = driver;
	}
	
	/**
	 * switchToFrame using index
	 * @param index
	 */
	public void switchToFrame(int index){
		driver.switchTo().frame(index);
		log.info("switch to: "+ index+ " frame");
		}
	
	/**
	 * switchToFrame using frame name
	 * @param index
	 */
	public void switchToFrame(String frameName){
		driver.switchTo().frame(frameName);
		log.info("switch to: "+ frameName+ " frame");
		}
	
	/**
	 * switchToFrame using element
	 * @param index
	 */
	public void switchToFrame(WebElement frameElement){
		driver.switchTo().frame(frameElement);
		log.info("switch to: "+ frameElement.getText()+ " frame");
		}

}
