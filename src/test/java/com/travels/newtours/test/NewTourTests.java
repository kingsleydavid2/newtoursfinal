package com.travels.newtours.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.travels.newtours.test.library.*;
import com.travels.newtours.test.pages.*;
import com.travels.newtours.test.utility.*;

public class NewTourTests {
	
	@Test
	public void tc1_verifyHomePageTitle() {
		
		try	{
			//String browser = CommonUtil.getPropertyValue("config", "config.browsername");
			//String rm = CommonUtil.getPropertyValue("config", "config.runmode");
			//String url = CommonUtil.getPropertyValue("config", "config.url");
			//WebDriver driver = BrowserFactory.getBrowser(browser, rm);
			//BrowserFactory.openUrl(url);
			
			System.setProperty("webdriver.chrome.driver", "C://Automation//chromedriver.exe");
	    	 WebDriver driver = new ChromeDriver();
	    	 //driver.get("https://www.google.com");
	    	driver.get("https://www.softwaretestingmaterial.com/javascript-alerts-popups-selenium/");
			HomePage hp = PageFactory.initElements(driver, HomePage.class);
			String expected = CommonUtil.getPropertyValue("homepage", "homepage.title");
			System.out.println(expected);
			String actual = hp.getHomePageTitle();
			System.out.println(actual);
			assert expected.equalsIgnoreCase(actual);
			System.out.println("Testcase completed successfully");
							
		}catch (Throwable t) {
			
		}
	}

	
		
		/*public void tc2_verifyConfirmationMessage() throws Throwable {
			
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
		}*/
		

		/*@Test
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
		}*/
		}

		
   





			
			
				
		


	
	
//	public static void main(String[] args) 
//	
//	{
//		
//		NewTourTests nt = new NewTourTests();
//		nt.tc_verifyHomePageTitle();
//	}


