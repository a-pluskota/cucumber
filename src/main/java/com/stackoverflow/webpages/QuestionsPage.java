package com.stackoverflow.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;

public class QuestionsPage extends AbstractPage {

    @FindBy(xpath = "//footer//a[contains(@href, 'questions')]")
    private WebElement questionsButton;

    @FindBy(xpath = "//input[@name = 'q']")
    private WebElement searchInput;

    @FindAll(@FindBy(xpath = "//div[contains(@id, 'question-summary')]/parent::div"))
    private List<WebElement> listOfQueryResults;

    @FindBy(id = "login-form")
    private WebElement logInForm;

    public QuestionsPage(WebDriver driver) {
        super(driver);
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
     * Uses the click( method from the AbstractPage to click return key in the search input from main page header.
     *
     * @see com.stackoverflow.webpages.AbstractPage#click(WebElement)
     * @see com.stackoverflow.webpages.QuestionsPage
     */
    public void clickReturnButton() {

        sendKeys(searchInput,
                Keys.RETURN);
    }

    /**
     * Uses the click( method from the AbstractPage to click space key in the search input from main page header.
     *
     * @see com.stackoverflow.webpages.AbstractPage#click(WebElement)
     * @see com.stackoverflow.webpages.QuestionsPage
     */
    public void clickSpaceButton() {

        sendKeys(searchInput,
                Keys.SPACE);
    }

    /**
     * Uses the sendKeys method from the AbstractPage to fill search input from main page header.
     *
     * @see com.stackoverflow.webpages.AbstractPage#sendKeys(WebElement, String)
     * @see com.stackoverflow.webpages.QuestionsPage
     */
    public void fillSearchInput(
            String keys
    ) {

        sendKeys(searchInput, keys);
    }

    /**
     * Uses List interface method isEmpty to determinate, if submit button is displayed.
     *
     * @return true, if element is displayed
     */
    public boolean isListOfQueryResultsDisplayed() {

        return !listOfQueryResults.isEmpty();
    }

    /**
     * Uses the click() method from the AbstractPage to click in the questions button from main page footer.
     *
     * @see com.stackoverflow.webpages.AbstractPage#click(WebElement)
     * @see com.stackoverflow.webpages.QuestionsPage
     */
    public void clickQuestionsFooterButton() {

        scrollIntoEndOfPage();
        click(questionsButton);
    }

    private boolean isLocatorPresentInEveryListWebelement(
        By locator
    ) {

        for (WebElement element : listOfQueryResults) {

            if (element.findElements(locator).size() == 0) {
                return false;
            }
        }

        return true;
    }

    private List<String> getTextValueFromLocatorForEveryListWebelement(
            By locator
    ) {

        List<String> listOfEveryTextValue = new LinkedList<>();

        for (WebElement element : listOfQueryResults) {

            listOfEveryTextValue
                    .add(element.findElement(locator).getText());
        }

        return listOfEveryTextValue;
    }

    /**
     * Uses the isLocatorPresentInEveryListWebelement() method to check if each
     * element of the search result list has a tag with the value specified
     * in the String type parameter named tag.
     *
     * @param tag
     * @return true, if every list element contains tag
     */
    public boolean isTagPresentInSearchResultsList(
            String tag
    ) {

        return isLocatorPresentInEveryListWebelement(By
                        .xpath(new StringBuilder()
                                .append("//a[@class='post-tag'")
                                .append(" and contains(text(),'")
                                .append(tag)
                                .append("')]")
                                .toString()));
    }

    /**
     * Uses the isLocatorPresentInEveryListWebelement() method in loop to check if each
     * element of the search result list has at least one phrase with the value specified
     * in the String type parameter named phrase. Using the toLowerCase() method in loop
     * ensures case insensitive matching.
     *
     * @param phrase
     * @return true, if every list element contains tag
     */
    public boolean isPhrasePresentInSearchResultsList(
            String phrase
    ) {

        By phraseLocator = By
                .xpath(new StringBuilder()
                        .append("//div[@class='summary']")
                        .append("/div[@class='excerpt']")
                        .append("/span[contains(@class, 'bold')]")
                        .toString());

        for (String text : getTextValueFromLocatorForEveryListWebelement(phraseLocator)) {

            if (!text.toLowerCase().equals(phrase)){
                return false;
            };
        }

        return true;
    }

    /**
     * Uses the isLocatorPresentInEveryListWebelement() method to check if each
     * element of the search result list has a author with the value specified
     * in the String type parameter named author.
     *
     * @param author
     * @return true, if every list element contains correct author
     */
    public boolean isAuthorPresentInSearchResultsList(
            String author
    ) {

        return isLocatorPresentInEveryListWebelement(By
                .xpath(new StringBuilder()
                                .append("//div[@class='summary']")
                                .append("/div[@class='started fr']")
                                .append("/a[contains(text(),'")
                                .append(author)
                                .append("')]")
                                .toString()));
    }
}
