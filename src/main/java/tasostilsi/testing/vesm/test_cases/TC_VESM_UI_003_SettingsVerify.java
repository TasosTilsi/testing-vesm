package tasostilsi.testing.vesm.test_cases;

import tasostilsi.testing.vesm.test_utils.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC_VESM_UI_003_SettingsVerify extends BaseTest {

    @Test
    public void TC_VESM_UI_003_SettingsVerify() {

        driver.findElement(By.id("linearSearch")).click();

        sendKeysInInputsAndGenerateNumbers(30,30,30);

        driver.findElement(By.id("options")).click();
        waitForLoad(driver);
        driver.findElement(By.id("dark_theme")).click();

        driver.findElement(By.id("options")).click();
        waitForLoad(driver);
        driver.findElement(By.id("clear_button")).click();

        driver.findElement(By.id("options")).click();
        waitForLoad(driver);
        driver.findElement(By.id("show_hide_manual")).click();

        driver.findElement(By.id("options")).click();
        waitForLoad(driver);
        driver.findElement(By.id("show_hide_step")).click();

    }

}
