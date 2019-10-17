package tasostilsi.testing.vesm.test_cases;

import tasostilsi.testing.vesm.test_utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_VESM_UI_001_VerifyPageLoaded extends BaseTest {

    @Test
    public void TC_VESM_UI_001_VerifyPageLoaded() {

        //PageFactory.initElements(driver,this);

        //verify page is loaded correctly
        verifyPageLoaded();

        // click at home and verify that page loaded correctly
        driver.findElement(By.xpath("//img[contains(@src,'home.png')]")).click();
        waitForLoad(driver);
        verifyPageLoaded();

        // click at nav title and verify that page loaded correctly
        driver.findElement(By.xpath("//a[contains(@class,'navbar-brand')]")).click();
        waitForLoad(driver);
        verifyPageLoaded();

    }

    public void verifyPageLoaded(){
        Assert.assertEquals(driver.getTitle(), "Visualized Environment for Search Methods");

        String generateNumbersBTN = driver.findElement(By.id("generateNumbers")).getText();
        Assert.assertTrue(generateNumbersBTN.equalsIgnoreCase("Generate Numbers"));

        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='dragable_container_header'][contains(@id,'header')][contains(.,'expand_more\n" +
                "                chevron_right\n" +
                "                Help\n" +
                "                drag_handle')]")));

        Assert.assertFalse(driver.findElement(By.id("pause")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("next")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("skipForward")).isEnabled());

        Assert.assertTrue(driver.findElement(By.id("dragable_container_step_content")).getText().equalsIgnoreCase("You will see the steps of every search you run..."));
        Assert.assertTrue(driver.findElement(By.id("search_title")).getText().equalsIgnoreCase("Press a Search Button"));
        Assert.assertTrue(driver.findElement(By.id("manual")).getText().equalsIgnoreCase("A manual for this search will appear hear"));

        driver.findElement(By.id("options")).click();
        waitForLoad(driver);
        Assert.assertTrue(isElementPresent((By.id("dark_theme"))));
    }

}
