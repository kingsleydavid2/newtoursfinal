package homework3;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase_01 extends LinkedinWrapper {
	
	@BeforeMethod (groups={"AdvanceSearch"})
	public void launchbrowser(){
	//	invokeApp(browserName) ;
		loginLinkedIn();
	}
//}
	@Test (dataProvider = "getSkillDetails",groups={"AdvanceSearch"})
	public void TC01(String skill,String cName) throws InterruptedException
	{
		//Invoke the application
				
				
				Thread.sleep(3000);
				if (verifyTextContainsByLinkText("Kingsley David", "Kingsley David"))
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
				enterById("main-search-box",skill);
				
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
		
				
	}
	
	@AfterMethod (groups={"AdvanceSearch"}, alwaysRun = true)
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
