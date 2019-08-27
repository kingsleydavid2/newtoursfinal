package homework3;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class TestCase_03 extends LinkedinWrapper{
	
	@BeforeMethod (groups={"Profile"})
	public void launchbrowser(){
	//	invokeApp(browserName) ;
	loginLinkedIn();
	}
//}
	@Test (dataProvider = "getSkillDetails",groups={"Profile"})
	//,dependsOnGroups={"AdvanceSearch"})
	public void TC03(String skillData,String cName) throws InterruptedException
	{
				int skillFlag = 0;
				//Invoke the application
				
				
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
					if (skill.equalsIgnoreCase(skillData) )
					{
					
						skillFlag = skillFlag + 1;
					}
					}
				}
				
				if (skillFlag == 0)
				{
					clickByXPath("//*[@id='background-skills']/button");
					Thread.sleep(2000);
					enterById("edit-skills-add-ta",skillData);
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
						if (skillAdd.equalsIgnoreCase(skillData) )
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
