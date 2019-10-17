package tasostilsi.testing.vesm.test_cases;

import tasostilsi.testing.vesm.test_utils.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_VESM_UI_002_VerifyAboutModal extends BaseTest {

    @Test
    public void TC_VESM_UI_002_VerifyAboutModal() {

        Assert.assertFalse(driver.findElement(By.id("myModal")).isDisplayed());

        //click at about nav link
        driver.findElement(By.xpath("//a[@class='nav-link'][contains(.,'About')]")).click();

        //verify modal opened page is loaded correctly
        waitForLoad(driver);
        Assert.assertTrue(driver.findElement(By.id("myModal")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'modal-dialog')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'modal-header')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'modal-body')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='resources/teiser_logo.png']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//i[contains(@class,'fas fa-graduation-cap')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//i[contains(@class,'far fa-user')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//i[contains(@class,'fas fa-user-graduate')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//i[contains(@class,'fas fa-id-card')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//i[contains(@class,'fas fa-link')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//i[contains(@class,'far fa-copyright')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//i[contains(@class,'fas fa-desktop')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//i[contains(@class,'fas fa-user-circle')]")).isDisplayed());

    }

}
