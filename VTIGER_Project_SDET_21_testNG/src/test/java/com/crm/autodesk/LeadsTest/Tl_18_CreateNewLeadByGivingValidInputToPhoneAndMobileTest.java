package com.crm.autodesk.LeadsTest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.autodesk.ElementRepository.CreateLeadsPage;
import com.crm.autodesk.ElementRepository.HomePage;
import com.crm.autodesk.ElementRepository.LeadInfoPage;
import com.crm.autodesk.ElementRepository.LeadsPage;
import com.crm.autodesk.GenericLibrary.BaseClass;

/**
 * This class contains detailed steps to create new lead by giving valid input to phone and mobile field
 * @author SHRUTHI
 *
 */
public class Tl_18_CreateNewLeadByGivingValidInputToPhoneAndMobileTest extends BaseClass
{
	@Test (groups="Regression")
	public void createLeadByGivingValidInputToPhoneAndMobile() throws Throwable
	{
		//read random number from java file
		int RN = javaLib.getRandomNumber();
		
		//read all required test data from excel file
		String CompanyName = excelLib.getDataFromExcelFile("Sheet3", 1, 2)+RN;
		String LastName = excelLib.getDataFromExcelFile("Sheet3", 1, 3)+RN;
		int Phone = excelLib.getIntDataFromExcelFile("Sheet3", 7, 4);
		int Mobile = excelLib.getIntDataFromExcelFile("Sheet3", 7, 5);
		
		//navigate to create lead page
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsLink();
		
		//navigate to create new leads page
		LeadsPage leadp = new LeadsPage(driver);
		leadp.clickOnCreateLeadsImg();
		
		//create lead with valid phone and mobile
		CreateLeadsPage createleadp = new CreateLeadsPage(driver);
		createleadp.createLeads(LastName, CompanyName);
		createleadp.createLeadsWithValidPhoneAndMobile(Phone, Mobile);
		createleadp.saveCreatedLead();
		
		//validation of lead Information using last name
		LeadInfoPage leadinfop = new LeadInfoPage(driver);
		String actualLeadInfo = leadinfop.getLeadInformation();
		Assert.assertTrue(actualLeadInfo.contains(LastName));
		System.out.println(actualLeadInfo);
		
	}
}
