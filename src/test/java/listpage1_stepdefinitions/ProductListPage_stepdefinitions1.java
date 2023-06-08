package listpage1_stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.pages.LandingPage;
import com.pages.ProductListPage;
import com.utility.Utility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.aventstack.extentreports.Status;

public class ProductListPage_stepdefinitions1 extends Utility{
	public LandingPage lp;
	public ProductListPage plp;
	public void objectMethod() throws IOException  {
        lp = new LandingPage();
        plp = new ProductListPage();
    }
	
	//Scenario 1
	@Given("Chrome is opened and Asian Paints app is opened")
	public void chrome_is_opened_and_asian_paints_app_is_opened() throws Exception {
		
		objectMethod();
		Utility.implicitWait();
		lp.noThanksButton();
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
        
        boolean logoCheck=lp.checkasianPaintLogo();
        assertTrue(logoCheck);
        System.out.println(logoCheck);
        
        String actualText = lp.verifyText();
        String expectedText = "Create your dream home with our painting experts";
        try {
            assertEquals(actualText, expectedText);
            logger.log(Status.PASS, "Step1 is passed for text");
            System.out.println(actualText);
            assert true;
        } catch (AssertionError e) {
         e.printStackTrace();
            logger.log(Status.FAIL, "Step1 is failed for text");
            captureScreenshotOnFailure();
            assert false;
        }
	}
	
	@When("User searches the product")
	public void user_searches_the_product() throws Exception {
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
	
	//Scenario 2
	@Then("Product List page fields are visible to the User")
	public void product_list_page_fields_are_visible_to_the_user() throws Exception {
		objectMethod();
		Utility.implicitWait();
		plp.scroll();
        plp.captureScreenshot(); 
        logger.log(Status.INFO, "Step4 is executed");
	}
	
	//Scenario 3
	// scrollForFilter() scrolls the page till the Filter By dropdown
	@When("User clicks on Filter By field")
	public void user_clicks_on_filter_by_field() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		Thread.sleep(2000);
		plp.scrollForFilter();
		plp.filterByValidation();
		 logger.log(Status.INFO, "Step5 is executed");
	}
	
	@When("Selects the options in Price")
	public void selects_the_options_in_price() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		Thread.sleep(2000);
		plp.selectPriceValidation();
		logger.log(Status.INFO, "Step6 is executed");
	}
	
	@When("User clicks on apply")
	public void user_clicks_on_apply() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		plp.scrollForFilter();
		Thread.sleep(4000);
		plp.applyButtonValidation();
		logger.log(Status.INFO, "Step7 is executed");
	}
	
	@Then("Application page shows the prioritized Product List")
	public void application_page_shows_the_prioritized_product_list() throws Exception {
		objectMethod();
		Thread.sleep(5000);
        plp.captureScreenshot(); 
        logger.log(Status.INFO, "Step8 is executed");
	}
	
}
