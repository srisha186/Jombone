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

public class JMB_DB_004 extends BaseClass {

	@Test
	public void validEmailandPwd() throws Exception {

		LandingPage lp = new LandingPage(driver);
		lp.loginLandingPage();

		LoginPage logPage = new LoginPage(driver);
		logPage.settxtemail(username1);
		logPage.settxtpassword(password);
		logPage.clkbtnSubmit();
		}

	@Test(dependsOnMethods = { "validEmailandPwd" })
	public void clickMe() throws IOException, InterruptedException {

		Homepage_Icon home = new Homepage_Icon(driver);
		home.closePopUpBtn();

		MeButton me = new MeButton(driver);
		me.clickMe();
		SoftAssert softAssert = new SoftAssert();
		if (me.clickMedrpdwn.isDisplayed()) {
			softAssert.assertTrue(true);
			logger.info("Assert passed by clicking Me Button: " + me.clickMedrpdwn.isDisplayed());
		} else {
			softAssert.assertTrue(false);
			logger.error("Assert Not passed");
			captureScreen(driver, "clickMe");
		}
		softAssert.assertAll();
		logger.info("Completed Me Dropdown click");

	}
}
