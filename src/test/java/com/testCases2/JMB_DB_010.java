package com.testCases2;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.LandingPage;
import com.pageObjects.LoginPage;
import com.pageObjects.Logout;
import com.utilities.MyScreenRecorder;

public class JMB_DB_010 extends BaseClass {
	public WebDriverWait wait;

	@Test(priority = 1)
	public void logoutTest() throws Exception {

		LandingPage lp = new LandingPage(driver);
		lp.loginLandingPage();

		LoginPage logPage = new LoginPage(driver);
		logPage.settxtemail(username1);
		logPage.settxtpassword(password);
		logPage.clkbtnSubmit();

		Logout lo = new Logout(driver);
		lo.logout();

		SoftAssert softAssert = new SoftAssert();
		if (lo.popLogoutHeader.isDisplayed() == true) {// validate logout header in pop up window
			softAssert.assertTrue(true);
			lo.logoutpopwindow();
			logger.info("Test Passed Successfully, Logout headeritle is Displayed ");// ref Logoutpageobj(used following
																						// xpath)
		} else {
			softAssert.assertTrue(false);
			logger.error("Test Failed! ");
			try {
				captureScreen(driver, "logoutTest");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		softAssert.assertAll();
		logger.info("Completed Test Successfully");
	}

}
