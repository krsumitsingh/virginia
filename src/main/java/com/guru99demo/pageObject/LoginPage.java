package com.guru99demo.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.guru99demo.helper.alert.AlertHelper;
import com.guru99demo.helper.assertions.VerificationHelper;
import com.guru99demo.helper.javaScript.JavaScriptHelper;
import com.guru99demo.helper.logger.LoggerHelper;
import com.guru99demo.helper.wait.WaitHelper;
import com.guru99demo.testBase.TestBase;

public class LoginPage {

	private WebDriver driver;

	private Logger log = LoggerHelper.getLogger(LoginPage.class);

	public String login_site = "Default welcome msg! ";

	WaitHelper waithelper;
	JavaScriptHelper javascripthelper;
	VerificationHelper verificationhelper;
	AlertHelper alertHelper;

	@FindBy(xpath = "//p[@class='welcome-msg']")
	WebElement dashboardDefaultMsg;

	@FindBy(xpath = "//span[text()='Account']")
	WebElement account;

	@FindBy(xpath = "//a[text()='Log In']")
	WebElement logIn;

	@FindBy(xpath = "//input[@id='email']")
	WebElement emailAddress;

	@FindBy(xpath = "//input[@id='pass']")
	WebElement password;

	@FindBy(xpath = "//span[text()='Login']")
	WebElement loginBtn;

	/*
	 * @FindBy(xpath="//a[text()='Log out']") WebElement logoutBtn;
	 */

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(driver);
		javascripthelper = new JavaScriptHelper(driver);
		verificationhelper = new VerificationHelper(driver);
		alertHelper = new AlertHelper(driver);
		TestBase.logExtentReport("Login Page Object Created");

	}

	public void userClicksAccount(WebElement element) {
		log.info("user clicks on the account...");
		javascripthelper.clickElement(element);
		TestBase.logExtentReport("account button clicked..");
	}

	public void userClicksLogIn(WebElement element) {
		log.info("user clicks on the Log In link...");
		javascripthelper.clickElement(element);
		TestBase.logExtentReport("Log In link clicked..");
	}

	public void enterUserEmailId(String email) {
		log.info("user id entered..");
		this.emailAddress.sendKeys(email);
		TestBase.logExtentReport("entering userid.." + email);
	}

	public void enterPassword(String password) {
		log.info("password entered..");
		this.password.sendKeys(password);
		TestBase.logExtentReport("entering password.." + password);
	}

	public NavigationMenu clickloginBtn(WebElement element) {
		log.info("login button clicked..");
		javascripthelper.clickElement(element);
		TestBase.logExtentReport("login button clicked..");
		return new NavigationMenu(driver);
	}

	/*
	 * public void clickLogoutBtn(WebElement element){ log.info(
	 * "logout button clicked.."); javascripthelper.clickElement(element);
	 * TestBase.logExtentReport("logout button clicked.."); }
	 */

	public boolean verifySuccessLoginMsg() {
		return new VerificationHelper(driver).elementIsDisplayed(dashboardDefaultMsg);
	}

	public void loginToApplication(String email, String password) {
		userClicksAccount(account);
		userClicksLogIn(logIn);
		enterUserEmailId(email);
		enterPassword(password);
		clickloginBtn(loginBtn);
	}

}
