package com.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.LandingPage;
import com.pageObjects.LoginPage;
import com.utilities.MyScreenRecorder;

public class JMB_COLogin_009 extends BaseClass {

	// @Test(dataProvider = "companyLogin", dataProviderClass = XLUtils_Admin.class)
	@Parameters({ "uname", "pword" })
	@Test(priority = 9, description = "Verify Admin Login page Availability")
	public void adminLoginAvailability(String uname, String pword) throws Exception {
		MyScreenRecorder.startRecording("adminLoginAvailability");

		LandingPage lp = new LandingPage(driver);
		lp.loginLandingPage();

		LoginPage loginpg = new LoginPage(driver);
		loginpg.settxtemail(uname); // Pass uname is given as parameter in testNG
		logger.info("Check Email TextBox is Displayed : " + loginpg.isEmailTextBoxDisplayed());

		loginpg.settxtpassword(pword); // Pass pword is given as parameter in testNG
		logger.info("Check Password textfiled is Displayed : " + loginpg.isPasswordTextBoxDisplayed());

		SoftAssert softassert = new SoftAssert();
		if (loginpg.isSubmitButtonDisplayed() == true) {
			softassert.assertTrue(true);
			logger.info("Submit button is selected : " + loginpg.isSubmitButtonDisplayed());

			loginpg.clkbtnSubmit();
			// Click on submit button
			loginpg.closePopupBox();
		} else {
			softassert.assertTrue(false);
			logger.error("Test Failed");
			try {
				captureScreen(driver, "adminLoginAvailability");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		softassert.assertAll();
		logger.info("Test Completed");

		MyScreenRecorder.stopRecording();
		
	}

}
