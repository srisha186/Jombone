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
import com.pageObjects.MeButton;
import com.utilities.MyScreenRecorder;

public class JMB_DB_005 extends BaseClass {

	@Test(priority = 1)
	public void validEmailandPwd() throws Exception {

		LandingPage lp = new LandingPage(driver);
		lp.loginLandingPage();

		LoginPage logPage = new LoginPage(driver);
		logPage.settxtemail(username1);
		logPage.settxtpassword(password);
		logPage.clkbtnSubmit();
	}

	@Test(priority = 2)
	public void candidateprofilePage() {
		Homepage_Icon home = new Homepage_Icon(driver);
		home.closePopUpBtn();

		MeButton me = new MeButton(driver);
		me.myProfile();
		
		SoftAssert softAssert = new SoftAssert();
		if (driver.getTitle().equalsIgnoreCase("Candidate Profile")) {
			softAssert.assertTrue(true);
			logger.info("Test Passed Successfully, Candidate Profile page is opened upon click action: "+driver.getTitle());
		} else {
			softAssert.assertTrue(false);
			logger.error("Test Failed! ");
			try {
				captureScreen(driver, "candidateprofilePage");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		softAssert.assertAll();
		logger.info("Completed Test Successfully");
		

	}

}
