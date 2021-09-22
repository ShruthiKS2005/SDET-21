package com.crm.autodesk.GenericLibrary;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all the webdriver specific generic methods  
 * @author SHRUTHI
 *
 */
public class WebDriverUtilities
{
	/**
	 * This method is used to wait until the page gets load 
	 */
	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	/**
	 * This method is used to maximize the window
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to wait till the web elements are found
	 */
	public void waitTillWebElementVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method is used to handle drop down using visible text
	 */
	public void handleDropDown(WebDriver driver, WebElement element, String visibleText)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	/**
	 * This method is used to handle drop down using index
	 */
	public void handleDropDown(WebDriver driver, WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/** 
	 * This method is used to perform mouse hovering
	 */
	public void handleMouseHover(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method is used to perform double click
	 */
	public void handleDoubleClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method is used to switch from one window to another
	 */
	public void switchToWindow(WebDriver driver, String partWinText)
	{
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		   while(it.hasNext())
		   {
			   String winId=it.next();
			   String title=driver.switchTo().window(winId).getTitle();
	           if(title.contains(partWinText))
	           {
	        	   break;
	           }
		   }
	   }
	
	/**
	 * This method is used to accept alert
	 */
	public void acceptAlertPopup(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method is used to get text from pop-up and accept pop up and return msg
	 * @param driver
	 * @return
	 */
	
	public String textFromAlert(WebDriver driver)
	{
		Alert text = driver.switchTo().alert();
		String msg = text.getText();
		text.accept();
		return msg;
	}
	
	/**
	 * This method is used to dismiss alert
	 */
	public void dismissAlertPopup(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
}
