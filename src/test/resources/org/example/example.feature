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

  Scenario: #3 Positive
    Given I am on the personal information page
    When I fill only the first name as "Marius"
    And I click the next button
    Then the system keeps me on the same page

  Scenario: #4 Positive
      Given I am on the main page
      When I click the Questions button
      Then the page goes down to the FAQ section

  Scenario: #5 Negative
      Given I am on the contact information page
      When I fill the email field of "mariusghe14@yahoo.com"
      And I fill the phone field with letters of "abcdef"
      And I fill the country field of "Romania"
      And I fill the City field of "Bran"
      And I fill the post code field of "507025"
      And I click the next button from contact info page
      Then the system keeps me on the contact information page

  Scenario: #6 Positive
      Given I am on the main page
      When I click the Read More button from Virtual section
      Then a new page opens

  Scenario: #7 Positive
    Given I am on the main page
    When I click the Instructors button
    Then the page goes down to the Our Instructors section

  Scenario: #8 Positive
    Given I am on the main page
    When I click the Blue Arrow from the right corner of the end page
    Then the page move back to the top

  Scenario: #9 Positive
    Given I am on the course options page
    When I select the manual tester option
    And  I click the next button from the course options page
    Then a payment information page opens

  Scenario: #10 Positive
    Given I am on the main page
    When I click the Read More button from Learn Selenium section
    Then a new page will open

