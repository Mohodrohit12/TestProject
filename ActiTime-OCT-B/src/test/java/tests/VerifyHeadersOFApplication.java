package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.ApplicationHeader;
import pom.LoginPage;

public class VerifyHeadersOFApplication {
	
	private WebDriver driver;
	private ApplicationHeader applicationHeader;
	private LoginPage loginPage;
	
	@BeforeClass
	public void launchBrowser(){
		System.out.println("launchBrowser");
		System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void loginToApplication(){
		System.out.println("loginToApplication");
		driver.get("http://localhost/login.do");
		loginPage = new LoginPage(driver);
		loginPage.sendUserName(null);
		loginPage.sendPassword(null);
		loginPage.clickOnLogin();
	    applicationHeader = new ApplicationHeader(driver);
		
	}

	@Test
	public void toVerifyTaskButton(){
		System.out.println("To Verify Task tab/button");
		
		applicationHeader.openTaskPage();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		Assert.assertEquals(url, "http://localhost/tasks/otasklist.do","url of user is not found");
		Assert.assertEquals(title, "actiTIME - Open Tasks");
		
//		if(url.equals("http://localhost/tasks/otasklist.do")) 
//		{
//			System.out.println("PASS");
//		}
//		else 
//		{
//			System.out.println("FAIL");
//		}
//		if(title.equals("actiTIME -  Open Tasks")) 
//		{
//			System.out.println("PASS");
//		}
//		else 
//		{
//			System.out.println("FAIL");
//		}
	}
	
	@Test
	public void toVerifyUserTab() {
		System.out.println("To Verify User tab/button");
		applicationHeader.openUserPage();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		Assert.assertEquals(url, "http://localhost/administration/userlist.do","url of user is not found");
		Assert.assertEquals(title, "actiTIME - User List");
	}

	@AfterMethod
	public void logoutFromAPPlication(){
		System.out.println("logout");
		applicationHeader.logoutFromApplication();
	}

	@AfterClass
	public void closedBrowser(){
		System.out.println("Closed Browser");
		driver.quit();
	}

}
