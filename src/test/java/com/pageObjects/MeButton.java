package com.pageObjects;

import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;

public class MeButton extends BasePage {
	public Actions action;

	public MeButton(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "navbardrop")
	public WebElement clickMedrpdwn;

	@FindBy(xpath = "(//div[@class='dropdown-menu'])[2]/a")
	public List<WebElement> totalDropdownList;

	@FindBy(linkText = "Log Out")
	public WebElement logoutbtn;

	@FindBy(linkText = "Yes")
	public WebElement popLogoutYes;

	@FindBy(linkText = "My Profile")
	public WebElement myProfileclick;

	@FindBy(linkText = "Settings")
	public WebElement settingsdropdwn;

	@FindBy(id = "currentPassword")
	public WebElement currentPassword_Txt;

	@FindBy(id = "newPassword")
	public WebElement newPassword_Txt;

	@FindBy(id = "confirmPassword")
	public WebElement confirmPassword_Txt;

	@FindBy(css = "input[value='Save Changes']")
	public WebElement saveBtn;

	@FindBy(xpath = "//label[@class='custom-control ios-switch']//child::span")
	public WebElement toggleBtn;
	@FindBy(xpath = "//div[text()='Now, you will not receive  notification']")
	public WebElement toggleBtnOff_msg;
	
	@FindBy(xpath = "//div[text()='You will receive  notification']")
	public WebElement toggleBtnOn_msg;
	
	@FindBy(xpath = "//div[text()='Password has been changed successfully.']")
	public WebElement pswdChange_msg;

	// ==================Action methods===========================//

	// Mouse Click Me button on header.Open all the links and display the title when child window is opened
	public void clickMe() throws InterruptedException {
		action = new Actions(driver);
		action.moveToElement(clickMedrpdwn).build().perform();
		System.out.println("List of total items in Me Dropdown Button is:" + totalDropdownList.size());
		// list all links in child window and navigate back to main window.
		for (int i = 0; i < totalDropdownList.size(); i++) {
			String value = totalDropdownList.get(i).getText();
			String presskey = Keys.chord(Keys.CONTROL, Keys.ENTER, Keys.TAB);
			totalDropdownList.get(i).sendKeys(presskey);
		}

		String mainwindowhandle = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		java.util.Iterator<String> iter = child.iterator();

		while (iter.hasNext()) {
			// Thread.sleep(3000);

			driver.switchTo().window(iter.next());
			System.out.println("The title displayed are: " + driver.getTitle());

			// Thread.sleep(3000);

			// driver.switchTo().window(presskey);

		}
		driver.switchTo().window(mainwindowhandle);

	}
	// action.moveToElement(logoutbtn).build().perform();
	// action.moveToElement(popLogoutYes).click().build().perform();

//click on Me button move the key to My Profile Tab on clicking it should open My Profile Page.
	public void myProfile() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.elementToBeClickable(clickMedrpdwn));

		Actions action = new Actions(driver);

		action.moveToElement(clickMedrpdwn).click().build().perform();
		action.moveToElement(myProfileclick).click().build().perform();

		// action.moveToElement(clickMedrpdwn).moveToElement(myProfileclick).click().build().perform();
		// action.moveToElement(myProfileclick).click().build().perform();
	}
	//When toggle button in clicked capture the String message
	public String getToggleOn() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(toggleBtnOn_msg));

		String dataOn=toggleBtnOn_msg.getText();
		System.out.println("The message displayed when the toggle button clicked is On: "+dataOn);

		return dataOn;


	}
	//When toggle button in clicked off capture the String message
	public String getToggleOff() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(toggleBtnOff_msg));
		
		String dataoff=toggleBtnOff_msg.getText();
		System.out.println("The message displayed when the toggle button clicked is Off: "+dataoff);
		// driver.navigate().refresh();

		return dataoff;
	}
    //Validate toggle Notification message is displayed for both toglle enable and disable message is captured
	public void toggleNotification() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.elementToBeClickable(clickMedrpdwn));

		Actions action = new Actions(driver);

		action.moveToElement(clickMedrpdwn).click().build().perform();
		action.moveToElement(settingsdropdwn).click().build().perform();
		Thread.sleep(3000);
			
		if (toggleBtn.isEnabled()) {
			System.out.println("Toggle is enabled: " + toggleBtn.isEnabled());
			if (toggleBtn.isEnabled()) {
				action.moveToElement(toggleBtn).click().build().perform();

				// toggleBtn.click();
				System.out.println("Toggle Button is clicked");
				System.out.println("Toggle button should be disabled after click action: " + toggleBtn.isEnabled());
				Thread.sleep(3000);
				do {
					action.moveToElement(toggleBtn).click().build().perform();
					System.out.println("Click Toggle Button again to make it enable: " + toggleBtn.isEnabled());

					// toggleBtn.click();
				} while (toggleBtn.isSelected());

			} else {
				System.out.println("Toggle is disabled: " + toggleBtn.isSelected());
			}
		} else {
			System.out.println("Toggle is disabled finally: " + toggleBtn.isSelected());

		}

	}
	
	//Validate change password using dataprovider method. Given two values and captured the changepassword message in output. 
	public void changepassword(String currentpwd, String newpwd, String changepwd) throws InterruptedException {
		
		//driver.navigate().to("http://52.60.159.184/candidate/settings");
		Thread.sleep(3000);

		currentPassword_Txt.sendKeys(currentpwd);
		Thread.sleep(3000);
		newPassword_Txt.sendKeys(newpwd);
		Thread.sleep(3000);

		confirmPassword_Txt.sendKeys(changepwd);
		//Thread.sleep(3000);
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		driver.switchTo().activeElement();

		saveBtn.click();
		Thread.sleep(3000);
		driver.navigate().refresh();

		System.out.println("successfully changed");


	}

}
