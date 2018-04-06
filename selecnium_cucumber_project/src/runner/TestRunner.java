package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features = "features",
					glue={"steps"},
						monochrome=true,
							format={"json:results/cucumber.json"},
							dryRun=false
							 
)
public class TestRunner {
 
}

