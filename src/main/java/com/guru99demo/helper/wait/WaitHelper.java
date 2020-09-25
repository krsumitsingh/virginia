/**
 * @ Author SumitKumarSingh
 */

package com.guru99demo.helper.wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.guru99demo.helper.logger.LoggerHelper;

public class WaitHelper {

	private WebDriver driver;

	private Logger log = LoggerHelper.getLogger(WaitHelper.class);

	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * ImplicitWait method
	 * @param timeout
	 * @param units
	 */
	public void setImplicitWait(long timeout, TimeUnit units) {
		log.info("Implicit Wait has been set to: " + timeout);
		driver.manage().timeouts().implicitlyWait(timeout, units);
	}

	/**
	 * pageLoadTime method
	 * @param timeout
	 * @param units
	 */
	public void pageLoadTime(long timeout, TimeUnit units){
		log.info("waiting for page to load: "+timeout);
		driver.manage().timeouts().pageLoadTimeout(timeout, units);		
	}
	
	
	/**
	 * getWait method
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return
	 */
	private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec){
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds );
		//wait.pollingEvery(pollingEveryInMiliSec, TimeUnit.SECONDS);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(NoSuchFrameException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);	
		return wait;		
	}
	
    /*	private Wait<WebDriver> getFluentWait(int timeOutInSeconds, int pollingEveryInMiliSec){
		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
				fWait.withTimeout((Duration.ofSeconds(timeOutInSeconds))
						fWait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec)).ignoring(NoSuchElementException.class);
		return fWait;
	}*/

	/**
	 * Wait For Element to be visible method
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 */
	public void waitForElementVisibleWithPollingTime(WebElement element,int timeOutInSeconds,int pollingEveryInMiliSec ){
		log.info("waiting for: "+element.toString()+" for: "+timeOutInSeconds+" seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is visible now: ");		
	}
	
	/**
	 * WaitForElementClickable method
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 */
	public void waitForElementClickable(WebElement element,int timeOutInSeconds,int pollingEveryInMiliSec ){
		log.info("waiting for: "+element.toString()+" for: "+timeOutInSeconds+" seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("element is clickable now: ");		
	}
	
	/**
	 * WaitForElementToBeInvisible method
	 * @param locator
	 * @param timeOutInSeconds
	 * @return
	 */
	public <Locator> boolean waitForElementToBeInvisible(Locator locator,int timeOutInSeconds){
		boolean status = false;
		log.info("waiting for: "+locator.toString()+" for: "+timeOutInSeconds+" seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		status = wait.until(ExpectedConditions.invisibilityOfElementLocated((By) locator));
		log.info("element is invisible now: ");
		return status;			
	}
	
	/**
	 * wait for frame availability and switch to it method
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForFrameToBeAvailableAndSwitchToIt(WebElement element, int timeOutInSeconds){
		log.info("waiting for: "+element.toString()+" for: "+timeOutInSeconds+" seconds");
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds );
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("switched to frame: ");
		
	}
	/**
	 * This method will make sure element is visible
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForElement(WebElement element, int timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is visible now");
	}
}
