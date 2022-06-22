package com.testCases2;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.Homepage_Icon;
import com.pageObjects.LandingPage;
import com.pageObjects.LoginPage;
import com.pageObjects.Logout;
import com.utilities.MyScreenRecorder;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JMB_DB_001 extends BaseClass {

	@Test(priority = 1)
	public void headerElementsclickBackHome() throws Exception {

		LandingPage lp = new LandingPage(driver);
		lp.loginLandingPage();

		LoginPage logPage = new LoginPage(driver);
		logPage.settxtemail(username1);
		logPage.settxtpassword(password);
		logPage.clkbtnSubmit();

		Homepage_Icon home = new Homepage_Icon(driver);
		home.closePopUpBtn();
		// home.home_Icon();
		home.headertag();
		home.headerElementsclick();

		
		SoftAssert softAssert = new SoftAssert();
		if (driver.getTitle().equalsIgnoreCase("dashboard")) {
			softAssert.assertTrue(true);
			logger.info("Test Passed Successfully,Home Page is clicked successfully after traversing all the header elements");
		} else {
			softAssert.assertTrue(false);
			logger.error("Test Failed!");
			try {
				captureScreen(driver, "headerElementsclickBackHome");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		softAssert.assertAll();
		logger.info("Completed Test Successfully");

	}

}
