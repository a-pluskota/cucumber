package com.stackoverflow;

import com.stackoverflow.configs.IncorrectParameterException;
import com.stackoverflow.configs.WebDriverConfig;
import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

public class AbstractStepdefs {

    protected static final String STACKOVERFLOW_URL = "https://stackoverflow.com";

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

    private String createPathToFileWithFailedTestScreenshots(
            Scenario scenario
    ) {

        String PATH = "target/screenshots/";
        String directoryName = PATH
                .concat(scenario.getName())
                .replace(" ", "_");
        String fileName =  new Timestamp(System.currentTimeMillis())
                .toString()
                .replace(" ", "_");

        File directory = new File(directoryName);

        if (!directory.exists()){
            directory.mkdir();
        }

        return directoryName
                .concat("/")
                .concat(fileName)
                .concat(".png");
    }

    protected void after(Scenario scenario) {

        if (driver != null) {

            if (scenario.isFailed()) {

                File file = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

                String pathToFile = createPathToFileWithFailedTestScreenshots(scenario);

                try {
                    FileUtils.copyFile(
                            file,
                            new File(pathToFile));

                    logger.info(String.format(
                            "File with screenshot of failed test was saved in path %s.",
                            pathToFile));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            driver.quit();
        }

        driver = null;
    }

}
