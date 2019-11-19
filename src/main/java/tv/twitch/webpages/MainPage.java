package tv.twitch.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//div[@data-test-selector='highwind-video-player__video-container']/video")
    private WebElement featuredVideoPlayer;

    @FindBy(xpath = "//div[@data-test-selector='anon-user-menu__login-button]")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@data-test-selector='anon-user-menu__sign-up-button]")
    private WebElement signUpButton;

    public MainPage(WebDriver driverValue) {
        super(driverValue);
    }

    /**
     * Uses WebElement interface method isDisplayed to determinate, if featured video player is displayed.
     *
     * @return true, if element is displayed
     */
    public boolean isFeaturedVideoPlayerDisplayed() {

        return featuredVideoPlayer.isDisplayed();
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
    public boolean isSignInButtonDisplayed() {

        return signInButton.isDisplayed();
    }
}
