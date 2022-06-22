package roughworks;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.LandingPage;
import com.pageObjects.LoginPage;
import com.pageObjects.Logout;
import com.pageObjects.Me_SettingPage;
import com.utilities.MyScreenRecorder;
import com.utilities.XLUtils;

public class JMB_DB_007 extends BaseClass {
	public Me_SettingPage st;
	public SoftAssert softAssert;

	@Test(priority=1, dataProvider = "ChangePwdData", dataProviderClass = XLUtils.class)
	public void validEmailandPwd(String currentpwd, String newpwd, String changepwd) throws Exception {

		LandingPage lp = new LandingPage(driver);
		lp.loginLandingPage();

		LoginPage logPage = new LoginPage(driver);
		logPage.settxtemail(username1);
		logPage.settxtpassword(password);
		logPage.clkbtnSubmit();

		st = new Me_SettingPage(driver);
		st.changepassword( currentpwd,  newpwd, changepwd);
		softAssert = new SoftAssert();
		if (st.headerSettingtext.isDisplayed()) {
			softAssert.assertTrue(true);
			//softAssert.assertNotNull(st.changepassword(currentpwd, newpwd, changepwd), st.headerSettingtext);
			logger.info("Test Passed Successfully"+st.pswdChange_msg.getText());
			Thread.sleep(3000);
			
			
			}
		else {
			softAssert.assertTrue(false);
			logger.error("Test Failed! Login failed!");
			
				captureScreen(driver, "validEmailandPwd");
				// TODO Auto-generated catch block
		}
		
		softAssert.assertAll();
		logger.info("Completed Logintest");
		// Logout lo=new Logout(driver);
		// lo.logout();
	}

}
