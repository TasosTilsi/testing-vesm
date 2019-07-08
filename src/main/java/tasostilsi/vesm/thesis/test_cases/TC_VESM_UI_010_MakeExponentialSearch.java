package com.intrasoft.stsc.test_cases;

import com.intrasoft.stsc.test_utils.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_VESM_UI_010_MakeExponentialSearch extends BaseTest {

    @Test
    public void TC_VESM_UI_010_MakeExponentialSearch() {

        makeASearch("expo");

        Assert.assertTrue(isElementPresent(By.xpath("//h6[contains(.,'Number of Checks')]")));
        Assert.assertTrue(driver.findElement(By.id("search_title")).getText().equalsIgnoreCase("Exponential Search"));
        Assert.assertTrue(driver.findElement(By.id("manual")).getText().contains("Algorithm"));
    }

}
