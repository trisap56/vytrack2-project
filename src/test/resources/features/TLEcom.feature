@tl
Feature:User Registration

  @register
  Scenario: Automate User Registration Process.
    Given Open this url  http://automationpractice.com/index.php
    When I Click on sign in link.
    And Enter 'gurhanwick62@yahoo.com' in Create and account section.
    Then Click on Create an Account button.
    Then Enter your Personal Information, Address and Contact info.
    And Click on Register button.
    Then Validate that user is created.

  @wipp
  Scenario: Verify invalid email address error.
    Given I open the url
    When I Click sign in link
    And Enter 'gurhanwick62@yahoo.com' in Create and account
    Then Click on Create an Account.
    Then I validate that an error message is displaying saying "Invalid email address."

