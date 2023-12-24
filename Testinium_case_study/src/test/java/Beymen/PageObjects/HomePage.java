package Beymen.PageObjects;

import Beymen.utils.BaseClass;
import Beymen.utils.ExcelReader;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;



import java.io.IOException;


public class HomePage extends BaseClass {

    private static String cerezKabul = "onetrust-accept-btn-handler" ;
    private static String cinsiyetErkek = "genderManButton" ;
    private static String cinsiyetKadın = "genderWomanButton" ;
    private static String searchBtn1 = "div.o-header__search.bwi-search-o input.o-header__search--input" ;
    private static String searchBtn2 = "o-searchSuggestion__input" ;

    public static void genderSelect() {
        driver.findElement(By.id(cinsiyetErkek)).click();
    }

    public static void acceptCookies() {
        driver.findElement(By.id(cerezKabul)).click();
    }

    public static void SearchShort() throws IOException, InterruptedException {
        String searchedItem = ExcelReader.ExcelRead(0, 0); // Excel'den okunan değeri al
        System.out.println("okunan değer:" + searchedItem);
        driver.findElement(By.cssSelector(searchBtn1)).click();
        driver.findElement(By.id(searchBtn2)).sendKeys(searchedItem);
        Thread.sleep(1500);
        logger.info("Searched for item: " + searchedItem);

    }

    public static void SearchGomlek() throws IOException, InterruptedException {
        String searchedItem = ExcelReader.ExcelRead(1, 0); // Excel'den okunan değeri al
        System.out.println("okunan değer:" + searchedItem);
        Thread.sleep(1500);
        driver.findElement(By.id(searchBtn2)).sendKeys(searchedItem);
        logger.info("Searched for item: " + searchedItem);
    }

    public static void clearSearchBox() {
        driver.findElement(By.id(searchBtn2)).clear();
        logger.info("Cleared search box");
    }

    public static void pressEnter() {
        driver.findElement(By.id(searchBtn2)).sendKeys(Keys.ENTER);
        logger.info("Pressed enter");
    }




}

