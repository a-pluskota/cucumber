package tv.twitch;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import tv.twitch.configs.IncorrectParameterException;
import tv.twitch.configs.WebDriverConfig;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

public class AbstractStepdefs {

    protected static final String TWITCH_TV_URL = "https://www.twitch.tv/";

    protected WebDriver driver;
    private static final Logger logger = Logger
            .getLogger(AbstractStepdefs.class);

    public WebDriver getDriver(){
        return this.driver;
    }

    public void startBrowser() {

        try {
            this.driver = WebDriverConfig.getWebDriver();
        } catch (IncorrectParameterException e) {
            e.printStackTrace();
        }

        driver.manage().window()
                .setSize(new Dimension(1920, 1020));
    }

    protected void after(Scenario scenario) {

        if (driver != null) {

            if (scenario.isFailed()) {

                File file = ((TakesScreenshot)driver)
                        .getScreenshotAs(OutputType.FILE);

                String fileName = new StringBuilder()
                        .append(scenario.getName())
                        .append(new Timestamp(System.currentTimeMillis()))
                        .toString()
                        .replace(" ", "_");

                String pathToFile = new StringBuilder()
                        .append("target/screenshots/")
                        .append(fileName)
                        .toString();

                try {
                    FileUtils.copyFile(file, new File(pathToFile));

                    logger.info(String.format(
                            "File %s with screenshot of failed test was saved in path %s.",
                            fileName,
                            pathToFile));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
    }

}
