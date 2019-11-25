package com.stackoverflow;

import com.stackoverflow.webpages.LogInPage;
import com.stackoverflow.webpages.MainPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LogInPageStepdefs {

    private Scenario scenario;
    private AbstractStepdefs abstractStepdefs;
    private LogInPage logInPage;

    public LogInPageStepdefs(AbstractStepdefs abstractStepdefs) {
        this.abstractStepdefs = abstractStepdefs;
    }

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @After
    public void closeDriver() {

        if (scenario != null) {
            abstractStepdefs
                    .after(scenario);
        }

        abstractStepdefs
                .getDriver()
                .quit();
    }

    @When("Click on log in button")
    public void click_on_log_in_button() {

        new MainPage(abstractStepdefs.getDriver())
                .clickLogInButton();

        logInPage = new LogInPage(abstractStepdefs.getDriver());
    }

    @Then("Redirect to log in form url {string}")
    public void redirect_to_log_in_form_url(
            String url
    ) {

        url = abstractStepdefs.STACKOVERFLOW_URL
                .concat("/users/login");

        assertTrue(
                "Log in page url is not correct.",
                abstractStepdefs.getDriver()
                        .getCurrentUrl()
                        .contains(url));
    }

    @Then("Log in form is displayed")
    public void log_in_form_is_displayed() {

        assertTrue(
                "Log in form is not displayed on main page.",
                new LogInPage(abstractStepdefs.getDriver())
                        .isLoginFormDisplayed());
    }

    @Then("Email input is displayed")
    public void email_input_is_displayed() {

        assertTrue(
                "Email input is not displayed on main page.",
                new LogInPage(abstractStepdefs.getDriver())
                        .isEmailInputDisplayed());
    }

    @Then("Password input is displayed")
    public void password_input_is_displayed() {

        assertTrue(
                "Password input is not displayed on main page.",
                new LogInPage(abstractStepdefs.getDriver())
                        .isPasswordInputDisplayed());
    }

    @Then("Submit button is displayed")
    public void submit_button_is_displayed() {

        assertTrue(
                "Submit button is not displayed on main page.",
                new LogInPage(abstractStepdefs.getDriver())
                        .isSubmitButtonDisplayed());
    }

    @When("The email field is filled in by {string}")
    public void the_email_field_is_filled_in_by(
            String email
    ) {

        logInPage.fillEmailInput(email);
    }

    @When("The password field is filled in by {string}")
    public void the_password_field_is_filled_in_by(
            String password
    ) {

        logInPage.fillPasswordInput(password);
    }

    @When("The submit button is clicked")
    public void the_submit_button_is_clicked() {

        logInPage.clickSubmitButton();
    }

    @Then("The email field displays a validation message with the content {string}")
    public void the_email_field_displays_a_validation_message_with_the_content(
            String emailValidationMessageContent
    ) {

        System.out.println(logInPage.getPasswordValidationMessage());

        assertEquals(
                "Email validation message do not displayed correct content.",
                emailValidationMessageContent,
                logInPage.getEmailValidationMessage());
    }

    @Then("The password field displays a validation message with the content {string}")
    public void the_password_field_displays_a_validation_message_with_the_content(
            String passwordValidationMessageContent
    ) {

    }
}
