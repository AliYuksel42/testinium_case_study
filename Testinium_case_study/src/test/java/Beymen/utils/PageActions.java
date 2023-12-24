package Beymen.utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;

public class PageActions extends BaseClass {

    public static String price1;

    private static String prdDetails = "o-productDetail__description" ;

    private static String priceDetails = "m-priceWrapper" ;

    public static void goToWebsite(String url) {
        driver.get(url);
        logger.info("Navigated to " + url);
        Assert.assertTrue(driver.getCurrentUrl().contains("beymen"));
        logger.info("Successfully navigated to Beymen website");
    }

    public static void writeProductInfoToFile() {
        // Ürün bilgisi
        WebElement productInfoElement = driver.findElement(By.className(prdDetails));
        String productInfo = productInfoElement.getText();

        // Tutar bilgisi
        WebElement priceElement = driver.findElement(By.className(priceDetails));
        price1 = priceElement.getText();

        // Dosyaya yazma işlemi
        try {
            FileWriter writer = new FileWriter("src/main/resources/product_info.txt");
            writer.write("Ürün Bilgisi: " + productInfo + "\n");
            writer.write("Tutar: " + price1 + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
