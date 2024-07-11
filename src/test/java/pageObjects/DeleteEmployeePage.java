package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.TestUtil;

public class DeleteEmployeePage 
{
	WebDriver driver;
	
	public DeleteEmployeePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "ohrmList_chkSelectAll")
	WebElement selectAll;
	
	@FindBy(id = "btnDelete")
	WebElement deleteBtn;
	
	@FindBy(id = "dialogDeleteBtn")
	WebElement popUpOkBtn;
	
	
	public void clickSelectAll()
	{
		selectAll.click();
	}
	
	public void clickOnDelBtn()
	{
		TestUtil.JSClick(driver, deleteBtn);
	}
	
	public void handlePopUp()
	{
		
		TestUtil.JSClick(driver, popUpOkBtn);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
