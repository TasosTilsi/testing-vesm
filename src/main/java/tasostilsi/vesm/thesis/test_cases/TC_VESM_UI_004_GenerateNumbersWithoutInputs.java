package com.intrasoft.stsc.test_cases;

import com.intrasoft.stsc.test_utils.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC_VESM_UI_004_GenerateNumbersWithoutInputs extends BaseTest {

    @Test
    public void TC_VESM_UI_004_GenerateNumbersWithoutInputs() {

        //generate numbers with default method
        driver.findElement(By.id("generateNumbers")).click();

        driver.findElement(By.className("dropdown-toggle-split")).click();
        driver.findElement(By.id("exponential")).click();

        driver.findElement(By.className("dropdown-toggle-split")).click();
        driver.findElement(By.id("logarithmic")).click();

        driver.findElement(By.className("dropdown-toggle-split")).click();
        driver.findElement(By.id("geometric")).click();

    }

}
