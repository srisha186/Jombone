package com.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.LandingPage;
import com.pageObjects.LoginPage;
import com.utilities.MyScreenRecorder;

public class JMB_CALogin_007 extends BaseClass{
	
	@Test(priority=7,description="Verify click on sign up link and Candidate Sign Up link ")
	public void candidateSignUpLink() throws Exception {
		MyScreenRecorder.startRecording("candidateSignUpLink");

		LandingPage lp=new LandingPage(driver);
		lp.loginLandingPage();
		
		LoginPage logPage=new LoginPage(driver);
		logPage.clickOnSignUpLink();
		logPage.clickOnCandidateSignUpLink();
		
		SoftAssert softAssert=new SoftAssert();
		if(driver.getTitle().equalsIgnoreCase("signup")) {
			softAssert.assertTrue(true);
			logger.info("Test Passed Successfully, Candidate SignUp Link Title Displayed is: "+driver.getTitle());
		}
		else {
			softAssert.assertTrue(false);
			
			logger.error("Test Failed! Login failed!");
			try {
				captureScreen(driver,"candidateSignUpLink");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		softAssert.assertAll();
		logger.info("Completed Logintest");
		logPage.signupLoginLink();//click on login page in Candidate sign up page
		MyScreenRecorder.stopRecording();

	}
	
}
