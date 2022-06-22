package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;

public class Logout extends BasePage {
	public Actions action;
	public WebDriverWait wait;

	public Logout(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "navbardrop")
	public WebElement clickMedrpdwn;

	@FindBy(linkText = "Log Out")
	public WebElement logoutbtn;

	@FindBy(linkText = "Yes")
	public WebElement popLogoutYes;

	@FindBy(xpath = "//div[@class='modal-content overflow-hidden']//following::h4[contains(text(),'Log out')]")
	public WebElement popLogoutHeader;

// ==================Action methods===========================//
	// Validate Logout functionality by sign off.
	public void logout() {
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(clickMedrpdwn));
		action.moveToElement(clickMedrpdwn).click().build().perform();

		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(logoutbtn));
		action.moveToElement(logoutbtn).click().build().perform();
		
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(popLogoutHeader));
		System.out.println("Logout pop window header sisplayed is: "+popLogoutHeader.getText());
	}

	public void logoutpopwindow() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(popLogoutYes));
		action.moveToElement(popLogoutYes).click().build().perform();

	}
}
