package tv.twitch;

import cucumber.api.Scenario;
import org.openqa.selenium.WebDriver;
import tv.twitch.configs.IncorrectParameterException;
import tv.twitch.configs.WebDriverConfig;

public class AbstractStepdefs {

    protected static final String TWITCH_TV_URL = "https://www.twitch.tv/";

    protected WebDriver driver;


    public AbstractStepdefs() {

        try {
            this.driver = WebDriverConfig.getWebDriver();
        } catch (IncorrectParameterException e) {
            e.printStackTrace();
        }

    }

    protected void after(Scenario scenario) {}
}
