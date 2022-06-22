package com.testCases2;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.Homepage_Icon;
import com.pageObjects.LandingPage;
import com.pageObjects.LoginPage;
import com.pageObjects.Logout;
import com.pageObjects.SearchBox;
import com.utilities.MyScreenRecorder;

public class JMB_DB_003 extends BaseClass {
	public SoftAssert softAssert;

	@Test(priority = 3)
	public void invaliSearchData() throws Exception {

		LandingPage lp = new LandingPage(driver);
		lp.loginLandingPage();

		LoginPage logPage = new LoginPage(driver);
		logPage.settxtemail(username1);
		logPage.settxtpassword(password);
		logPage.clkbtnSubmit();

		// logger.info("Completed Logintest");
		Homepage_Icon home = new Homepage_Icon(driver);
		home.closePopUpBtn();

		SearchBox search = new SearchBox(driver);
		search.invalidStringSearch();
		// String expmsg="Invalid Data";
		boolean expmsg = search.errormessageNotDisplayed();

		SoftAssert softAssert = new SoftAssert();
		if (expmsg == true) {
			softAssert.assertTrue(true);
			logger.info("Error Message is empty");
		} else {
			softAssert.assertTrue(false);
			logger.error("Test Failed!");
			captureScreen(driver, "invalidsearchbox");

		}

		softAssert.assertAll();
		logger.info("Completed Test Successfully");

	}

}
