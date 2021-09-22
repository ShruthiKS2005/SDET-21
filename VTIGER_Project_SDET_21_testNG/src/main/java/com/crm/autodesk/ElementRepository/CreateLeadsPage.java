package com.crm.autodesk.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericLibrary.WebDriverUtilities;

/**
 * This is class for create leads web page
 * @author SHRUTHI
 *
 */
//step1: separate class created for create leads page
public class CreateLeadsPage extends WebDriverUtilities
{
	WebDriver driver;
	//step4: create a constructor and use page factory class
	public CreateLeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//step2: identify all web elements using @FindBy or @FindBys or @FindAll and declare those webelements as private
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name="company")
	private WebElement companyEdt;
	
	@FindBy(name="assigntype")
	private WebElement assignToBtn;
	
	@FindBy(id="email")
	private WebElement emailEdt;
	
	@FindBy(id="secondaryemail")
	private WebElement secondaryemailEdt;
	
	@FindBy(id="phone")
	private WebElement phoneEdt;
	
	@FindBy(id="mobile")
	private WebElement mobileEdt;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	@FindBy(name="button")
	private WebElement cancelBtn;
	
	@FindBy(name="salutationtype")
	private WebElement firstNamedrop;
	
	@FindBy(name="firstname")
	private WebElement firstNameEdt;

	//step3: generate getters for these private web elements
	public WebElement getLastNameEdt() 
	{
		return lastNameEdt;
	}

	public WebElement getCompanyEdt() 
	{
		return companyEdt;
	}
	public WebElement getAssignToBtn()
	{
		return assignToBtn;
	}

	public WebElement getEmailEdt() 
	{
		return emailEdt;
	}

	public WebElement getSecondaryemailEdt() 
	{
		return secondaryemailEdt;
	}

	public WebElement getPhoneEdt() 
	{
		return phoneEdt;
	}

	public WebElement getMobileEdt() 
	{
		return mobileEdt;
	}

	public WebElement getSaveBtn() 
	{
		return saveBtn;
	}
	
	public WebElement getCancelBtn() 
	{
		return cancelBtn;
	}
	
	public WebElement getFirstNamedrop()
	{
		return firstNamedrop;
	}
	
	//step5:access the web elements using getters()/business methods
	public void createLeads(String lastname, String company)
	{
		lastNameEdt.sendKeys(lastname);
		companyEdt.sendKeys(company);
		assignToBtn.click();
	}
	public void createLeadsWithInvalidEmail(String email, String secondemail)
	{
		emailEdt.sendKeys(email);
		secondaryemailEdt.sendKeys(secondemail);
	}
	public void createLeadsWithValidPhoneAndMobile(int phone, int mobile)
	{
		phoneEdt.sendKeys(""+phone);
		mobileEdt.sendKeys(""+mobile);
	}
	public void createLeadsWithValidEmailAndSecondEmail(String firstName, String email, String secondemail)
	{
		firstNameEdt.sendKeys(firstName);
		emailEdt.sendKeys(email);
		secondaryemailEdt.sendKeys(secondemail);
	}
	public void saveCreatedLead()
	{
		saveBtn.click();
	}
	public void cancelFilledLeadDetails()
	{
		cancelBtn.click();
	}
	

}

