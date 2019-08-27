package homework3;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_06 extends LinkedinWrapper{
	
	@BeforeMethod (groups={"Profile"})
	public void launchbrowser(){
		//invokeApp(browserName) ;
		loginLinkedIn();
	}
	
	@Test ( groups={"Profile"})//,dependsOnGroups={"AdvanceSearch"})//, invocationCount = 2, invocationTimeOut = 120000)
	public void TC06() throws InterruptedException{
		Thread.sleep(3000);
		String connectName="";
		int counter = 0;
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
		
	
		
	}
	}


