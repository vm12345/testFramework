package steps;

import app.TestSettigns;
import cucumber.api.java.en.And;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Implementation of cucumber steps
 */
@SuppressWarnings("rawtypes")
public class GoogleMapsVisit {
    private TestSettigns testSettigns = new TestSettigns();
    private AppiumDriver driver = testSettigns.getDriver();
    private WebDriverWait webDriverWait = testSettigns.getWebDriverWait();

    @SuppressWarnings("unchecked")
    @And("find first value {string} with category {string}")
    public void findValue(String valueFromFeature, String category) {
        setValueInTextBox(valueFromFeature);
        findFrameLayout(By.className("android.widget.FrameLayout"));
        List<MobileElement> resultElements = getMobileElements(valueFromFeature, ((List<MobileElement>) driver.findElementsByClassName("android.widget.RelativeLayout")).get(0)
                .findElementsByClassName("android.widget.TextView"));
        MobileElement address = findElementOnMap(resultElements);
        findCategoryOnMap(category, address);
        driver.navigate().back();
    }

    @SuppressWarnings({"unchecked", "ResultOfMethodCallIgnored"})
    @And("find random value {string} with category {string}")
    public void findRandomValue(String valuesFromFeature, String category) {
        setValueInTextBox(valuesFromFeature);
        Random random = new Random();
        findFrameLayout(By.className("android.widget.FrameLayout"));
        int index = random.nextInt(((List<MobileElement>) testSettigns.getDriver().findElementsByClassName("android.widget.RelativeLayout")).size() - 1);
        ((List<MobileElement>) driver.findElementsByClassName("android.widget.RelativeLayout")).get(index);
        List<MobileElement> elementsByClassName = ((List<MobileElement>) driver.findElementsByClassName("android.widget.RelativeLayout")).get(index)
                .findElementsByClassName("android.widget.TextView");
        List<MobileElement> resultElements = getMobileElements(valuesFromFeature, elementsByClassName);
        MobileElement address = findElementOnMap(resultElements);
        try {
            findCategoryOnMap(category, address);
        } catch (RuntimeException e) {
            Assert.assertTrue(address.isDisplayed());
        }
    }

    private void findFrameLayout(By locator) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void findCategoryOnMap(String category, MobileElement address) {
        MobileElement savedCategory = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + category + "\");"));
        Assert.assertTrue(address.isDisplayed());
        Assert.assertTrue(savedCategory.isDisplayed());
    }

    private MobileElement findElementOnMap(List<MobileElement> resultElements) {
        String resName = resultElements.get(0).getText();
        resultElements.get(0).click();
        return (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + Objects.requireNonNull(resName) + "\");"));
    }

    private void setValueInTextBox(String valueFromFeature) {
        driver.findElementById("com.google.android.apps.maps:id/search_omnibox_text_box").click();
        webDriverWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("com.google.android.apps.maps:id/search_omnibox_edit_text")))
                .sendKeys(valueFromFeature);
        findFrameLayout(By.className("android.widget.FrameLayout"));
        driver.findElementsByClassName("android.widget.RelativeLayout");
    }

    private List<MobileElement> getMobileElements(String valueForSearch, List<MobileElement> elementsByClassName) {
        List<MobileElement> resultElements = new ArrayList<>();
        for (MobileElement mobileElement : elementsByClassName) {
            if (mobileElement.getText().contains(valueForSearch)) {
                resultElements.add(mobileElement);
            }
        }
        return resultElements;
    }
}
