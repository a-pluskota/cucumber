package tv.twitch.configs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverConfig {

    private static final Logger logger = Logger
            .getLogger(WebDriverConfig.class);

    private static final String HEADLESS_MODE = System
            .getProperty("HEADLESS_MODE");

    /**
     * Use WebDriver implementation that controls a Chrome browser, to run tests on the local machine using Chrome.
     *
     * @return ChromeDriver
     *
     */
    private static WebDriver getChromeDriver() {

        WebDriverManager
                .chromedriver()
                .setup();

        logger.info("Starts running Chrome browser on the local machine");

        return new ChromeDriver();

    }

    /**
     * Use WebDriver implementation that controls a Chrome browser, to run tests on the local machine using Chrome.
     * Also use WebDriver interface Options, to manage running browse in headless mode.
     *
     * @return ChromeDriver with headless options
     *
     */
    private static WebDriver getHeadlessChromeDriver() {

        getChromeDriver();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");

        logger.info("Starts running Chrome browser in headless mode on the local machine");

        return new ChromeDriver(options);

    }

    /**
     * Use WebDriver implementation that controls a Chrome browser, to run tests on the local machine using Chrome.
     * Also, if system property HEADLESS_MODE is provided with value "on", use WebDriver interface Options, to manage
     * running browse in headless mode.
     *
     * @return ChromeDriver
     * @throws IncorrectParameterException
     */
    public static WebDriver getWebDriver() throws IncorrectParameterException {

        if (HEADLESS_MODE == null) {
            return getChromeDriver();

        } else if (HEADLESS_MODE.toLowerCase().equals("on")) {
            return getHeadlessChromeDriver();

        } else {
            throw new IncorrectParameterException("Parameter HEADLESS_MODE contains incorrect value.");

        }
    }
}
