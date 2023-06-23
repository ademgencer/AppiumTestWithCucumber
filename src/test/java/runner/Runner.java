package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/AppiumTestSenaryo.feature"},
        glue = {"stepdefs"},
        tags = ""
        //dryRun = true // stepdefs ler tanımlı mı diye bakar sadece.

)
public class Runner extends AbstractTestNGCucumberTests{// runnable olması için extend ettik

}
