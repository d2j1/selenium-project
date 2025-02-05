package com.store.pageobjects;



import java.security.cert.X509Certificate;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.store.actiondriver.Action;
import com.store.base.BaseClass;

public class OrderPage extends BaseClass{

	
	Action action;
	
	public OrderPage() {
		this.action = new Action();
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//*[@id=\"content\"]/h1")
	WebElement checkoutPageSectionTitle;
	
	@FindBy(xpath = "//*[@id=\"accordion\"]/div[1]/div[1]/h4/a")
	WebElement checkOutOptionsLink;
	                 //*[@id="accordion"]/div[2]/div[1]/h4/a
	@FindBy(xpath = "//*[@id='accordion']/div[2]/div[1]/h4/a")
	WebElement billingDetails;

	@FindBy(xpath = "//*[@id=\"payment-existing\"]/div/div/div/div/button")
	WebElement addAddressBtn;
	
	@FindBy(xpath = "//*[@id=\"newAddress\"]/div/div")
	WebElement addressWindow;
	
	@FindBy(xpath = "//*[@id=\"new-address-firstname\"]")
	WebElement firstName;
	
	@FindBy(xpath = "//*[@id=\"new-address-lastname\"]")
	WebElement lastName;

	@FindBy(xpath = "//*[@id=\"new-address-address_1\"]")
	WebElement address;
	
	@FindBy(xpath = "//*[@id=\"new-address-city\"]")
	WebElement city;
	
	@FindBy(xpath = "//*[@id=\"new-address-postcode\"]")
	WebElement postCode;
	
	@FindBy(xpath = "//*[@id=\"new-address-country_id\"]")
	WebElement selectCountry;
	
	@FindBy(xpath = "//*[@id=\"new-address-zone_id\"]")
	WebElement selectState;
	
	@FindBy(xpath = "//*[@id=\"new-address-mobile_no_country_code\"]")
	WebElement selectMobileCountryCode;
	
	@FindBy(xpath = "//*[@id=\"new-address-mobile_no\"]")
	WebElement mobileNoInput;
	
	@FindBy(xpath = "//*[@id=\"btn-newAddress\"]")
	WebElement submitDeliveryDetailsBtn;
	
	@FindBy(xpath = "submitDeliveryDetailsBtn")
	WebElement closeDeliveryDetailsWindowBtn;
	
	@FindBy(xpath = "//button[@id='button-shipping-address']")
	WebElement selectAddressContinueBtn;
	
	@FindBy(xpath = "//*[@id='accordion']/div[3]/div[1]/h4/a")
	WebElement deliveryMethodSection;
	
	
	@FindBy(xpath = "//*[@id=\"collapse-shipping-method\"]/div/div[1]/label/input")
	WebElement deliverRadioBtn;
	
	@FindBy(xpath = "//*[@id=\"collapse-shipping-method\"]/div/div[2]/label/input")
	WebElement PickUpRadioBtn;
	
	@FindBy(xpath = "//*[@id=\"button-shipping-method\"]")
	WebElement deliveryContinueBtn;
	
	@FindBy(xpath = "//*[@id=\"accordion\"]/div[5]/div[1]/h4/a")
	WebElement paymentOptionSection;
	
	@FindBy(xpath = "//*[@id=\"collapse-payment-method\"]/div/div[1]/label/input")
	WebElement payByRazorPayRadioBtn;
	
	@FindBy(xpath = "//*[@id=\"collapse-payment-method\"]/div/div[2]/label/input")
	WebElement payByBankTransferRadioBtn;
	
	@FindBy(xpath = "//*[@id=\"button-payment-method\"]")
	WebElement paymentContinueBtn;
	
	@FindBy(xpath = "//*[@id=\"accordion\"]/div[6]/div[1]/h4/a")
	WebElement confirmOrderSection;
	
	@FindBy(xpath = "//*[@id=\"collapse-checkout-confirm\"]/div/div[2]/div/input")
	WebElement confirmOrderBtn;
	
	
	public boolean validateSectionTitle() {
		String expectedText = "Checkout";
		String actualText=checkoutPageSectionTitle.getText();
		
		return expectedText.equals(actualText);
	}
	
	public boolean validateCheckoutOptionsDisplayed(){
		return action.isDisplayed(getDriver(), checkOutOptionsLink);
	}
	
	public boolean validateBillingDetailsDisplayed(){
		return action.isDisplayed(getDriver(), billingDetails);
	}
	
	
	public boolean fillDeliveryDetails() {
		action.click(getDriver(), billingDetails);
		action.implicitWait(getDriver(), 5);
		action.click(getDriver(), addAddressBtn);
		
		if(!validateBillingDetailsDisplayed() ) {
			return false;
		}
		
		action.click(getDriver(), addAddressBtn);
		
		if(!validateAddAddressWindow()) {
			return false;
		}
		
		action.type(firstName, "Sagar");
		action.type(lastName, "Malhora");
		action.type(address, "23, 1st Cross Road, Kadubissanahalli-varthur road, Kadubissanahalli, 560018");
		action.type(city, "Bengaluru");
		action.type(postCode, "560018");
		action.selectByVisibleText(selectCountry, "India");
		action.selectByVisibleText(selectState, "Karnataka");
		action.selectByVisibleText(selectMobileCountryCode, "91 India");
		action.type(mobileNoInput, "6234567892");
		
		action.click(getDriver(), submitDeliveryDetailsBtn);
		
		return true;
	}
	
	public boolean validateAddAddressWindow() {
		return action.isDisplayed(getDriver(), addressWindow);
	}
	
	public void closeAddressFormWindowImmaturely() {
		action.click(  getDriver(),closeDeliveryDetailsWindowBtn);
	}
	
	public boolean  selectAddressAndContinue() {
		
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        // Locate the button
		
        WebElement continueButtons = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='accordion']/div[2]/div[1]/h4/a")));
        
		String isExpanded = billingDetails.getAttribute("aria-expanded");
		if(isExpanded.equals("false")) {
			return false;
		}
			
		action.implicitWait(getDriver(), 5);
//		action.click(getDriver(), selectAddressContinueBtn);
		
//		System.out.println("tttttttttttttttttttttt"+billingDetails.getAttribute("aria-expanded"));
		
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
		WebElement tempp = getDriver().findElement(By.id("button-payment-address"));
//		System.out.println("tttttttttttttttttttttt"+tempp.getText());
		
		tempp.click();
		
//		System.out.println("tttttttttttttttttttttt"+selectAddressContinueBtn.getText());
		
//		WebDriverWait wait2 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//		WebElement selectAddressContinueBtn = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"button-shipping-address\"]")));
//		selectAddressContinueBtn.click();
		
//		System.out.print("qqqqqqqqqqqqqqqqqqqqqqqqqq");
		action.implicitWait(getDriver(), 5);
		return true;
	}
	
