package Beymen.PageObjects;

import Beymen.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Beymen.utils.PageActions.price1;

public class CartPage extends BaseClass {

    private static String cartPrice = "m-productPrice__salePrice" ;

    private static String prdSelect = "quantitySelect0-key-0" ;


    public static void comparePrices() {
        // Sepetteki fiyat bilgisi
        WebElement cartPriceElement = driver.findElement(By.className(cartPrice));
        String price2 = cartPriceElement.getText();

        // fiyat karşılaştırması
        assert price1.equals(price2) : "Ürün sayfasındaki fiyat ile sepetteki fiyat eşleşmiyor.";
    }

}
