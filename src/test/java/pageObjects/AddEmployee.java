package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.TestUtil;

public class AddEmployee 
{
	WebDriver driver;
	
	public AddEmployee(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[text()='PIM']")
	WebElement PIM;
	
	@FindBy(id = "menu_pim_addEmployee")
	WebElement addEm;
	
	@FindBy(id ="firstName")
	WebElement firstName;
	
	@FindBy(id ="middleName")
	WebElement middleName;
	
	@FindBy(id ="lastName")
	WebElement lastName;
	
	@FindBy(id= "btnSave")
	WebElement saveBtn;
	
	public void hoverPIM()
	{
		
		PIM.click();
		
	}
	
	public void clickOnAddEmp()
	{
		TestUtil.JSClick(driver, addEm);
	}
	
	public void setFirstName(String txt)
	{
		firstName.sendKeys(txt);
	}
	
	
	public void setMiddleName(String txt)
	{
		middleName.sendKeys(txt);
	}
	
	public void setLastName(String txt)
	{
		lastName.sendKeys(txt);
	}
	
	
	public void clickOnSave()
	{
		TestUtil.JSClick(driver, saveBtn);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


























