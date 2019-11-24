package com.stackoverflow.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//input[@name = 'q']")
    private WebElement searchInput;

    @FindBy(xpath = "//header//a[contains(@href, 'login')]")
    private WebElement logInButton;

    @FindBy(xpath = "//header//a[contains(@href, 'signup')]")
    private WebElement signUpButton;

    public MainPage(WebDriver driverValue) {
        super(driverValue);
    }

    /**
     * Uses WebElement interface method isDisplayed to determinate, if search input is displayed.
     *
     * @return true, if element is displayed
     */
    public boolean isSearchInputDisplayed() {

        return searchInput.isDisplayed();
    }

    /**
     * Uses WebElement interface method isDisplayed to determinate, if sign up button is displayed.
     *
     * @return true, if element is displayed
     */
    public boolean isSignUpButtonDisplayed() {

        return signUpButton.isDisplayed();
    }

    /**
     * Uses WebElement interface method isDisplayed to determinate, if sign in button is displayed.
     *
     * @return true, if element is displayed
     */
    public boolean isLogInButtonDisplayed() {

        return logInButton.isDisplayed();
    }

    public LoginPage clickLogInButton(
            WebDriver driver
    ) {

        click(logInButton);

        return new LoginPage(driver);
    }

}
