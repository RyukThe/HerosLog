package LibraryFiles;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass
{
	public WebDriver m;
	
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	
	public void openBrowser() throws IOException
	{
		m=new ChromeDriver();
		m.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		m.get(UtilityClass.getPropertyFileData("URL"));
	}
	
	public void compability(String BrowserName) throws IOException
	{
		if(BrowserName.equals("chrome"))
		{
			m= new ChromeDriver();
		
		}
		else if(BrowserName.equals("edge"))
		{
			m=new EdgeDriver();
		}
		else if(BrowserName.equals("firefox"))
		{
			m= new FirefoxDriver();
		}
		m.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		m.get(UtilityClass.getPropertyFileData("URL"));
	}
	
	public void getReport(String filename)
	{
		
	}
	
	

}
