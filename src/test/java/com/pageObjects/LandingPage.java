package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.base.BasePage;

public class LandingPage extends BasePage {

	public LandingPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText="Log In")
	public WebElement login;
	
	@FindBy(linkText="Sign Up")
	public WebElement signUp;
	
	@FindBy(linkText="Looking for work")
	public WebElement lookingForWork;
	
	// ==================Action methods===========================//

	
	public void loginLandingPage() {
		
		login.click();
	}
	
	public void signupLandingPage() {
		
		signUp.click();
	}
	
	public void lookingWorkLandingPage() {
		lookingForWork.click();
		
	}
	
}
