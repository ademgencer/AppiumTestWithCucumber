package hepsiburada.stepdefs;

import hepsiburada.locators.Locators;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
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

import java.time.Duration;
import java.util.List;

public class MyStepdefs extends BaseTest implements Locators {
    @Given("Kullanıcı önceden uygulamaya SignIn olmuştur")
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
        //((AndroidDriver<?>)driver).pressKey(new KeyEvent(AndroidKey.SEARCH));// AppiumDriver ı AndroidDriver a Cast ederek extra
        // metotları kullanabiliriz, SEARCH çalışmıyor, ENTER arama çubuğundan ilk arama önerisine atlıyor, tekrar ENTER yapınca basıyor.
        click(xpathContainsTextByIndex("nutella", 1));// Arama önerilerinden ilkidir.
    }

    @And("Arama sonucu {string} gelen ilk ürüne tıklar")
    public void aramaSonucuGelenIlkÜrüneTıklar(String text) {
        click(xpathContainsTextByIndex(text, 1));// Arama sonuçlarından ilkidir.
    }

    @And("Ürünü favorilere ekle butonuna tıklar")
    public void ürünüFavorilereEkler() {
        click(lFavoriyeEkleButon);
    }

    @And("Çıkan login ekranından login olur")
    public void çıkanLoginEkranındanLoginOlur() {
        sendKeys(lEmailInput, "ademyasargencer@gmail.com");
        click(textLocatorByIndex("Giriş yap", 2));// 2.indexli buton
        pauseByActions(2000);
        sendKeys(lPasswordInput, "hepsiburada2202");// Todo: Github paylaşımında password silinecek.
        driver.hideKeyboard();// Klavyeyi gizler, butonu engellemesin diye.
        click(textLocatorByIndex("Giriş yap", 1));// 1.indexli buton
    }

    @And("Ekrandaki uyarı yazısında {string} butonuna tıklanır")
    public void ekrandakiUyarıYazısındaButonunaTıklanır(String text) {
        click(xpathContainsText(text));
        pauseByActions(2000);
    }

    @And("Çıkış yapılır")
    public void çıkışYapılır() {
        Driver.quit();
    }


    // Swipe yap, sepete ekle senaryosu:

    @And("Anasayfada {string} ürününü aratır")
    public void anasayfadaSekmesineTıklanır(String text) {
        click(lSearch);
        sendKeys(lSearch, text);
        click(xpathContainsTextByIndex(text, 2));
    }

    @And("Açılan sayfada {string} adında bir ürüne tıklar")
    public void açılanSayfadaBirÜrüneTıklar(String text) {
        click(xpathContainsTextByIndex(text, 2));
    }

    @And("Görsel üzerinde sağa doğru swipe yapılarak diğer resimlere geçilir")
    public void görselÜzerindeSağaDoğruSwipeYapılarakDiğerResmeGeçilir() {
        swipeHorizontal(.8, .2);
        pauseByActions(1000);// Görsel takip için kondu, pause leri silebiliriz.
        swipeHorizontal(.8, .2);
        pauseByActions(1000);
        swipeHorizontal(.8, .2);
        pauseByActions(1000);
        swipeHorizontal(.8, .2);
        pauseByActions(1000);
        swipeHorizontal(.8, .2);
        pauseByActions(1000);

    }

    @When("Kullanıcı {string} ekle butonuna tıklar")
    public void kullanıcıEkleButonunaTıklar(String text) {
        click(lSepeteEkleButon);
    }

    @And("{string} butonuna tıklar")
    public void butonunaTıklar(String text) {
        click(text);
        pauseByActions(8000);
    }

    @Then("Ürünün sepete eklendiği kontrol edilir")
    public void ürününSepeteEklendiğiKontrolEdilir() {
        // Todo: Assertion eklenecek.
    }
}
