package hepsiburada.locators;

import org.openqa.selenium.By;

public interface Locators {

    By lSearch = By.id("com.pozitron.hepsiburada:id/etSearchBox");

    By lHemenAl = By.xpath("//*[contains(@text,'Hemen Al')]");

    By lFavoriyeEkleButon = By.xpath("//*[@content-desc='favoriye ekle']");

    By lProductImage = By.id("com.pozitron.hepsiburada:id/productImage");

    By lProductImageZoom = By.id("com.pozitron.hepsiburada:id/zoomableImage");

    By lImageKapat = By.id("com.pozitron.hepsiburada:id/leftIcon");




}
