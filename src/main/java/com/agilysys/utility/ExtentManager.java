package com.agilysys.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {

	private  String timeStamp=new SimpleDateFormat("dd-MM-YYYY-hh-mm-ss").format(new Date());
	private  String reportDir=System.getProperty("user.dir")+"/report";
	private  String reportPath="";
	private  ExtentHtmlReporter htmlReport=null;
	private  ExtentReports report=null;
	private  Map<Integer, ExtentTest> extentTestMap=new HashMap<Integer, ExtentTest>();
	private static ExtentManager manager=null;
	
	private ExtentManager()
	{
		
		File dir=new File(reportDir);
		if(!dir.exists()) {
				dir.mkdir();
			}
		reportPath=dir+"\\"+timeStamp+".html";
		if(report==null)
		{
			htmlReport=new ExtentHtmlReporter(reportPath);
			report=new ExtentReports();
		}
		report.attachReporter(htmlReport);
	}
	public synchronized ExtentTest getTest()
	{
		
		return (ExtentTest) extentTestMap.get((int)(long)Thread.currentThread().getId());
	}
	
	public synchronized void endTest()
	{
		report.flush();
	}
	
	public  synchronized ExtentTest startTest(String testName) {
		
		ExtentTest test=report.createTest(testName);
		extentTestMap.put((int)(long)Thread.currentThread().getId(),test);
		return test;
	}
	
	public static ExtentManager getInstance()
	{
		if(manager==null)
			manager=new ExtentManager();
		
		return manager;
	}
}
