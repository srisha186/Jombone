package roughworks;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.utilities.ReadConfig;



public class BaseClass2 
{
	static ReadConfig  readconfig = new ReadConfig(); // Creating object
	// Integrating data from ReadConfig
	public static String baseURL=readconfig.getApplicationURL(); 
	public String username1=readconfig.getUsername1();
	public String password=readconfig.getPassword(); 
	public  String browser=readconfig.getbrowser();
	public static ChromeOptions handlingSSL = new ChromeOptions();
	public static WebDriver driver;
	public static Logger logger;
	//public static Logger logger = Logger.getLogger("qaLogger");

	public static String screenshotPath;
	public static String screenshotName;
	
	
	@BeforeClass
	public void setup()
	{	
		if(browser.equalsIgnoreCase("chrome")) {
			 //Create instance of ChromeOptions Class
			
			//Using the accept insecure cert method with true as parameter to accept the untrusted certificate
			handlingSSL.setAcceptInsecureCerts(true);
			//Creating instance of Chrome driver by passing reference of ChromeOptions object
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver(handlingSSL);
		// Initialization // Logger initiated within the setup method
		logger=Logger.getLogger("Jombone Test");// Project Name 
		PropertyConfigurator.configure("log4j.properties"); // Added Logger
		logger.setLevel(Level.DEBUG); // to get the debug log
		logger.debug("Debug logging has started ");
		
		
		}
		driver.get(baseURL);
        driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public String captureScreen(WebDriver driver,String tname) throws IOException 
	{
		//String fileName = getrandomstring(3) + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//File target = new File(System.getProperty("user.dir") + "\\Screenshots\\" + tname +"randomNumber"+getrandomstring(3)+ ".png");
		String target = System.getProperty("user.dir") + "\\Screenshots\\" + tname +"randomNumber"+getrandomstring(3)+ ".png";
		FileUtils.copyFile(source, new File(target));
		System.out.println("Screenshot taken");
		return target;
	}
	public static String getrandomstring(int length) 
	{
		String generatedString1 = RandomStringUtils.randomAlphabetic(5); // generate random char string with the specified values passed 
		return (generatedString1);										 
	}

	public static String randomeNum() 
	{
		String generatedString2 = RandomStringUtils.randomNumeric(4);// generate random digits with the specified values passed
		return (generatedString2);
	}
	

	/*public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));

	}
	
	*public static String screenshotPath;
	public static String screenshotName;

	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));

	}

	*/
	
	/*public static void captureScreen(WebDriver driver, String tname) throws IOException {
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d=new Date();
		screenshotName=d.toString().replace(":", "_").replace("", "_")+ ".png";
		
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\Screenshots\\"+""+tname+""+screenshotName));
	}
	
	/*public void captureScreen(WebDriver driver, String tname) throws IOException 
	{
		//String fileName = getRandomString(3) + ".png";
		//TakesScreenshot ts = (TakesScreenshot) driver;
		//File source = ts.getScreenshotAs(OutputType.FILE);
		Date dd=new Date();
		screenshotName=dd.toString().replace(":", "_").replace(" ", "_")+".png";
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//File target = new File(System.getProperty("user.dir") + "\\Screenshots\\" +getRandomString(3) +""+ tname + ".png");
		
		//FileUtils.copyFile(source, target);
		//FileUtils.copyFile(source, new File(System.getProperty("user.dir") + "\\Screenshots\\" +getRandomString(3)+""+tname+""+screenshotName));
		FileUtils.copyFile(source, new File(System.getProperty("user.dir") + "\\Screenshots\\" +tname+""+screenshotName));

		System.out.println("Screenshot taken");
	}
	public static String getRandomString(int length) 
	{
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();									 
	}

	public static String randomeNum() 
	{
		String generatedString2 = RandomStringUtils.randomNumeric(3);// generate random digits with the specified values passed
		return (generatedString2);
	}*/
	
}