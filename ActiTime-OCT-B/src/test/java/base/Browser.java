package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	
	
	public static WebDriver launchEdgeBrowser() {
		System.setProperty("webdriver.edge.driver","D:\\Browsers\\msedgedriver.exe");
    	WebDriver driver = new EdgeDriver();
		return driver;
	}
	
	public static WebDriver launchChromeBrowser() {
		System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver launchFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver","D:\\Browsers\\AMozila\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

}
