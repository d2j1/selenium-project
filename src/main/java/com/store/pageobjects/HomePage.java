package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondriver.Action;
import com.store.base.BaseClass;

public class HomePage extends BaseClass{

	Action action ;
	
	@FindBy(xpath = "/html/body/div[4]/footer/div/div[3]/div/div[5]/div/div/div/ul/li/a/span")
	WebElement copyRight;
	
	@FindBy(xpath = "//*[@id=\"logo\"]/a/img")
	WebElement logo;
	
	@FindBy(xpath = "/html/body/div[4]/header/div[1]/div[2]/div[3]/div/div/ul/li[1]/a/span")
	WebElement accountSpan;
	
	@FindBy(xpath = "/html/body/div[4]/header/div[1]/div[2]/div[3]/div/div/ul/li[2]/a/span")
	WebElement logOutSpan;
	
	@FindBy(xpath = "//*[@id=\"search\"]/div/div/input")
	WebElement searchInput;
	
	@FindBy(xpath = "//*[@id=\"content-top\"]/div/div[2]/div/div[1]/div/div/div/div/h3")
	WebElement topProducts;
	
	@FindBy(xpath = "//*[@id=\"content-top\"]/div/div[2]/div/div[3]/div/div/div/div/h3")
	WebElement topCategories;
	
	
	public HomePage() {
		this.action = new Action();
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateCopyRightText(String copyRightText) {
		String actualText = copyRight.getText();
		return actualText.equals(copyRightText);
	}
	
	public boolean validateLogo() {
		return action.isDisplayed(getDriver(), logo);
	}
	
	public boolean validateAccountLoginText() {
		String accountText = "Account";
		String actualText = accountSpan.getText();
		return accountText.equals(actualText);
	}
	
	public boolean validateLogoutText() {
		String accountText = "Logout";
		String actualText = logOutSpan.getText();
		return accountText.equals(actualText);
	}
	
	public boolean validateSearchInput() {
		return action.isDisplayed(getDriver(), searchInput);
	}
	
	public boolean validateTopProducts() {
		String topProductText = "Our Top Products";
		String actualResult = topProducts.getText();
		return topProductText.equals(actualResult);
	}
	
	public boolean validateTopCategories() {
		String topCategoryText = "Our Top Categories";
		String actualResult = topCategories.getText();
		return topCategoryText.equals(actualResult);
	}
}
