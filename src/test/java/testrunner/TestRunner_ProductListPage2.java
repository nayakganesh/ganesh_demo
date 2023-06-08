package testrunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/resources/features/ListPage2.feature"},
        glue = {"listpage2_stepdefinitions","apphooks"},
                 plugin= {"pretty" ,
                		 "html:cucumber-report/cucumber",
                         "json:cucumber-report/cucumber.json",
                          "junit:cucumber-report/cucumber.xml"}
        //dryRun=true
        )

public class TestRunner_ProductListPage2 extends AbstractTestNGCucumberTests{

}
