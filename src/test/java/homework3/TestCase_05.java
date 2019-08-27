package homework3;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_05 extends LinkedinWrapper{
	
	@BeforeMethod (groups={"Profile"})
	public void launchbrowser(){
		//invokeApp(browserName) ;
		loginLinkedIn();
	}
	
	@Test (enabled = false, groups={"Profile"},dependsOnGroups={"AdvanceSearch"})
	public void TC05() throws InterruptedException
	{
		
		
		Thread.sleep(3000);
		clickById("advanced-search");
		
		Thread.sleep(3000);
		enterById("advs-company", "kpmg");
		
		selectByIDByVisibleText("advs-locationType", "Located in or near:");
		
		Thread.sleep(3000);
		selectByIDByVisibleText("advs-countryCode", "India");
		
		Thread.sleep(2000);
		clickByXPath("//*[@id='peopleSearchForm']/div[1]/input[2]");
		
		Thread.sleep(1000);
		
		System.out.println("Company name is: " + getAttributeValueByID("advs-company", "value"));
		
		if (getAttributeValueByID("advs-company", "value").isEmpty())
		{
			System.out.println("Company name is cleared and verification is passed");
		}
		else
		{
			System.out.println("Company name is not cleared and verification is failed");
		}
		
		
		Thread.sleep(2000);
		//WebElement element = driver.findElementByXPath("//*[@id='adv-facet-N']/fieldset/div/ol/li[1]/div/label/bdi']");
		//Actions action = new Actions(driver);
		//action.moveToElement(element).click().perform();
		//driver.findElementByXPath("//*[@id='adv-facet-N']/fieldset/div/ol/li[1]/div/label/bdi").submit();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(250,0)");
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@id='adv-facet-N']/fieldset/div/ol/li[1]/div/label/bdi").click();	
		//*[@id='adv-facet-N']/fieldset/div/ol/li[1]/div/label/bdi
		//clickByXPath("//*[@id='adv-facet-N']/fieldset/div/ol/li[1]/div/label/bdi']");
		//Thread.sleep(5000);
		js.executeScript("scroll(0,250)");
		Thread.sleep(1000);
		clickByXPath("//*[@id='peopleSearchForm']/div[1]/input[1]");
				
		
		

		
	}

}
