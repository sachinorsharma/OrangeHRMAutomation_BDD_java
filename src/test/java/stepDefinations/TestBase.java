/**
 * 
 */
package stepDefinations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import pageObjects.AddEmployee;
import pageObjects.DeleteEmployeePage;
import pageObjects.LoginPage;
import pageObjects.SearchEmployeePage;
import utilities.TestUtil;

/**
 * @author Vikas Ingle
 *
 */
public class TestBase 
{
	
	public static WebDriver driver;
	public static Properties prop= new Properties();
	public static String current_project_dir;
	public static Logger logger;
	
	public LoginPage loginPage;
	public  AddEmployee addEmp;
	public DeleteEmployeePage deleteEmpPage;
	public SearchEmployeePage searchEmpPage;
	
	
	
	
	
	
	
	
	
	
}
