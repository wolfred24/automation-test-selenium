package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)

@CucumberOptions (
	features = {"src/test/resources/FeatureFiles/"},
	glue = {"stepFiles", "hooks"},
	plugin = {"pretty",
			"json:reports/report.json",
			"junit:reports/report.xml"},
	publish = true,
	monochrome = true
	
)
public class MainRunner {

}
