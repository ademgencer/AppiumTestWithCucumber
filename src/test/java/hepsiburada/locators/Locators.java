package hepsiburada.locators;

import org.openqa.selenium.By;

public interface Locators {

    By lSearch = By.id("com.pozitron.hepsiburada:id/etSearchBox");

    By lNutella = By.xpath("//*[contains(@text,'NUTELLA Kakaolu Fındık Kreması')]");

    By lFavoriyeEkleButon = By.xpath("//android.widget.ImageView[@content-desc=\"favoriye ekle\"]");

    By lProductImage = By.id("com.pozitron.hepsiburada:id/productImage");

    By lProductImageZoom = By.id("com.pozitron.hepsiburada:id/zoomableImage");

    By lImageKapat = By.id("com.pozitron.hepsiburada:id/leftIcon");

    By lEmailInput = By.className("android.widget.EditText");

    By lPasswordInput = By.className("android.widget.EditText");

    By lSepeteEkleButon = By.id("com.pozitron.hepsiburada:id/product_detail_add_to_cart_text");


}
