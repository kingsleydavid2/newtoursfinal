package homework3;

import java.util.List;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverCommandExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import com.thoughtworks.selenium.webdriven.commands.Click;

public class TestCase_02 extends LinkedinWrapper {
	
	//@org.testng.annotations.BeforeClass
	//public void variableDeclaration(){
	//String userName = "dinesh.13@iimtrichy.ac.in";
	//String passWord = "eagle04";
	//public String browser;
	//RemoteWebDriver driver;
	//String url = "https://www.linkedin.com/";
	//}
	
	@BeforeMethod (groups={"AdvanceSearch"})
	//@Parameters({"browser"})
	public void launchbrowser(){
	//	invokeApp(browserName) ;
		loginLinkedIn();
	}
//}
	@Test (groups={"AdvanceSearch"})
	public void TC02() throws InterruptedException
	{
		
		
		
		Thread.sleep(1000);
		//Click on the advanced link
		clickById("advanced-search");
		
		Thread.sleep(2000);
		//Close the small frame
		clickByXPath("//*[@id='advs']/div[1]/button");
		
		Thread.sleep(2000);
		//Close 2nd connection
		clickByXPath("//*[@id='pivot-bar']/ul/li[2]/button");
		
		Thread.sleep(3000);
		//Close the group members
		clickByXPath("//*[@id='pivot-bar']/ul/li[2]/button");
		
		Thread.sleep(3000);
		//Get the search result count
		String actualcount = getTextByXPath("//*[@id='results_count']/div/p/strong");
		
		Thread.sleep(3000);
		//Print the search result
		System.out.println("Search result of 1st connection count is: "+ actualcount);
		
		Thread.sleep(3000);
		//Verify that with the results with 1st connections count and get the result
		boolean result = verifyTextContainsByClassName("facet-count", actualcount);
		if (result == true)
		{
			System.out.println("The number of 1st connection search results and side pane 1st connection number is the same hence test case is passed. The count is: "+actualcount);
		}
		else
		{
			System.out.println("Test case failed");
		}
		
		 
	
	}
	@AfterMethod (groups={"AdvanceSearch"}, alwaysRun = true)
	public void closeApp(){
		quitBrowser();
	}

	

		}


