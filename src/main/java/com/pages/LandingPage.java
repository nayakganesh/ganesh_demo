package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class LandingPage extends Utility 
{
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement searchBar;
	
	@FindBy(xpath="//span[normalize-space(text())='Texture']")
	private WebElement textureClick;
	
	@FindBy(xpath="//button[text()='ACCEPT ALL COOKIES']")
	private WebElement acceptCookiesButton;
	
	@FindBy(xpath="//div[@id='st_notification_modal']/iframe")
    private WebElement frame1;

    @FindBy(id="NC_CTA_TWO")
    private WebElement nothanksbutton;

    @FindBy(xpath="//*[@id='__st_fancy_popup']/iframe")
    private WebElement frame2;

    @FindBy(id="__st_bpn_no")
    private WebElement laterbutton;
    
    @FindBy(xpath="//img[@title = 'asian-paint-logo']")
    private WebElement asianpaintlogo;
    
    @FindBy(xpath="//h2[text()='Create your dream home with our painting experts']")
    WebElement textcheck;
	
	public LandingPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	} 
	
	public String validateLandingPageTitle()
	{
		return validatePageTitle(); 
	}
	
	public ProductListPage productListPageNavigation() throws IOException
	{
		searchBar.click(); 
		textureClick.click();
		return new ProductListPage();
	}
	
	public void acceptCookiesButtonValidation() throws IOException
	{
		acceptCookiesButton.click();
	}
	
	public void noThanksButton() throws IOException
    {
        driver.switchTo().frame(frame1);
        nothanksbutton.click();
        driver.switchTo().defaultContent();
    }

    public void laterButton() throws IOException
    {
        driver.switchTo().frame(frame2);
        laterbutton.click();
        driver.switchTo().defaultContent();
    }
    
    public boolean checkasianPaintLogo() throws IOException
    {
         return asianpaintlogo.isDisplayed();
    }
    
    public String verifyText()
    {
         return textcheck.getText();
    }
}
	


