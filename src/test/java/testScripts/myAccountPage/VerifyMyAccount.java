package testScripts.myAccountPage;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guru99demo.helper.assertions.AssertionHelper;
import com.guru99demo.helper.browserConfiguration.config.ObjectReader;
import com.guru99demo.helper.logger.LoggerHelper;
import com.guru99demo.pageObject.HomePage;
import com.guru99demo.pageObject.MyAccountPage;
import com.guru99demo.testBase.TestBase;

public class VerifyMyAccount extends TestBase {
	
	private Logger log = LoggerHelper.getLogger(VerifyMyAccount.class);
	//MyAccountPage myaccountpage = new MyAccountPage(driver);
	//HomePage homepage = new HomePage(driver);
	boolean status;

	@BeforeClass
	public void beforeClass() {
		getApplicationUrl(ObjectReader.reader.getUrl());
	}

	@Test(description = "create a new account")
	public void createNewAccount() {
		try {
			MyAccountPage myaccountpage = new MyAccountPage(driver);
			HomePage homepage = new HomePage(driver);
			myaccountpage = homepage.clickMyAccountLink();
			status=homepage.verifySuccessLoginMsg();
			AssertionHelper.updateTestStatus(status);
			
		} catch (Exception e) {
			TestBase.logExtentReport("my account link not clickable...");	
			e.printStackTrace();
		}
	}
	
	
	
}
