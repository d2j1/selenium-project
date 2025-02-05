package com.store.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.base.BaseClass;
import com.store.pageobjects.CartPage;
import com.store.pageobjects.HomePage;
import com.store.pageobjects.IndexPage;
import com.store.pageobjects.LoginPage;
import com.store.pageobjects.SearchResultPage;

public class CartPageTest extends BaseClass{

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchProduct;
	CartPage cartPage;
	
	@BeforeMethod
	public void setup() {
		launchApp(prop.getProperty("browser"));
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	
	@Test
	public void validateCartPageSectionTitleTest() {
		
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchProduct = indexPage.searchResultPage();
		
		cartPage = searchProduct.goToCartPage();
		
		boolean result = cartPage.validateCartPageSectionTitle();
		
		Assert.assertTrue(result);
	}
	
	@Test
	public void validateCartTableTest() {
		
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchProduct = indexPage.searchResultPage();
		
		cartPage = searchProduct.goToCartPage();
		
		boolean result = cartPage.validateCartTable();
		
		Assert.assertTrue(result);
	}
	
	
	@Test
	public void validateProductsCountTest() {
		
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchProduct = indexPage.searchResultPage();
		
		cartPage = searchProduct.goToCartPage();
		
		boolean result = cartPage.validateTheProductsCount();
		
		Assert.assertTrue(result);
	}
	
	@Test
	public void validateTotalPriceTest() {
		
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchProduct = indexPage.searchResultPage();
		
		cartPage = searchProduct.goToCartPage();
		cartPage.validateTheProductsCount();
		boolean result = cartPage.validateTotalPrice();
		
		Assert.assertTrue(result);
	}
}
