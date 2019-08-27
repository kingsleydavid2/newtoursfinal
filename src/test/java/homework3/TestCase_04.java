package homework3;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase_04 extends LinkedinWrapper {
	
	
	public String browser ;
	//String url = "https://www.linkedin.com/";
	@BeforeMethod (groups={"Profile"})
	public void launchbrowser(){
		//invokeApp(browserName) ;
		loginLinkedIn();
	}

	@Test (dataProvider = "getSkillDetails",groups={"Profile"})
	//,dependsOnGroups={"AdvanceSearch"})
	public void TC04(String skillData ,String cName) throws InterruptedException
	{
		
		
		Thread.sleep(3000);
		
		clickByLinkText("Jobs");
		Thread.sleep(2000);
		
		enterById("job-search-box",skillData);
		
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
		

		
	}
	
	@AfterMethod (groups={"Profile"}, alwaysRun = true)
	public void closeApp(){
		quitBrowser();
	}
	@DataProvider(name="getSkillDetails")

	public Object[][] getData(){

		//PersonDetails 
		//person = new PersonDetails();

		System.out.println(" I am inside Data Provider");

		Object[][] data=new Object[1][2];
				data[0][0]="selenium";
				data[0][1]="selenium";
				
				
				
		//person.setName(data[0][0]);

		return data;
			}



}
