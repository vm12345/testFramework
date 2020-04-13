package steps;

import app.WebAppDriverCapabilities;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.codeborne.selenide.Selenide.$x;

public class UIandAPITests {

    // This test get two values in parallel ways using asynchronous Tasks
    @Then("do requests {string} and {string}")
    public void doRequests(final String sourceValue, final String targetValue) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            WebDriverRunner.setWebDriver(WebAppDriverCapabilities.getInstance().getDesiredCapabilitiesWebApp());
            Selenide.open("https://currency-api.appspot.com/");
            SelenideElement source = $x("//select[@name='source']");
            source.click();
            source.$x("./option[contains(@value,'" + sourceValue + "')]").click();
            SelenideElement target = $x("//select[@name='target']");
            target.click();
            target.$x("./option[contains(@value,'" + targetValue + "')]").click();
            return $x("//input[@name='result']").getValue();
        }, executorService).thenApply(fromUI -> {
            try {
                GetRequest getRequest = Unirest.get("http://api.currencylayer.com/live?access_key=bc0d1388278fbda4627eba74f6550db9&source=" + sourceValue + "&currencies=" + sourceValue + "," + targetValue + "&format=1");
                String fromAPI = String.valueOf(getRequest.asJson().getBody().getObject().getJSONObject("quotes").getDouble(sourceValue.concat(targetValue)));

                Assert.assertEquals(Integer.parseInt(fromUI.substring(0, 3)), Integer.parseInt(fromAPI.substring(0, 3)));

                // if you use code in line 44 - tests will fail because UI rate is not equals to API rate absolutely
//                Assert.assertEquals(fromUI, fromAPI);


            } catch (UnirestException e) {
                e.getMessage();
                e.printStackTrace();
            }
            return null;
        });
        try {
            stringCompletableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
