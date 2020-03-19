import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"/Users/ruamvvc/Documents/testFramework/src/test/resources/features"},
        glue = {"steps",
                "actions"})
public class RunCucumberSteps {
}
