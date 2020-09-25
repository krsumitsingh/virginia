package testScripts.loginPage;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.guru99demo.helper.browserConfiguration.config.ObjectReader;
import com.guru99demo.helper.logger.LoggerHelper;
import com.guru99demo.pageObject.LoginPage;
import com.guru99demo.testBase.TestBase;

public class LoginTest extends TestBase {
	
	private Logger log = LoggerHelper.getLogger(LoginTest.class);
	LoginPage login;
	public String loginpage_text="";
	public String homepage_text="";
	 
	/*@Test(description="login test with valid credentials")
	public void testLoginToApplication(){
		LoginPage login = new LoginPage(driver);
		getApplicationUrl(ObjectReader.reader.getUrl());
		loginpage_text = login.verifyLoginPageText();
		logExtentReport("login page text captured ..."+loginpage_text);	
		login.loginToApplication(ObjectReader.reader.getUserName(),ObjectReader.reader.getPassword());	
		try {
			login.logout();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	@BeforeClass
	public void beforeClass(){
		getApplicationUrl(ObjectReader.reader.getUrl());
		login = new LoginPage(driver);
	} 
	
	@DataProvider(name="testData")
	public Object[][] testData(){
		Object[][] data = getExcelData("TestData.xlsx", "LoginDetails");
		return data;
	}
	
	@Test(priority=1,dataProvider="testData")	
	public void loginTestWithCredentials(String userName, String password, String runMode){
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("Run mode for this set of data is marked N");
		}
		loginpage_text = login.verifyLoginPageText();
		logExtentReport("login page text captured ..."+loginpage_text);	
		login.loginToApplication(userName, password);			
		
		try{
			//homepage_text = login.verifyHomePageText();
		
				login.logout();
			
		}catch(Exception e){
			log.info("homepage not visible.."+homepage_text);
			TestBase.logExtentReport("homepage not visible.."+homepage_text);	
			e.printStackTrace();
		}
		
		
		
	}
		
		
		
}
