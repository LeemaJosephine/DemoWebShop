package utils;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityClass {

	
	public static WebDriver driver;
	public String sheetname;
	public WebDriverWait wait;
	
	public void launch() {
		
		driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void closing() {
		
		driver.close();
	}
	
	public static String[][] readExcel(String sheetname) throws IOException {
		

		XSSFWorkbook book = new XSSFWorkbook("D:\\NewWorkSpace\\DemoWebShopProject\\src\\test\\resources\\DemoWebShopDB.xlsx");
		
		// Get to the sheet
		
		XSSFSheet sheet = book.getSheet(sheetname);
		
		// get the no.of rows
		
		int rowCount = sheet.getLastRowNum();
		
		System.out.println("Row count: "+rowCount);
		
		// get the no.of columns
		
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		System.out.println("Column count: "+columnCount);
		
		// create 2D array
		
		String[][] data = new String[rowCount][columnCount];
		
		for(int i =1 ; i <= rowCount; i++) {
			
			XSSFRow row = sheet.getRow(i);
			
			// get into the columns
			
			for(int j =0 ; j<columnCount; j++) {
				
				XSSFCell cell = row.getCell(j);
				
				// to store in array
				data[i-1][j] = cell.getStringCellValue();
				
			}
			
			
		}
	
		
		book.close();
		
		return data;
	}
	
	
	public void passValue(WebElement ele , String value) {
		
		ele.sendKeys(value);
	}
	
	public void elementClickWait(WebElement ele, int duration) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
	}
}
