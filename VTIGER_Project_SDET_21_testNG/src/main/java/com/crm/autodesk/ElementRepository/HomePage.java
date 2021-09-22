package com.crm.autodesk.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericLibrary.WebDriverUtilities;

/**
 * This is class for home web page
 * @author SHRUTHI
 *
 */
//step1: separate class created for home page
public class HomePage extends WebDriverUtilities
{
	WebDriver driver;
	//step4: create a constructor and use page factory class
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step2: identify all web elements using @FindBy or @FindBys or @FindAll and declare those webelements as private
	@FindBy(linkText="Leads")
	private WebElement leadsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutLnk;
	
	//step3: generate getters for these private web elements
	public WebElement getLeadsLnk()
	{
		return leadsLnk;
	}

	public WebElement getAdministratorImg() 
	{
		return administratorImg;
	}

	public WebElement getSignoutLnk() 
	{
		return signoutLnk;
	}
	
	//step5:access the web elements using getters()/business methods
	public void clickOnLeadsLink()
	{
		leadsLnk.click();
	}
	public void clickOnSignOutLink()
	{
		administratorImg.click();
		signoutLnk.click();
	}
}
