package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BaseTest;
import utils.App;
import utils.Device;
import utils.Driver;

public class MyStepdefs extends BaseTest implements Locators {

    @Given("^user opens \"(APIDEMOS|CALCULATOR)\" on the phone \"(SAMSUNG_GALAXY_FAN|EMULATOR)\"$")
    public void userOpensOnThePhone(String app, String device) {
        driver = Driver.getDriver(Device.valueOf(device), App.valueOf(app));// Stepteki uygun girilen stringi enuma çevirerek alir
        //driver = Driver.getDriver(Device.SAMSUNG_GALAXY_FAN, App.APIDEMOS);// Direk enum olarak da alabiliriz.
        wait = new WebDriverWait(driver,20);

        By okButton = By.xpath("//*[@text='TAMAM']");// Appium da @text yazılır, selenyumda text() yazıyorduk.
        wait.until(ExpectedConditions.visibilityOfElementLocated(okButton)).click();// TAMAM buttona tıklar (dil eng ise OK çıkacaktır)

        By apiDemosLink = By.xpath("//*[@text='API Demos']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(apiDemosLink)).click();
    }

    @When("user clicks {string}")
    public void userClicks(String text) {
        swipeUntil(text);
        click(text);
    }

    @Then("{string} should be visible")
    public void shouldBeVisible(String text) {
        waitFor(text);
    }
}
