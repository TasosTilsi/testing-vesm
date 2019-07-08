package com.intrasoft.stsc.test_utils;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;

    /**
     * This method runs before every test case runs and sets up the driver
     */
    @BeforeTest
    public void setUp() {
        // open browser and application url
        System.setProperty("webdriver.chrome.driver", "C:/Users/atilsizoglou/Projects/Personal/Selenium/testing-my-thesis/src/main/resources/chromedriver.exe");

        // create a new chrome driver
        driver = new ChromeDriver();

        //navigate to web app
        driver.get("https://tasostilsi.github.io/VESM");

        //maximize window
        driver.manage().window().maximize();

        //setting the WebDriverWait
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * This method runs after every test case runs and closes the driver
     */
    @AfterTest
    public void tearDown() {
        //close chrome window
        driver.quit();
    }

    /**
     * This is a method that is used for dynamic waiting until the page is loaded
     *
     * @param driver this is the webdriver that we use
     */
    public void waitForLoad(final WebDriver driver) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            @NullableDecl
            public Boolean apply(@NullableDecl WebDriver input) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };

        try {
            Thread.sleep(500);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until((expectation));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    /**
     * This is a method that return if an element exists or not
     *
     * @param by is the element locator
     * @return true or false when an element exists ot not
     */
    public Boolean isElementPresent(By by) {
        return (driver.findElements(by).size() > 0);
    }

    /**
     * This is a method that takes a string and return it with no spaces
     *
     * @param s the string that gets
     * @return the string without spaces
     */
    public String ignoreSpaces(String s) {
        return s.replaceAll("\\s+", "");
    }

    /**
     * This is a method to put numbers in inputs and generate numbers
     *
     * @param arraySize
     * @param numbersRange
     * @param searchingNumber
     */
    public void sendKeysInInputsAndGenerateNumbers(int arraySize, int numbersRange, int searchingNumber) {
        driver.findElement(By.id("arraySize")).sendKeys(String.valueOf(arraySize));
        driver.findElement(By.id("numbersRange")).sendKeys(String.valueOf(numbersRange));
        driver.findElement(By.id("searchingNumber")).sendKeys(String.valueOf(searchingNumber));
        driver.findElement(By.id("generateNumbers")).click();
    }

    /**
     * This is a method to change the Slider Value
     */
    public void changeTheSliderValue() {
        System.out.println("Check The slider size here " + driver.findElement(By.id("rangeInput".toLowerCase())).getSize());
        System.out.println("Check The slider location here " + driver.findElement(By.id("rangeInput".toLowerCase())).getLocation());
        new Actions(driver).moveByOffset(driver.findElement(By.id("rangeInput".toLowerCase())).getLocation().x, driver.findElement(By.id("rangeInput".toLowerCase())).getLocation().y).click().build().perform();
        //WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@id,'snackbar') and contains(@class,'show')]")));

    }

    /**
     * This is a method that takes a string with the name of the search and clicks the propriate button
     *
     * @param search the name of the search
     */
    public void makeASearch(String search) {

        sendKeysInInputsAndGenerateNumbers(200, 200, 64);

        if (search.toLowerCase().startsWith("lin")) {
            search = "linearSearch";
        }

        if (search.toLowerCase().startsWith("bin")) {
            search = "binarySearch";
        }

        if (search.toLowerCase().startsWith("jum")) {
            search = "jumpSearch";
        }

        if (search.toLowerCase().startsWith("int")) {
            search = "interpolationSearch";
        }

        if (search.toLowerCase().startsWith("exp")) {
            search = "exponentialSearch";
        }

        if (search.toLowerCase().startsWith("fib")) {
            search = "fibonacciSearch";
        }

        driver.findElement(By.id(search)).click();
        waitForLoad(driver);

        //WebDriverWait wait = new WebDriverWait(driver, 15);

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("skipForward")));
        element.click();

//        waitForLoad(driver);
//        Assert.assertFalse(driver.findElement(By.id("searchingNumber")).isEnabled());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'snackbar') and contains(@class,'show')]")));

    }

}
