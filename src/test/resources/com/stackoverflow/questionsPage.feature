Feature: Stackoverflow questions page

  Background:
    Given On Stackoverflow main page

  @SMOKE
  @QUESTIONS_PAGE
  Scenario: Url is redirect after clicking on questions button on main page footer
    When Click on questions button in main page footer
    Then Redirect to all questions page url "url"


  @SMOKE
  @QUESTIONS_PAGE
  Scenario: Search input is displayed after clicking on questions button on main page footer
    When Click on questions button in main page footer
    Then Search input is displayed


  @QUESTIONS_PAGE
    Scenario Outline: Search within a tag
    When Filled search input with "<search_within_a_tag>"
    And Clicked return key
    Then List of search results is returned
    And Every returned record contains tag "<tag_in_search_results>"

    Examples:
      | search_within_a_tag | tag_in_search_results |
      | [java]              | java                  |
      | [cucumber]          | cucumber              |


  @QUESTIONS_PAGE
  Scenario Outline: Search exact phrase
    When Filled search input with "<search_exact_phrase>"
    And Clicked return key
    Then List of search results is returned
    And Every returned record contains phrase "<phrase_in_search_results>"

    Examples:
      | search_exact_phrase | phrase_in_search_results |
      | \"java\"            | java                     |
      | \"cucumber\"        | cucumber                 |


  @QUESTIONS_PAGE
  Scenario Outline: Search by text
    When Filled search input with "<search_by_text>"
    And Clicked return key
    Then List of search results is returned
    And Every returned record contains tag "<text_in_search_results>"

    Examples:
      | search_by_text | text_in_search_results |
      | java           | java                   |
      | cucumber       | cucumber               |


  @QUESTIONS_PAGE
  Scenario Outline: Search by author
    When Filled search input with "<search_by_author>"
    And Clicked return key
    Then List of search results is returned
    And Every returned record contains author "<author_in_search_results>"

    Examples:
      | search_by_author | author_in_search_results |
      | user:3877746     | Boni García              |
      | user:985584      | Angie Jones              |


  @QUESTIONS_PAGE
  Scenario Outline: Search within a tag, exact phrase and by author
    When Filled search input with "<search_within_a_tag>"
    And Add clicked space key
    And Filled search input with "<search_exact_phrase>"
    And Add clicked space key
    And Filled search input with "<search_by_author>"
    And Clicked return key
    Then List of search results is returned
    And Every returned record contains tag "<tag_in_search_results>"
    And Every returned record contains phrase "<phrase_in_search_results>"
    And Every returned record contains author "<author_in_search_results>"

    Examples:
      | search_within_a_tag | search_exact_phrase | search_by_author | tag_in_search_results | phrase_in_search_results | author_in_search_results |
      | [selenium]          | \"selenium\"        | user:3877746     | selenium              | selenium                 | Boni García              |
      | [java]              | \"java\"            | user:3877746     | java                  | java                     | Boni García              |