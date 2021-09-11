@login
Feature: login feature

  Scenario Outline: login
    Given I am on the login page
    When i enter valid "<username>" and "<password>"
    Then i sign in successfully and see dashboard logo

    Examples:
      | username | password    |
      | user1    | UserUser123 |
      | user2    | UserUser123 |
      | user3    | UserUser123 |
      | user4    | UserUser123 |
      | user5    | UserUser123 |
      | user6    | UserUser123 |
      | user7    | UserUser123 |
      | user8    | UserUser123 |
      | user9    | UserUser123 |
      | user10   | UserUser123 |
      | user11   | UserUser123 |
      | user12   | UserUser123 |
      | user13   | UserUser123 |


