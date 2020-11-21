package testScripts.productCategoryPage;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.guru99demo.helper.assertions.AssertionHelper;
import com.guru99demo.helper.assertions.VerificationHelper;
import com.guru99demo.helper.browserConfiguration.config.ObjectReader;
import com.guru99demo.helper.logger.LoggerHelper;
import com.guru99demo.helper.wait.WaitHelper;
import com.guru99demo.pageObject.LoginPage;
import com.guru99demo.pageObject.NavigationMenu;
import com.guru99demo.pageObject.ProductCategoryPage;
import com.guru99demo.testBase.TestBase;

public class VerifyProductPriceInSortedOrder extends TestBase {

	private final Logger log = LoggerHelper.getLogger(VerifyProductPriceInSortedOrder.class);
	boolean status;

	@BeforeClass
	public void beforeClass() {
		getApplicationUrl(ObjectReader.reader.getUrl());
	}

	@Test
	public void verifyProductPriceSortingInProductCategoryPage()  {

		LoginPage login = new LoginPage(driver);
		NavigationMenu navigationMenu = new NavigationMenu(driver);
		WaitHelper waitHelper = new WaitHelper(driver);
		ProductCategoryPage productCategoryPage = new ProductCategoryPage(driver);
		VerificationHelper verificationhelper = new VerificationHelper(driver);
		waitHelper.setImplicitWait(ObjectReader.reader.getImpliciteWait(), TimeUnit.SECONDS);
		try {
			login.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
			verificationhelper.getTitle();
			status = productCategoryPage.verifySuccessLoginMsg();
			AssertionHelper.updateTestStatus(status);
			productCategoryPage = navigationMenu.clickOnMenu(navigationMenu.mobileMenu);
			productCategoryPage.sortFilter("Price");
			Thread.sleep(7000);
			//List<WebElement> totalProducts = productCategoryPage.getTotalProducts();
			List<Double>pricedata=productCategoryPage.getPriceData(productCategoryPage.productPrice);
			status = productCategoryPage.verifyProductSortedByPrice(pricedata);
			AssertionHelper.updateTestStatus(status);
		} catch (Exception e) {
			TestBase.logExtentReport("login page not visible...");
			e.printStackTrace();
		}

	}

}
