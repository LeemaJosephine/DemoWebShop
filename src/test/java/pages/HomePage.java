package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethod;

public class HomePage extends ProjectSpecificMethod {

	@FindBy(className = "ico-register")
	WebElement register;
	
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public RegisterPage clickRegister() {
		
		register.click();
		return new RegisterPage(driver);
	}
	
	
}
