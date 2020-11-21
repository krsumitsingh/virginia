package testScripts.addToCart;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guru99demo.helper.assertions.AssertionHelper;
import com.guru99demo.helper.assertions.VerificationHelper;
import com.guru99demo.helper.browserConfiguration.config.ObjectReader;
import com.guru99demo.helper.logger.LoggerHelper;
import com.guru99demo.helper.wait.WaitHelper;
import com.guru99demo.pageObject.AddToCart;
import com.guru99demo.pageObject.LoginPage;
import com.guru99demo.pageObject.NavigationMenu;
import com.guru99demo.pageObject.ProductCategoryPage;
import com.guru99demo.pageObject.ProductDetailPage;
import com.guru99demo.testBase.TestBase;

import testScripts.productDetailPage.VerifyProductDetailPage;

public class VerifyAddToCartPage extends TestBase {
	
	private final Logger log = LoggerHelper.getLogger(VerifyProductDetailPage.class);
	boolean status;

	@BeforeClass
	public void beforeClass() {
		getApplicationUrl(ObjectReader.reader.getUrl());
	}
	
	@Test
	public void verifyUpdateAddItemCart(){
		LoginPage login = new LoginPage(driver);
		NavigationMenu navigationMenu = new NavigationMenu(driver);
		ProductCategoryPage productCategoryPage = new ProductCategoryPage(driver);
		AddToCart addToCart = new AddToCart(driver);
		AssertionHelper Obj = AssertionHelper.getInstance();
		WaitHelper waitHelper = new WaitHelper(driver);
		VerificationHelper verificationhelper = new VerificationHelper(driver);
		waitHelper.setImplicitWait(ObjectReader.reader.getImpliciteWait(), TimeUnit.SECONDS);

		try {
			login.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
			verificationhelper.getTitle();
			status = productCategoryPage.verifySuccessLoginMsg();
			Obj.updateTestStatus(status);
			productCategoryPage = navigationMenu.clickOnMenu(navigationMenu.mobileMenu);
			//String expectedPrice = productCategoryPage.verifySingleProductPrice();
			addToCart = productCategoryPage.clickAddToCart(productCategoryPage.addToCartBtn);
			Thread.sleep(2000);
			verificationhelper.getTitle();
			//String actualPrice = productDetailPage.actualPriceofProduct();
			//log.info("AP IS.."+actualPrice);
			Thread.sleep(2000);
			//Obj.verifyText(expectedPrice, actualPrice);
		} catch (Exception e) {
			TestBase.logExtentReport("login page not visible...");
			e.printStackTrace();
		}

		
		
		
		
		
		
		
	}
	

}
