package com.guru99demo.helper.window;

import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.guru99demo.helper.logger.LoggerHelper;

public class WindowHelper {

	private WebDriver driver;

	private Logger log = LoggerHelper.getLogger(WindowHelper.class);

	public WindowHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * switch to parent window method
	 */
	public void switchToParentWindow() {
		log.info("switch tom parent window");
		driver.switchTo().defaultContent();
	}

	/**
	 * switch to child window method
	 * @param index
	 */
	public void switchToWindow(int index) {
		Set<String> windows = driver.getWindowHandles();
		int i = 1;
		for (String window : windows) {
			if (i == index) {
				log.info("switched to: "+index+" child window");
				driver.switchTo().window(window);			
			} else {
				i++;
			}
		}
	}

	/**
	 * close All Tabs And Switch To ParentWindow method
	 */
	public void closeAllTabsAndSwitchToParentWindow() {
		Set<String> windows = driver.getWindowHandles();
		String parentWindow = driver.getWindowHandle();
		for (String window : windows) {
			if (!window.equalsIgnoreCase(parentWindow)) {
				driver.close();
			}
		}
		log.info("switched to parent window");
		driver.switchTo().window(parentWindow);	
	} 
	
	/**
	 * navigate back method
	 */
	public void navigateBack(){
		log.info("navigate back");
		driver.navigate().back();
		}
	
	/**
	 * navigate forward method
	 */
	public void navigateForward(){
		log.info("navigate forward");
		driver.navigate().forward();		
	}
	
	
	
	
	
	
	
	
	
		
}
