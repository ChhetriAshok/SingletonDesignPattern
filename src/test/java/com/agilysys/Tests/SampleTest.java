package com.agilysys.Tests;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.agilysys.Pages.Login;
import com.agilysys.Pages.WebTable;
import com.agilysys.utility.DriverSetup;
import com.agilysys.utility.ExtentManager;
import com.aventstack.extentreports.Status;

public class SampleTest {
	
	private Login login=null;
	private WebTable webTable=null;
	private DriverSetup setup=null;
	private WebDriver driver=null;
	
	@BeforeClass
	public void init()
	{
		setup=DriverSetup.getInstance();
		driver=setup.getDriver();
	}
	
	@Test(priority = 1,alwaysRun = true,enabled = true)
	public void launchBrowser() throws InterruptedException
	{
		 ExtentManager.getInstance().getTest().log(Status.INFO,"First Scenario started");
		 login=PageFactory.initElements(setup.getDriver(),Login.class); 	 
		 login.launchURL();
		 System.out.println("URL launched");
		 
	}
	
	@Test(priority = 2,alwaysRun = true, enabled = true)
	public void next() {
		//ExtentManager.getInstance().getTest().log(Status.INFO,"Second Scenario started");
		webTable=PageFactory.initElements(setup.getDriver(), WebTable.class);
		webTable=login.clickWebTableHeader(WebTable.class);
		assertTrue(false);
		webTable.getPhoneNumber();
	}
	
	@AfterClass
	public void flushDriver()
	{
		 driver.close();
	}
	
}
