package base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import utils.UtilityClass;

public class ProjectSpecificMethod extends UtilityClass{

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
	
}
