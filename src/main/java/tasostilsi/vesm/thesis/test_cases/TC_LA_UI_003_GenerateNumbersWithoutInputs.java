package com.intrasoft.stsc.test_cases;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_LA_UI_003_GenerateNumbersWithoutInputs {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        // open browser and application url
        System.setProperty("webdriver.chrome.driver", "C:/Users/atilsizoglou/Development/la-ui-test-tool/src/main/resources/chromedriver.exe");

        // create a new chrome driver
        driver = new ChromeDriver();

        //navigate to web app
        driver.get("https://tasostilsi.github.io/VESM");

        //macimize window
        driver.manage().window().maximize();
    }

    @Test
    public void TC_LA_UI_003_GenerateNumbersWithoutInputs() {

        //generate numbers with default method
        driver.findElement(By.id("generateNumbers")).click();

        driver.findElement(By.className("dropdown-toggle-split")).click();
        driver.findElement(By.id("exponential")).click();

        driver.findElement(By.className("dropdown-toggle-split")).click();
        driver.findElement(By.id("logarithmic")).click();

        driver.findElement(By.className("dropdown-toggle-split")).click();
        driver.findElement(By.id("geometric")).click();


    }

    @AfterTest
    public void tearDown() {
        //close chrome window
        driver.quit();
    }

    public void waitForLoad(final WebDriver driver) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            @NullableDecl
            public Boolean apply(@NullableDecl WebDriver input) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState;") == "complete" ;
            }
        };

        try {
            Thread.sleep(500);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until((expectation));
        } catch (Throwable error){
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

}
