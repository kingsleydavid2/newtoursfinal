package homework3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.service.DriverCommandExecutor;
import org.testng.annotations.Test;



import com.thoughtworks.selenium.webdriven.commands.Click;

import wrappers.LinkedinWrappers;
@Test
public class TestCase_02 extends LinkedinWrapper
{
	
	
	public void verifySearchResult() throws InterruptedException
	{
		//Invoke the application
		invokeApp("chrome","https://www.linkedin.com/");
		Thread.sleep(3000);
		
		//Login to the application
		loginLinkedIn("dinesh.13@iimtrichy.ac.in","eagle04");
		
		Thread.sleep(3000);
		//Click on the advanced link
		clickById("advanced-search");
		
		Thread.sleep(3000);
		//Close the small frame
		clickByXPath("//*[@id='advs']/div[1]/button");
		
		Thread.sleep(3000);
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
		
		 quitBrowser();
	
	}
	
	public void printSearchResult() throws InterruptedException
	{
		//Invoke the application
				invokeApp("chrome","https://www.linkedin.com/");
				Thread.sleep(3000);
				
				//Login to the application
				loginLinkedIn("dinesh.13@iimtrichy.ac.in","eagle04");
				
				Thread.sleep(3000);
				if (verifyTextContainsByLinkText("Dinesh kaarthik", "Dinesh kaarthik"))
				{
					System.out.println("Login successfull");
				}
				else
				{
					System.out.println("Login not successfull");
				}
				//Click on the advanced link
				clickById("advanced-search");
				
				Thread.sleep(3000);
				//Close the small frame
				clickByXPath("//*[@id='advs']/div[1]/button");
				
				Thread.sleep(3000);
				//Enter the keyword in the search box
				enterById("main-search-box","selenium");
				
				//Click on the search button
				clickByClassName("search-button");
				
				Thread.sleep(2000);
				
				//To print the search result number
				String outPutValue = getTextById("results_count");
				//System.out.println(outPutValue);
				int charPosition = outPutValue.indexOf("r");
				System.out.println("Total number of search result is: " + outPutValue.substring(0, charPosition));
				
				//To print name of the first listed connection and type of connection
				
				System.out.println("First connection name is: " + getTextByLinkText("senthil kumar"));
				Thread.sleep(2000);
				System.out.println("And the first connection name displayed is a : " + getTextByClassName("degree-icon")+" connection");
		
				quitBrowser();
	}
	
	public void addSkills() throws InterruptedException
	{
				int skillFlag = 0;
				//Invoke the application
				invokeApp("Chrome","https://www.linkedin.com/");
				Thread.sleep(3000);
				
				//Login to the application
				loginLinkedIn("dinesh.13@iimtrichy.ac.in","eagle04");
				
				Thread.sleep(3000);
				clickByLinkText("Profile");
				Thread.sleep(2000);
				if (verifyTextContainsByXPath("//*[@id='headline']/div[1]/p", "HCL"))
				{
					System.out.println("Company name is displayed as expected");
				}
				else
				{
					System.out.println("Company name is not as expected");
				}
				
				List<WebElement> skillElements = findAllElementsByClassName("endorse-item-name");
				for (WebElement skillName : skillElements)
				{
					String skill = skillName.getText();
					
					
					if (skill !=null)
					{
					if (skill.equalsIgnoreCase("Selenium") )
					{
					
						skillFlag = skillFlag + 1;
					}
					}
				}
				
				if (skillFlag == 0)
				{
					clickByXPath("//*[@id='background-skills']/button");
					Thread.sleep(2000);
					enterById("edit-skills-add-ta","Selenium");
					Thread.sleep(2000);
					clickById("edit-skills-add-btn");
					Thread.sleep(2000);
					clickByXPath("//*[@id='skills-editor-form']/p/input");
					Thread.sleep(2000);
					List<WebElement> skillElementsAdd = findAllElementsByClassName("endorse-item-name");
					for (WebElement skillNameAdd : skillElementsAdd)
					{
						String skillAdd = skillNameAdd.getText();
						
						
						if (skillAdd !=null)
						{
						if (skillAdd.equalsIgnoreCase("Selenium") )
						{
						
							System.out.println("Skill added successfully: " + skillAdd);
							skillFlag =skillFlag + 1;
							break;
						}
						}
					}
					if (skillFlag == 0)
					{
						System.out.println("Skill not added successfully");
					}
					
					
				}else
				{
					System.out.println("Skill already exists");
				}
				
		
				quitBrowser();
	}
	
	public void printEmployeeCount() throws InterruptedException
	{
		invokeApp("Chrome","https://www.linkedin.com/");
		Thread.sleep(3000);
		
		//Login to the application
		loginLinkedIn("dinesh.13@iimtrichy.ac.in","eagle04");
		
		Thread.sleep(3000);
		
		clickByLinkText("Jobs");
		Thread.sleep(2000);
		
		enterById("job-search-box","Selenium");
		
		clickByName("jsearch");
		Thread.sleep(2000);
		String actualCssValue = getCSSValueByXPath("//*[@id='results']/li[1]/div/div[3]/a", "background-color");
		if (actualCssValue.contains("rgba(0, 140, 201, 1"))
		{
			System.out.println("The color of the first view button is blue and verification passed. Its rgba value is: " +actualCssValue );
		}
		else
		{
			System.out.println("The color of the first view button is not blue and verification failed. Its rgba value is: " +actualCssValue);
		}
		
		
		
		clickByXPath("//*[@id='results']/li[2]/div/div[3]/a");
		Thread.sleep(3000);
		System.out.println("Company name is: " + getTextByXPath("//*[@id='top-card']/div/div[1]/div[2]/h3[1]/a/span[1]"));
		clickByXPath("//*[@id='top-card']/div/div[1]/div[2]/h3[1]/a/span[1]");
		Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		System.out.println("Number of employees count is: " + getTextByClassName("company-size"));
		quitBrowser();

		
	}
	
