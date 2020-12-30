package com.guru99demo.pageObject;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.guru99demo.helper.assertions.VerificationHelper;
import com.guru99demo.helper.javaScript.JavaScriptHelper;
import com.guru99demo.helper.logger.LoggerHelper;
import com.guru99demo.helper.select.DropDownHelper;
import com.guru99demo.helper.window.WindowHelper;
import com.guru99demo.testBase.TestBase;

public class ProductCategoryPage {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(ProductCategoryPage.class);
	JavaScriptHelper javascripthelper;
	WindowHelper windowhelper;
	String text="";

	@FindBy(css = "p.welcome-msg")
	WebElement homePageMessage;

	@FindBy(xpath = "//select[@title='Sort By']")
	WebElement sortBy;

	@FindBy(css = "h2.product-name a")
	List<WebElement> totalProducts;

	@FindBy(xpath = "//span[contains(@id,'product-price')]")
	public List<WebElement> productPrice;

	@FindBy(xpath = "//span[@id='product-price-1']/span")
	public WebElement singleProductPrice;

	@FindBy(xpath = "//img[@alt='Xperia']")
	public WebElement productItem;
	
	@FindBy(xpath="//span[text()='Add to Cart']")
	public WebElement addToCartBtn;
	
	@FindBy(xpath="//li[1]/div[1]/div[3]/ul[1]/li[2]/a[1]")
	public WebElement firstProductAddToCompare;
	
	@FindBy(xpath="//li[2]/div[1]/div[3]/ul[1]/li[2]/a[1]")
	public WebElement secondProductAddToCompare;
	
	@FindBy(xpath="//span[text()='Compare']")
	public WebElement compareBtn;
	
	@FindBy(xpath="//a[@class='link-wishlist']")
	public WebElement addWishlist;
	
	

	public ProductCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		javascripthelper = new JavaScriptHelper(driver);
		windowhelper = new WindowHelper(driver);

	}

	public boolean verifySuccessLoginMsg() {
		return new VerificationHelper(driver).elementIsDisplayed(homePageMessage);
	}

	public String verifySingleProductPrice() {
		return new VerificationHelper(driver).getTextFromElement(singleProductPrice);
		
	}

	public void sortFilter(String dataToSelect) {
		DropDownHelper dropdownhelper = new DropDownHelper(driver);
		dropdownhelper.selectUsingVisibleText(sortBy, dataToSelect);
	}

	/**
	 * this method returns the total product count
	 * 
	 * @return
	 */
	public List<WebElement> getTotalProducts() {
		return totalProducts;
	}

	/**
	 * this method verify the product sorting based on name
	 * 
	 * @param totalProducts
	 */
	public void verifyProductSortedByName(List<WebElement> totalProducts) {
		List<String> productnames = new LinkedList<>();
		for (int i = 0; i < totalProducts.size(); i++) {
			String productNames = totalProducts.get(i).getAttribute("title");
			productnames.add(productNames);
		}
		boolean result = chkAlphabeticalOrder(productnames);
		if (result) {
			log.info("products sorted..");
			TestBase.logExtentReport("products sorted..");
		} else {
			log.info("name sorting filter not working..");
			TestBase.logExtentReport("name sorting filter not working..");
		}

	}

	private boolean chkAlphabeticalOrder(List<String> productnames) {
		String previous = ""; // empty string

		for (final String current : productnames) {
			if (current.compareTo(previous) < 0)
				return false;
			previous = current;
		}
		log.info("products sorted on the basis of name.." + productnames);
		TestBase.logExtentReport("products sorted on the basis of name.." + productnames);
		return true;

	}

	public List<Double> getPriceData(List<WebElement> productPrices) {
		List<Double> priceofProducts = new LinkedList<>();
		Iterator<WebElement> prices = productPrices.iterator();
		while (prices.hasNext()) {
			String p = prices.next().getText();
			if (p.contains("$")) {
				String actualPrice = p.substring(1);
				// log.info(actualPrice);
				double newActualPrice = Double.parseDouble(actualPrice);
				// int finalPrice = (int)(newActualPrice);
				priceofProducts.add(newActualPrice);
			}
		}
		return priceofProducts;
	}

	/**
	 * this method verify the product sorting based on price
	 * 
	 * @param totalProducts
	 */
	public boolean verifyProductSortedByPrice(List<Double> pricedata) {
		for (int i = 0; i < pricedata.size() - 1; i++) {
			if (pricedata.get(i) <= pricedata.get(i + 1)) {
				log.info("products sorted on the basis of price.." + pricedata);
				TestBase.logExtentReport("products sorted on the basis of price.." + pricedata);
			} else {
				log.info("price filter is not working..");
				TestBase.logExtentReport("price filter is not working..");
				return false;
			}
		}
		return true;
	}

	/**
	 * this method will click on Product detail section in the product detail page
	 * 
	 * @param element
	 * @return
	 */
	public ProductDetailPage clickProductItem(WebElement element) {
		text=new VerificationHelper(driver).getAttributeFromElement(element, "alt");
		log.info("clickin on : " + text);
		TestBase.logExtentReport("clickin on : " + text);
		javascripthelper.clickElement(element);
		return new ProductDetailPage(driver);
	}
	
	/**
	 * this method will click on Add to cart in the product detail page and 
	 * return add to card object
	 * @param element
	 * @return
	 */
	public AddToCart clickAddToCart(WebElement element) {
		text=new VerificationHelper(driver).getTextFromElement(element);
		log.info("clickin on : " + text);
		TestBase.logExtentReport("clickin on : " + text);
		javascripthelper.clickElement(element);
		return new AddToCart(driver);
	}
	
	/**
	 * this method will add products to compare
	 * @param element
	 */
	public void addToCompareProducts(WebElement element){
		String text=new VerificationHelper(driver).getTextFromElement(element);
		log.info("clickin on : " + text);
		TestBase.logExtentReport("clickin on : " + text);
		javascripthelper.clickElement(element);
	}
	
	public CompareProducts clickOnCompare(WebElement element, int i){
		String text=new VerificationHelper(driver).getTextFromElement(element);
		log.info("clickin on : " + text);
		TestBase.logExtentReport("clickin on : " + text);
		javascripthelper.clickElement(element);		
		windowhelper.switchToWindow(i);
		return new CompareProducts(driver);
	}

	public WishlistPage clickAddToWishlist(WebElement element){		
		text=new VerificationHelper(driver).getTextFromElement(element);
		log.info("clickin on : " + text);
		TestBase.logExtentReport("clickin on : " + text);
		javascripthelper.clickElement(element);	
		return new WishlistPage(driver);
		
	}
	
	
	
}
