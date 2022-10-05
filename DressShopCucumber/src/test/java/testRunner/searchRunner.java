package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".//Features/Search.feature"},
		glue= {"StepDefinitions"},
		dryRun=false,
		plugin= {"pretty","html:target/cucumberOutput.html"},
		monochrome=true
			)

public class searchRunner {

}
