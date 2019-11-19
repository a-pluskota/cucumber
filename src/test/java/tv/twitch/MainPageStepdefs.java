package tv.twitch;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import tv.twitch.webpages.MainPage;

import static org.junit.Assert.assertTrue;


public class MainPageStepdefs {

    private Scenario scenario;
    private AbstractStepdefs abstractStepdefs;

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

    @Given("On Twitch TV main page")
    public void on_Twitch_TV_main_page() {

        abstractStepdefs
                .startBrowser();

        abstractStepdefs
                .getDriver()
                .get(abstractStepdefs.TWITCH_TV_URL);    }

    @Then("Featured video player is displayed.")
    public void featured_video_player_is_displayed() {

        assertTrue(
                "Featured video player is not displayed on main page.",
                new MainPage(abstractStepdefs.getDriver())
                        .isFeaturedVideoPlayerDisplayed());
    }


    @Then("Sign up button is displayed.")
    public void sign_up_button_is_displayed() {

        assertTrue(
                "Sign up button is not displayed on main page.",
                new MainPage(abstractStepdefs.getDriver())
                        .isSignUpButtonDisplayed());
    }

    @Then("Sign in button is displayed.")
    public void sign_in_button_is_displayed() {

        assertTrue(
                "Sign in button is not displayed on main page.",
                new MainPage(abstractStepdefs.getDriver())
                        .isSignInButtonDisplayed());
    }

}
