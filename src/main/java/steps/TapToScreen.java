package steps;

import app.TestSettigns;
import cucumber.api.java.en.And;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class TapToScreen {
    TestSettigns testSettigns = new TestSettigns();

    // This step needs to tap to selected point on screen
    @And("tap to screen {int}, {int}")
    public void tapToScreen(int xOffset, int yOffset) {
        getPerform(xOffset, yOffset);
        getPerform(xOffset, yOffset);
        getPerform(xOffset, yOffset);
    }

    @SuppressWarnings("rawtypes")
    private void getPerform(int xOffset, int yOffset) {
        new TouchAction(testSettigns.getDriver()).tap(PointOption.point(xOffset, yOffset)).perform();
    }
}
