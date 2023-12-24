package Beymen.Tests;

import Beymen.PageObjects.CartPage;
import Beymen.PageObjects.SearchPage;
import Beymen.utils.BaseClass;

import Beymen.utils.PageActions;
import Beymen.PageObjects.HomePage;

import org.junit.Test;



import java.io.IOException;


public class Tests extends BaseClass {

    @Test
    public void beyMenTest() throws IOException, InterruptedException {
        PageActions.goToWebsite("https://www.beymen.com/");
        HomePage.genderSelect();
        HomePage.acceptCookies();
        HomePage.SearchShort();
        HomePage.clearSearchBox();
        HomePage.SearchGomlek();
        HomePage.pressEnter();
        SearchPage.selectRandomProduct();
        PageActions.writeProductInfoToFile();
        SearchPage.scrollToElement();
        SearchPage.selectAvailableSize();
        SearchPage.addToCart();
        SearchPage.goToCart();
        CartPage.comparePrices();
    }


}
