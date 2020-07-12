package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/java/feature/Leads.feature",glue="stepDef",monochrome=true)

public class RunSteps extends AbstractTestNGCucumberTests{

}
