package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.core.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.slf4j.LoggerFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;

public class UtilityClass 
{
	public static String getData(String SheetName,int  rowIndex, int cellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file= new FileInputStream("D:\\eclipse\\heros\\TestData\\sele.xlsx");
		String value = WorkbookFactory.create(file).getSheet( SheetName).getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return value;
	}
	
	public static String getPropertyFileData(String key) throws IOException
	{
		FileInputStream file = new FileInputStream("D:\\eclipse\\HerosLog\\propertyfile.properties");
	
		Properties p= new Properties();
		p.load(file);
		
		String value = p.getProperty(key);
		
		return value;
	
	}
	
	public static void captureScreeShot(WebDriver driver, int TCID) throws IOException
	{
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dec= new File("D:\\eclipse\\HerosLog\\FailedTestCasesScreenShot\\HEROS-"+TCID+".png");
		
		FileHandler.copy(scr, dec);
		
		
	}
	
	
	public static void getHandelDropDown(WebDriver Driver, WebElement WElemenet)
	{
		Actions act= new Actions(Driver);
		act.moveToElement(WElemenet).perform();
	}
	
	public static void getclikonWebElement(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.click(element);
		
		
		
		
	}
	
	
	public static Logger getLogger(Class<?> clazz)
	{
		Logger logger= (Logger) LoggerFactory.getLogger(clazz);
		return logger;
	}

	public static ExtentReports getExtentReport() 
	{
		String ExtentReporterFilePath= System.getProperty("user.dir\\Reports\\extentRepoert.html"); //this statement is used to save reporter in folder under project path.
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter(ExtentReporterFilePath);
		sparkReporter.config().setReportName("Automation Results"); // Report Name
		sparkReporter.config().setDocumentTitle("Test Automation Result"); // Title of Report
		ExtentReports report= new ExtentReports();
		report.attachReporter(sparkReporter);
		report.setSystemInfo("Selenium Version ", "4.6.0");
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("", "");
		report.setSystemInfo("Executed By ", "Saurav "); 
		 return report;
	}
	
	
	



}
