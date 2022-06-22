package com.pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;

public class Homepage_Icon extends BasePage {
	
	public WebDriverWait wait;

	public Homepage_Icon(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
@FindBy(xpath="//body/nav[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")//span[@class='icon-home navbar-svg-size']
public  WebElement homeIcon_button;

@FindBy(xpath="//div[@class='navbar-collapse justify-content-end']")
public WebElement header_Driver;

@FindBy(tagName="a")
public WebElement tag;

@FindBy(xpath="//div[@class='navbar-collapse justify-content-end']/ul[1]/li")//body/nav[1]/div[1]/div[1]/ul[1]
public List<WebElement> totalheader_buttons;

@FindBy(xpath="//body/section[1]/div[3]/div[1]/div[1]/div[1]/span[1]")//div[@class='modal-body d-flex']/span
public WebElement popupclose;

// ==================Action methods===========================//


public void home_Icon() {
	homeIcon_button.click();
	System.out.println("Home Icon is clicked");
}

public void closePopUpBtn() {
	 wait=new WebDriverWait(driver,25);
	wait.until(ExpectedConditions.elementToBeClickable(popupclose));
	popupclose.click();
}

public void headertag() {
	System.out.println(header_Driver.findElements(By.tagName("li")).size());
}

public void headerElementsclick() throws InterruptedException {
	
    wait=new WebDriverWait(driver,25);
	wait.until(ExpectedConditions.visibilityOfAllElements(totalheader_buttons));
	//Thread.sleep(3000);
	System.out.println("Total Header elements: "+totalheader_buttons.size());
	
	for(int i=1;i<totalheader_buttons.size();i++) {
		
		String value=totalheader_buttons.get(i).getText();

		//String value=header_Driver.findElements(By.tagName("li")).get(i).getText();
		
		
		
		Actions action=new Actions(driver);
		Thread.sleep(3000);

		action.moveToElement(totalheader_buttons.get(i)).click().build().perform();
		System.out.println("The header link is navigated to :" +driver.getTitle());

		driver.navigate().back();
		System.out.println("The Homepage link is navigated back :" +driver.getTitle());

		

	}
		
		
		/*do {
			action.moveToElement(homeIcon_button).click().build().perform();
		}
		while(i<totalheader_buttons.size());
		System.out.println("The Title of window is: " +driver.getTitle());
		Thread.sleep(3000);
	
			
			
			
			
		
	}
	
		
		
		//Action seriesofaction=action.contextClick("valu
	   // String presskey=Keys.chord(Keys.CONTROL,Keys.ENTER);
	//	wait.until(ExpectedConditions.visibilityOfAllElements("presskey"));

	  //  totalheader_buttons.get(i).sendKeys(presskey);
	   // header_Driver.findElements(By.tagName("li")).get(i).sendKeys(presskey);
	    
	   // System.out.println("Total value: "+value);
	
	/*String mainwindow=driver.getWindowHandle();

	Set<String> childWindow=driver.getWindowHandles();
	Thread.sleep(3000);

	Iterator<String> iterator=childWindow.iterator();
	while(iterator.hasNext()) {
		
		Thread.sleep(3000);

	//wait.until(ExpectedConditions.titleContains(iterator.next()));
		driver.switchTo().window(iterator.next());
		//wait.until(ExpectedConditions.titleContains(iterator.next()));

		System.out.println("The Title of window is: " +driver.getTitle());
		
		/*if(iterator.next().contains("homeIcon_button")) {
			homeIcon_button.click();
			
		}
		else {
			System.out.println("Throw no Element is present");
		}*/
	

	/*}	Thread.sleep(3000);

    driver.switchTo().window(mainwindow);*/
	
}


}


