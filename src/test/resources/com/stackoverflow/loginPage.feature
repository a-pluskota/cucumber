Feature: Stackoverflow login form page

  Background:
    Given On Stackoverflow main page

  @SMOKE
  @MAIN_PAGE
  Scenario: Login form is correctly displayed after clicking on log in button on main page
    When Click on login button
    Then Login form is displayed
    And Email input is displayed
    And Password input is dispalyed
    And Submit button is dispalyed