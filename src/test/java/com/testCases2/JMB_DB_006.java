package com.testCases2;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.apache.http.conn.ConnectTimeoutException;
import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.Homepage_Icon;
import com.pageObjects.LandingPage;
import com.pageObjects.LoginPage;
import com.pageObjects.Logout;
import com.pageObjects.MeButton;
import com.pageObjects.Me_SettingPage;
import com.pageObjects.SearchBox;
import com.utilities.MyScreenRecorder;
import com.utilities.XLUtils;

public class JMB_DB_006 extends BaseClass {
	public Me_SettingPage st;
	public SoftAssert softAssert;
	public WebDriverWait wait;

	@Test(priority = 1)

	public void settingPage_Toggle() throws Exception {

		LandingPage lp = new LandingPage(driver);
		lp.loginLandingPage();

		LoginPage logPage = new LoginPage(driver);
		logPage.settxtemail(username1);
		logPage.settxtpassword(password);
		logPage.clkbtnSubmit();

		Homepage_Icon home = new Homepage_Icon(driver);
		home.closePopUpBtn();
		st = new Me_SettingPage(driver);
		st.toggleNotification();

		softAssert = new SoftAssert();
		if (st.toggleBtn.isEnabled() == true) {
			softAssert.assertTrue(true);

			// st.togglebtnclick();
			Thread.sleep(3000);
			logger.info("Test Passed Successfully, message Displayed is: " + st.getToggleOn());
			driver.navigate().refresh();
			Thread.sleep(3000);

			if (st.toggleBtn.isEnabled() == true) {
				softAssert.assertTrue(true);

				st.togglebtnclick();
				Thread.sleep(3000);
				logger.info("Test Passed Successfully, message Displayed is: " + st.getToggleOff());
				driver.navigate().refresh();

			} else {
				softAssert.assertTrue(false);
				captureScreen(driver, "settingPage_Toggle");
				logger.info("Test Passed Successfully,  message not  Displayed : ");

			}
		} else {
			softAssert.assertTrue(false);
			captureScreen(driver, "settingPage_Toggle");
			logger.info("Test Passed Successfully,  message not  Displayed : ");

		}

		softAssert.assertAll();
		logger.info("Completed Logintest");
	}

	
	@Test(priority = 2, dependsOnMethods = {"settingPage_Toggle" }, dataProvider = "ChangePwdData", dataProviderClass = XLUtils.class)

	public void settingPage_Changepassword(String currentpwd, String newpwd, String changepwd)
			throws InterruptedException {

		// Homepage_Icon home = new Homepage_Icon(driver);
		// home.closePopUpBtn();

		st = new Me_SettingPage(driver);
		st.changepassword(currentpwd, newpwd, changepwd);

		softAssert = new SoftAssert();
		if (st.headerSettingtext.isDisplayed()) {
			softAssert.assertTrue(true);
			// Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 25);
			wait.until(ExpectedConditions.visibilityOf(st.pswdChange_msg));
			logger.info("change Password message displayed is for each data: " + st.pswdChange_msg.getText());
			// logger.info("change Password message is successfully displayed aftersubmitting the value. " );
			driver.navigate().refresh();
			driver.getCurrentUrl();

		} else {
			softAssert.assertTrue(false);
			logger.error("Test Failed! ");
			try {
				captureScreen(driver, "settingPage_Changepassword");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		softAssert.assertAll();
		logger.info("Completed Test Successfully");

	}

}
