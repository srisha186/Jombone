package com.pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;

public class Preferences extends BasePage {
	public Actions action;
	public JavascriptExecutor js;

	public Preferences(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "navbardrop")
	public WebElement clickMedrpdwn;

	@FindBy(linkText = "Preferences")
	public WebElement clickPreferences;

	@FindBy(id = "autocomplete")
	public WebElement prefLocationTxtbox;

	@FindBy(linkText = "Current Week")
	public WebElement currentweekLink;

	@FindBy(xpath = "//div[@class='availablityTable']")
	public WebElement tableAvail;

	@FindBy(xpath = "//div[@class='jb-pre-table-data']/div")
	public List<WebElement> totalTablerows;

	@FindBy(xpath = "//a[@class='arrow rightarrow reload-availability']")
	public List<WebElement> workDayTableRightarrow;

	@FindBy(xpath = "//div[@class='jb-pre-table-data']/div/div")
	public List<WebElement> togglebtnTable;
	// label[@class='btn btn-success btn-xs toggle-on']
	// div[@class='jb-pre-table-body-col-data']
	// //input[@class='availability-toggle']

	@FindBy(xpath = "(//div[@class='payRateSection'])[1]/ul/li")
	public List<WebElement> prefHourlyRate;
	
	@FindBy(xpath = "//label[contains(text(),'Preferred Hourly Pay Rate')]")
	public WebElement prefHourlyRateLabel;

	@FindBy(xpath = "(//div[@class='payRateSection'])[2]/ul/li")
	public List<WebElement> commute;
	
	@FindBy(xpath = "//label[contains(text(),'Commute')]")
	public WebElement commuteLabel;

	@FindBy(xpath = "(//div[@class='payRateSection'])[3]/ul/li")
	public List<WebElement> jobType;

	@FindBy(xpath = "//label[contains(text(),'Preferred Job Type')]")
	public WebElement jobTypeLabel;

	// ==================Action methods===========================//
//Mouseover clickme button on header
	public void clickMe() throws InterruptedException {

		action = new Actions(driver);
		action.moveToElement(clickMedrpdwn).click().build().perform();
		action.moveToElement(clickPreferences).click().build().perform();

	}

	//validate prefered location text box displays when given data
	public void pref_Location() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(prefLocationTxtbox));
		prefLocationTxtbox.sendKeys("Mississauga", Keys.ENTER);
	}
//click on currentweek link in preference page
	public void currentweek() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(currentweekLink));
		action = new Actions(driver);
		action.moveToElement(currentweekLink).click().build().perform();
	}
	
//get total table rows size and size of all 40 toggle buttons in table & validate each toggle button in the table is enabled.
	@SuppressWarnings("unlikely-arg-type")
	public void validateTableRows() throws InterruptedException  { 
		
		js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,200);");

		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfAllElements(totalTablerows));
		

		//js.executeScript("window.scrollBy(0,200);");

		System.out.println("Totals Rows in the Table "+totalTablerows.size());
		//js.executeScript("totalTablerows.window.scrollBy(0,200);");
		System.out.println("Total elements in the table is : "+togglebtnTable.size());


		for(int i=0;i<togglebtnTable.size();i++) {
			String tablevalue=togglebtnTable.get(i).getText();
			//Thread.sleep(3000);
			//int cellCount=sheet.getRow(0).getLastCellNum();
			//int cellCount=totalTablerows.get(i-1);

			//for(int j=0;j<totalTablerows.get(i);j++) {
				
			
			if(totalTablerows!=null) {
			//if(togglebtnTable!=null) 

				//js.executeScript("arguments[0].scrollIntoView(true)", togglebtnTable);
				js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
		      //  js.executeScript("arguments[0].click();", togglebtnTable);

				togglebtnTable.get(i).click();
				//Thread.sleep(1000);

				System.out.println("Is Toggle button Enabled: "+togglebtnTable.get(i).isEnabled());

				
			}

			else {
				System.out.println("error");
			}


		}

	}

//validate PreferedHourlyRate checkbox is enabled after click action
	public void PreferedHourlyRate() throws InterruptedException {
		System.out.println("Size of HourlyRate CheckBox is: " + prefHourlyRate.size());
		for (int i = 0; i < prefHourlyRate.size(); i++) {

			String value = prefHourlyRate.get(i).getText();
			if (value != null) {
				js = (JavascriptExecutor) driver;
				// js.executeScript("searchListitems.window.scrollBy(0,200);");
				js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");

				prefHourlyRate.get(i).click();

				// Thread.sleep(3000);

				System.out.println("The Values are: "+prefHourlyRate.get(i).getText());

			} else {
				System.out.println("error");
			}
			System.out.println("Is CheckBox Enabled?: "+prefHourlyRate.get(i).isEnabled());

		}

	}
	
	//validate commuteJob checkbox is enabled after click action
	public void commuteJob() {
		System.out.println("Size of Commute to Job CheckBox is: " + commute.size());
		for (int i = 0; i < commute.size(); i++) {

			String value = commute.get(i).getText();
			if (value != null) {
				js = (JavascriptExecutor) driver;
				// js.executeScript("searchListitems.window.scrollBy(0,200);");
				js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");

				commute.get(i).click();

				// Thread.sleep(3000);

				System.out.println("The Values are: "+commute.get(i).getText());

			} else {
				System.out.println("error");
			}
			System.out.println("Is CheckBox Enabled?: "+commute.get(i).isEnabled());

		}

	}
	
	//validate prefjobType checkbox is enabled after click action
	public void prefjobType() {
		System.out.println("Size of prefJobType checkBox: " + jobType.size());
		for (int i = 0; i < jobType.size(); i++) {

			String value = jobType.get(i).getText();
			if (value != null) {
				js = (JavascriptExecutor) driver;
				// js.executeScript("searchListitems.window.scrollBy(0,200);");
				js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");

				jobType.get(i).click();

				// Thread.sleep(3000);

				System.out.println("The Values are: "+jobType.get(i).getText());

			} else {
				System.out.println("error");
			}
			System.out.println("Is CheckBox Enabled?: "+jobType.get(i).isEnabled());

		}

	}

}
