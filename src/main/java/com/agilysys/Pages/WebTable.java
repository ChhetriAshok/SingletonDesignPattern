package com.agilysys.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.agilysys.utility.DriverSetup;

public class WebTable {
	
	private DriverSetup setup=DriverSetup.getInstance();
	private WebDriver driver=null;
	
	
	public WebTable() {
		driver=setup.getDriver();
	}
	
	@FindBy(xpath = "//div[text()='pruebas@pruebas.com']/../../div[5]/div")
	private WebElement phoneNum;
	
	
	
	
	public void getPhoneNumber()
	{
		
		System.out.println(phoneNum.getText());
		//div[text()='pruebas@pruebas.com']
		
		//div[text()='pruebas@pruebas.com']/../../div[5]/div
		
	}
	
}
