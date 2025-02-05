package com.store.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.base.BaseClass;
import com.store.pageobjects.HomePage;
import com.store.pageobjects.IndexPage;
import com.store.pageobjects.LoginPage;

public class LoginTest extends BaseClass{

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	
	@BeforeMethod
	public void setup() {
		launchApp(prop.get("browser").toString());
	}
	
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void loginTestUsingURL() {
		indexPage = new IndexPage();
		loginPage = new LoginPage();
	
			indexPage.clickOnSignIn();
		

			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password") );
		
		String actualUrl = homePage.getCurrentUrl();
		String expectedUrl = "https://robomart.com/";
		Assert.assertEquals(actualUrl, expectedUrl);
		
	}
	
	@Test
	public void loginTestLogOutButton() {
		indexPage = new IndexPage();
		loginPage = new LoginPage();
	
			indexPage.clickOnSignIn();
		

			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password") );
		
		boolean result = homePage.validateLogoutText();

		Assert.assertTrue(result);
		
	}
	
}
