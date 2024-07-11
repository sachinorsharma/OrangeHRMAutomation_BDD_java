package stepDefinations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddEmployee;
import pageObjects.DeleteEmployeePage;
import pageObjects.LoginPage;
import pageObjects.SearchEmployeePage;
import utilities.TestUtil;

public class Steps extends TestBase
{	
	
	public String empFullName;
	String searchEmpName;
	boolean status;
	
	
	@Before
	public void setUp()
	{
		logger = Logger.getLogger("OrangeHRMAutomation");
		PropertyConfigurator.configure(current_project_dir+"/log4j.properties");
		
		
		try
		{
			current_project_dir=System.getProperty("user.dir");
			File propFile = new File(current_project_dir+"/config.properties");
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
			logger.info("Loading config Properties file");
			
			
		}
		catch(IOException e)
		{
			e.getMessage();
			e.getStackTrace();
		}
		
		String browserName = prop.getProperty("browser");
		logger.info("Using browser- "+browserName);
		
		logger.info("Getting "+browserName+" webdriver");
		driver = utilities.BrowserFactory.checkBrowser(driver, current_project_dir,browserName);
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
	}
	
	
	
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() 
	{

		loginPage = new LoginPage(driver);
		logger.info("User lanuchs chrome browser");
				  
	}
	@When("User opens URL {string}")
	public void user_opens_url(String url) 
	{
		logger.info("Getting application URL- "+url);
		driver.get(url);
	}
	@When("User Enters username as {string} and Password as {string}")
	public void user_enters_username_as_and_password_as(String un, String pwd) 
	{
		loginPage.sendUsername(un);
	    loginPage.sendPassword(pwd);
	    logger.info("Logging in application using "+un+" as an username and "+pwd+" as a password");
	    
	    
	}
	@When("Click on Login")
	public void click_on_login() 
	{
		loginPage.clickLogin();
		logger.info("Clicked on Login Button");
	}
	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) 
	{
		try
		{
		Assert.assertEquals(title, driver.getTitle());
		logger.info("Successfully validated the Page Tile: "+title);
		}
		catch(Exception e)
		{
			logger.info("Title validation failed");
		}
	}
	@When("User click on profile link")
	public void user_click_on_profile_link() 
	{
	    loginPage.clickProfile();
	    logger.info("User clicked on My Profile icon");
	}
	@When("click on Logout link")
	public void click_on_logout_link() 
	{
	    loginPage.clickLogOut();
	    logger.info("logging out of an Application");
	}
	@Then("close the browser")
	public void close_the_browser()
	{
	    driver.close();
	    logger.info("Closing browser");
	}

	// Add Employee Steps
	
		@When("User hover over PIM menu")
		public void user_hover_over_pim_menu()
		{
		    addEmp = new AddEmployee(driver);
		    addEmp.hoverPIM();
		    
		    logger.info("Clicked on PIM menu");
		    
		    
		}
		
		@When("clicks on Add Employee menu item")
		public void clicks_on_add_employee_menu_item() 
		{
		    addEmp.clickOnAddEmp();
		    
		    logger.info("Go to Add Employee workarea");
		}
		
		
		@Then("User fills info of new Employee {string} {string} {string}")
		public void user_fills_info_of_new_employee(String fName, String mName, String lName) 
		{
		    addEmp.setFirstName(fName);
		    logger.info("Setting First Name: "+fName);
		    addEmp.setMiddleName(mName);
		    logger.info("Setting Middle Name: "+mName);
		    addEmp.setLastName(lName);
		    logger.info("Setting Last Name: "+lName);
		    
		    empFullName = fName+" "+mName+" "+lName;
		}
		
		
		@Then("clicks on Save button")
		public void clicks_on_save_button() 
		{
		    addEmp.clickOnSave();
		    
		    logger.info("Saving info by clicking on Save button");
		}
		
		
		@Then("User is added successfully")
		public void user_is_added_successfully() 
		{
		    boolean status = driver.getPageSource().contains(empFullName);
		    
		    try
		    {
		    Assert.assertTrue(status);
		    logger.info(empFullName+" employee is added successfully");
		    }
		    catch(Exception e)
		    {
		    	logger.info(empFullName+" employee is not added");
		    }
		    
		    
		}
		
		
		// Search Employee Steps
		
		
		@When("Clicks on Employee List menu item")
		public void clicks_on_employee_list_menu_item() 
		{
		    searchEmpPage = new SearchEmployeePage(driver);
		    logger.info("Initiating Search Page Constructor");
		    
		    logger.info("Go to Employee list work area");
		    searchEmpPage.clickOnEmpList();
		    
		}
		
		@When("User searchs for this employee {string}")
		public void user_searchs_for_this_employee(String name) throws Exception 
		{
			Thread.sleep(3000);
			searchEmpName = name;
		    searchEmpPage.setEmpName(name);
		    logger.info("Search for this employee"+searchEmpName);
		}
		
		@When("clicks on Search button")
		public void clicks_on_search_button()
		{
		    deleteEmpPage  = searchEmpPage.clickOnSearchBtn();
		    logger.info("User clicks on Search button and initiates DeletePage constructor");
		    
		}
		
		@Then("it displays results")
		public void it_displays_results()
		{
			try {
		    status = searchEmpName.contains(searchEmpPage.getText());
		    Assert.assertTrue(status);
		    logger.info("Employee "+empFullName+" found in database");
		    logger.info("Search Employee test passed");
			}
			catch(NoSuchElementException e)
			{
				logger.info("There is no Employee "+searchEmpName+" present in application");
				logger.info("Search Employee test failed");
				driver.close();
				System.out.println(e);
			}
			
		}

		
		// Delete Employee steps
		
		
		@When("User clicks on select all")
		public void user_clicks_on_select_all() throws InterruptedException 
		{
			Thread.sleep(3000);
			
			logger.info("Deleting employee "+empFullName);
			
		    deleteEmpPage.clickSelectAll();
		    
		    logger.info("Clicked on Select All control");
		}
		
		@When("clicks on delete button")
		public void clicks_on_delete_button()
		{
		    deleteEmpPage.clickOnDelBtn();
		    logger.info("Clicked on Delete button");
		}
		
		@Then("confirmation pop up will appear")
		public void confirmation_pop_up_will_appear() throws InterruptedException
		{
			Thread.sleep(2000);
		    deleteEmpPage.handlePopUp();
		    logger.info("Confirmation pop up");
		}
		
		@Then("record will be deleted")
		public void record_will_be_deleted() throws Exception
		{
		    
			Thread.sleep(3000);
			
			status = driver.getPageSource().contains("No Records Found");
			try
			{
			Assert.assertTrue(status);
			logger.info(empFullName+ "successfully got deleted");
			logger.info("Delete Employee test case passed");
			}
			
			catch(Exception e)
			{
				logger.info("Delete Employee test case failed i.e user still exists in database");
			}
			
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
}
