package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondriver.Action;
import com.store.base.BaseClass;

public class AccountPage extends BaseClass{

	Action action;
	
	@FindBy(xpath = "//*[@id=\"content\"]/h1")
	WebElement myAccountTitle;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/ul/li[1]/a")
	WebElement editAccountInformation;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/h2")
	WebElement myOrdersTitle;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/ul/li[1]/a")
	WebElement ordersHistory;
	
	
	public AccountPage() {
		this.action = new Action();
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateOrdersHistoryText() {
		String expectedText = "View your order history";
		String actualText = ordersHistory.getText();
		return expectedText.equals(actualText);
	}
		
	public boolean validateOrdersHistoryLink() {
		String expectedLink = "https://robomart.com/index.php?route=account/order";
		String actualLink = ordersHistory.getAttribute("href");
		return expectedLink.equals(actualLink);
	}
	
	public boolean validateOrdersSectionTitle() {
		String expectedTitle = "My Orders";
		String actualTitle = myOrdersTitle.getText();
		return expectedTitle.equals(actualTitle);
	}
	 
	
	
	public boolean validateAccountEditLink() {
		String expectedLink="https://robomart.com/index.php?route=account/edit";
		String actualLink = editAccountInformation.getAttribute("href");
		return expectedLink.equals(actualLink);
	}
	
	public boolean validateAccountEditText() {
		String expectedString="Edit your account information";
		String actualString = editAccountInformation.getText();
		return expectedString.equals(actualString);
	}
	
	public boolean validateAccountSectionTitle() {
		String expectedText = "My Account";
		String actualText = myAccountTitle.getText();
		return actualText.equals(expectedText);
	}
}
