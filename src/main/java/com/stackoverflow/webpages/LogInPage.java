package com.stackoverflow.webpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage extends AbstractPage {

    @FindBy(id = "login-form")
    private WebElement logInForm;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    /**
     * WIP xpath below
     */
    @FindBy(xpath = "//p[@class='grid--cell s-input-message js-error-message'][1]")
    private WebElement emailInputValidation;

    @FindBy(xpath = "//p[@class='grid--cell s-input-message js-error-message'][2]")
    private WebElement passwordInputValidation;


    public LogInPage(WebDriver driverValue) {
        super(driverValue);

        getCustomisedWait().until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));

    }

    /**
     * Uses WebElement interface method isDisplayed to determinate, if login form is displayed.
     *
     * @return true, if element is displayed
     */
    public boolean isLoginFormDisplayed() {

        return logInForm.isDisplayed();
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

    /**
     * Uses the sendKeys method from the AbstractPage to fill email form input from main page header.
     *
     * @see com.stackoverflow.webpages.AbstractPage#sendKeys(WebElement, String)
     */
    public void fillEmailInput(
            String keys
    ) {

        sendKeys(emailInput, keys);
    }

    /**
     * Uses the sendKeys method from the AbstractPage to fill password form input from main page header.
     *
     * @see com.stackoverflow.webpages.AbstractPage#sendKeys(WebElement, String)
     */
    public void fillPasswordInput(
            String keys
    ) {

        sendKeys(passwordInput, keys);
    }

    /**
     * Uses the click method from the AbstractPage to click in the submit button from login form.
     *
     * @see com.stackoverflow.webpages.AbstractPage#click(WebElement)
     */
    public void clickSubmitButton() {

        click(submitButton);
    }

    public String getEmailValidationMessage() {

        getCustomisedWait()
                .until(ExpectedConditions.visibilityOf(emailInputValidation));

        return emailInputValidation.getText();
    }

    public String getPasswordValidationMessage() {

//        getCustomisedWait()
//                .until(ExpectedConditions.visibilityOf(passwordInputValidation));

        return passwordInput.getText();
    }
}
