package com.stackoverflow;

import com.stackoverflow.webpages.LoginPage;
import com.stackoverflow.webpages.MainPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class LoginPageStepdefs {

    private Scenario scenario;
    private AbstractStepdefs abstractStepdefs;
    private LoginPage loginPage;

    public LoginPageStepdefs(AbstractStepdefs abstractStepdefs) {
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

    @When("Click on login button")
    public void click_on_login_button() {

        loginPage = new MainPage(abstractStepdefs.getDriver())
                .clickLogInButton(abstractStepdefs.getDriver());
    }

    @Given("On Stackoverflow login form page")
    public void on_Stackoverflow_login_form_page() {

        assertTrue(
                "Login page url is not correct.",
                abstractStepdefs.getDriver()
                        .getCurrentUrl()
                        .contains(abstractStepdefs.STACKOVERFLOW_URL
                                .concat("/users/login")));
    }

    @Then("Login form is displayed")
    public void login_form_is_displayed() {

        assertTrue(
                "Log in form is not displayed on main page.",
                loginPage.isLoginFormDisplayed());
    }

    @Then("Email input is displayed")
    public void email_input_is_displayed() {

        assertTrue(
                "Email input is not displayed on main page.",
                loginPage.isEmailInputDisplayed());
    }

    @Then("Password input is dispalyed")
    public void password_input_is_dispalyed() {

        assertTrue(
                "Password input is not displayed on main page.",
                loginPage.isPasswordInputDisplayed());
    }

    @Then("Submit button is dispalyed")
    public void submit_button_is_dispalyed() {

        assertTrue(
                "Submit button is not displayed on main page.",
                loginPage.isSubmitButtonDisplayed());
    }
}
