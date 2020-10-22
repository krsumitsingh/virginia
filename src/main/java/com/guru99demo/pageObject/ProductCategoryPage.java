package com.guru99demo.pageObject;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99demo.helper.assertions.AssertionHelper;
import com.guru99demo.helper.assertions.VerificationHelper;
import com.guru99demo.helper.logger.LoggerHelper;
import com.guru99demo.helper.select.DropDownHelper;
import com.guru99demo.testBase.TestBase;

public class ProductCategoryPage {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(ProductCategoryPage.class);

	public String homepageText = "Welcome, Deryl Adler! ";

	@FindBy(css = "p.welcome-msg")
	WebElement homePageText;

	@FindBy(xpath = "//select[@title='Sort By']")
	WebElement sortBy;

	@FindBy(xpath = "//img[contains(@id, 'product-collection-image')]")
	List<WebElement> totalProducts;

	public ProductCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public boolean verifySuccessLoginMsg() {
		return new VerificationHelper(driver).elementIsDisplayed(homePageText);
	}

	public void sortFilter(String dataToSelect) throws InterruptedException {
		DropDownHelper dropdownhelper = new DropDownHelper(driver);
		dropdownhelper.selectUsingVisibleText(sortBy, dataToSelect);
	}

	public List<WebElement> getTotalProducts() {
		return totalProducts;
	}

	public void verifyProductSortedByName(List<WebElement> totalProducts) {
		LinkedList<String> product_names = new LinkedList<String>();
		for (int i = 0; i < totalProducts.size(); i++) {
			String productNames = totalProducts.get(i).getAttribute("title");
			product_names.add(productNames);
		}
		boolean result = chkalphabetical_order(product_names);
		if (result) {
			log.info("products sorted on the basis of names..");
			TestBase.logExtentReport("products sorted on the basis of names..");
		} else {
			log.info("name sorting filter not working..");
			TestBase.logExtentReport("name sorting filter not working..");
		}

	}

	private boolean chkalphabetical_order(LinkedList<String> product_names) {
		String previous = ""; // empty string

		for (final String current : product_names) {
			if (current.compareTo(previous) < 0)
				return false;
			previous = current;
		}

		return true;

	}

}
