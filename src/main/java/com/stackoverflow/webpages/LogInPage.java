package com.stackoverflow.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends AbstractPage {

    @FindBy(id = "login-form")
    private WebElement loginForm;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    public LogInPage(WebDriver driverValue) {
        super(driverValue);
    }

    /**
     * Uses WebElement interface method isDisplayed to determinate, if login form is displayed.
     *
     * @return true, if element is displayed
     */
    public boolean isLoginFormDisplayed() {

        return loginForm.isDisplayed();
    }

    /**
     * Uses WebElement interface method isDisplayed to determinate, if email input is displayed.
     *
     * @return true, if element is displayed
     */
    public boolean isEmailInputDisplayed() {

        return emailInput.isDisplayed();
    }

    /**
     * Uses WebElement interface method isDisplayed to determinate, if password input is displayed.
     *
     * @return true, if element is displayed
     */
    public boolean isPasswordInputDisplayed() {

        return passwordInput.isDisplayed();
    }

    /**
     * Uses WebElement interface method isDisplayed to determinate, if submit button is displayed.
     *
     * @return true, if element is displayed
     */
    public boolean isSubmitButtonDisplayed() {

        return submitButton.isDisplayed();
    }
}
