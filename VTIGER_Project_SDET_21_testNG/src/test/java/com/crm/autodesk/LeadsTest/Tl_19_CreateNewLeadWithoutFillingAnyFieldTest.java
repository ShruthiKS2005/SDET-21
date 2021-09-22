package com.crm.autodesk.LeadsTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.ElementRepository.CreateLeadsPage;
import com.crm.autodesk.ElementRepository.HomePage;
import com.crm.autodesk.ElementRepository.LeadsPage;
import com.crm.autodesk.GenericLibrary.BaseClass;

/**
 * This class contains detailed steps to create new lead without filling any field
 * @author SHRUTHI
 *
 */
public class Tl_19_CreateNewLeadWithoutFillingAnyFieldTest extends BaseClass
{
	@Test (groups="Regression")
	public void createNewLeadWithoutFillingAnyField() throws Throwable
	{
				
		//read all required test data from excel file
		
				
		//navigate to create lead page
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsLink();
				
		//navigate to create new leads page
		LeadsPage leadp = new LeadsPage(driver);
		leadp.clickOnCreateLeadsImg();
				
		//create new lead without filling fields
		CreateLeadsPage createleadp=new CreateLeadsPage(driver);
		createleadp.saveCreatedLead();
		
		//validate whether lead is created or not
		String errorMsg = webLib.textFromAlert(driver);
		String expErrorMsg = excelLib.getDataFromExcelFile("Sheet3", 10, 2);
		Assert.assertTrue(errorMsg.contains(expErrorMsg));
		System.out.println(errorMsg);
		
				
	}
}
