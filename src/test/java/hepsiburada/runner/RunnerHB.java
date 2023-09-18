package hepsiburada.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/hepsiburada/features/hepsiburada.feature"},
        glue = {"hepsiburada/stepdefs"},
        //tags = "@FavoriyeEkle"
        tags = "@SwipeYapSepeteEkle",
        //dryRun = true // stepdefs ler tanımlı mı diye bakar sadece.
        plugin = {"pretty",
        "json:test-output/cucumber-reports/cucumber.json",
        "html:test-output/cucumber-reports/cucumber.html",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        // todo: plugin'leri CucumberOptions, resources ve pom.xml e
        //  ekledikten sonra rapor almayı deneyeceğim!
        //  Raporlara SS eklemek için Hook Class kullanılacak!
        //  Tüm bunları moneyPayApp. projesinde başarıyla çalıştırdım, oraya bak!

)
public class RunnerHB extends AbstractTestNGCucumberTests{

}
