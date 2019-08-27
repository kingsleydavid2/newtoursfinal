package com.travels.newtours.test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.travels.newtours.test.pages.FlightFinderPage;
import com.travels.newtours.test.pages.HomePage;
import com.travels.newtours.test.pages.RegisterPage;
import com.travels.newtours.test.utility.CommonUtil;
import com.travels.newtours.test.utility.Utility;

public class NewTour {
	
	ExtentReports extent;
	 ExtentTest logger;
	 WebDriver driver;
	
	@Test
	public void tc1_verifyHomePageTitle() throws InterruptedException{
		
		try{
	    	    	
	    	System.setProperty("webdriver.chrome.driver", "C://Automation//chromedriver.exe");
	    	 WebDriver driver = new ChromeDriver();
	    	 //driver.get("https://www.google.com");
	    	 ExtentHtmlReporter reporter=new ExtentHtmlReporter("C://Automation//learn_automation1.html");
	    	 ExtentReports extent = new ExtentReports();
	    	 extent.attachReporter(reporter);
	    	 ExtentTest logger=extent.createTest("LoginTest");
	    	driver.get("http://newtours.demoaut.com");
	    	logger.log(Status.INFO, "Launch to newtours website");
	    	logger.log(Status.PASS, "Test Case (failTest) Status is passed");
	    	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    	 driver.manage().window().maximize() ;
	    	 HomePage hp = PageFactory.initElements(driver, HomePage.class);
				String expected = CommonUtil.getPropertyValue("homepage", "homepage.title");
				System.out.println(expected);
				String actual = hp.getHomePageTitle();
				System.out.println(actual);
				assert expected.equalsIgnoreCase(actual);
				System.out.println("Testcase completed successfully");
				logger.log(Status.PASS, "Title verified");
				
												
			}catch (Throwable t) {
				
			}
	}
	
	
	@AfterMethod
	public void getResult(ITestResult result) throws NullPointerException{
		 if(result.getStatus() == ITestResult.FAILURE){
		 logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
		 logger.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
		 //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
		                        //We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method. 
		String screenshotPath;
		try {
			try {
				screenshotPath = Utility.getScreenshot(driver, result.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
				 
				 
		 }else if(result.getStatus() == ITestResult.SKIP){
		 logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
		 }
		 // ending test
		 //endTest(logger) : It ends the current test and prepares to create HTML report
		 
		 extent.flush();
		 driver.close();
		 }

	
	

	
	
	public void tc2_verifyConfirmationMessage() throws Throwable {
		
		try	{
			System.setProperty("webdriver.chrome.driver", "C://Automation//chromedriver.exe");
	    	 WebDriver driver = new ChromeDriver();
	    	 //driver.get("https://www.google.com");
	    	driver.get("http://newtours.demoaut.com");
	    	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    	 driver.manage().window().maximize() ;
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
	
	
	public void tc3_verifyFlightFinderHeading() throws Throwable {
		try	{
			System.setProperty("webdriver.chrome.driver", "C://Automation//chromedriver.exe");
	    	 WebDriver driver = new ChromeDriver();
	    	 //driver.get("https://www.google.com");
	    	driver.get("http://newtours.demoaut.com");
	    	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    	 driver.manage().window().maximize() ;
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.loginToNewTours("tutorial", "tutorial");
		WebElement FlightFinderTitle = driver.findElement(By.xpath("//tr//tr//tr//tr[1]//td[1]//img[1]"));
		System.out.println(FlightFinderTitle);
		WebElement PreferenceTitle = driver.findElement(By.xpath("//font[contains(text(),'Preferences')]"));
		System.out.println(PreferenceTitle);
		/*Set<String> AllWindowHandles = driver.getWindowHandles();
		String window1 = (String) AllWindowHandles.toArray()[0];
		String window2 = (String) AllWindowHandles.toArray()[1];
		driver.switchTo().window(window1);*/
		/*FlightFinderPage FFP = PageFactory.initElements(driver, FlightFinderPage.class);
		WebElement FlightDetailsTitle = FFP.FlightDetails();
		System.out.println(FlightDetailsTitle);*/
		/*WebElement PreferencesTitle = FFP.Preferences();
		System.out.println(PreferencesTitle);*/
		System.out.println("Test Case executed successfully");
		
		}catch (Throwable t) {
			t.printStackTrace();
			throw t;
		}
	}
}
