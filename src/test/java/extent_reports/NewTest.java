package extent_reports;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest 
{
	  ExtentReports extent= new ExtentReports();
	  ExtentSparkReporter spark= new ExtentSparkReporter("Spark.html");
  @Test
  public void f1() 
  {
	 ExtentTest test = extent.createTest("lunch broswer");
	 test.log(Status.PASS, "user");
	 test.pass("user verifed");
	 
  }
  @Test
  public void test2()
  {
		 ExtentTest test = extent.createTest("verify test 2").assignAuthor("Saurav").assignCategory("Regression").assignDevice("Chrome");
		 test.log(Status.PASS, "user");
		 test.generateLog(Status.INFO, "give info");
		 test.fail("notvalid");
  }
  @BeforeTest
  public void beforeTest() 
  {

	  	extent.attachReporter(spark);
  }

  @AfterTest
  public void afterTest() 
  {
	  extent.flush();
  }

}
