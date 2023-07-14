package hepsiburada.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/hepsiburada/features/hepsiburada.feature"},
        glue = {"hepsiburada/stepdefs"},
        tags = "@swipeyap"
        //dryRun = true // stepdefs ler tanımlı mı diye bakar sadece.

)
public class RunnerHB extends AbstractTestNGCucumberTests{

}
