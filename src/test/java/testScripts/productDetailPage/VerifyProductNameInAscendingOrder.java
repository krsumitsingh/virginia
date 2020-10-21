package testScripts.productDetailPage;

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

public class VerifyProductNameInAscendingOrder extends TestBase {

	private final Logger log = LoggerHelper.getLogger(VerifyProductNameInAscendingOrder.class);
	
	@BeforeClass
	public void beforeClass() {
		getApplicationUrl(ObjectReader.reader.getUrl());
	}

	@Test
	public void verifyProductNameInAscendingOrder_InProductDeatilsPage() throws InterruptedException {

		LoginPage login = new LoginPage(driver);
		NavigationMenu navigationMenu = new NavigationMenu(driver);
		WaitHelper waitHelper = new WaitHelper(driver);
		ProductCategoryPage productCategoryPage = new ProductCategoryPage(driver);
		VerificationHelper verificationhelper = new VerificationHelper(driver);
		

		try {
			login.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());

		} catch (Exception e) {
			TestBase.logExtentReport("login page not visible...");
			e.printStackTrace();
		}
		verificationhelper.getTitle();
		boolean status=productCategoryPage.verifySuccessLoginMsg();
		AssertionHelper.updateTestStatus(status);
		
		productCategoryPage = navigationMenu.clickOnMenu(navigationMenu.mobileMenu);
		waitHelper.setImplicitWait(5,TimeUnit.SECONDS);
		

	}

}
