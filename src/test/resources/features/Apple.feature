@apple @wip
Feature: Apple task

  Scenario:
    Given I am on apple url
    When I Click to all of the headers one by one
    Then I Print out the titles of the each page
    And Print out total number of links in each page
    When While on each page I Print out how many link is missing textTOTAL
    And I Print out how many link has textTOTAL