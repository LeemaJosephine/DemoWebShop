package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.HomePage;

public class TC001_RegisterTest extends ProjectSpecificMethod{

	@BeforeTest
	public void setup() {
		
		sheetname="register";
	}
	
	@Test(dataProvider = "ReadData")
	public void registerTest(String fname,String lname, String email, String pass, String conpass) {
		
		HomePage obj = new HomePage(driver);
		obj.clickRegister()
		.chooseGender()
		.enterFirstName(fname)
		.enterLastName(lname)
		.enterEmail(email)
		.enterPass(pass)
		.enterConPass(conpass)
		.clickRegisterButton();
	}
}
