package com.travels.newtours.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.k2js.mavenselenium.pageobjects.FlightFinderPage;
import com.travels.newtours.test.library.BaseTestMethod;
import com.travels.newtours.test.pages.HomePage;
import com.travels.newtours.test.pages.RegisterPage;
import com.travels.newtours.test.utility.BrowserFactory;
import com.travels.newtours.test.utility.CommonUtil;

public class SmokeRefTest extends BaseTestMethod {
			
		@BeforeMethod (groups={"AdvanceSearch"})
		public void launchbrowser(){
			invokeApp(browser) ;
			loginLinkedIn();
		}
	
		//}
		@Test
		public void tc1_verifyHomePageTitle(){
		
		try	{
			/*String browser = CommonUtil.getPropertyValue("config", "config.browsername");
			String rm = CommonUtil.getPropertyValue("config", "config.runmode");
			String url = CommonUtil.getPropertyValue("config", "config.url");
			
			WebDriver driver = BrowserFactory.getBrowser(browser, rm);
			BrowserFactory.openUrl(url);*/
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
	
	@Test
	public void tc2_verifyConfirmationMessage() throws Throwable {
		
		try	{
			String browser = CommonUtil.getPropertyValue("config", "config.browsername");
			String rm = CommonUtil.getPropertyValue("config", "config.runmode");
			String url = CommonUtil.getPropertyValue("config", "config.url");
			
			WebDriver driver = BrowserFactory.getBrowser(browser, rm);
			BrowserFactory.openUrl(url);
			HomePage hp = PageFactory.initElements(driver, HomePage.class);
			RegisterPage rp = hp.clickRegisterLink();
			String fn = CommonUtil.getPropertyValue("registerpage", "registerpage.firstname");
			System.out.println(fn);
			Thread.sleep(3000);
			rp.enterfirstname(fn);
			rp.RegisterButton();
			Thread.sleep(4000);
			driver.close();
			System.out.println("Test Case executed successfully");
			
		}catch (Throwable t) {
			t.printStackTrace();
			throw t;
	}
	
}
	
	
	@Test
	public void tc3_verifyFlightFinderHeading() throws Throwable {

		
		try	{
		String browser = CommonUtil.getPropertyValue("config", "config.browsername");
		String rm = CommonUtil.getPropertyValue("config", "config.runmode");
		String url = CommonUtil.getPropertyValue("config", "config.url");
		
		WebDriver driver = BrowserFactory.getBrowser(browser, rm);
		BrowserFactory.openUrl(url);
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.loginToNewTours("tutorial", "tutorial");
		FlightFinderPage FFP = PageFactory.initElements(driver, FlightFinderPage.class);
		WebElement FlightDetailsTitle = FFP.FlightDetailsTitle;
		System.out.println(FlightDetailsTitle);
		WebElement PreferencesTitle = FFP.PreferencesTitle;
		System.out.println(PreferencesTitle);
		System.out.println("Test Case executed successfully");
		
		}catch (Throwable t) {
			t.printStackTrace();
			throw t;
	}
	}
	
	@AfterMethod (groups={"AdvanceSearch"}, alwaysRun = true)
	public void closeApp(){
		quitBrowser();
	}
}
	


