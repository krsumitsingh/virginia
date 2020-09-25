package com.guru99demo.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.guru99demo.helper.resource.ResourceHelper;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeBrowser {

	public ChromeOptions getChromeOptions(){

		//WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("-test-type");
		option.addArguments("--start-maximized");
		option.addArguments("--disable-browser-side-navigation");
		option.addArguments("--disable-extensions");
		option.addArguments("disable-infobars");
		option.addArguments("--disable-plugins-discovery");
		DesiredCapabilities chrome  = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		//option.setExperimentalOption(ChromeOptions.CAPABILITY, option);
		option.setCapability(ChromeOptions.CAPABILITY, option);
			if(System.getProperty("os.name").contains("Linux")){
			option.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
		}	
		return option;	
	}
	
	
	public WebDriver getChromeDriver(ChromeOptions cap) {
		
		if (System.getProperty("os.name").contains("Mac")){
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("resources/configFile/chromedriver"));
			return new ChromeDriver(cap);
		}
		else if(System.getProperty("os.name").contains("Window")){
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("resources/configFile/chromedriver.exe"));
			return new ChromeDriver(cap);
		}
		else if(System.getProperty("os.name").contains("Linux")){
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "/usr/bin/chrome");
			return new ChromeDriver(cap);
		}
		return null;
	
	}
	
	
	/*public static void main(String[] args) {
		ChromeBrowser chromebrowser = new ChromeBrowser();
		WebDriver driver = chromebrowser.getChromeDriver(chromebrowser.getChromeOptions());
		driver.get("https://www.zomato.com/");
	}*/
	
	
}
