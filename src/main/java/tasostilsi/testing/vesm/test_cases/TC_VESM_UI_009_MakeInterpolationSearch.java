package tasostilsi.testing.vesm.test_cases;

import tasostilsi.testing.vesm.test_utils.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_VESM_UI_009_MakeInterpolationSearch extends BaseTest {

    @Test
    public void TC_VESM_UI_009_MakeInterpolationSearch() {

        makeASearch("inter");

        Assert.assertTrue(isElementPresent(By.xpath("//h6[contains(.,'Number of Checks')]")));
        Assert.assertTrue(driver.findElement(By.id("search_title")).getText().equalsIgnoreCase("Interpolation Search"));
        Assert.assertTrue(driver.findElement(By.id("manual")).getText().contains("Algorithm"));

    }

}
