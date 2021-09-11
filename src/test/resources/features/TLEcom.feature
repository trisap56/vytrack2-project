Feature:User Registration
  @tl @register @wip
  Scenario: Automate User Registration Process
  Given Open this url  http://automationpractice.com/index.php
  When I Click on sign in link.
  And Enter 'gurhanwick60@yahoo.com' in Create and account section.
  Then Click on Create an Account button.
  Then Enter your Personal Information, Address and Contact info.
  And Click on Register button.
  Then Validate that user is created.