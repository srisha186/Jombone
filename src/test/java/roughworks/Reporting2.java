package roughworks;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.utilities.MyScreenRecorder;


//public class Reporting extends TestListenerAdapter
public class Reporting2 extends TestListenerAdapter
{
	public WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	//public static String screenshotPath
	//public static String screenshotName;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	//test=extent.createTest(result.getName().toUpperCase()); 
	
	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html"; // Report name and time stamp in html format
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "\\test-output\\htmlreports\\"+repName);//specify location of the report
		
		htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report - given by the user
		htmlReporter.config().setReportName("Functional Testing"); // name of the report - given by the user
		htmlReporter.config().setTheme(Theme.DARK); //
	//	htmlReporter.config().setTheme(Theme.STANDARD); 
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		// System info can be any info defined by the User that comes in the report
		// populate the common details
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("user","busyQA");
		extent.setSystemInfo("OS","Windows10");
		extent.setSystemInfo("Browser name","Chrome,Firefox,IE");
	}
	public void onTestSuccess(ITestResult result)
	{

		test=extent.createTest(result.getName().toUpperCase()); // create new entry in the report
		extentTest.set(test);
		extentTest.get().log(Status.PASS, "Test Case PASSED IS " + result.getName().toUpperCase());
		
		
		}
	//String record=MyScreenRecorder.startRecording("onTestFailure");
	//extentTest.get().addScreencastFromPath(record); //MyScreenRecorder class is in util package since its methods are static call it without instatiating new class object.
	//public void onTestFailure (ITestResult result)
	public void onTestFailure(ITestResult result, String tname)
	{
		test=extent.createTest(result.getName().toUpperCase()); // create new entry in the report
		extentTest.set(test);

		extentTest.get().log(Status.FAIL, "Test Case FAILED IS " + result.getName().toUpperCase());
		extentTest.get().log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
	//	FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\Screenshots\\"+""+tname+""+screenshotName));

		
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+result.getMethod().getMethodName();
		try {
			extentTest.get().addScreenCaptureFromPath(captureScreen(driver,tname),screenshotPath);// adding screen shot	
		} catch (IOException e) {
				e.printStackTrace();
		}
		

		
		/*try {
			com.base.BaseClass.captureScreenshot();
		}catch(IOException e) {
			e.printStackTrace();
		}
		test=extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.FAIL,result.getName().toUpperCase()+"Failed with exception: "+result.getThrowable());
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+result.getName();
		try {
			 test.addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	/*	try {
			Utilities.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Below is for extent report, it will attach screenshot in the extent report
		test.log(LogStatus.FAIL, arg0.getName().toUpperCase()+" Failed with exception : "+arg0.getThrowable());
		test.log(LogStatus.INFO, test.addScreenCapture(Utilities.screenshotName));
		
		rep.endTest(test);
		rep.flush();*/
		
		/*LogEntries entry=driver.manage().logs().get(LogType.BROWSER);//get all logs of browser in list
		List<LogEntry> logs=entry.getAll();
		
		for(LogEntry e:logs)
		{
			System.out.println(e.getMessage());
		}*/
		/*test=extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.FAIL, "Test Case FAILED IS " + result.getName());
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
		
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
		try {
			test.addScreenCaptureFromPath(screenshotPath);// adding screen shot	
		} catch (IOException e) {
				e.printStackTrace();
		}*/
		
		
	}
	private String captureScreen(WebDriver driver2, String tname) {
		// TODO Auto-generated method stub
		return null;
	}
	private String captureScreen(String tname, WebDriver driver2) {
		// TODO Auto-generated method stub
		return null;
	}
	public void onTestSkipped (ITestResult result)
	{
		test=extent.createTest(result.getName()); // create new entry in the report
		extentTest.set(test);
		extentTest.get().log(Status.SKIP, "Test Case SKIIPED  IS " + result.getName());

		
	}
	public void onFinish(ITestContext testContext)
	{
		
		extent.flush();
		
	}
	
}
