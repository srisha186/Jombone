package com.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.LandingPage;
import com.pageObjects.LoginPage;
import com.pageObjects.Logout;
import com.utilities.MyScreenRecorder;

public class JMB_CALogin_001 extends BaseClass{
	
	@Test(priority=1, description="Valid Email and valid Password")
	public void validEmailandPwd() throws Exception {
		MyScreenRecorder.startRecording("validEmailandPwd");

		LandingPage lp=new LandingPage(driver);
		lp.loginLandingPage();
		
		LoginPage logPage=new LoginPage(driver);
		logPage.settxtemail(username1);
		logPage.settxtpassword(password);
		logPage.clkbtnSubmit();
		
		SoftAssert softAssert=new SoftAssert();
		if(driver.getTitle().equalsIgnoreCase("dashboard")) {
			softAssert.assertTrue(true);
			logger.info("Test Passed Successfully");
		}
		else {
			softAssert.assertTrue(false);
			logger.error("Test Failed! Login failed!");
			try {
				captureScreen(driver,"validEmailandPwd");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		softAssert.assertAll();
		logger.info("Completed Logintest");
		//Logout lo=new Logout(driver);
		//lo.logout();
		MyScreenRecorder.stopRecording();
	}
	
}
