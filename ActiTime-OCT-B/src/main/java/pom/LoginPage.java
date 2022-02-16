package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy (xpath = "//input[@name='username']")
	private WebElement userName;
	
	@FindBy (xpath = "//input[@name='pwd']")
	private WebElement password;
	
	@FindBy (xpath = "//div[text()='Login ']")
	private WebElement login;
	
	@FindBy (xpath = "//input[@id='loginButton']")
	private WebElement keepMeLoginCheckbox;

	public LoginPage(WebDriver driver123) 
	{
		PageFactory.initElements(driver123, this);
	}
	
	public void sendUserName(String ID) {
		userName.sendKeys(ID);
	}
	
	public void sendPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnLogin() {
		login.click();
	}
	
	public void selectKeepMeLogin() {
		keepMeLoginCheckbox.click();
	}
	
//	public void loginToApplication() {
//		userName.sendKeys("admin");
//		password.sendKeys("manager");
//		keepMeLoginCheckbox.click();
//		login.click();
//	}
	
   }
