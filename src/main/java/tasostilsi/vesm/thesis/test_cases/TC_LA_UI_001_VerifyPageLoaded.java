package com.intrasoft.stsc.test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_LA_UI_001_VerifyPageLoaded {

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
    public void TC_LA_UI_001_VerifyPageLoaded() {

        //verify page is loaded correctly
        Assert.assertEquals(driver.getTitle(), "Visualized Environment for Search Methods");

        String generateNumbersBTN = driver.findElement(By.id("generateNumbers")).getText();
        Assert.assertTrue(generateNumbersBTN.equalsIgnoreCase("Generate Numbers"));

        Assert.assertTrue(isElementPresent(By.xpath("//input")));
    }

    @AfterTest
    public void tearDown() {
        //close chrome window
        driver.quit();
    }

    public Boolean isElementPresent(By by){
        return (driver.findElements(by).size() > 0);
    }
}
