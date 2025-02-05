package com.store.tests;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.base.BaseClass;
import com.store.pageobjects.HomePage;
import com.store.pageobjects.IndexPage;
import com.store.pageobjects.LoginPage;

public class HomePageTest extends BaseClass{

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setup() {
		launchApp(prop.getProperty("browser"));
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	
	@Test
	public void validateUrl() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		System.out.println( homePage.getCurrentUrl());
		
	}
	
	@Test
	public void validateCopyRightTextTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	    WebElement copyRightText = wait.until(ExpectedConditions.visibilityOf(homePage.copyRight));
	    
		boolean actualResult = homePage.validateCopyRightText();
		Assert.assertTrue(actualResult);
	}
	
	@Test
	public void validateLogoTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean actualResult = homePage.validateLogo();		
		Assert.assertTrue(actualResult);
	}
	
	@Test
	public void validateAccountLoginTextTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean actualResult = homePage.validateAccountLoginText();		
		Assert.assertTrue(actualResult);
	}
	
	@Test
	public void validateAccountLogoutTextTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean actualResult = homePage.validateLogoutText();		
		Assert.assertTrue(actualResult);
	}
	
	@Test
	public void validateSearchInputTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean actualResult = homePage.validateSearchInput();		
		Assert.assertTrue(actualResult);
	}
	
	@Test
	public void validateTopProductsTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean actualResult = homePage.validateTopProducts();		
		Assert.assertTrue(actualResult);
	}
	
	@Test
	public void validateTopCategoriesTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean actualResult = homePage.validateTopCategories();		
		Assert.assertTrue(actualResult);
	}
}
