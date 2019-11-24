package com.stackoverflow;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import com.stackoverflow.webpages.MainPage;

import static org.junit.Assert.assertTrue;

public class MainPageStepdefs {

    private Scenario scenario;
    private AbstractStepdefs abstractStepdefs;
    private MainPage mainPage;

    public MainPageStepdefs(AbstractStepdefs abstractStepdefs) {
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

    @Given("On Stackoverflow main page")
    public void on_Stackoverflow_main_page() {

        abstractStepdefs
                .startBrowser();

        abstractStepdefs
                .getDriver()
                .get(abstractStepdefs.STACKOVERFLOW_URL);

        mainPage = new MainPage(abstractStepdefs.getDriver());
    }

    @Then("Search input is displayed")
    public void search_input_is_displayed() {

        assertTrue(
                "Search input is not displayed on main page.",
                mainPage.isSearchInputDisplayed());
    }

    @Then("Sign up button is displayed")
    public void sign_up_button_is_displayed() {

        assertTrue(
                "Sign up button is not displayed on main page.",
                mainPage.isSignUpButtonDisplayed());
    }

    @Then("Log in button is displayed")
    public void log_in_button_is_displayed() {

        assertTrue(
                "Log in button is not displayed on main page.",
                mainPage.isLogInButtonDisplayed());
    }

}
