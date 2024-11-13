package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondriver.Action;
import com.store.base.BaseClass;

public class IndexPage extends BaseClass {
	
	private Action action;
	
	@FindBy(xpath = "//img[@title='Robomart.com']")
	WebElement logo;
		
	@FindBy(xpath = "//div[@class='top-menu top-menu-240']//ul[@class='j-menu']//li[@class='menu-item top-menu-item top-menu-item-1']//a[@href='javascript:open_login_popup()']") 
	private WebElement signInBtn;
		
	@FindBy(xpath = "/html/body/div[10]/div[1]/div/div/iframe")
	WebElement loginIFrame ;
	
	@FindBy(className = "search-input")
	private WebElement searchProductBox;
	
	@FindBy(className = "search-button")
	private WebElement searchButton;
	
	@FindBy(xpath = "//div[@class='top-menu top-menu-240']//ul[@class='j-menu']//li[@class='menu-item top-menu-item top-menu-item-2']//a[@href='javascript:open_register_popup()']")
	WebElement registerBtn;
	
	@FindBy(xpath = "/html/body/div[10]/div[1]/div/div/iframe")
	WebElement registerIFrame;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
		this.action = new Action();
	}
	
	public LoginPage clickOnSignIn() throws Throwable {
		action.fluentWait(getDriver(), signInBtn, 10);
		action.click(getDriver(), signInBtn);
		action.switchToFrameByWebElement(getDriver(), loginIFrame);
		action.implicitWait(getDriver(), 5);
		return new LoginPage();
	}
	
	public boolean validateLogo() throws Throwable {
		return action.isDisplayed(getDriver(), logo);
	}
	
	public String getStoreTitle() {
		String myStoreTitel=getDriver().getTitle();
		return myStoreTitel;
	}
	
	public SearchResultPage searchProduct(String productName) throws Throwable {
		action.type(searchProductBox, productName);
		action.scrollByVisibilityOfElement(getDriver(), searchButton);
		action.click(getDriver(), searchButton);
		Thread.sleep(3000);
		return new SearchResultPage();
	}
	
	public RegisterUserPage clickOnRegister() throws Throwable {
		action.fluentWait(getDriver(), registerBtn, 10);
		action.click(getDriver(), registerBtn);
		action.switchToFrameByWebElement(getDriver(), registerIFrame);
		action.implicitWait(getDriver(), 5);
		return new RegisterUserPage();
	}

}