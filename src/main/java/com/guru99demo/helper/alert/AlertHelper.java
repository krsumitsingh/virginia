package com.guru99demo.helper.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import com.guru99demo.helper.logger.LoggerHelper;

public class AlertHelper {

	private WebDriver driver;

	private Logger log = LoggerHelper.getLogger(AlertHelper.class);

	public AlertHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method will switch to alert
	 * 
	 * @return
	 */
	public Alert getAlert() {
		log.info("switched to alert: " + driver.switchTo().alert());
		return driver.switchTo().alert();
	}

	/**
	 * This method will accept alert
	 */
	public void acceptAlert() {
		getAlert().accept();
		log.info("accept the alert");
	}

	/**
	 * This method will dismiss alert
	 */
	public void dismissAlert() {
		getAlert().dismiss();
		log.info("dismiss the alert");
	}

	/**
	 * This method will get text from the alert
	 * @return
	 */
	public String getAlertText() {
		String text = getAlert().getText();
		// return getAlert().getText();
		log.info("alert text is: " + text);
		return text;
	}

	/**
	 * This method will check if alert is present
	 * @return
	 */
	public boolean isAlertPresent() {
		try {
			if (driver.switchTo().alert() != null) {
				log.info("alert is present");
				getAlert();
				return true;
			}
		} catch (NoAlertPresentException e) {
			log.info("alert not present: " + e.getCause());
		}
		return false;
	}

	/**
	 * This method will accept alert if it is present
	 */
	public void acceptAlertIfPresent() {
		if (isAlertPresent()) {
			acceptAlert();
		} else {
			log.info("alert not present...");
		}
	}

	/**
	 * This method will dismiss alert if it is present
	 */
	public void dismissAlertIfPresent() {
		if (isAlertPresent()) {
			dismissAlert();
		} else {
			log.info("alert not present...");
		}
	}

	/**
	 * This method will input text in alert if it is present
	 */
	public void textInputInAlertIfPresent(String text) {
		if (isAlertPresent()) {
			getAlert().sendKeys(text);
			acceptAlert();
			log.info("text entered into alert is: " + text);
		} else {
			log.info("alert not present...");
		}
	}

}