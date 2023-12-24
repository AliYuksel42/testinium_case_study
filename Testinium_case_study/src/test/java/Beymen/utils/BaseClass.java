package Beymen.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {

     public static WebDriver driver;

     public static WebDriverWait wait;
     public static Logger logger = LogManager.getLogger(BaseClass.class);

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        logger.info("Chrome driver started");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            logger.info("Chrome driver quit");
        }
    }
}
