package listpage2_stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import com.aventstack.extentreports.Status;
import com.pages.LandingPage;
import com.pages.ProductListPage;
import com.pages.StoreLocatorPage;
import com.utility.Utility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductListPage_stepdefinitions2 extends Utility{
	public LandingPage lp; //Reference that can hold the object of LandingPage class
	public ProductListPage plp; //Reference that can hold the object of ProductListPage class
	public StoreLocatorPage slp; //Reference that can hold the object of StoreLocatorPage class
	
	public void objectMethod() throws IOException  {
        plp = new ProductListPage(); //Instance of LandingPage class
        lp = new LandingPage(); //Instance of ProductListPage class
        slp = new StoreLocatorPage(); //Instance of StoreLocatorPage class
    }
	
	//Scenario Outline 1
	@Given("Chrome is opened and Asian Paints app is opened")
	public void chrome_is_opened_and_asian_paints_app_is_opened() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		lp.noThanksButton();
		Utility.implicitWait();
		lp.laterButton();
		lp.acceptCookiesButtonValidation();
		
        logger = report.createTest("test01");
        logger.log(Status.INFO, "Validating landing page title");

        String actualTitle = lp.validateLandingPageTitle();
        String expectedTitle = "Trusted Wall Painting, Home Painting & Waterproofing in India - Asian Paints";
        
        try {
            assertEquals(actualTitle, expectedTitle);
            logger.log(Status.PASS, "Step1 is passed");
            System.out.println(actualTitle);
            assert true;
        } catch (AssertionError e) {
         e.printStackTrace();
            logger.log(Status.FAIL, "Step1 is failed");
            captureScreenshotOnFailure();
            assert false;
        } 
	}
	
	@When("User searches the product")
	public void user_searches_the_product() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		lp.productListPageNavigation();
		logger.log(Status.INFO, "Step2 is executed");
	}
	
	@Then("User navigates to the Product List page")
	public void user_navigates_to_the_product_list_page() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		logger = report.createTest("test02");
        logger.log(Status.INFO, "Validating product list page title");
        String actualTitle = plp.validateProductListPageTitle();
        String expectedTitle = "Interior Wall Texture Designs, Modern Texture Paint Designs & Catalogue - Asian Paints"; 
        
        try {
            assertEquals(actualTitle, expectedTitle);
            logger.log(Status.PASS, "Step3 is passed");
            System.out.println(actualTitle);
            assert true;
        } catch (AssertionError e) {
         e.printStackTrace();
            logger.log(Status.FAIL, "Step3 is failed");
            captureScreenshotOnFailure();
            assert false;
        } 
	}
	
	@When("User enters Pincode {string}")
	public void user_enters_pincode(String string) throws IOException, InterruptedException {
		plp.fullPageScroll();
		Utility.implicitWait();
		plp.storePincode();
		plp.Pincode(string);
		logger.log(Status.INFO, "Step4 is executed");
	}
	
	@When("User clicks on Go button")
	public void user_clicks_on_go_button() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		plp.fullPageScroll();
		//Thread.sleep(2000);
		plp.goButtonValidation();
		logger.log(Status.INFO, "Step5 is executed");
	}
	
	@Then("Application shows the stores near you")
	public void application_shows_the_stores_near_you() throws Exception {
		objectMethod();
		Utility.implicitWait(); 
	    logger = report.createTest("test03");
        logger.log(Status.INFO, "Validating store locator page title");
        String actualTitle = slp.validateStoreLocatorPageTitle();
	    String expectedTitle = "Store Locator: Design Solutions for a Beautiful Home Makeover - Asian Paints";
        try {
            assertEquals(actualTitle, expectedTitle);
            logger.log(Status.PASS, "Step6 is passed");
            System.out.println(actualTitle);
            assert true;
        } catch (AssertionError e) {
         e.printStackTrace();
            logger.log(Status.FAIL, "Step6 is failed");
            captureScreenshotOnFailure();
            assert false;
        } 
	    slp.captureScreenshot();
	}
	
	//Scenario Outline 2
	@Then("Application displays a message to enter a valid Zip Code")
	public void application_displays_a_message_to_enter_a_valid_zip_code() throws Exception {
		objectMethod();
		Utility.implicitWait();
	    plp.captureScreenshot();
	    
	    String text = plp.textCapture();
        System.out.println(text);
	    logger.log(Status.INFO, "Step7 is executed");
	}
	
}
