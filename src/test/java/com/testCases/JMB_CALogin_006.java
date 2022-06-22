package com.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.LandingPage;
import com.pageObjects.LoginPage;
import com.utilities.MyScreenRecorder;
import com.utilities.XLUtils;

public class JMB_CALogin_006 extends BaseClass{
	
	@Test(priority=6, dataProvider="InvalidEmailPassword", dataProviderClass=XLUtils.class, description= "Verify InValid Email and Invalid Password")
	public void invalidEmailInvPassword(String email, String password) throws Exception {
		MyScreenRecorder.startRecording("invalidEmailInvPassword");

		LandingPage lp=new LandingPage(driver);
		lp.loginLandingPage();
		
		LoginPage logPage=new LoginPage(driver);
		logPage.loginParametrized(email, password);
		//logPage.clkbtnSubmit();
		SoftAssert softAssert=new SoftAssert();
		if(logPage.invalidCredentialsText.isDisplayed()) {
			softAssert.assertTrue(true);
			logger.info("Test Passed Successfully,Error message Displayed is: "+logPage.getinvalidCredential());
		}
		else {
			softAssert.assertTrue(false);
			logger.error("Test Failed! Login failed!");
			try {
				captureScreen(driver,"invalidEmailInvPassword");
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
