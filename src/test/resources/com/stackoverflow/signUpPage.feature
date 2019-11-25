Feature: Stackoverflow sign up form page

  Background:
    Given On Stackoverflow main page
    When Click on sign up button

  @SMOKE
  @SIGNUP_PAGE
  Scenario: Url is redirect after clicking on sign up button on main page header
    Then Redirect to sign up form url "url"

  @SMOKE
  @SIGNUP_PAGE
  Scenario: Sign up form is displayed after clicking on sign up button on main page header
    Then Sign up form is displayed

  @SMOKE
  @SIGNUP_PAGE
  Scenario: Sign up form email input is displayed after clicking on sign up button on main page header
    Then Email input is displayed

  @SMOKE
  @SIGNUP_PAGE
  Scenario: Sign up form password input is displayed after clicking on sign up button on main page header
    Then Password input is displayed

  @SMOKE
  @SIGNUP_PAGE
  Scenario: Sign up form submit button is displayed after clicking on sign up button on main page header
    Then Submit button is displayed

  @SMOKE
  @SIGNUP_PAGE
  Scenario: Sign up form display name is displayed after clicking on sign up button on main page
    Then Display name input is displayed

  @SMOKE
  @SIGNUP_PAGE
  Scenario: Sign up form opt in checkbox is displayed after clicking on sign up button on main page
    Then Opt in checkbox is displayed