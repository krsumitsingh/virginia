package com.guru99demo.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99demo.helper.browserConfiguration.config.ObjectReader;
import com.guru99demo.helper.logger.LoggerHelper;
import com.guru99demo.helper.select.DropDownHelper;
import com.guru99demo.helper.wait.WaitHelper;
import com.guru99demo.testBase.TestBase;

public class NavigationMenu {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(NavigationMenu.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//a[text()='Mobile']")
	public
	WebElement mobileMenu;

	@FindBy(xpath = "//a[text()='TV']")
	WebElement tvMenu;

	public NavigationMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(mobileMenu, ObjectReader.reader.getExplicitWait());
		TestBase.logExtentReport("NavigationMenu object created");
	}

	public ProductCategoryPage clickOnMenu(WebElement element) {
		log.info("clickin on : " + element.getText());
		TestBase.logExtentReport("clickin on : " + element.getText());
		element.click();
		return new ProductCategoryPage(driver);
	}

}
