package com.agilysys.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

	
	private static DriverSetup driverSetup=null;
	
	//private String driverPath=System.getProperty("user.dir")+"\\driver\\chromedriver.exe";
	private WebDriver driver=null;
	
	private DriverSetup()
	{
		//System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static DriverSetup getInstance() {
		if(driverSetup==null)
			driverSetup=new DriverSetup();
		
		return driverSetup;
	}
	
	public WebDriver getDriver() {
		
		return driver;
	}
	
}
