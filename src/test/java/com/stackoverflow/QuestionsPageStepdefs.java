package com.stackoverflow;

import com.stackoverflow.webpages.QuestionsPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class QuestionsPageStepdefs {

    private Scenario scenario;
    private AbstractStepdefs abstractStepdefs;
    private QuestionsPage questionsPage;

    public QuestionsPageStepdefs(AbstractStepdefs abstractStepdefs) {
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

    }

    @When("Click on questions button in main page footer")
    public void click_on_questions_button_in_main_page_footer() {

        new QuestionsPage(abstractStepdefs.getDriver())
                .clickQuestionsFooterButton();
    }

    @Then("Redirect to all questions page url {string}")
    public void redirect_to_all_questions_page_url(String url) {

        url = abstractStepdefs.STACKOVERFLOW_URL
                .concat("/questions");

        assertTrue(
                "All questions page url is not correct.",
                abstractStepdefs.getDriver()
                        .getCurrentUrl()
                        .contains(url));
    }

    @When("Filled search input with {string}")
    public void filled_search_input_with(String query) {

        questionsPage = new QuestionsPage(abstractStepdefs.getDriver());

        questionsPage.fillSearchInput(query);
    }

    @When("Clicked return key")
    public void clicked_return_key() {

        questionsPage.clickReturnButton();

    }

    @Then("List of search results is returned")
    public void list_of_search_results_is_returned() {

        assertTrue(
                "List of search results is not returned.",
                questionsPage.isListOfQueryResultsDisplayed());
    }

    @Then("Every returned record contains tag {string}")
    public void every_returned_record_contains_tag (
            String tag_in_search_results
    ) {

        assertTrue(
                "List of search results do not contains tag: ".concat(tag_in_search_results),
                questionsPage
                        .isTagPresentInSearchResultsList(tag_in_search_results));
    }

    @Then("Every returned record contains phrase {string}")
    public void every_returned_record_contains_phrase (
            String phrase_in_search_results
    ) {

        assertTrue(
                "List of search results do not contains phrase: ".concat(phrase_in_search_results),
                questionsPage
                        .isPhrasePresentInSearchResultsList(phrase_in_search_results));
    }

    @Then("Every returned record contains author {string}")
    public void every_returned_record_contains_author(
            String author_in_search_results
    ) {

        assertTrue(
                "List of search results do not contains phrase: ".concat(author_in_search_results),
                questionsPage
                        .isAuthorPresentInSearchResultsList(author_in_search_results));
    }

    @When("Add clicked space key")
    public void add_clicked_space_key() {

        questionsPage.clickSpaceButton();

    }


}
