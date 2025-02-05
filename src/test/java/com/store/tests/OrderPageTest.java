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
import com.store.pageobjects.OrderPage;
import com.store.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass{

	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchProduct;
	CartPage cartPage;
	OrderPage orderPage;
	
	@BeforeMethod
	public void setup() {
		launchApp(prop.getProperty("browser"));
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void validateSectionTitleTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchProduct = indexPage.searchResultPage();
		
		cartPage = searchProduct.goToCartPage();
		orderPage = cartPage.goToOrderPage();
		
		boolean result = orderPage.validateSectionTitle();
		
		Assert.assertTrue(result);
		
	}
	
	@Test
	public void validateCheckoutOptionsDisplayedTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchProduct = indexPage.searchResultPage();
		
		cartPage = searchProduct.goToCartPage();
		orderPage = cartPage.goToOrderPage();
		
		boolean result = orderPage.validateCheckoutOptionsDisplayed();
		
		Assert.assertTrue(result);
		
	}
	
	@Test
	public void validateBillingDetailsDisplayedTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchProduct = indexPage.searchResultPage();
		
		cartPage = searchProduct.goToCartPage();
		orderPage = cartPage.goToOrderPage();
		
		boolean result = orderPage.validateBillingDetailsDisplayed();
		
		Assert.assertTrue(result);
		
	}
	
	@Test
	public void validatefillDeliveryDetailsTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchProduct = indexPage.searchResultPage();
		
		cartPage = searchProduct.goToCartPage();
		orderPage = cartPage.goToOrderPage();
		
		boolean result = orderPage.fillDeliveryDetails();
		
		Assert.assertTrue(result);
		
	}
	
//	@Test
	public void validateDeliveryMethodSectionVisibleTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchProduct = indexPage.searchResultPage();
		
		cartPage = searchProduct.goToCartPage();
		orderPage = cartPage.goToOrderPage();
		
		boolean test = orderPage.selectAddressAndContinue();
		
		System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvv"+test);
		
		boolean result = orderPage.validateDeliveryMethodSectionVisible();
		
		Assert.assertTrue(result);
		
	}
}
