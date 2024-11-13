package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondriver.Action;
import com.store.base.BaseClass;

public class RegisterUserPage extends BaseClass{

	
	Action action = new Action();
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstName;
	
	@FindBy(xpath = "//*[@id=\"input-lastname\"]")
	WebElement lastName;
	
	@FindBy(xpath = "//*[@id=\"input-email\"]")
	WebElement email;
	
	@FindBy(xpath = "//*[@id=\"country_code\"]")
	WebElement selectCountryCodeForMobile;
	
	@FindBy(xpath = "//*[@id=\"input-telephone\"]")
	WebElement mobileNumber;
	
	@FindBy(xpath = "//*[@id=\"input-password\"]")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"input-confirm\"]")
	WebElement confirmPassword;
	
	@FindBy(xpath = "//*[@id=\"register-btn\"]")
	WebElement signUpBtn;
	
	 public RegisterUserPage() {
		PageFactory.initElements(getDriver(), this);
		this.action = new Action();
	}
	 
	 
	public LoginPage signUp(String fName, String lName, String email, String mobileNo, 
			String countryCode, String password, String confirmPassword ) {
		action.type(firstName, fName);
		action.type(lastName, lName);
		action.type(this.email, email);
		action.type(mobileNumber, mobileNo);
		action.type(this.password, password);
		action.type(this.password, confirmPassword);
		action.selectByVisibleText(selectCountryCodeForMobile, countryCode);
		
		action.click(getDriver(), signUpBtn);
		
		return new LoginPage();
	}
	
}
