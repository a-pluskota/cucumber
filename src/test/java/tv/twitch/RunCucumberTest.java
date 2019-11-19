package tv.twitch;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/tv.twitch/",
        plugin = {"pretty"})
public class RunCucumberTest {
}
