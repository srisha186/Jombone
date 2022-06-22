package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class ForgotPassword extends BasePage {

	public ForgotPassword(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "email")
	public WebElement forgotpwdEmailtxt;

	@FindBy(id = "sbBt")
	public WebElement forgotpwssbmt;

	@FindBy(xpath = "//input[@class='form-control pincode-input-text first']")
	public WebElement pincodetxt1;

	@FindBy(xpath = "//input[@class='form-control pincode-input-text mid'][1]")
	public WebElement pincodetxt2;

	@FindBy(xpath = "//input[@class='form-control pincode-input-text mid'][2]")
	public WebElement pincodetxt3;

	@FindBy(xpath = "//input[@class='form-control pincode-input-text last']")
	public WebElement pincodetxt4;
	
	@FindBy(id="sbBt")
	public WebElement verifyclick;
	
	@FindBy(id="newPassword")
	public WebElement newPasswordtxt;
	
	@FindBy(id="confirmNewPassword")
	public WebElement confirmNewPasswordtxt;
	
	@FindBy(id="sbBt")
	public WebElement changepwdsubmit;
	
	// ==================Action methods===========================//

	
	
	public void forgotEmail() {
		forgotpwdEmailtxt.sendKeys("srisha186@gmail.com");
	}

	public void forgotSubmit() {
		forgotpwssbmt.click();

	}

	public void digitalcode() {
		pincodetxt1.sendKeys("1");
		pincodetxt2.sendKeys("2");
		pincodetxt3.sendKeys("3");
		pincodetxt4.sendKeys("4");
		
	}
	
	public void verifybtn() {
		
		verifyclick.click();
	}
	
	public void chngPwd() {
		newPasswordtxt.sendKeys("@bcdefg");
		confirmNewPasswordtxt.sendKeys("@bcdefg");
		changepwdsubmit.click();
	}
}
