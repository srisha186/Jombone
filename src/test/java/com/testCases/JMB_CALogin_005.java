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

public class JMB_CALogin_005 extends BaseClass{
	
	@Test(priority=5, dataProvider="InvalidEmail", dataProviderClass=XLUtils.class, description= "Verify InValid Email and valid Password")
	public void invalidEmail(String email, String password) throws Exception {
		MyScreenRecorder.startRecording("invalidEmail");

		LandingPage lp=new LandingPage(driver);
		lp.loginLandingPage();
		
		LoginPage logPage=new LoginPage(driver);
		logPage.loginParametrized(email, password);
		
		SoftAssert softAssert=new SoftAssert();
		if(logPage.invalidCredentialsText.isDisplayed()) {
		//if(driver.getTitle().equalsIgnoreCase("dashboard")) {
			softAssert.assertTrue(true);
			logger.info("Test Passed Successfully,Error message displayed is: "+logPage.getinvalidCredential());
		}
		else {
			softAssert.assertTrue(false);
			logger.error("Test Failed! Login failed!");
			try {
				captureScreen(driver,"invalidEmail");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		softAssert.assertAll();
		logger.info("Completed Logintest");
		MyScreenRecorder.stopRecording();;

	}
	
}
