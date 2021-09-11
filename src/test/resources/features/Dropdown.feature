@dropdown
Feature: select state

  Scenario:  Verifying “Simple dropdown” and “State selection” dropdown default values
  Given I am on correct url
  Then verify that “Simple dropdown” default selected value is as expected: “Please select an option”
  Then verify that “State selection” default selected value is as expected: “Select a State”