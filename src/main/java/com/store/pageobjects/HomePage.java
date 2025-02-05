package com.store.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.store.actiondriver.Action;
import com.store.base.BaseClass;

public class HomePage extends BaseClass{

	Action action ;
	
//	span[contains(text(),'Copyright © 2012-2023, RoboMart.com | A Unit of AP')]
	@FindBy(xpath = "//span[contains(text(),'Copyright © 2012-2023, RoboMart.com | A Unit of AP')]")
	public WebElement copyRight;
	
	
	@FindBy(xpath = "//img[@title='Robomart.com']")
	WebElement logo;
	
	@FindBy(xpath = "/html/body/div[4]/header/div[1]/div[2]/div[3]/div/div/ul/li[1]/a")
	WebElement accountLoggedInText;
	
	@FindBy(xpath = "/html/body/div[4]/header/div[1]/div[2]/div[3]/div/div/ul/li[2]/a/span")
	WebElement accountLogOutText;
	
	@FindBy(xpath = "//*[@id='search']/div/div/input")
	WebElement searchInput;
	
	@FindBy(xpath = "//*[@id=\"content-top\"]/div/div[2]/div/div[1]/div/div/div/div/h3")
	WebElement topProducts;
	
	@FindBy(xpath = "//*[@id=\"content-top\"]/div/div[2]/div/div[3]/div/div/div/div/h3")
	WebElement topCategories;
	
	
	public HomePage() {
		this.action = new Action();
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateCopyRightText() {

		String copyRightText = "Copyright © 2012-2023, RoboMart.com | A Unit of APS Innovations Pvt. Ltd.";
		String actualText = copyRight.getText();
//		String actualText = getDriver().findElement(By.xpath("/html/body/div[4]/footer/div/div[3]/div/div[5]/div/div/div/ul/li/a/span")).getText();
		return actualText.equals(copyRightText);
	}
	
	public boolean validateLogo() {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(logo));
//		return logo.isDisplayed();
		return action.isDisplayed(getDriver(), logo);
	}
	
	public boolean validateAccountLoginText() {
//		getDriver().navigate().refresh();
		action.implicitWait(getDriver(), 5);
		String accountText = "Account";
		String actualText = accountLoggedInText.getText();
//		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+actualText);
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
	
	public String getCurrentUrl() {
		return getDriver().getCurrentUrl(); 
	}
}
