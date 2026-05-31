Feature: User Registration

  Scenario: Successful registration
    Given user opens registration page
    When user enters valid registration details
    And accepts terms and conditions
    And clicks create account
    Then account should be created successfully

  Scenario: Passwords do not match
    Given user opens registration page
    When user enters mismatching passwords
    And accepts terms and conditions
    And clicks create account
    Then password error should be shown

  Scenario: Terms not accepted
    Given user opens registration page
    When user enters valid registration details
    And clicks create account
    Then terms error should be shown