package com.pages;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class StoreLocatorPage extends Utility{
	
	public StoreLocatorPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	} 
	
	public String validateStoreLocatorPageTitle() {
		Utility.navigateUsingWindowHandles();
		return validatePageTitle(); 
	}
}
