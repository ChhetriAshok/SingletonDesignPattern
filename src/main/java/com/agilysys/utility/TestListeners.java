package com.agilysys.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class TestListeners implements ITestListener {
	
		private ExtentManager manager=ExtentManager.getInstance();
		private WebDriver driver=DriverSetup.getInstance().getDriver();
		public void onTestStart(ITestResult result) {
		  
			manager.startTest(result.getMethod().getMethodName());
		  
		  }
		public void onTestSuccess(ITestResult result) {
			System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
			manager.getTest().log(Status.PASS, "Test passed");
			try {
				manager.getTest().pass("Attaching Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(captureSnapshot(driver)).build());
			} catch (IOException e) {
				System.out.println("Failed to attach Screemshot to the html report");
				e.printStackTrace();
			}
		}
		public void onTestFailure(ITestResult result) {
			
			manager.getTest().log(Status.FAIL,result.getMethod().getMethodName()+"method Test Case Failed!!!");
			try {
				manager.getTest().fail("Attaching Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(captureSnapshot(driver)).build());
			} catch (IOException e) {
				System.out.println("Failed to attach Screemshot to the html report");
				e.printStackTrace();
			}
			
		}
		
		public void onFinish(ITestContext context) {
		
			manager.endTest();
		
		}
		private String captureSnapshot(WebDriver driver) {
			
			String timeStamp=new SimpleDateFormat("dd-MM-YYYY-hh-mm-ss").format(new Date());
			String screenshotDirPath=System.getProperty("user.dir")+"/snapshot";
			String screenshotImagePath="";
			File snapDir=new File(screenshotDirPath);
			
			if(!snapDir.exists())
				snapDir.mkdir();
			
			screenshotImagePath=snapDir+"/"+timeStamp+".jpg";
			
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dest=new File(screenshotImagePath);
			try {
				FileHandler.copy(src, dest);
			} catch (IOException e) {
			
				System.out.println("Can't copy snapshot to "+screenshotImagePath);
				e.printStackTrace();
			}
			return dest.getAbsolutePath();
		}

}
