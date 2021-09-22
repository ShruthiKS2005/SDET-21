package com.crm.autodesk.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is a class for login web page
 * @author SHRUTHI
 *
 */
//step1: separate class created for login page
public class LoginPage 
{
	//step4: create a constructor and use page factory class
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//step2: identify all web elements using @FindBy or @FindBys or @FindAll and declare those webelements as private
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement userPasswordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	//step3: provide getters methods for private webelements 
	public WebElement getUserNameEdt()
	{
		return userNameEdt;
	}

	public WebElement getUserPasswordEdt() 
	{
		return userPasswordEdt;
	}

	public WebElement getLoginBtn() 
	{
		return loginBtn;
	}
	
	//step5:access the web elements using getters()/business methods
	public void login(String username, String password)
	{
		userNameEdt.sendKeys(username);
		userPasswordEdt.sendKeys(password);
		loginBtn.click();
	}
}
