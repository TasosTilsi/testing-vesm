package com.intrasoft.stsc.test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.charset.CharsetDecoder;

public class TC_LA_UI_002_SetValuesAndGenerateNumbers {

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
    public void TC_LA_UI_002_SetValuesAndGenerateNumbers() {

        driver.findElement(By.id("arraySize")).sendKeys("20");
        driver.findElement(By.id("numbersRange")).sendKeys("20");
        driver.findElement(By.id("generateNumbers")).click();
        driver.findElement(By.id("searchingNumber")).sendKeys("10");
        driver.findElement(By.id("linearSearch")).click();

    }

    @AfterTest
    public void tearDown() {
        //close chrome window
        driver.quit();
    }
}
