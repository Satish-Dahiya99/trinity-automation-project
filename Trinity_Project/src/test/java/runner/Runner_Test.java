package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/feature", glue = "stepDef", tags = "@Test1", monochrome = true, plugin = {"pretty", "html:target/cucumber-reports"})
public class Runner_Test extends AbstractTestNGCucumberTests {

}
