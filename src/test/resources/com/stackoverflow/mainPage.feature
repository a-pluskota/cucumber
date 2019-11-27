Feature: Stackoverflow main page

  Background:
    Given On Stackoverflow main page

  @SMOKE
  @MAIN_PAGE
  Scenario: Search input is displayed
    Then Search input is displayed

  @SMOKE
  @MAIN_PAGE
  Scenario: Sign up button is displayed
    Then Sign up button is displayed

  @SMOKE
  @MAIN_PAGE
  Scenario: Log in button is displayed
    Then Log in button is displayed