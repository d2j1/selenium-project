package com.store.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondriver.Action;
import com.store.base.BaseClass;

public class SearchResultPage extends BaseClass{

	Action action;
	List<WebElement> products;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[2]")
	WebElement searchedProductList;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[2]/div[2]/div/div[2]/div[6]/div/div/a/span")
	WebElement addToCartButton;
	
	@FindBy(xpath = "//*[@id=\"cart\"]/a")
	WebElement goToCartButton;
	
	
	public SearchResultPage() {
		this.action = new Action();
		PageFactory.initElements(getDriver(), this);
	}

	
	
	public boolean validateProductSearchResults() {
		
		
		products = searchedProductList.findElements(By.xpath("./div"));
		
		if( products.size() > 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean addProductsToCart() {
		
		if(products.size() <= 1) {
			return false;
		}
		
		WebElement element;
		
		for( int i =1; i < products.size(); i++) {
			
			element = products.get(i);
			WebElement addToCartBtn ;
		
			try {
				
//				addToCartBtn = element.findElement(By.xpath("//*[@id=\\\"content\\\"]/div[3]/div[2]/div[2]/div/div[2]/div[6]/div/div/a/span"));
				addToCartBtn = element.findElement(By.xpath(".//a[contains(@class, 'add-to-cart') or contains(@class, 'add-to-cart-btn') or .//span[text()='Add to Cart']]"));

				addToCartBtn.click();
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	public boolean validateGoToCartPageLink() {
		String expectedLink = "https://robomart.com/index.php?route=checkout/cart";
		String actualLink = goToCartButton.getAttribute("href");
		return expectedLink.equals(actualLink);
	}
	
	public CartPage goToCartPage() {
		action.click(getDriver(), goToCartButton);
		return new CartPage();
	}
}
