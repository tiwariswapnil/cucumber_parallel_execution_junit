@AmazonSearch
Feature: Amazon search

  Scenario Outline: Retrieve Amazon search results
    Given User navigates to Amazon home page
    When User searches for "<product>" in Amazon
    Then Retrieve the first Amazon search result

    Examples:
      | product                             |
      | The power of your subconscious mind |
      | Think and grow rich                 |