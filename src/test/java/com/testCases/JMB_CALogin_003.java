package com.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.LandingPage;
import com.pageObjects.LoginPage;
import com.utilities.MyScreenRecorder;

public class JMB_CALogin_003 extends BaseClass {

	@Test(priority=3, description="Valid Email and Password Blank")
	public void pwdBlank() throws Exception {
		MyScreenRecorder.startRecording("pwdBlank");

		LandingPage lp = new LandingPage(driver);
		lp.loginLandingPage();

		LoginPage logPage = new LoginPage(driver);
		logPage.settxtemail(baseURL);
		logPage.clkbtnSubmit();

		SoftAssert softAssert = new SoftAssert();
		if (logPage.errmsg_pwdBlank.isDisplayed()) {

			// if(driver.getPageSource().equalsIgnoreCase("Please enter valid email.")) {
			softAssert.assertTrue(true);
			logger.info("Test Passed Successfully, Error message Displayed is: "+logPage.getInvalidPwdErrMsg());
		} else {
			softAssert.assertTrue(false);
			logger.error("Test Failed! Login failed!");
			try {
				captureScreen(driver, "pwdBlank");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		softAssert.assertAll();
		logger.info("Completed Logintest");
		MyScreenRecorder.stopRecording();

	}

}
