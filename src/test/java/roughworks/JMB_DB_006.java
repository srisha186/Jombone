package roughworks;

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

	@Test(priority = 6)

	public void settingPage_Toggle() throws Exception {

		LandingPage lp = new LandingPage(driver);
		lp.loginLandingPage();

		LoginPage logPage = new LoginPage(driver);
		logPage.settxtemail(username1);
		logPage.settxtpassword(password);
		logPage.clkbtnSubmit();

		Homepage_Icon home = new Homepage_Icon(driver);
		home.closePopUpBtn();
		//st = new Me_SettingPage(driver);
	//	st.toggleNotification();
		MeButton me = new MeButton(driver);
		me.toggleNotification();
		SoftAssert softAssert = new SoftAssert();
		if (me.toggleBtnOn_msg.isDisplayed()) {

			// if(driver.getPageSource().equalsIgnoreCase("Please enter valid email.")) {
			softAssert.assertTrue(true);
			logger.info("Test Passed Successfully, Error message Displayed is: "+me.getToggleOn());
		} else {
			softAssert.assertTrue(false);
			logger.info("Test Passed Successfully, Error message Displayed is: "+me.getToggleOff());
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

	/*
	 * @Test(dependsOnMethods = {"settingPage_Toggle"}, dataProvider="dataValue",
	 * dataProviderClass=XLUtils.class) public void
	 * settingPage_Changepassword(String currentpwd, String newpwd, String
	 * changepwd) throws InterruptedException { st=new Me_SettingPage(driver);
	 * st.changepassword(currentpwd, newpwd, changepwd); logger.info("success");
	 * 
	 * }
	 */

}
