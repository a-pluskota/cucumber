Feature: Stackoverflow log in form page

  Background:
    Given On Stackoverflow main page
    When Click on log in button

  @SMOKE
  @LOGIN_PAGE
  Scenario: Url is redirect after clicking on log in button on main page header
    Then Redirect to log in form url "url"

  @SMOKE
  @LOGIN_PAGE
  Scenario: Log in form is displayed after clicking on log in button on main page header
    Then Log in form is displayed

  @SMOKE
  @LOGIN_PAGE
  Scenario: Log in form email input is displayed after clicking on log in button on main page header
    Then Email input is displayed

  @SMOKE
  @LOGIN_PAGE
  Scenario: Log in form password input is displayed after clicking on log in button on main page header
    Then Password input is displayed

  @SMOKE
  @LOGIN_PAGE
  Scenario: Log in form submit button is displayed after clicking on log in button on main page header
    Then Submit button is displayed
