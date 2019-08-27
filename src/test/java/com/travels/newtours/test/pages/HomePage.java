package com.travels.newtours.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.travels.newtours.test.pages.BasePage;
import com.travels.newtours.test.pages.*;

public class HomePage extends BasePage {
	
	private WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=super.driver;
	}
	
	public String getHomePageTitle(){
		return super.getPageTitle();
	}
	
	@FindBy(linkText = "REGISTER")
	public WebElement register;
	
	@FindBy(name="userName")
	public WebElement username;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(name="login")
	public WebElement loginbutton;
	
	
	public void setUserName(String strUserName){
		username.sendKeys(strUserName);
	}
	
	
	public void setPassWord(String strPassWord){
		password.sendKeys(strPassWord);
	}
	
	public void clickLogin(){
		loginbutton.click();
	}
	
	public RegisterPage clickRegisterLink(){
		this.register.click();
		return PageFactory.initElements(driver, RegisterPage.class);
	}
	
	public void loginToNewTours(String strUserName, String strPassWord){
		this.setUserName(strUserName);
		this.setPassWord(strPassWord);
		this.clickLogin();
	}

}

