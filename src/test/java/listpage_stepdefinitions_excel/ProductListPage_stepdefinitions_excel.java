package listpage_stepdefinitions_excel;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import com.pages.LandingPage;
import com.pages.ProductListPage;
import com.pages.StoreLocatorPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;
 
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
 
import com.aventstack.extentreports.Status;
import com.utility.Config;
import com.utility.ExcelReader;
import com.utility.Utility;

public class ProductListPage_stepdefinitions_excel extends Utility{
	
	public LandingPage lp;
	public ProductListPage plp;
	public StoreLocatorPage slp;
	ExcelReader reader;
	
	public void objectMethod() throws IOException  {
        plp = new ProductListPage();
        lp = new LandingPage();
        slp = new StoreLocatorPage();
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
		        logger.log(Status.INFO, "Validating landing page title");
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
			
			@When("User fills the pincode from given sheetname {string} and rownumber {int}")
			public void user_fills_the_pincode_from_given_sheetname_and_rownumber(String sheetName, int rowNumber) throws IOException, InterruptedException, InvalidFormatException {
		        objectMethod();
		        Utility.implicitWait();
		        reader = new ExcelReader();
		        List<Map<String,String>> testData = reader.getData(Config.excelPath, sheetName);
		        Thread.sleep(1000);
		        String pincode = testData.get(rowNumber).get("pincode");
		        
		        plp.Pincode(pincode);
		        Thread.sleep(5000);
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
		        logger.log(Status.INFO, "Validating landing page title");
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
}
