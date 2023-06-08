package testrunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/resources/features/ListPage1.feature"},
        glue = {"listpage1_stepdefinitions","apphooks"},
                 plugin= {"pretty" ,
                         "html:cucumber-report/cucumber",
                         "json:cucumber-report/cucumber.json",
                          "junit:cucumber-report/cucumber.xml"}
        //dryRun=true
        )

public class TestRunner_ProductListPage1 extends AbstractTestNGCucumberTests{

}