@tl
Feature: Print displayed options
  Scenario:Print out all the options displayed in Google suggestion box
  Given I open URL - http://www.google.com
  When I Enter keyword "techlistic" in search bar
  And Wait for ajax suggestion box to appear
  Then I Get/store all the options of suggestion box in a list
