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

public class JMB_DB_002 extends BaseClass {
	SoftAssert softAssert;

	@Test(priority = 2)
	public void searchBox() throws Exception {

		LandingPage lp = new LandingPage(driver);
		lp.loginLandingPage();

		LoginPage logPage = new LoginPage(driver);
		logPage.settxtemail(username1);
		logPage.settxtpassword(password);
		logPage.clkbtnSubmit();

		
		Homepage_Icon home = new Homepage_Icon(driver);
		home.closePopUpBtn();

		SearchBox search = new SearchBox(driver);
		search.searchBox();

		softAssert = new SoftAssert();
		if (driver.getTitle().equalsIgnoreCase("Company Profile")) {
			// In the page class(SearchBox) I had parsed the list of items displayed when
			// givivng value"Software testing"
			// Used iterator method to traverse till end of list to identified the
			// respective element and
			// clicked the selection and printed the page title.
			softAssert.assertTrue(true, "software Testing");
			logger.info("Successfully the Software testing is selected from the list of multiple search items is: "
					+ driver.getTitle());
		}

		else {
			softAssert.assertTrue(false);
			logger.error("Test Failed! ");
			try {
				captureScreen(driver, "searchBox");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		logger.info("Completed Test Successfully");

		softAssert.assertAll();

	}

}
