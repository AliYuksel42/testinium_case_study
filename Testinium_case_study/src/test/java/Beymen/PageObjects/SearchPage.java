package Beymen.PageObjects;

import Beymen.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;


public class SearchPage extends BaseClass {

    private static String srcResult = "productList" ;

    private static String scrElement = "m-campaignWrapper__desc" ;

    private static String availableSizes = ".m-variation__item:not(.-disabled)" ;

    private static String addCart = "addBasket" ;



    private static String goCart = "/html[1]/body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/a[3]/span[1]" ;

    public static void selectRandomProduct() {
        List<WebElement> products = driver.findElements(By.id(srcResult));

        Random random = new Random();
        int randomIndex = random.nextInt(products.size());

        WebElement selectedProduct = products.get(randomIndex);
        selectedProduct.click();

    }
    public static void scrollToElement() {
        WebElement element = driver.findElement(By.className(scrElement));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public static void selectAvailableSize() {
        List<WebElement> sizes = driver.findElements(By.cssSelector(availableSizes));

        for (WebElement size : sizes) {
            try {
                size.click();
                break;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void addToCart() throws InterruptedException {
        Thread.sleep(1500);
        driver.findElement(By.id(addCart)).click();
    }

    public static void goToCart() throws InterruptedException {
        Thread.sleep(6000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
        driver.findElement(By.xpath(goCart)).click();
    }


}
