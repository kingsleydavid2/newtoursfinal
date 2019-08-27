package homework3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import wrappers.WrapperMethods;

public class LinkedinWrapper extends WrapperMethod{
	@BeforeClass
	public void linkedinVariable(){
	String userName = "tstchennai16@gmail.com";
	String passWord = "thestreet";
	}
	@BeforeSuite
	public void dummySuite()
	{
		System.out.println("Test suite dummy");
	}
	
	@BeforeTest
	public void dummyTestSuite()
	{
		System.out.println("Test dummy");
	}
	
	@AfterSuite
	public void afterdummySuite()
	{
		System.out.println("Test suite dummy");
	}
	
	@AfterTest
	public void afterdummyTestSuite()
	{
		System.out.println("Test dummy");
	}
	public boolean loginLinkedIn(){
		
		try {
			driver.findElementById("login-email").sendKeys("dinesh.13@iimtrichy.ac.in");
			driver.findElementById("login-password").sendKeys("eagle04");
			driver.findElementByName("submit").click();
		} catch (NoSuchElementException e) {
			
			System.out.println("Element for User Login is not found");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	


	//@AfterMethod (groups={"AdvanceSearch","Profile"}, alwaysRun = true)
	//public boolean quitBrowser() {

		//driver.quit();
		//return false;
	//}
}
