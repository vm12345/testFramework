package app;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.After;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebAppDriverCapabilities {
    private static final WebAppDriverCapabilities CAPABILITIES = new WebAppDriverCapabilities();
    private AppiumDriverLocalService service;

    private WebAppDriverCapabilities() {
    }

    public static WebAppDriverCapabilities getInstance() {
        return CAPABILITIES;
    }

    public AndroidDriver<WebElement> getDesiredCapabilitiesWebApp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability("chromedriverExecutableDir", "/Users/ruamvvc/Downloads/cucumber-rs/lib/");
        service = AppiumDriverLocalService
                .buildService(new AppiumServiceBuilder().usingAnyFreePort());
        service.start();
        return new AndroidDriver<>(service.getUrl(), capabilities);
    }

    @After
    public void shutDown() {
        service.stop();
    }
}