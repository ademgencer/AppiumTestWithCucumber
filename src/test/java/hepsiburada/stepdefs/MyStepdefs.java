package hepsiburada.stepdefs;

import hepsiburada.locators.Locators;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BaseTest;
import utils.App;
import utils.Device;
import utils.Driver;

import java.util.List;

public class MyStepdefs extends BaseTest implements Locators {
    @Given("Kullanıcı öncesinde uygulamaya login olmuştur")
    public void kullanıcıÖncesindeUygulamayaLoginOlmuştur() {
    }

    @When("Kullanıcı {string} cihazında {string} uygulamasina girer")
    public void kullanıcıCihazındaUygulamayaGirer(String device, String app) {
        driver = Driver.getDriver(Device.valueOf(device), App.valueOf(app));
        wait = new WebDriverWait(driver, 10);

    }

    // Favoriye ekle senaryosu:

    @And("Anasayfada {string} aratır")
    public void anasayfadaAratır(String text) {
        click(lSearch);
        sendKeys(lSearch, text);
        click(xpathContainsTextByIndex(text,2));
        pauseByActions(2000);

    }

    @And("Çıkan sonuclardan {string} metinli ürünü favorilere ekler")
    public void çıkanSonuclardanMetinliÜrünüFavorilereEkler(String text) {
        swipeVertical(.7,.3);
        swipeUntil(text);
        click(lHemenAl);
        click(lFavoriyeEkleButon);
    }

    @And("Listelerim sekmesinden favoriler butonuna tıklar")
    public void listelerimSekmesindenFavorilerButonunaTıklar() {

    }

    @Then("Favorilere eklendiğini kontrol eder")
    public void favorilereEklendiğiniKontrolEder() {

    }


    // Swipe yap senaryosu:

    @And("Anasayfada {string} sekmesine tıklanır")
    public void anasayfadaSekmesineTıklanır(String text) {
        click(xpathContainsContentDesc(text));
    }

    @And("Elektronik sayfasından bir ürün grubuna tıklar")
    public void elektronikSayfasındanBirÜrüneTıklar() {
        click(xpathContainsContentDesc("Seçili Apple Ürünlerinde"));
        pauseByActions(2000);
        /*
        swipeVertical(.7,.3);
        pauseByActions(2000);
        swipeVertical(.3,.7);
        pauseByActions(2000);
        swipeVertical(.4,.6);

         */
    }

    @And("Açılan sayfada bir ürüne tıklar")
    public void açılanSayfadaBirÜrüneTıklar() {
        //click(xpathWithAttribute("iPhone 11"));
        //By lIPhone11 = By.xpath("//*[@*[contains(.,'iPhone 11')]]");
        By lIPhone11_withText = By.xpath("//*[contains(@text,'iPhone 11')]");
        //driver.findElement(lIPhone11_withText).click();
        //click(lIPhone11_withText);
        //click(xpathContainsText("iPhone 11"));
        click(xpathContainsText("Hemen Al")); // ?
    }

    @And("Ürün görseline tıklar")
    public void ürünGörselineTıklar() {
        click(lProductImage);
    }

    @And("Görsel üzerinde sağa doğru swipe yapılarak diğer resme geçilir")
    public void görselÜzerindeSağaDoğruSwipeYapılarakDiğerResmeGeçilir() {
        wait.until(ExpectedConditions.elementToBeClickable(lProductImageZoom));
        swipeHorizontal(.8, .2);
    }

    @And("Görsel kapatılır")
    public void görselKapatılır() {
        pauseByActions(2000);
        click(lImageKapat);
    }


}
