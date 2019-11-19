package tv.twitch.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public abstract class AbstractPage {

    private WebDriver driver;
    private FluentWait wait;

    public AbstractPage(
            org.openqa.selenium.WebDriver driverValue
    ) {
        this.driver = driverValue;
        this.wait = new FluentWait<WebDriver>((WebDriver) driver)
                .pollingEvery(Duration.ofMillis(500))
                .withTimeout(Duration.ofSeconds(5000))
                .withMessage("Waiting for element.")
                .ignoring(WebDriverException.class);

        PageFactory.initElements(driver, this);


    }

    /**
     * Uses customised Fluent Wait defines the maximum amount of time for Selenium WebDriver to wait for a certain condition to appear.
     * It also defines the frequency with which WebDriver will check if the condition appears before throwing Exception.
     *
     *  @return Fluent wait
     */
    protected FluentWait getCustomisedWait(){

        return wait;
    }


}
