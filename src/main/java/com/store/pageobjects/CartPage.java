package com.store.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondriver.Action;
import com.store.base.BaseClass;

public class CartPage extends BaseClass{
	
	Action action;
	List<WebElement> products;
	
	@FindBy(xpath = "//*[@id=\"content\"]/h1")
	WebElement cartPageSectionTitle;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/form/div/table")
	WebElement cartPageTable;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/form/div/table/tbody")
	WebElement cartPageTableBody;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[2]")
	WebElement cartSubTotal;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[2]/div[2]/a")
	WebElement orderButton;
	
	
	
	public CartPage() {
		this.action = new Action();
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateCartPageSectionTitle() {
		String expected = "Shopping Cart";
		String actual = cartPageSectionTitle.getText();
		
		return expected.equals(actual);
	}
	
	public boolean validateCartTable() {
		return action.isDisplayed(getDriver(), cartPageTable);
	}
	
	public boolean validateTheProductsCount() {
		products = cartPageTableBody.findElements(By.xpath("./tr"));
		
		if(products.size() > 0) {
			return true;
		}
		
		return false;
	}
	
	public boolean validateTotalPrice() {
		
		if( products.isEmpty()) {
			return false;
		}
		
		double expectedPrice = 0;
		
		for( WebElement element : products) {
			 WebElement priceElement = element.findElement(By.cssSelector("td.td-total"));
			 String priceText = priceElement.getText().replace("₹", "").trim();
			 double price = Double.parseDouble(priceText);
			 expectedPrice = expectedPrice + price;
			 
		}
		
		String totalPriceText = cartSubTotal.getText().replace("₹", "").trim().replace(",", "").trim();
		double actualTotalPrice = Double.parseDouble(totalPriceText);
		
		return actualTotalPrice == expectedPrice;
				
	}
	
	public OrderPage goToOrderPage() {
		action.click(getDriver(), orderButton);
		return new OrderPage();
	}

}
