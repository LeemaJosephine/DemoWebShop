package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethod;

public class RegisterPage extends ProjectSpecificMethod{

	@FindBy(id="gender-female")
	WebElement gender;
	
	@FindBy(id="FirstName")
	WebElement firstName;
	
	@FindBy(id="LastName")
	WebElement lastName;
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement pass;
	
	@FindBy(id="ConfirmPassword")
	WebElement conPass;
	
	@FindBy(id="register-button")
	WebElement registerButton;
	
	public RegisterPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public RegisterPage chooseGender() {
		
		gender.click();
		return this;
	}
	
	public RegisterPage enterFirstName(String fname) {
		
		passValue(firstName, fname);
		return this;
		
	}
	
	public RegisterPage enterLastName(String lname) {
		
		lastName.sendKeys(lname);
		return this;
		
	}

	public RegisterPage enterEmail(String emailid) {
	
		email.sendKeys(emailid);
		return this;
	
	}

	public RegisterPage enterPass(String password) {
	
		pass.sendKeys(password);
		return this;
	
	}

	public RegisterPage enterConPass(String conpass) {
	
		conPass.sendKeys(conpass);
		return this;
	
	}

	public RegisterPage clickRegisterButton() {
	
		elementClickWait(registerButton, 10);
		registerButton.click();
		return this;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
