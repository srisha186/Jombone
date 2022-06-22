package com.pageObjects;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;

public class Me_SettingPage extends BasePage {
	public Actions action;
	public WebDriverWait wait;

	public Me_SettingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "navbardrop")
	public WebElement clickMedrpdwn;

	@FindBy(xpath = "(//div[@class='dropdown-menu'])[2]/a")
	public List<WebElement> totalDropdownList;

	@FindBy(linkText = "Settings")
	public WebElement settingsdropdwn;
	
	@FindBy(xpath="//h4[contains(text(),'Settings')]")
	public WebElement headerSettingtext;

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

	@FindBy(xpath = "//div[contains(text(),'Now, you will not receive notification')]")
	public WebElement toggleBtnOff_msg;

	@FindBy(xpath = "//div[contains(text(),'You will receive notification')]")
	public WebElement toggleBtnOn_msg;

	@FindBy(xpath = "//div[contains(text(),'Password has been changed successfully.')]")
	public WebElement pswdChange_msg;
	
	// ==================Action methods===========================//

	// Mouse Click Me button on header.
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
	
	//validate Toggle button
	public void toggleNotification() throws InterruptedException {
		wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.elementToBeClickable(clickMedrpdwn));

		action = new Actions(driver);

		action.moveToElement(clickMedrpdwn).click().build().perform();
		action.moveToElement(settingsdropdwn).click().build().perform();
		Thread.sleep(3000);
		action.moveToElement(toggleBtn).click().build().perform();

	}
	//click toggle
	public void togglebtnclick() {
		wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.elementToBeClickable(toggleBtn));
		action = new Actions(driver);
		action.moveToElement(toggleBtn).click().build().perform();

	}
	//get ToggleOn message
	public String getToggleOn() throws TimeoutException {
		String dataOn = toggleBtnOn_msg.getText();
		System.out.println("The message displayed when the toggle button clicked is On: " + dataOn);
		return dataOn;

	}
	//get ToggleOff message
	public String getToggleOff() throws TimeoutException {
		// WebDriverWait wait = new WebDriverWait(driver, 25);
		// wait.until(ExpectedConditions.visibilityOf(toggleBtnOff_msg));

		String dataoff = toggleBtnOff_msg.getText();
		System.out.println("The message displayed when the toggle button clicked is Off: " + dataoff);
		// driver.navigate().refresh();

		return dataoff;
	}
	//Validate change password by giving multiple values using DataDriven
	public void changepassword(String currentpwd, String newpwd, String changepwd) throws InterruptedException {
		//wait = new WebDriverWait(driver, 25);
		//wait.until(ExpectedConditions.elementToBeClickable(clickMedrpdwn));

		action = new Actions(driver);

		//action.moveToElement(clickMedrpdwn).click().build().perform();
		//action.moveToElement(settingsdropdwn).click().build().perform();
		
		wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(currentPassword_Txt));
		currentPassword_Txt.sendKeys(currentpwd);
		
		wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(newPassword_Txt));
		newPassword_Txt.sendKeys(newpwd);

		wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(confirmPassword_Txt));
		confirmPassword_Txt.sendKeys(changepwd);
		// Thread.sleep(3000);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		driver.switchTo().activeElement();

		saveBtn.click();
		//Thread.sleep(3000);
		WebDriverWait wait=new WebDriverWait(driver,25);
		wait.until(ExpectedConditions.visibilityOf(pswdChange_msg));
		System.out.println("change Password message is displayed ");

		//System.out.println("change Password message displayed is: " + pswdChange_msg.getText());

		//Thread.sleep(3000);
		//driver.navigate().refresh();
		//Thread.sleep(3000);

		//driver.navigate().to("http://52.60.159.184/candidate/settings");

		System.out.println("successfully changed");
		//driver.getCurrentUrl();


	}

}
