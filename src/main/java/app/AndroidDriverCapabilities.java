package app;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Factory for get capabilities
 * <p>
 * Interface DriverCapabilities needs to implement new Capabilities
 */

public class AndroidDriverCapabilities {
    private static final AndroidDriverCapabilities CAPABILITIES = new AndroidDriverCapabilities();

    private AndroidDriverCapabilities() {
    }

    public static AndroidDriverCapabilities getInstance() {
        return CAPABILITIES;
    }

    // This is a capabilities for testing
    public DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
//         desiredCapabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT,"4728");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.apps.maps");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.maps.MapsActivity");
        return desiredCapabilities;
    }

}
