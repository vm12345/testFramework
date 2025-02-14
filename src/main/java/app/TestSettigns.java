package app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("rawtypes")
public class TestSettigns {
    private final AppiumDriver driver;
    private final WebDriverWait webDriverWait;
    private final AppiumDriverLocalService service = AppiumDriverLocalService
            .buildService(new AppiumServiceBuilder().usingAnyFreePort());

    public TestSettigns() {
        driver = new AndroidDriver(service,
                AndroidDriverCapabilities.getInstance().getDesiredCapabilities());
        webDriverWait = new WebDriverWait(driver, 30);
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public AppiumDriverLocalService getService() {
        return service;
    }
}
