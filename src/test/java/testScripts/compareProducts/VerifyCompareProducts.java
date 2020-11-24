package testScripts.compareProducts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guru99demo.helper.assertions.AssertionHelper;
import com.guru99demo.helper.assertions.VerificationHelper;
import com.guru99demo.helper.browserConfiguration.config.ObjectReader;
import com.guru99demo.helper.logger.LoggerHelper;
import com.guru99demo.helper.wait.WaitHelper;
import com.guru99demo.pageObject.AddToCart;
import com.guru99demo.pageObject.CompareProducts;
import com.guru99demo.pageObject.LoginPage;
import com.guru99demo.pageObject.NavigationMenu;
import com.guru99demo.pageObject.ProductCategoryPage;
import com.guru99demo.testBase.TestBase;

public class VerifyCompareProducts extends TestBase {
	
	private final Logger log = LoggerHelper.getLogger(VerifyCompareProducts.class);
	boolean status;
	//String actualCompareProductLabel="Compare Products";
	
	@BeforeClass
	public void beforeClass() {
		getApplicationUrl(ObjectReader.reader.getUrl());
	}
	
	@SuppressWarnings("static-access")
	@Test(priority = 1)
	public void verifyCompareProducts() {
		LoginPage login = new LoginPage(driver);
		NavigationMenu navigationMenu = new NavigationMenu(driver);
		ProductCategoryPage productCategoryPage = new ProductCategoryPage(driver);
		CompareProducts compareProduct = new CompareProducts(driver);
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
			productCategoryPage.addToCompareProducts(productCategoryPage.firstProductAddToCompare);
			productCategoryPage.addToCompareProducts(productCategoryPage.secondProductAddToCompare);		
			compareProduct = productCategoryPage.clickOnCompare(productCategoryPage.compareBtn,1);
			//compareProduct.compareWindow();
			String expectedCompareProductLabel = compareProduct.Message(compareProduct.compareProductLabel);
			Obj.verifyText(expectedCompareProductLabel, CompareProducts.actualCompareProductLabel.toUpperCase());
			List<WebElement> totalProducts = productCategoryPage.getTotalProducts();
			compareProduct.compareProductAdded(totalProducts);
			compareProduct.closeCompareProducts();
		} catch (Exception e) {
			TestBase.logExtentReport("login page not visible...");
			e.printStackTrace();
		}

	}
	
	
}