	public void asearch() throws InterruptedException
	{
		invokeApp("Chrome","https://www.linkedin.com/");
		Thread.sleep(3000);
		
		//Login to the application
		loginLinkedIn("dinesh.13@iimtrichy.ac.in","eagle04");
		
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
				
		quitBrowser();
		

		
	}
	
	public void messagingTest () throws InterruptedException
	{
		try {
			
		
		invokeApp("chrome","https://www.linkedin.com/");
		Thread.sleep(3000);
		
		//Login to the application
		loginLinkedIn("dinesh.13@iimtrichy.ac.in","eagle04");
		
		Thread.sleep(3000);
		clickByXPath("//*[@id='account-nav']/ul/li[1]/a");
		Thread.sleep(10000);
		//driver.navigate().refresh();
		List<WebElement> buttonElements = findAllElementsByTagname("button");
		for (WebElement button: buttonElements) {
			String myText = button.getText();
			if (myText!=null && myText.contains("Compose a new message")){
				button.click();
				break;
			}
		}
		Thread.sleep(10000);
		//System.out.println(driver.findElementById("compose-button").getAttribute("xpath"));
		
		//clickById("compose-button");
		
		Thread.sleep(5000);
		
		
		enterById("pillbox-input","L");
		
		enterById("pillbox-input","i");
		
		Thread.sleep(1000);
		
		driver.findElementById("pillbox-input").sendKeys("n",Keys.TAB);
		
		if (isVisibleByXPath("//*[@id='pillbox-list']/span/pre")){
			clickByXPath("//*[@id='pillbox-list']/span/pre");
		}
		Actions action = new Actions(driver); 
		
		Thread.sleep(5000);
		enterById("compose-message", "Thank you");
		
		

		action.sendKeys(driver.findElement(By.xpath("//*[@id='compose-message']")), Keys.ENTER).build().perform();
		
		clickByXPath("//*[@id='enter-to-reply-callout-content']/button[1]");
		
		
		Thread.sleep(5000);
		
		String actualMessage = getTextByXPath("//*[@id='messages-list-wrapper']/ul/li[2]/div[2]/div[2]/div[2]/div/h4/p");
		if (actualMessage.equals("Thank You")){
			System.out.println("Message successfully sent and verification passed: "+ actualMessage);
		}else
		{
			System.out.println("Message not sent successfully and verification failed");
		}
		quitBrowser();

		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("No such element present");
		}catch (NoSuchElementException e){
			e.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
			
		}

		
		
	}
	public void aconnect() throws InterruptedException
	{
		String connectName="";
		invokeApp("firefox","https://www.linkedin.com/");
		Thread.sleep(3000);
		int counter = 0;
		//Login to the application
		loginLinkedIn("dinesh.13@iimtrichy.ac.in","eagle04");
		
		Thread.sleep(3000);
		clickById("dropdowntest");
		
		Thread.sleep(3000);
		scroller("scroll(0,250)");
		
		Thread.sleep(5000);
		List<WebElement> allButtons = findAllElementsByTagname("button");
		System.out.println(allButtons.size());
		for (WebElement buttonConnect : allButtons) {
			
			String buttonName = buttonConnect.getText();
			if (buttonName.contains("Connect"))
			{
				counter = counter + 1;
			}
		}
		
		for (WebElement buttonConnect : allButtons) {
			String buttonName = buttonConnect.getText();
			if (buttonName.contains("Connect"))
			{
				System.out.println(buttonConnect.getCssValue("background"));
				String colorCode = buttonConnect.getCssValue("background");
				if (colorCode.contains("rgb(0, 119, 181)"))
						{
					System.out.println("The button color is blue : "+ colorCode);
						}
				else
				{
					System.out.println("Button color is not blue" + colorCode);
				}
				connectName = buttonConnect.getText();
				System.out.println(connectName);
				buttonConnect.click();
				break;
			}
			
		}
		String myString = connectName.substring(21);
		System.out.println(myString);
		Thread.sleep(3000);
		
		//System.out.println(driver.switchTo().alert().getText());
		String actualString = getTextByCSS("#global-alert-queue > div");
		String verifyText = "Invitation sent to "+ myString;
		System.out.println(verifyText);
		if (actualString.contains(verifyText))
		{
			System.out.println("Connection invite sent successfully and message displayed as : "+ actualString);
		}else
		{
			System.out.println("Connection invite not sent successfully and message not displayed");
		}
			
		
		
					
		
			//System.out.println(driver.findElementByXPath("//*[@class='alert success']/div").getText());
		
		System.out.println(counter);
		quitBrowser();
	
		
	}
}
