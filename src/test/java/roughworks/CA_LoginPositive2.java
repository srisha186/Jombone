package roughworks;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.LandingPage;
import com.pageObjects.LoginPage;

public class CA_LoginPositive2 extends BaseClass {
	
	@Test(priority=1)
	public void Logintest() throws IOException
	{
		
		LandingPage landpg=new LandingPage(driver);
		landpg.loginLandingPage();
		//Started the login test
		logger.info("Started Logintest");		
		//Clicking on Login button
		logger.info("Clicked on Login");
		//Create an object for LoginPage
		LoginPage loginpg = new LoginPage(driver);
		loginpg.settxtemail(username1);		//Pass username1 declared in config file
		loginpg.settxtpassword(password);	//Pass password declared in config file
		loginpg.clkbtnSubmit();             //Click on submit button
		
		//Validate whether login is successful
		SoftAssert softassert = new SoftAssert();
		if(driver.getTitle().equals("Dashboard"))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! Login Successful!");
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Test Failed! Login failed!");
			captureScreen(driver,"Logintest");
		}
		softassert.assertAll();
		logger.info("Completed Logintest");
		
	}
	
	

}
