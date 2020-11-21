package testScripts.productDetailPage;

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
import com.guru99demo.pageObject.ProductDetailPage;
import com.guru99demo.testBase.TestBase;

public class VerifyProductDetailPage extends TestBase {

	private final Logger log = LoggerHelper.getLogger(VerifyProductDetailPage.class);
	boolean status;

	@BeforeClass
	public void beforeClass() {
		getApplicationUrl(ObjectReader.reader.getUrl());
	}

	@SuppressWarnings("static-access")
	@Test
	public void verifyProductDeatilsPage() {

		LoginPage login = new LoginPage(driver);
		NavigationMenu navigationMenu = new NavigationMenu(driver);
		ProductCategoryPage productCategoryPage = new ProductCategoryPage(driver);
		ProductDetailPage productDetailPage = new ProductDetailPage(driver);
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
			String expectedPrice = productCategoryPage.verifySingleProductPrice();
			productDetailPage = productCategoryPage.clickProductItem(productCategoryPage.productItem);
			Thread.sleep(2000);
			verificationhelper.getTitle();
			String actualPrice = productDetailPage.actualPriceofProduct();
			//log.info("AP IS.."+actualPrice);
			Thread.sleep(2000);
			Obj.verifyText(expectedPrice, actualPrice);
		} catch (Exception e) {
			TestBase.logExtentReport("login page not visible...");
			e.printStackTrace();
		}

	}

}
