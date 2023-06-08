package com.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class ProductListPage extends Utility{
	
	@FindBy(xpath="//*[text()='FILTER BY']")
	private WebElement filterBy;
	
	@FindBy(xpath="(//*[text()='luxury'])[2]")
	private WebElement selectPrice;
	
	@FindBy(xpath="//span[text()='APPLY']")
	private WebElement applyButton;
	
	@FindBy(xpath="//input[@id='storePincode']")
	private WebElement storePincode;
	
	@FindBy(xpath="//button[text()='Go']")
	private WebElement goButton;
	
	@FindBy(xpath="//div[text()='Enter a valid 6 digit Zip Code']")
	private WebElement invalidMessageCheck;
	

	public ProductListPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	} 
	
	public String validateProductListPageTitle() {
		return validatePageTitle(); 
	}
	
	public void filterByValidation() throws IOException
	{
		filterBy.click();
	}
	
	public void selectPriceValidation() throws IOException
	{
		selectPrice.click();
	}
	
	public void applyButtonValidation() throws IOException
	{
		applyButton.click();
	}
	
	public void storePincode() throws IOException
	{
		storePincode.click();
	}
	
	public void Pincode(String str) throws IOException
	{
		storePincode.sendKeys(str);
	}
	
	public StoreLocatorPage goButtonValidation() throws IOException
	{
		goButton.click();
		return new StoreLocatorPage();
	}
	
	public void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,250)");
    }
	
	public void scrollForFilter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,100)");
    }
	
	public void fullPageScroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
	
	public String textCapture()
    {
         return invalidMessageCheck.getText();
    }
	
}
