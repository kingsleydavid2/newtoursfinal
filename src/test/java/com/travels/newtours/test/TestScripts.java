package com.travels.newtours.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.k2js.newtoursfinalfw.pageobjects.HomePage;
import com.k2js.newtoursfinalfw.util.BrowserFactory;
import com.k2js.newtoursfinalfw.util.CommonUtil;

public class TestScripts {
	
	@Test
	public void verifyHomePageTitle(){
	
		
		try	{
			String browser = CommonUtil.getPropertyValue("config", "config.browsername");
			String rm = CommonUtil.getPropertyValue("config", "config.runmode");
			String url = CommonUtil.getPropertyValue("config", "config.url");
			
			WebDriver driver = BrowserFactory.getBrowser(browser, rm);
			BrowserFactory.openUrl(url);
			HomePage hp = PageFactory.initElements(driver, HomePage.class);
			String expected = CommonUtil.getPropertyValue("homepage", "homepage.title");
			System.out.println(expected);
			String actual = hp.getHomePageTitle();
			System.out.println(actual);
			assert expected.equalsIgnoreCase(actual);
			System.out.println("Testcase completed successfully");
				
			System.out.println(browser);
			System.out.println(rm);
			System.out.println(url);
		}catch (Throwable t) {
			
		}
	}
}


