Feature: An example

  Scenario: # The example
    Given I am on the main page
    When I write the email address of "test@tester.com"
    And I click the submit button
    Then the confirmation pop-up appears

  Scenario: #1 Positive
    Given I am on the main page
    When I write the email address of "test@tester.ro"
    And I click the submit button
    Then the confirmation pop-up appears

  Scenario: #2 Negative
    Given I am on the main page
    When I write the email address of "test.tester.ro"
    And I click the submit button

  Scenario: #3 Negative
    Given I am on the personal information page
    When I fill the first name field with numbers or special characters of "@#%$&"
    And I click the next button
    Then the system keeps me on the same page

  Scenario: #4 Positive
      Given I am on the main page
      When I click the Questions button
      Then the page goes down to the FAQ section

  Scenario: #5 Negative
      Given I am on the contact information page
      When I fill the phone field with letters of "abcdefgh"
      And I click the next button from contact info page
      Then the system keeps me on the same page
