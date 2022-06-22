package com.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.ForgotPassword;
import com.pageObjects.LandingPage;
import com.pageObjects.LoginPage;
import com.pageObjects.Logout;
import com.utilities.MyScreenRecorder;

public class JMB_CALogin_008 extends BaseClass {

	@Test(priority=8, description="Verify forgot password link works as expected and landed on Login Page ")
	public void forgotPasswordLink() throws Exception {
			MyScreenRecorder.startRecording("forgotPasswordLink");

		LandingPage lp = new LandingPage(driver);
		lp.loginLandingPage();

		LoginPage logPage = new LoginPage(driver);
		logPage.clickOnForgotPasswordLink();

		//ForgotPassword fp = new ForgotPassword(driver);
		//logger.info("Entered Forgot password Page");

		SoftAssert softAssert = new SoftAssert();

		if (driver.getTitle().equalsIgnoreCase("Forgot Password")) {
			softAssert.assertTrue(true);
			logger.info("Test Passed Successfully, Forgot Password Title Displayed is: " + driver.getTitle());
		} else {
			softAssert.assertTrue(false);
			logger.error("Test Failed! Login failed!");
			try {
				captureScreen(driver, "Forgot Password Title not Displayed");
				MyScreenRecorder.stopRecording();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		softAssert.assertAll();
	
		//Navigate from forgot password filed to Verify 
		ForgotPassword fp = new ForgotPassword(driver);
		logger.info("Entered Forgot password Page");
		fp.forgotEmail();
		fp.forgotSubmit();
		SoftAssert softAssert1 = new SoftAssert();

		if (driver.getTitle().equalsIgnoreCase("Verify Your Email")) {
			softAssert1.assertTrue(true);
			logger.info("Test Passed Successfully, Verify Email Title Displayed is: " + driver.getTitle());
		} else {
			softAssert1.assertTrue(false);
			logger.error("Test Failed! Login failed!");
			try {
				captureScreen(driver, "Verify Email Title not Displayed");
				MyScreenRecorder.stopRecording();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		softAssert.assertAll();
		

		
	//Navigate from verify email page to Change Password page
		
		fp.digitalcode();
		fp.verifybtn();
		SoftAssert softAssert2 = new SoftAssert();

		if (driver.getTitle().equalsIgnoreCase("Change Password")) {
			softAssert2.assertTrue(true);
			logger.info("Test Passed Successfully, Verify Change Password Title Displayed is: " + driver.getTitle());
		} else {
			softAssert2.assertTrue(false);
			logger.error("Test Failed! Login failed!");
			try {
				captureScreen(driver, "Verify Change Password not Displayed");
				MyScreenRecorder.stopRecording();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		softAssert.assertAll();
		
		
	//Navigate from change password field to home page
		
		fp.chngPwd();
		//after giving the change password it should navigate to Login page, but it navigates to Dashboard.
		SoftAssert assert3=new SoftAssert();
		if(driver.getTitle().equalsIgnoreCase("Login")) {
			assert3.assertTrue(true);
			logger.info("When change password clicked, it should navigate to Login page, but it navigates to Home page :"+driver.getTitle());
		}
		else {
			assert3.assertTrue(false);
			logger.error("Assert Failed, After confirm password button is clicked, it should Navigate to Login Page, but it navigate to Candidate Login Dashboard ");
			try {
				captureScreen(driver,"forgotPasswordLink");
				MyScreenRecorder.stopRecording();

			}catch(IOException e) {
				e.printStackTrace();

		}	
		assert3.assertAll();
		
		//Logout functionality to reach Login Page again for executing in testNG file.
		
		Logout lo=new Logout(driver);
		lo.logout();

	}

}
}

