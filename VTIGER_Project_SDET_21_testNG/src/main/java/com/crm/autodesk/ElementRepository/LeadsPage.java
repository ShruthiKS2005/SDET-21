package com.crm.autodesk.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericLibrary.WebDriverUtilities;

/**
 * This is class for leads web page
 * @author SHRUTHI
 *
 */
//step1: separate class created for leads page
public class LeadsPage extends WebDriverUtilities
{
	WebDriver driver;
	//step4: create a constructor and use page factory class
	public LeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step2: identify all web elements using @FindBy or @FindBys or @FindAll and declare those webelements as private
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']") 
	private WebElement createLeadImg;
	
	//step3: generate getters for these private web elements
	public WebElement getCreateLeadImg()
	{
		return createLeadImg;
	}
	//step5:access the web elements using getters()/business methods
	public void clickOnCreateLeadsImg()
	{
		createLeadImg.click();
	}
}
