package tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Browser;
import pom.ApplicationHeader;
import pom.LoginPage;
import utils.Utility;

public class FinalVerifyHeadersOFApplication extends Browser{

	private WebDriver driver;
	private ApplicationHeader applicationHeader;
	private LoginPage loginPage;
	private int testID ;
	static ExtentReports test;
	static ExtentHtmlReporter reporter; 
	
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) {
		
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);

		
		System.out.println(browser);
		
		if(browser.equalsIgnoreCase("Edge")) {
			driver = launchEdgeBrowser();
		}
		
		if(browser.equalsIgnoreCase("Chrome")) {
			driver = launchChromeBrowser();
		}
		
		if(browser.equalsIgnoreCase("Firefox")) {
			driver = launchFirefoxBrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void createPOMObject(){
		loginPage = new LoginPage(driver);
		applicationHeader = new ApplicationHeader(driver);
		
	}

	@BeforeMethod
	public void loginToApplication() throws EncryptedDocumentException, IOException {
		System.out.println("loginToApplication");
		driver.get("http://localhost/login.do");
		
		String useName = Utility.getDataFromExcel("Katraj", 1, 0);
		loginPage.sendUserName(useName);
		
		String password = Utility.getDataFromExcel("Katraj", 1, 1);
		loginPage.sendPassword(password);
		
		loginPage.clickOnLogin();
		
	}

	@Test
	public void toVerifyTaskButton(){
		testID = 101;
		System.out.println("To Verify Task tab/button");
		
		applicationHeader.openTaskPage();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		Assert.assertEquals(url, "http://localhost/tasks/otasklist.do","url of user is not found");
		Assert.assertEquals(title, "actiTIME - Open Tasks");
		

	}
	
	@Test
	public void toVerifyUserTab() {
		testID = 101;
		
		System.out.println("To Verify User tab/button");
		applicationHeader.openUserPage();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		Assert.assertEquals(url, "http://localhost/administration/userlist.do","url of user is not found");
		Assert.assertEquals(title, "actiTIME - User List");
	}

	@AfterMethod
	public void logoutFromAPPlication(ITestResult result) throws IOException{
		
		if(ITestResult.SUCCESS == result.getStatus()) 
		{
			Utility.getScreenshot(driver, testID);
			
		}
		
		System.out.println("logout");
		applicationHeader.logoutFromApplication();
	}

	@AfterClass
	public void clearPOMOObject(){
		loginPage = null;
		applicationHeader = null;
	}
	
	@AfterTest
	public void closedBrowser(){
//		System.out.println("Closed Browser");
		driver.quit();
		driver = null ;
		System.gc(); //to delete the object
	}



}
