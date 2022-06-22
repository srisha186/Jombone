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
import com.utilities.XLUtils;
import com.utilities.XLUtils_Admin;

import roughworks.XLUtils2;

public class JMB_COLogin_010 extends BaseClass {

	// @Test(dataProvider = "companyLogin", dataProviderClass = XLUtils_Admin.class)
@Parameters({"uname","pword"})
	@Test(priority=10, description="Verify valid admin user and Valid password landed on Admin Dashboard")

	public void adminValidUserandPwd(String uname,String pword) throws Exception {
	MyScreenRecorder.startRecording("adminValidUserandPwd");

		LandingPage lp = new LandingPage(driver);
		lp.loginLandingPage();

		LoginPage loginpg = new LoginPage(driver);
		loginpg.settxtemail(uname); // Pass uname is given as parameter in testNG
		logger.info("Check Email TextBox is Displayed : " + loginpg.isEmailTextBoxDisplayed());

		loginpg.settxtpassword(pword); // Pass pword is given as parameter in testNG
		logger.info("Check Password textfiled is Displayed : " + loginpg.isPasswordTextBoxDisplayed());

		loginpg.clkbtnSubmit();
		loginpg.closePopupBox();//after successfull login to Admin Dashboard close the pop up box

		SoftAssert softassert = new SoftAssert();
		if (driver.getTitle().equalsIgnoreCase("Dashboard")) {
			softassert.assertTrue(true);
			logger.info("Admin page title displayed is: " + driver.getTitle());

			// Click on submit button
		} else {
			softassert.assertTrue(false);
			logger.error("Test Failed");
			try {
				captureScreen(driver, "adminValidUserandPwd");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		softassert.assertAll();
		logger.info("Test Completed");

		// SoftAssert softAssert = new SoftAssert();
		// System.out.println("softAssert Method Was Started");

		//loginpg.clkbtnSubmit(); // Click on submit button
		MyScreenRecorder.stopRecording();
	}

}
