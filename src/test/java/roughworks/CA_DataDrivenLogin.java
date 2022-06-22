package roughworks;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.LandingPage;
import com.pageObjects.LoginPage;

import roughworks.XLUtils2;

public class CA_DataDrivenLogin extends BaseClass {

	@Test(dataProvider = "dp", dataProviderClass = XLUtils2.class, description = "Verify Data Driven Test cases for Login Functionality")
	public void LogintestDataDriven(String email, String password) throws IOException {

		//SoftAssert softAssert = new SoftAssert();
		//System.out.println("softAssert Method Was Started");

		//LandingPage landpg = new LandingPage(driver);
		//landpg.loginLandingPage();
		// Started the login test
		logger.info("Started Logintest");
		// Create the object for LandingPage
		driver.get("http://52.60.159.184/login");
		LoginPage lp = new LoginPage(driver);
		// Clicking on Login button
		// lp.clkbtnSubmit();
		lp.loginParametrized(email,password);
		logger.info("Clicked on Login");
		
		
		// Create an object for LoginPage
	//	LoginPage loginpg = new LoginPage(driver);
	//	loginpg.settxtemail(username1); // Pass username1 declared in config file
		//loginpg.settxtpassword(password); // Pass password declared in config file
		//loginpg.clkbtnSubmit(); // Click on submit button

		// Validate whether login is successful
		
		  SoftAssert softassert = new SoftAssert();
		 if(driver.getTitle().equals("Dashboard")) { 
		  
			softassert.assertTrue(true);
		  logger.info("Test Passed! Login Successful!"); 
		  } 
		  else {
		  softassert.assertTrue(false); 
		  logger.error("Test Failed! Login failed!");
		  try {
				captureScreen(driver,"CA_DataDrivenLogin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  } 
		  softassert.assertAll();
		  logger.info("Completed Logintest");
		 
		/*softAssert.assertTrue(true);
		  captureScreen(driver,"LogintestDataDriven");
		softAssert.assertAll();
				System.out.println("softAssert Method Was Passed with condition");*/
	}

}
