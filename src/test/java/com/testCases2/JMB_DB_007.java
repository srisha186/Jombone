package com.testCases2;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.Homepage_Icon;
import com.pageObjects.LandingPage;
import com.pageObjects.LoginPage;
import com.pageObjects.Logout;
import com.pageObjects.MeButton;
import com.pageObjects.Me_SettingPage;
import com.pageObjects.Preferences;
import com.utilities.MyScreenRecorder;
import com.utilities.XLUtils;

public class JMB_DB_007 extends BaseClass {
	public Me_SettingPage st;
	public SoftAssert softAssert;

	@Test
	public void validEmailandPwd() throws Exception {

		LandingPage lp = new LandingPage(driver);
		lp.loginLandingPage();

		LoginPage logPage = new LoginPage(driver);
		logPage.settxtemail(username1);
		logPage.settxtpassword(password);
		logPage.clkbtnSubmit();

	}

	@SuppressWarnings("unlikely-arg-type")
	@Test(dependsOnMethods = { "validEmailandPwd" })
	public void preference() throws InterruptedException {
		Homepage_Icon home = new Homepage_Icon(driver);
		home.closePopUpBtn();

		Preferences pre = new Preferences(driver);
		pre.clickMe();// click on Me Button,click on Preference.

		softAssert = new SoftAssert();
		if (driver.getTitle().equalsIgnoreCase("Preferences")) {
			softAssert.assertTrue(true);
			pre.pref_Location(); // Click on Location Preference TextBox
			logger.info("Preferred Location TextBox is Displayed : " + pre.prefLocationTxtbox.isDisplayed());
			logger.info("Test Passed Successfully ");

			if (pre.currentweekLink.isDisplayed()) {
				pre.currentweek();
				logger.info("Current Week Link is clicked: " + pre.currentweekLink.isDisplayed());
				Thread.sleep(1000);
				pre.validateTableRows();
				logger.info("Test Passed Successfully ");
				if (pre.prefHourlyRateLabel.isDisplayed()) {
					pre.PreferedHourlyRate();
					logger.info("Preferred hourly Rate header is Displayed : " + pre.prefHourlyRateLabel.getText());

					if (pre.commuteLabel.isDisplayed()) {
						pre.commuteJob();
						logger.info("Preferred hourly Rate header is Displayed : " + pre.commuteLabel.getText());
						if (pre.jobTypeLabel.isDisplayed()) {
							pre.prefjobType();
							logger.info("Preferred hourly Rate header is Displayed : " + pre.jobTypeLabel.getText());
						}

						else {
							softAssert.assertTrue(false);
							logger.error("Test Failed! ");
							try {
								captureScreen(driver, "preference");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							softAssert.assertAll();
							logger.info("Completed Test Successfully");
						}
					} else {
						softAssert.assertTrue(false);
						logger.error("Test Failed! ");
					}
				} else {
					softAssert.assertTrue(false);
					logger.error("Test Failed! ");
				}
			} else {
				softAssert.assertTrue(false);
				logger.error("Test Failed! ");
			}
		} else {
			softAssert.assertTrue(false);
			logger.error("Test Failed! ");
		}

	}
}
