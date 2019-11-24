Feature: Stackoverflow login form page

  Background:
    Given On Stackoverflow main page

  @SMOKE
  @SIGNUP_PAGE
  Scenario: Sign up form url is redirect after clicking on log in button on main page header
    When Click on sign up button
    Then Redirect to sign up form url "url"

  @SMOKE
  @SIGNUP_PAGE
  Scenario: Sign up form email input is displayed after clicking on log in button on main page header
    When Click on log in button
    Then Email input is displayed

  @SMOKE
  @SIGNUP_PAGE
  Scenario: Sign up form password input is displayed after clicking on log in button on main page header
    When Click on log in button
    Then Password input is displayed

  @SMOKE
  @SIGNUP_PAGE
  Scenario: Sign up form submit button is displayed after clicking on log in button on main page header
    When Click on log in button
    Then Submit button is displayed

  @SMOKE
  @SIGNUP_PAGE
  Scenario: Sign up form display name is displayed after clicking on sign up button on main page
    When Click on sign up button
    Then Display name input is displayed

  @SMOKE
  @SIGNUP_PAGE
  Scenario: Sign up form opt in checkbox is displayed after clicking on sign up button on main page
    When Click on sign up button
    Then Opt in checkbox is displayed