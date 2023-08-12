package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {

    private static AppiumDriverLocalService service;
    private static AppiumDriver<?> driver;


    private static void startAppium(){
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .build();
        service.clearOutPutStreams();
        service.start();
    }


    public static AppiumDriver<?> getDriver(Device device, App app){
        if (driver == null) {
            startAppium();
            String apkPath = "src/test/resources/";// Apk nın olduğu adres
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:udid", device.getUdid());// Zorunlu -> Her cihazın üretimden gelen unique id sidir.
            // udid: unique device id
            caps.setCapability("appium:version", device.getVersion());
            caps.setCapability("appium:deviceName", device.getDeviceName());
            caps.setCapability("platformName", device.getPlatformName());// Zorunlu
            if (app.app.length()>0) // Application ın apk dosyası ver mı ?
                caps.setCapability("appium:app", apkPath + app.app);// Apk sı varsa adresi budur
            // appium:app -> Test edilecek App in baslangicta kurulması gereken apk dosyası varsa adresini burada veriyoruz.

            caps.setCapability("appium:appPackage", app.getAppPackage());// App in başlatıldığı dosyanın package ıdır
            caps.setCapability("appium:appActivity", app.getAppActivity());// App in başlatıldığğı appPackage taki startUp dosyasıdır
            // Main metodunun bulunduğu main class ve içinde bulunduğu package gibi düşünebiliriz

            driver = new AndroidDriver<>(service.getUrl(), caps);
        }
        return driver;
    }

    public static void quit(){
        driver.quit();
        service.stop();
    }


}
