package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondriver.Action;
import com.store.base.BaseClass;

public class AccountCreatedPage extends BaseClass {
	
	Action action ;
	
	@FindBy(xpath = "//*[@id=\"content\"]/p[1]")
	WebElement accountCreatedText;
	
	@FindBy(xpath = "//*[@id=\"content\"]/p[1]")
	WebElement accountCreatedSubText;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/a")
	WebElement continueLink;
	
	@FindBy(xpath = "/html/body/div[4]/header/div[1]/div[2]/div[3]/div/div/ul/li[1]/a/span")
	WebElement accountLoggedInText;
	
	@FindBy(xpath = "/html/body/div[4]/header/div[1]/div[2]/div[3]/div/div/ul/li[2]/a/span")
	WebElement accountLogOutText;
	
	@FindBy(xpath = "/html/body/div[4]/header/div[1]/div[2]/div[3]/div/div/ul/li[1]/a")
	WebElement accountLoggedIn;
	
	@FindBy(xpath = "/html/body/div[4]/header/div[1]/div[2]/div[3]/div/div/ul/li[2]/a")
	WebElement accountLogOut;
	
	
	@FindBy(xpath = "//*[@id=\"search\"]/div/div/input")
	WebElement searchInput;
	
	
	public AccountCreatedPage() {
		this.action = new Action();
		PageFactory.initElements(getDriver(), this);;
	}
	
	
	public boolean validateAccountCreatedWelcomeText() {
		String expectedText = "Your Account Has Been Created!";
		String actualText = accountCreatedText.getText();
		return expectedText.equals(actualText);
	}
	
	public boolean validateAccountCreatedWelcomeSubText() {
		String expectedText = "Congratulations! Your new account has been successfully created!";
		String actualText = accountCreatedText.getText();
		return expectedText.equals(actualText);
	}
	
	public boolean validateAccountLoginText() {
		String accountText = "Account";
		String actualText = accountLoggedInText.getText();
		return accountText.equals(actualText);
	}
	
	public boolean validateLogoutText() {
		String accountText = "Logout";
		String actualText = accountLogOutText.getText();
		return accountText.equals(actualText);
	}
	
	public boolean validateSearchInput() {
		return action.isDisplayed(getDriver(), searchInput);
	}
	
	public boolean validateAccountLink() {
		String accountLink = "https://robomart.com/account";
		String actualLink = accountLoggedIn.getAttribute("href");
		return accountLink.equals(actualLink);
		
	}
	
	public boolean validateLogOutLink() {
		String logOutLink = "https://robomart.com/logout";
		String actualLink = accountLoggedIn.getAttribute("href");
		return logOutLink.equals(actualLink);
		
	}
	
//	https://robomart.com/account
	public AccountPage goToAccountContinueLink() {
		action.click(getDriver(), continueLink);
		return new AccountPage();
	}
}
