package com.store.tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.base.BaseClass;
import com.store.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass{

	IndexPage indexPage ;
	
	@BeforeMethod
	public void setup() {
		launchApp(prop.get("browser").toString());
	}
	
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	
	@Test
	public void verifyLogo() throws Throwable {
		 indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test
	public void verifyTitle() {
		String actualTitle = indexPage.getStoreTitle();
		String expectedTitle = "Raspberry Pi Products | Quadcopter KIT | Arduino Boards | Robomart";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
}
