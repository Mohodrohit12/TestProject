package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.ApplicationHeader;
import pom.LoginPage;

public class TestClass1 {

	public static void main(String[] args) {
		
		    System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().to("http://localhost/login.do");
			
			LoginPage loginPage = new LoginPage(driver);
			
			loginPage.sendUserName(null);
			loginPage.sendPassword(null);
			
			loginPage.clickOnLogin();
			
	        ApplicationHeader applicationHeader = new ApplicationHeader(driver);
			applicationHeader.openReportpage();
	}
	
}
