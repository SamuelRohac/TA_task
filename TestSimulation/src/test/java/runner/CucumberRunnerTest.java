package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)  // Indicates that JUnit should run the Cucumber tests
@CucumberOptions(
        features = "src/test/resources/features",   // Path to your .feature files
        glue = "steps",                             // Package containing step definitions
        plugin = {                                  // Plugins for reporting and console output
                "pretty",                           // Pretty console output
                "html:target/cucumber-reports.html",// HTML report
                "json:target/cucumber.json",        // JSON report
                "junit:target/cucumber.xml"         // JUnit XML report
        },
        monochrome = true                     // Makes console output readable
        
)
public class CucumberRunnerTest {
}
