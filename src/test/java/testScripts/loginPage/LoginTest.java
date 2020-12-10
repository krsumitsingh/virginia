/**
 * Author: Sumit kumar Singh
 * Date: 26-09-2020
 */
package testScripts.loginPage;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.guru99demo.helper.assertions.AssertionHelper;
import com.guru99demo.helper.assertions.VerificationHelper;
import com.guru99demo.helper.browserConfiguration.config.ObjectReader;
import com.guru99demo.helper.logger.LoggerHelper;
import com.guru99demo.pageObject.LoginPage;
import com.guru99demo.testBase.TestBase;

public class LoginTest extends TestBase {

	private Logger log = LoggerHelper.getLogger(LoginTest.class);

	@BeforeClass
	public void beforeClass() {
		getApplicationUrl(ObjectReader.reader.getUrl());
	}

	@Test(description = "login test with valid credentials")
	public void testLoginToApplication() {
		LoginPage login = new LoginPage(driver);
		VerificationHelper verificationhelper = new VerificationHelper(driver);
		verificationhelper.getTitle();
		boolean status = login.verifySuccessLoginMsg();
		AssertionHelper.updateTestStatus(status);

		try {
			login.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());

		} catch (Exception e) {
			TestBase.logExtentReport("login page not visible...");	
			e.printStackTrace();
		}
	}

	/*
	 * @DataProvider(name="testData") public Object[][] testData(){ Object[][]
	 * data = getExcelData("TestData.xlsx", "LoginDetails"); return data; }
	 */
	/*
	 * @Test(priority=1,dataProvider="testData") public void
	 * loginTestWithCredentials(String userName, String password, String
	 * runMode){
	 * 
	 * if(runMode.equalsIgnoreCase("n")){ throw new SkipException(
	 * "Run mode for this set of data is marked N"); } loginpage_text =
	 * login.verifyLoginPageText(); logExtentReport(
	 * "login page text captured ..."+loginpage_text);
	 * login.loginToApplication(userName, password);
	 * 
	 * try{ //homepage_text = login.verifyHomePageText();
	 * 
	 * login.logout();
	 * 
	 * }catch(Exception e){ log.info("homepage not visible.."+homepage_text);
	 * TestBase.logExtentReport("homepage not visible.."+homepage_text);
	 * e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * }
	 */

}
