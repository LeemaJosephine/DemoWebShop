package base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.UtilityClass;

public class ProjectSpecificMethod extends UtilityClass{

	@BeforeSuite
	public void report() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("SauceDemoTestResults");
		reporter.config().setDocumentTitle("Login Test Results");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Gaurav");
	}
	
	@BeforeMethod
	public void launchBrowser() {
		
		launch();
		
	}
	
	@DataProvider(name="ReadData")
	public String[][] readData() throws IOException {
		
		String[][] data = readExcel(sheetname);
		return data;
	}
	
	@AfterMethod
	public void closeBrowser() {
		
		closing();
	}
	
	@AfterTest
	public void reportClose() {
		extent.flush();
	}
	
}
