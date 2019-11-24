package com.stackoverflow;

import com.stackoverflow.webpages.MainPage;
import com.stackoverflow.webpages.SingUpPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class SignUpPageStepdefs {

    private Scenario scenario;
    private AbstractStepdefs abstractStepdefs;
    private SingUpPage singUpPage;

    public SignUpPageStepdefs(AbstractStepdefs abstractStepdefs) {
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

    @When("Click on sign up button")
    public void click_on_sign_up_button() {

        new MainPage(abstractStepdefs.getDriver())
                .clickSignUpButton();
    }

    @Then("Redirect to sign up form url {string}")
    public void redirect_to_sign_up_form_url(String url) {

        url = abstractStepdefs.STACKOVERFLOW_URL
                .concat("/users/signup");

        assertTrue(
                "Sign up page url is not correct.",
                abstractStepdefs.getDriver()
                        .getCurrentUrl()
                        .contains(url));
    }

    @Then("Sign up form is displayed")
    public void sign_up_form_is_displayed() {

        assertTrue(
                "Sign up form is not displayed on main page.",
                new SingUpPage(abstractStepdefs.getDriver())
                        .isSubmitFormDisplayed());
    }

    @Then("Display name input is displayed")
    public void display_name_input_is_displayed() {

        assertTrue(
                "Display name input is not displayed on main page.",
                new SingUpPage(abstractStepdefs.getDriver())
                        .isDisplayNameInputDisplayed());
    }

    @Then("Opt in checkbox is displayed")
    public void opt_in_checkbox_is_displayed() {

        assertTrue(
                "Sign up opt in checkbox is not displayed on main page.",
                new SingUpPage(abstractStepdefs.getDriver())
                        .isOptInCheckboxDisplayed());
    }

}
