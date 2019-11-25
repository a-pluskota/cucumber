package com.stackoverflow.webpages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public abstract class AbstractPage {

    private WebDriver driver;
    private FluentWait wait;

    public AbstractPage(
            org.openqa.selenium.WebDriver driver
    ) {
        this.driver = driver;
        this.wait = new FluentWait<WebDriver>((WebDriver) driver)
                .pollingEvery(Duration.ofMillis(500))
                .withTimeout(Duration.ofSeconds(5))
                .ignoring(WebDriverException.class)
                .ignoring(NoSuchElementException.class);

        PageFactory.initElements(driver, this);

    }

    /**
     * Uses customised Fluent Wait to define the maximum amount of time
     * for Selenium WebDriver to wait for a certain condition to appear.
     * It also defines the frequency with which WebDriver will check if
     * the condition appears before throwing Exception.
     *
     *  @return Fluent wait
     */
    protected FluentWait getCustomisedWait(){

        return wait;
    }

    /**
     * Waits for element using Fluent Wait
     *
     * @param element
     */
    protected void click(
            WebElement element
    ) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void sendKeys(
            WebElement element,
            String keys
    ) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(keys);
    }

    protected void sendKeys(
            WebElement element,
            Keys keys
    ) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(keys);
    }

    protected void scrollIntoElement(
            WebElement element
    ) {

        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    protected void scrollIntoEndOfPage() {

        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

}
