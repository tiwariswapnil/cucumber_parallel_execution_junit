@GoogleSearch
Feature: Google Search

  Scenario: Retrieve Google search results
    Given User navigates to Google home page
    When User enters "Cucumber Selenium" in Google searchbox
    And User clicks on search button
    Then Retrieve the first Google search result