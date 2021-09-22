package com.crm.autodesk.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is class for lead information web page
 * @author SHRUTHI
 *
 */
//step1: separate class created for lead information page
public class LeadInfoPage
{
	WebDriver driver;
	//step4: create a constructor and use page factory class
	public LeadInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//step2: identify all web elements using @FindBy or @FindBys or @FindAll and declare those webelements as private
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement leadInfo;
	
	//step3: generate getters for these private web elements
	public WebElement getLeadInfo()
	{
	return leadInfo;
	}
	
	//step5:access the web elements using getters()/business methods
	public String getLeadInformation()
	{
		String value = leadInfo.getText();
		return value;
	}
	
}
