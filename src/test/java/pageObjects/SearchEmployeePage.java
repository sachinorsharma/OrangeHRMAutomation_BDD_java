package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.TestUtil;

public class SearchEmployeePage
{
	WebDriver driver;
	DeleteEmployeePage deleteEmpPage;
	
	public SearchEmployeePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "menu_pim_viewEmployeeList")
	WebElement empList;
	
	@FindBy(id = "empsearch_employee_name_empName")
	WebElement searchEmpName;
	
	
	@FindBy(id="searchBtn")
	WebElement searchbtn;
	
	@FindBy(xpath = "//td[3]//a")
	WebElement tabletxt;
	
	public void clickOnEmpList()
	{
		
		TestUtil.JSClick(driver, empList);
		
	}
	
	public void setEmpName(String txt)
	{
		searchEmpName.clear();
		searchEmpName.click();
		Actions actions = new Actions(driver);
		actions.sendKeys(searchEmpName, txt).perform();
		
		
//		TestUtil.sendKeys(driver, searchEmpName, txt);
	}
	
	public DeleteEmployeePage clickOnSearchBtn()
	{
		TestUtil.JSClick(driver, searchbtn);
		
		return new DeleteEmployeePage(driver);
	}
	
	
	public String getText()
	{
		String tabName = tabletxt.getText();
		
		return tabName;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
