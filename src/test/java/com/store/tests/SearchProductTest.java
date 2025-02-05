package com.store.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.base.BaseClass;
import com.store.pageobjects.HomePage;
import com.store.pageobjects.IndexPage;
import com.store.pageobjects.LoginPage;
import com.store.pageobjects.SearchResultPage;

public class SearchProductTest extends BaseClass{

	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchProduct;
	
	@BeforeMethod
	public void setup() {
		launchApp(prop.getProperty("browser"));
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
//	@Test
	public void validateSearchProductTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		searchProduct = indexPage.searchProduct("Wire");
		
		boolean validateProductSearchResults = searchProduct.validateProductSearchResults();
		
		Assert.assertTrue(validateProductSearchResults);
		
	}
	
//	@Test
	public void validateAddToCatTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		searchProduct = indexPage.searchProduct("Wire");
		boolean productsValidated = searchProduct.validateProductSearchResults();
		
		boolean productsAddedToCart = searchProduct.addProductsToCart();
		
		Assert.assertTrue(productsValidated);
		Assert.assertTrue(productsAddedToCart);
		
	}
	
	@Test
	public void validateGoToCartPageLinkTest() {
		
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchProduct = indexPage.searchResultPage();
		
		boolean result = searchProduct.validateGoToCartPageLink();
		Assert.assertTrue(result);
		
	}
	
}
