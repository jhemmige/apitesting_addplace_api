package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith (Cucumber.class)
@CucumberOptions(
		//features="/Users/jayashreehemmige/eclipse-workspace/Cucumber_API_Framework_Following_Udemy_Course/src/test/java/Features/PlaceValidationRahulShetty.feature",
		
		features="/Users/jayashreehemmige/eclipse-workspace/Cucumber_API_Framework_Following_Udemy_Course/src/test/java/Features/PlaceValidation.feature",
		glue="StepDefinition",
		//tags= "@Deleteplaceapi", //Rahul Shettys code
		tags= "@Regression",
		//tags= "@DeletePlace",
		dryRun= false,
		monochrome=true,
		plugin= {"pretty","html:test-output","json:target/jsonReports/cucumber-report.json"}
		
		)
public class Cucumber_Api_TestRunnerTest {

}


//to run cucumber, we just needs to add tags to the faeture file

//for running the same test on cmd prompt, use-  mvn test -Dcucumber.options="--tags @DeletePlace"