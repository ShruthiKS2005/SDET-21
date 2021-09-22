package com.crm.autodesk.LeadsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.ElementRepository.CreateLeadsPage;
import com.crm.autodesk.ElementRepository.HomePage;
import com.crm.autodesk.ElementRepository.LeadsPage;
import com.crm.autodesk.ElementRepository.LoginPage;
import com.crm.autodesk.GenericLibrary.BaseClass;
import com.crm.autodesk.GenericLibrary.ExcelFileUtilities;
import com.crm.autodesk.GenericLibrary.JSONFileUtilities;
import com.crm.autodesk.GenericLibrary.JavaUtilities;
import com.crm.autodesk.GenericLibrary.WebDriverUtilities;


/**
 * This class contains detailed steps to create new lead without filling any field
 * @author SHRUTHI
 *
 */
public class Tl_20_FillAllTheFieldsAndCancelTest extends BaseClass
{
	@Test (groups="Smoke")
	public void fillAllTheFieldsAndCancel() throws Throwable
	{
		//read random number from java file
		int RN = javaLib.getRandomNumber();
			
		//read all required test data from excel file
		String LastName = excelLib.getDataFromExcelFile("Sheet3", 13, 2)+RN;
		String CompanyName = excelLib.getDataFromExcelFile("Sheet3", 13, 3)+RN;
		String Email = excelLib.getDataFromExcelFile("Sheet3", 13, 4);
		String SecondEmail = excelLib.getDataFromExcelFile("Sheet3", 13, 5);
		
		//navigate to create lead page
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsLink();
			
		//navigate to create new leads page
		LeadsPage leadp = new LeadsPage(driver);
		leadp.clickOnCreateLeadsImg();
			
		//enter lead details
		CreateLeadsPage createleadp = new CreateLeadsPage(driver);
		createleadp.createLeads(LastName, CompanyName);
		createleadp.createLeadsWithInvalidEmail(Email, SecondEmail);
		createleadp.cancelFilledLeadDetails();
		

		/*//Lead Information created validation
		LeadInfoPage leadinfop = new LeadInfoPage(driver);
		String actualleadinfo = leadinfop.getLeadInformation();
		
		assert.
		*/
					
			
	}
}
