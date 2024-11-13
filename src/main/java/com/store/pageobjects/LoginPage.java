package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondriver.Action;
import com.store.base.BaseClass;

public class LoginPage extends BaseClass{
	
	private Action  action;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtn;
	
	@FindBy(xpath = "//a[normalize-space()='Forgotten Password']")
	WebElement forgotPassword;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
		this.action = new Action();
	}
	

	public HomePage login(String userName, String password) {
		action.type(this.userName, userName);
		action.type(this.password, password);
		action.click(getDriver(), signInBtn);
		return new HomePage();
	}
}
