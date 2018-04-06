package runner;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//tags={"@SanityTest, @RegressionTest"}
//tags={"@SanityTest", "@RegressionTest"}
//tags={"~@SanityTest, @RegressionTest"}



@RunWith(Cucumber.class)
@CucumberOptions(features = "features/TagExample.feature",
							glue={"steps"},
							monochrome=true,
							format={"json:results/cucumber.json"},
							tags={"@SanityTest, @RegressionTest"}
)

public class TagExample {

}
