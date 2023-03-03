package extent_reports;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import net.bytebuddy.implementation.bytecode.Throw;

public class class2 
{
	ExtentSparkReporter htmlreport;
	ExtentReports reports;
	ExtentTest test;
	
	//we have to run this method before execution test method
	@BeforeTest
	public void startRepoerts()
	{
		htmlreport=new ExtentSparkReporter("ExtentDemo.html");
		reports=  new ExtentReports();
		reports.attachReporter(htmlreport); // here we attach report
		//here we can environment details also 
		reports.setSystemInfo("Machine", "PC1");
		reports.setSystemInfo("OS", "WindowHome");
		reports.setSystemInfo("Broswer", "Chrome");
		
		//here we can configure look and feel of report also 
		//here we can add title of report 
		htmlreport.config().setDocumentTitle("Extent Repoter class2");
		//
	
		System.out.println("Helo");
		
	}
	
	@Test
	public void m1()
	{
		//To create test we have to use of Extent report  object name
		//this createTest return Extent Test. and value returned by this method is store in Test i.e. object of extent test.
		test=reports.createTest("Open broswer and hit ULR");
		Assert.assertTrue(true);
	}
	
	@Test
	public void m2()
	{
		//To create test we have to use of Extent report  object name
		//this createTest return Extent Test. and value returned by this method is store in Test i.e. object of extent test.
		test=reports.createTest("m2");
		Assert.assertTrue(false);
	}
	
	@Test
	public void m3()
	{
		//To create test we have to use of Extent report  object name
		//this createTest return Extent Test. and value returned by this method is store in Test i.e. object of extent test.
		test=reports.createTest("m3");
		Assert.assertTrue(true);
	}
	@Test
	public void m4()
	{
		//To create test we have to use of Extent report  object name
		//this createTest return Extent Test. and value returned by this method is store in Test i.e. object of extent test.
		test=reports.createTest("m4");
	throw new SkipException("Skip");// is used to skip one of test method.
	}
	
	@Test
	public void m5()
	{
		//To create test we have to use of Extent report  object name
		//this createTest return Extent Test. and value returned by this method is store in Test i.e. object of extent test.
		test=reports.createTest("m5");
		Assert.assertTrue(true);
	}
	@AfterMethod //after each test method this method will execute
	public void getTestResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//to get log of test method we have to use ExtentTest objectname.log()
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() +" fail", ExtentColor.RED)); // my using getName method we get name of testmethod which is fail;
			test.fail(result.getThrowable()); //this result.getThrowable() will log error msg in report also.
		 }
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+ "Pass", ExtentColor.GREEN));
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+ "skip", ExtentColor.BROWN));
		}
	
		
		
	}
	//afterTest is used when we have code to execute when all test method is execute
	@AfterTest
	public void flus()
	{
		//this mandatory  method is used when all test method is executed then it will write report of that in Report.
		reports.flush();
	}
}
