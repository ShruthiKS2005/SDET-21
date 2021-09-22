package com.crm.autodesk.LeadsTest;

import org.testng.Assert;
import org.testng.annotations.Test;



import com.crm.autodesk.ElementRepository.CreateLeadsPage;
import com.crm.autodesk.ElementRepository.HomePage;
import com.crm.autodesk.ElementRepository.LeadsPage;
import com.crm.autodesk.GenericLibrary.BaseClass;

/**
 * This class contains detailed steps to create new lead by giving invalid input to email and secondary email field
 * @author SHRUTHI
 *
 */

public class Tl_16_CreateNewLeadByGivingInvalidInputToEmailAndSecondaryEmailTest extends BaseClass
{
	@Test (groups="Smoke")
	public void createLeadByGivingInvalidInputToEmailAndSecondaryEmail() throws Throwable
	{	
		//read random number from java file
		int RN = javaLib.getRandomNumber();
		
		//read all required test data from excel file
		String CompanyName = excelLib.getDataFromExcelFile("Sheet3", 1, 2)+RN;
		String LastName = excelLib.getDataFromExcelFile("Sheet3", 1, 3)+RN;
		String Email = excelLib.getDataFromExcelFile("Sheet3",1, 4);
		String SecondEmail = excelLib.getDataFromExcelFile("Sheet3", 1, 5);
		
		
		//navigate to create lead page
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsLink();
		
		//navigate to create new leads page
		LeadsPage leadp = new LeadsPage(driver);
		leadp.clickOnCreateLeadsImg();
		
		//create lead with invalid email and secondary email
		CreateLeadsPage createleadp = new CreateLeadsPage(driver);
		createleadp.createLeads(LastName, CompanyName);
		createleadp.createLeadsWithInvalidEmail(Email, SecondEmail);
		createleadp.saveCreatedLead();
		
		//validate whether lead is created or not
		String errorMsg = webLib.textFromAlert(driver);
		String expErrorMsg = excelLib.getDataFromExcelFile("Sheet3", 1, 6);
		Assert.assertTrue(errorMsg.contains(expErrorMsg));
		System.out.println(errorMsg);
		
		//Lead Information created validation
		
		
		/*LeadInfoPage leadinfop = new LeadInfoPage(driver);
		String actualleadinfo = leadinfop.getLeadInformation();
		Assert.assertTrue(actualleadinfo.);
		*/
		
		
	}
}
