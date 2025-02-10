package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "C:\\Users\\Arjun Joshi\\IdeaProjects\\BDDTestDemo\\src\\test\\resources\\myfeatures\\reqres.feature",
        glue = {"stepDefinitions"},
        tags = "@Smoke",
        plugin = {
                "pretty",
                "json:target/cucumber-reports/cucumber.json",  // Ensure JSON report is generated
                "html:target/cucumber-reports/index.html"
        },
        monochrome = true




)
public class TestRunner extends AbstractTestNGCucumberTests {

}
