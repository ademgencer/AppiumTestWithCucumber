package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.App;
import utils.Device;
import utils.Driver;

import java.time.Duration;

public class BaseTest {

    protected AppiumDriver<?> driver;
    protected WebDriverWait wait;

    @BeforeTest
    public void beforeTest() {
        //driver = Driver.getDriver(Device.SAMSUNG_GALAXY_FAN, App.APIDEMOS);
        //wait = new WebDriverWait(driver,20);
    }

    @AfterTest
    public void afterTest() {
        driver.closeApp();
        driver.quit();
    }


    public void click(String text){
        click(textLocator(text));
    }

    public void sendKeys(By locator, CharSequence text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    public By xpathContainsText(String text){
        return By.xpath("//*[contains(@text, '" + text + "')]");
    }

    public By textLocator(String text){
        return By.xpath("//*[@text='" + text + "']");
    }

    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }


    public By xpathWithAttribute(String text){
        return xpathWithAttribute(text, 1);
    }

    public By xpathWithAttribute(String text, int index){
        return By.xpath("//*[@*[contains(.,'" + text + "')]][" + index + "]");
    }

    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Texti aranan element ekranda gözükene kadar swipe eder
     * @param text
     */
    public void swipeUntil(String text){
        while (driver.findElements(xpathContainsText(text)).size() == 0){
            swipeV(.7,.3);
        }
    }

    /**
     * swipeV(.7, .3) : ekranin %70'inden %30'una kadar dikey swipe eder
     * @param start swipe baslama orani, 0-1 arasinda long
     * @param end swipe bitis orani, 0-1 arasinda long
     */
    public void swipeV(double start, double end){
        int w = driver.manage().window().getSize().width;
        int h = driver.manage().window().getSize().height;

        start = Math.min(Math.max(0., start), 1.);
        end = Math.min(Math.max(0., end), 1.);

        int startPoint = (int) (start * h);
        int endPoint = (int) (end * h);

        new TouchAction<>(driver)
                .press(PointOption.point(w/2, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
                .moveTo(PointOption.point(w/2, endPoint))
                .release()
                .perform();
    }

    /**
     * swipeH(.7, .3) : ekranin %70'inden %30'una kadar yatay swipe eder
     * @param start swipe baslama orani, 0-1 arasinda long
     * @param end swipe bitis orani, 0-1 arasinda long
     */
    public void swipeH(double start, double end){
        int w = driver.manage().window().getSize().width;
        int h = driver.manage().window().getSize().height;

        start = Math.min(Math.max(0., start), 1.);
        end = Math.min(Math.max(0., end), 1.);

        int startPoint = (int) (start * w);
        int endPoint = (int) (end * w);

        new TouchAction<>(driver)
                .press(PointOption.point(startPoint, h/2))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
                .moveTo(PointOption.point( endPoint, h/2))
                .release()
                .perform();
    }

    public void waitFor(String...texts){
        wait.until(driver -> {
            for (String text : texts) {
                if (driver.findElements(xpathContainsText(text)).size()>0)
                    return true;
            }
            return false;
        });
    }
}
