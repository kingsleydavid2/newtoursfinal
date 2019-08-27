package com.travels.newtours.test.library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public interface GenericWrappers
{
	public boolean clickById(String id);
	/*
	 * This method will find the element by id and click
	 * @param - id
	 */
	public boolean clickByName(String name);	
	public boolean clickByClassName(String classname);	
	/*
	 * This method will find the element by classname and clicks on submit
	 * @param - classname as string
	*/
	public boolean clickByTagName(String tagname);	
	public boolean clickByXPath(String XPath);

	
	public boolean clickByCSS(String CSS);			
	public boolean clickByLinkText(String linktext);	//all LinkText and Partial Link Text - Santosh
	public boolean clickByPartialLinkText(String partiallinktext); 

	public boolean enterById(String id, String data);
	/*
	 * This method will enter the string by finding element by Id and passing the data to the text field
	 * @param - id as string
	 * @param - data as string	
	*/
	public boolean enterByName(String name, String data);

	public boolean enterByCSS(String CSS, String data);
	public boolean enterByXPath(String XPath, String data);

	public String getTextById(String id);
	/*
	 * This method will get the values by using element id
	 * @param- id as string 
	 * 	
	*/
	public String getTextByName(String name);

	public String getTextByCSS(String CSS);
	public String getTextByClassName (String classname);
	public String getTextByLinkText(String linktext);
	/*This method will getting text by linkText and returning the linktext
	 * @param - linktext as string	
	*/
	public String getTextByPartialLinkText(String name, String partiallinktext);
	public String getTextByXPath(String XPath);
	public boolean verifyTextByClassName(String classname, String data);
	public boolean verifyTextByLinkText(String linktext);
	public boolean verifyTextByPartialLinkText(String partiallinktext);
	public boolean verifyTextContainsByLinkText(String name, String linktext);
	public boolean verifyTextContainsByPartialLinkText(String name,String partiallinktext);
	public String verifyTextByXPath(String XPath, String data);
	public boolean verifyTextContainsByClassName(String classname, String data);
	public boolean verifyTextContainsByXPath(String XPath, String text);
	public String verifyTextById(String id, String data);
	public String verifyTextByName(String name, String data);


	public boolean verifyTextByCSS(String CSS, String text);

	public boolean verifyTextContainsByID(String id, String text);
	public boolean verifyTextContainsByName(String name, String text);


	public boolean verifyTextContainsByCSS(String CSS, String text);	

	public boolean selectByClassNameByValue(String classname, String value);
	public boolean selectByClassnameByVisbleText(String classname, String VisibleText);
	public boolean selectByClassNameByIndex(String classname, int index);

	public boolean selectByNameByValue(String id, String value);
	public boolean selectByNameByVisbleText(String id, String VisibleText);
	public boolean selectByNameByIndex(String id, int index);

	public boolean selectByIDByValue(String id, String value);
	public boolean selectByIDByVisbleText(String id, String VisibleText);
	public boolean selectByIDByIndex(String id, int index);


	public String getCSSValueByXPath(String XPath, String attributeName);
	public boolean selectByCSSByValue(String CSS, String value);
	public boolean selectByCSSByVisbleText(String CSS, String VisibleText);
	public boolean selectByCSSByIndex(String CSS, int index);
	public Select getDropDownByXPath(String XPath);


	public boolean selectByTagnameByValue(String tagname, String value);
	public boolean selectByTagnameByVisbleText(String tagname, String VisibleText);
	public boolean selectByTagnameByIndex(String tagname, int index);

	public boolean switchToFrameByID(String id);
	public boolean switchToFrameByName(String name);
	public boolean switchToFrameByClassName(String className);
	public boolean switchToFrameByTagname(String tagname);
	public boolean switchToFrameByCSS(String CSS);
	public boolean switchToFrameByXPath(String XPath);
	public List<WebElement> findAllElementsByID(String id);
	public List<WebElement> findAllElementsByName(String name);
	public List<WebElement> findAllElementsByTagname(String tagname);
	public List<WebElement> findAllElementsByCSS(String CSS);
	public List<WebElement> findAllElementsByXPath(String XPath);
	public List<WebElement> findAllElementsByClassName(String className);
	public int countAllElementsByID(String id);
	public int countAllElementsByName(String name);
	public int countAllElementsByTagname(String tagname);
	public int countAllElementsByCSS(String CSS);
	public int countAllElementsByXPath(String XPath);
	public int countAllElementsByClassName(String classname);

	public boolean isEnabledByID(String id);
	public boolean isEnabledByName(String name);
	public boolean isEnabledByTagname(String tagname);
	public boolean isEnabledByCSS(String CSS);
	public boolean isEnabledByXPath(String XPath);
	public boolean isEnabledByClassName(String name);

	public boolean isVisibleByID(String id);
	public boolean isVisibleByName(String name);
	public boolean isVisibleByTagname(String tagname);
	public boolean isVisibleByCSS(String CSS);
	public boolean isVisibleByXPath(String XPath);
	public boolean isVisibleByClassName(String name);

		public boolean invokeApp(String browser,String url);
		/*
		 *This method will launch chrome or firefox and maximise the browser and set the
		 * wait for 30 seconds and load the url
		 * @param url - The url with http or https
		 */
		public boolean verifyTitle(String title);
	public boolean verifyTitleContains(String title);

	public boolean acceptAlert();   //Santosh
	public boolean dismissAlert();  //Ashish
	public String getAlertText();   //Santosh
	public boolean sendTextToAlert(String data);   //Ashish

	//Ashish and Karthikeyan
	public boolean quitBrowser();    
	public boolean closeCurrentWindow();
	public boolean closeAllWindows();
	public boolean closeAllButParentWindow();
	public List<String> getAllWindowHandles();

	public boolean closeWindowWithTitle(String Title); //Hussain	
	public boolean switchToWindow(String handle); //Hussain

	public String getCurrentWindowHandle(); //Santosh

	public boolean mouseOverByXpath(String xpathVal);   //To be implemented in future
	public boolean mouseOverByLinkText(String linkName); //To be implemented in future

	public boolean getScreenShot(); //Sarathi

	public boolean switchToFrameID(String id);  //Sarathi
	public boolean switchToFrameName(String name);  //Sarathi

	public boolean switchBackFromFrame(); //Sarathi

	public String getURL();  //Sarathi
	public String getPageSource(); //Sarathi

	public List<String> getAllOptionByID(String ID);  //do it for all other applicable locators //Sarathi
	public String getAttributeValueByID(String id, String Attribute); //do it for all other applicable locators //Sarathi
	public String getAttributeValueByName(String name, String Attribute);
	public String getAttributeValueByClassName(String className, String Attribute);
	public String getAttributeValueByXpath(String xpath, String Attribute);
	public String getAttributeValueByTagName(String tagName, String Attribute);

}

