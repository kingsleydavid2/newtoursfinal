package com.travels.newtours.test.utility;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.travels.newtours.test.utility.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	private static WebDriver driver = null;
	public static WebDriver getBrowser(String browser, String rm) throws MalformedURLException  {
		if(rm.equalsIgnoreCase("remote")){
			if(browser.equalsIgnoreCase("Chrome"));
			WebDriverManager.chromedriver().setup();
			ChromeOptions co=new ChromeOptions();
			String chromeMatchPath;
			try {
				chromeMatchPath = CommonUtil.getPropertyValue("config", "config.remotechromeM1");
				driver=new RemoteWebDriver(new URL(chromeMatchPath),co);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//			try {
//				//driver=new RemoteWebDriver(new URL(chromeMatchPath),co);
//			} catch (MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		else if (browser.equalsIgnoreCase("firefox")) {
		
		}else if(rm.equalsIgnoreCase("local")) {
			if(browser.equalsIgnoreCase("chrome")){
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if (browser.equalsIgnoreCase("firefox")) {
		
	}
		
        
		}
		return driver;

	}
	
	public static void openUrl(String url)
	{
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public static void closeAllBrowsers() {
		driver.quit();
	}
	public static void closeBrowser() {
		driver.close();
	}

}
