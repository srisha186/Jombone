package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;

public class LoginPage extends BasePage {

//	public WebDriver ldriver;

	// Constructor

	public LoginPage(WebDriver driver) {
		super(driver);
		// ldriver = rdriver;
		// PageFactory.initElements(ldriver, this);
	}

	// Capture email field
	@FindBy(id = "email")
	
	public WebElement txtemail;

	// Capture password field
	@FindBy(id = "password-field")
	@CacheLookup
	public WebElement txtpassword;

	// Capture Submit button
	@FindBy(id = "sbBt")
	@CacheLookup
	public WebElement btnSubmit;

	@FindBy(xpath = "//span[contains(text(),'Please enter valid email.')]")
	@CacheLookup
	public WebElement errmsg_emailBlank;

	// Capture "invalid credentials text"
	@FindBy(xpath = "//div[@id='toast-container'] //div[contains(text(),'Invalid credentials')]")
	@CacheLookup
	public WebElement invalidCredentialsText;

	@FindBy(xpath = "//span[contains(text(),'Please enter password')]")
	@CacheLookup
	public WebElement errmsg_pwdBlank;

	// Capture "sign up" link in login page
	@FindBy(linkText = "Sign Up")
	@CacheLookup
	public WebElement signUpLink;

	// Capture "candidate sign up" link in login page
	@FindBy(xpath = "//a[contains(text(),'Candidate Sign Up')]")
	@CacheLookup
	public WebElement candidateSignUpLink;
	
	@FindBy(linkText="Log In")
	public WebElement loginSignupPage;

	// capture Company Sign Up Link in login page
	@FindBy(xpath = "//a[contains(text(),'Company Sign Up')]")
	@CacheLookup
	public WebElement companySignUpLink;

	// Capture "forgot password" link
	@FindBy(linkText = "Forgot Password?")
	@CacheLookup
	public WebElement forgotPasswordLink;

	@FindBy(xpath = "//button[contains(text(),'Skip')]")
	@CacheLookup
	public WebElement skipPop;

	@FindBy(xpath = "//span[@data-role='end']")
	@CacheLookup
	public WebElement closepop;

	@FindBy(xpath = "//li[@id='three']")
	@CacheLookup
	public WebElement candidate;

	@FindBy(xpath = "//li[@id='three'] //a[contains(text(),'Candidate Search')]")
	@CacheLookup
	public WebElement candidateSearch;

	// ==================Action methods===========================//

	// Send text to the email field
	public void settxtemail(String email) {

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(txtemail));
		txtemail.sendKeys(email);
	}

	// Send text to password field
	public void settxtpassword(String pwd) {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(txtpassword));
		txtpassword.sendKeys(pwd);
	}

	// Click on submit button
	public void clkbtnSubmit() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		// wait.until(ExpectedConditions.visibilityOf(btnSubmit));
		wait.until(ExpectedConditions.elementToBeClickable(btnSubmit));
		btnSubmit.click();
		//btnSubmit.isSelected();
	}
	
	public String getinvalidCredential() {
		String data=invalidCredentialsText.getText();
		System.out.println(invalidCredentialsText.getText());
		return data;
		
	}

	 //display "invalid credentials" message
	/* public Boolean displayInvalidCredentialsMessage() {
	 return invalidCredentialsText.isDisplayed();
	 }*/
	 
	 public String getInvalidEmailErrMsg() {
		 String data=errmsg_emailBlank.getText();
		 System.out.println("The INvalid Email error msg is: "+data);
		 return data;
	 }
	 
	 public Boolean displayInvalidEmailErrBool() {
		 return errmsg_emailBlank.isDisplayed();
	 }
	 
	 public String getInvalidPwdErrMsg() {
		 String data=errmsg_pwdBlank.getText();
		 System.out.println("Invalid password displayed is: "+data);
		 return data;
	 }
	 
	 public Boolean displayInvalidPwdErrBool() {
		 return errmsg_pwdBlank.isDisplayed();
	 }

	// click on sign up link
	public void clickOnSignUpLink() {
		signUpLink.click();
	}

	// click on candidate sign up link
	public void clickOnCandidateSignUpLink() {
		candidateSignUpLink.click();
	}
	
	public void signupLoginLink(){
		loginSignupPage.click();
	}

	// click on forgot password link
	public void clickOnForgotPasswordLink() {
		forgotPasswordLink.click();
	}

	// to display email text box in login page
	public Boolean isEmailTextBoxDisplayed() {
		return txtemail.isDisplayed();
	}

	// to display password text box in login page
	public Boolean isPasswordTextBoxDisplayed() {
		return txtpassword.isDisplayed();
	}

	// to display submit button in login page
	public Boolean isSubmitButtonDisplayed() {
	 return btnSubmit.isEnabled();
	 }

	public void closePopupBox() {
		// Alert alert=driver.switchTo().alert();
		// String alertmessage=driver.switchTo().alert().getText();
	//	Actions action = new Actions(driver);
	//	action.moveToElement(closepop).click().build().perform();
		closepop.click();
		// Actions action=new Actions(driver);
		// action.moveToElement(closePopup).click().build().perform();
		 WebDriverWait wait=new WebDriverWait(driver,20);
		 wait.until(ExpectedConditions.elementToBeClickable(skipPop)).click();;

	}

	public void loginParametrized(String email, String password) {
		// txtemail.clear();
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.visibilityOf(txtemail));
		txtemail.sendKeys(email);
		// WebDriverWait wait1=new WebDriverWait(driver,30);
		// wait1.until(ExpectedConditions.visibilityOf(txtpassword));
		// txtpassword.clear();
		txtpassword.sendKeys(password);
		WebDriverWait submitBtn = new WebDriverWait(driver, 20);
		submitBtn.until(ExpectedConditions.elementToBeClickable(btnSubmit));
		try {
			btnSubmit.click();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	/*
	 * catch (AWTException e) { System.out.println(“WebDriver couldn’t locate the
	 * element”); }
	 */

	public void loginParametrized2(String email, String password) {
		// txtemail.clear();
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.visibilityOf(txtemail));
		txtemail.sendKeys(email);
		// WebDriverWait wait1=new WebDriverWait(driver,30);
		// wait1.until(ExpectedConditions.visibilityOf(txtpassword));
		// txtpassword.clear();
		txtpassword.sendKeys(password);
		WebDriverWait submitBtn = new WebDriverWait(driver, 20);
		submitBtn.until(ExpectedConditions.visibilityOf(btnSubmit));

		btnSubmit.click();

		WebDriverWait wait5 = new WebDriverWait(driver, 30);
		wait5.until(ExpectedConditions.visibilityOf(skipPop));
		
		//Actions mouseover1 = new Actions(driver);
		//mouseover1.moveToElement(skipPop).click().build().perform();

		skipPop.click();

		WebDriverWait wait6 = new WebDriverWait(driver, 20);
		wait6.until(ExpectedConditions.visibilityOf(candidate));
		
		Actions mouseover = new Actions(driver);
		mouseover.moveToElement(candidate).click().build().perform();
		mouseover.moveToElement(candidateSearch).click().build().perform();

		// Actions action = new Actions(driver);
		// action.moveToElement(closepop).click().build().perform();

		/*
		 * try{ btnSubmit.click(); } catch (Exception e) { e.printStackTrace();
		 * 
		 * } }
		 * 
		 * /*catch (AWTException e) { System.out.println(“WebDriver couldn’t locate the
		 * element”); }
		 */
	}

}
