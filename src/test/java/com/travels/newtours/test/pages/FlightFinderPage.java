package com.travels.newtours.test.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightFinderPage extends BasePage{

	protected FlightFinderPage(WebDriver driver) {
		super(driver);
		this.driver=super.driver;
}
	
	@FindBy(xpath = "//form[@name='findflight']//table//tbody//tr//td//font//font//b//font//font[contains(text(),'Flight')]")
	public WebElement FlightDetails;
	
	@FindBy(xpath=" //font[contains(text(),'Preferences')]")
	public String Preferences;
	
	
	public WebElement FlightDetails(){
		FlightDetails.getText();
		return FlightDetails;
	}
	
	

}