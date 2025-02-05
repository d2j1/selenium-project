package com.store.pageobjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(xpath = "/html/body/div[4]/header/div[1]/div[2]/div[3]/div/div/ul/li[1]/a")
	WebElement isLoggedInLink;
	
	
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
		this.action = new Action();
	}
	

	public HomePage login(String userName, String password)  {
		

		action.type(this.userName, userName);
		action.type(this.password, password);
		action.click(getDriver(), signInBtn);
		
		action.switchToDefaultFrame(getDriver());
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.textToBePresentInElement(isLoggedInLink, "Account"));
	
		return new HomePage();
	}
	
	
}
