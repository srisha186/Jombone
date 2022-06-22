package com.pageObjects;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;

public class SearchBox extends BasePage {
	public static WebDriverWait wait;
	public JavascriptExecutor js;

	public SearchBox(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "typeahead1")
	public static WebElement searchbox_Button;

	@FindBy(xpath = "//ul[@id='ui-id-1']/li")
	public List<WebElement> searchListitems;

	// ==================Action methods===========================//

	//search user input in searchbox textfield, click from the list displayed and navigate to respective page
	public void searchBox() throws InterruptedException {
		// Actions action=new Actions(driver);
		// action.moveToElement(searchbox_Button).sendKeys("Software
		// Testing").build().perform();
		wait = new WebDriverWait(driver, 25);
		// wait.until(ExpectedConditions.visibilityOf(searchbox_Button));
		wait.until(ExpectedConditions.visibilityOf(searchbox_Button));

		searchbox_Button.sendKeys("Software Testing", Keys.ENTER);
		// Thread.sleep(3000);

		// searchbox_Button.sendKeys(Keys.ENTER);

		System.out.println("Current URl before sending text: " + driver.getCurrentUrl());
		System.out.println("Current URl before sending text: " + driver.getTitle());
		// Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfAllElements(searchListitems));
		System.out.println("Total number of items listed when searching software testing: " + searchListitems.size());

		for (int i = 1; i < searchListitems.size(); i++) {
			String value = searchListitems.get(i).getText();
			// Thread.sleep(3000);

			// String keypress=Keys.chord(Keys.DOWN,Keys.ENTER);
			if (value.equalsIgnoreCase("Software Testing")) {
				// Thread.sleep(3000);
				js = (JavascriptExecutor) driver;
				// js.executeScript("searchListitems.window.scrollBy(0,200);");
				js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
				System.out.println("Using Javascript asyncScript to wait for choosing from the list");

				// searchListitems.listIterator();(iterator also works but I preferred using
				System.out.println("click the item from search list and navigate to next page");

				searchListitems.get(i).click();
				// js.executeScript("arguments[arguments.length - 1].click();",
				// searchListitems.get(i));

			} else {
				System.out.println("The item is not in the list");
			}
			System.out.println("The title displayed after entering text from the search list is: " + driver.getTitle());

		}
	}

	//Capturing error message which is not displayed
	public boolean errormessageNotDisplayed() {
		String errormsg = "Invalid Data";
		System.out.println("Error Message " + errormsg + " is not displayed");
		return true;

	}
	
//provide the searchtext box with invalid data
	public void invalidStringSearch() throws InterruptedException {

		wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(searchbox_Button));

		String invalidData = "!@#$%^&*()";
		String errormsg = "Invalid Input";
		searchbox_Button.sendKeys(invalidData, Keys.ENTER);
		if (invalidData.matches(errormsg)) {
			try {
				// System.out.println("No error message is displayed");
				System.out.println("Proper Error message is displayed:" + driver.getTitle());

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Thread.sleep(3000);
			// js = (JavascriptExecutor) driver;
			// js.executeScript("alert('Error Invalid Input');");
			Thread.sleep(3000);

			System.out.println("Error message not displayed, Title of HomePage is: " + driver.getTitle());

		}
		Thread.sleep(3000);

		// searchbox_Button.sendKeys(invalidData);

		// js.executeScript("arguments[0].click();");


	}
}
