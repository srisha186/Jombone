package com.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.LandingPage;
import com.pageObjects.LoginPage;
import com.utilities.MyScreenRecorder;

public class JMB_CALogin_002 extends BaseClass {

	@Test(priority=2, description=" Email Blank and valid Password")
	public void emailBlank() throws Exception {
		//MyScreenRecorder.startRecording("emailBlank");

		LandingPage lp = new LandingPage(driver);
		lp.loginLandingPage();

		LoginPage logPage = new LoginPage(driver);
		logPage.settxtpassword(password);
		logPage.clkbtnSubmit();

		SoftAssert softAssert = new SoftAssert();
		if (logPage.errmsg_emailBlank.isDisplayed()) {

			// if(driver.getPageSource().equalsIgnoreCase("Please enter valid email.")) {
			softAssert.assertTrue(true);
			logger.info("Test Passed Successfully, Error message is displayed: "+logPage.getInvalidEmailErrMsg());
		} else {
			softAssert.assertTrue(false);
			logger.error("Test Failed! Login failed!");
			try {
				captureScreen(driver, "emailBlank");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		softAssert.assertAll();
		logger.info("Completed Logintest");
	//	MyScreenRecorder.stopRecording();

	}

}
