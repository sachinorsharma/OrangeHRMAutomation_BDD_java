package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.TestUtil;

public class LoginPage 
{
	WebDriver pdriver;
	
	
	@FindBy(name  = "txtUsername")
	@CacheLookup
	WebElement username;
	
	@FindBy(name = "txtPassword")
	@CacheLookup
	WebElement password;
	
	@FindBy(id = "btnLogin")
	@CacheLookup
	WebElement logInBtn;
	
	@FindBy(id = "welcome")
	@CacheLookup
	WebElement profileLink;
	
	@FindBy(linkText = "Logout")
	@CacheLookup
	WebElement logOutBtn;
	
	
	
	public LoginPage(WebDriver driver)
	{
		pdriver = driver;
		PageFactory.initElements(pdriver, this);
	}
	
	public void sendUsername(String uname)
	{
		username.clear();
		username.sendKeys(uname);
	}
	
	public void sendPassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		TestUtil.JSClick(pdriver, logInBtn);
	}
	
	public void clickProfile()
	{
		TestUtil.JSClick(pdriver, profileLink);
	}
	
	
	public void clickLogOut()
	{
		TestUtil.JSClick(pdriver, logOutBtn);
	}
	
	
}
