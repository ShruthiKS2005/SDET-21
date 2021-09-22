package com.crm.autodesk.GenericLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodesk.ElementRepository.HomePage;
import com.crm.autodesk.ElementRepository.LoginPage;


/**
 * This class contains basic annotation configurations
 * @author SHRUTHI
 *
 */

public class BaseClass
{
	public JSONFileUtilities jsonLib=new JSONFileUtilities();
	public ExcelFileUtilities excelLib=new ExcelFileUtilities();
	public WebDriverUtilities webLib=new WebDriverUtilities();
	public DataBaseUtilities dbLib=new DataBaseUtilities();
	public JavaUtilities javaLib=new JavaUtilities();
	public PropertyFileUtilities propertyLib=new PropertyFileUtilities();
	
	public WebDriver driver;
	
	
	@BeforeSuite //(groups= {"Smoke","Regression"})
	public void connectToDB()
	{
		System.out.println("Connected to DB");
	}
	@Parameters("Browser")//-->use for compatibilty execution
	@BeforeClass //(groups= {"Smoke","Regression"})//-->group execution
	public void launchBrowser(String BROWSER) throws Throwable//--> pass argument for compatibilty execution
	//public void launchBrowser() throws Throwable
	{
		System.out.println("Launching Browser");
		//String BROWSER = jsonLib.readDataFromJSON("browser");//-->remove for compatibilty execution
		//String BROWSER = jsonLib.readDataFromJSON("browser");
		String URL = jsonLib.readDataFromJSON("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid BROWSER");
		}
		
		webLib.maximizeWindow(driver);
		webLib.waitUntilPageLoad(driver);
		
		driver.get(URL);
	}
	
	@BeforeMethod//(groups={"Smoke","Regression"})
	public void logIn() throws Throwable  
	{
		String USERNAME = jsonLib.readDataFromJSON("username");
		String PASSWORD = jsonLib.readDataFromJSON("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
	}
	
	@AfterMethod //(groups= {"Smoke","Regression"})
	public void logOut()
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnSignOutLink();
	}

	@AfterClass //(groups= {"Smoke","Regression"})
	public void closeBrowser()
	{
		driver.close();
	}
	
	@AfterSuite //(groups= {"Smoke","Regression"})
	public void disconnectFromDB()
	{
		System.out.println("disconnect from db");
	}
}
