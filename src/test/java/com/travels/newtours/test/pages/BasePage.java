package com.travels.newtours.test.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	protected WebDriver driver;
	protected BasePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getPageTitle() {
		return this.driver.getTitle();
		
	}

}
	
	


