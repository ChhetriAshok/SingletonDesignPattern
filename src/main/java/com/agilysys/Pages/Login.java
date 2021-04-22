package com.agilysys.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.agilysys.utility.DriverSetup;

public class Login {

	private DriverSetup setup=DriverSetup.getInstance();
	private WebDriver driver=null;
	
	public Login(){
		driver=setup.getDriver();
		//PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
	}
	
	public void launchURL()
	{
		
		driver.get("http://demo.automationtesting.in/Register.html");		
	}
	
	@FindBy(linkText = "WebTable")
	private WebElement webTableHeader;
	
	public <T> T clickWebTableHeader( Class<T> currClass)
	{
		webTableHeader.click();		
		return PageFactory.initElements(driver, currClass);
	}
}
