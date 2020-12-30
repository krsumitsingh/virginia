package testScripts.myAccountPage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guru99demo.helper.assertions.AssertionHelper;
import com.guru99demo.helper.assertions.VerificationHelper;
import com.guru99demo.helper.browserConfiguration.config.ObjectReader;
import com.guru99demo.helper.logger.LoggerHelper;
import com.guru99demo.helper.wait.WaitHelper;
import com.guru99demo.pageObject.DashboardPage;
import com.guru99demo.pageObject.HomePage;
import com.guru99demo.pageObject.MyAccountPage;
import com.guru99demo.pageObject.NavigationMenu;
import com.guru99demo.pageObject.ProductCategoryPage;
import com.guru99demo.pageObject.WishlistPage;
import com.guru99demo.testBase.TestBase;

public class VerifyMyAccount extends TestBase {
	
	private Logger log = LoggerHelper.getLogger(VerifyMyAccount.class);
	//MyAccountPage myaccountpage = new MyAccountPage(driver);
	//HomePage homepage = new HomePage(driver);
	
	WishlistPage wishlist;
	boolean status;

	@BeforeClass
	public void beforeClass() {
		getApplicationUrl(ObjectReader.reader.getUrl());
	}

	@Test(priority=1,description = "create a new account")
	public void createNewAccount() {
		try {
			MyAccountPage myaccountpage = new MyAccountPage(driver);
			HomePage homepage = new HomePage(driver);
			myaccountpage = homepage.clickMyAccountLink();
			DashboardPage dp = new DashboardPage(driver);
			wishlist = new WishlistPage(driver);
			status=homepage.verifyMsg();
			AssertionHelper.updateTestStatus(status);
			myaccountpage.clickCreateAnAccount();
			myaccountpage.setFirstName();
			myaccountpage.setLastName();
			myaccountpage.setEmailAddress();
			myaccountpage.setPassword();
			myaccountpage.setConfirmPassword();
			myaccountpage.clickRegister();
			status = dp.verifyAccountCreationMessage();
			AssertionHelper.updateTestStatus(status);		
		} catch (Exception e) {
			TestBase.logExtentReport("my account link not clickable...");	
			e.printStackTrace();
		}
	}
	     
	@Test(priority=2,description = "add a wishlist")
	public void addWishlist() {
		NavigationMenu navigationMenu = new NavigationMenu(driver);
		WaitHelper waitHelper = new WaitHelper(driver);
		ProductCategoryPage productCategoryPage = new ProductCategoryPage(driver);
		VerificationHelper verificationhelper = new VerificationHelper(driver);		
		waitHelper.setImplicitWait(ObjectReader.reader.getImpliciteWait(), TimeUnit.SECONDS);
		try{
			productCategoryPage = navigationMenu.clickOnMenu(navigationMenu.tvMenu);
			wishlist = productCategoryPage.clickAddToWishlist(productCategoryPage.addWishlist);
			status = wishlist.verifyWishlistMsg(wishlist.myWishlistMsg);
			AssertionHelper.updateTestStatus(status);	
			wishlist.clickShareWishlist(wishlist.shareWishlistBtn);
			status = wishlist.verifyWishlistMsg(wishlist.wishlistShare);
			AssertionHelper.updateTestStatus(status);	
			wishlist.setEmailAddress();
			wishlist.setMessage();
			wishlist.clickShareWishlist(wishlist.shareWishlistBtn);
			status = wishlist.verifyWishlistMsg(wishlist.myWishlistMsg);
			AssertionHelper.updateTestStatus(status);
			
		}catch(Exception e){
			TestBase.logExtentReport("error occured");	
			e.printStackTrace();
		}
		
	
	}
	
	
}
