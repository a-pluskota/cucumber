Feature: Twitch TV main page

  @SMOKE
  @MAIN_PAGE
  Scenario: Featured video player is displayed.
    Given On Twitch TV main page
    Then Featured video player is displayed.