	public boolean validateDeliveryMethodSectionVisible() {
		
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		
        WebElement continueButtons = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='accordion']/div[3]/div[1]/h4/a")));
        
//		String isExpanded =   deliveryMethodSection.getAttribute("aria-expanded");
        WebElement isExpandedEle = getDriver().findElement(By.xpath("//*[@id='accordion']/div[3]/div[1]/h4/a"));
        String isExpanded = isExpandedEle.getText();
		if( isExpanded.equals("true")) {
			return true;
		}else
		{ return false;
	}
	
	}
	
	public boolean validateDeliveryOptionSelectedByDefault() {
		String checked = deliverRadioBtn.getAttribute("checked");
		return checked.equals("checked");
	}
	
	public boolean validatePickUpOptionNotSelectedByDefault() {
		String checked = PickUpRadioBtn.getAttribute("checked");
		
		if(checked.equals("checked")) {
			return false;
		}else {
			return true;
		}
	}
	
	
	
	public void selectDeliveryMethodAndContinue() {
			action.click(getDriver(), deliveryContinueBtn);
			action.implicitWait(getDriver(), 5);
	}
	
	public boolean validatePaymentOptionsSectionVisible() {
		String isVisible = paymentOptionSection.getAttribute("aria-expanded");
		return isVisible.equals("true");
	}
	
	public boolean validateRazorPayPaymentOptionSelectedByDefault() {
		String checked = payByRazorPayRadioBtn.getAttribute("checked");
		return checked.equals("checked");
	}
	
	public boolean validateBankTransferPaymentOptionNotSelectedByDefault() {
		String checked = payByBankTransferRadioBtn.getAttribute("checked");
		
		if(checked.equals("checked")) {
			return false;
		}else {
			return true;
		}
	}
	
	public void continueWithPayment() {
		
		action.click(getDriver(), paymentContinueBtn);
	}
	
	public boolean validateConfirmOrderSectionVisible() {
		String isVisible =   confirmOrderSection.getAttribute("aria-expanded");
		return isVisible.equals("true");
	}
	
	public void confirmOrder() {
		action.click(getDriver(), confirmOrderBtn);
		action.implicitWait(getDriver(), 5);
	}
	
	
}
