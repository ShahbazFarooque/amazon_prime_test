package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/featurefiles",
		glue = {"stepdefinition","apphooks"},
		monochrome = true,
		//tags = "@latestMovieDesc",
				plugin = { "pretty", "html:target/html_reports.html",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)



public class AppRunner {
	
}
