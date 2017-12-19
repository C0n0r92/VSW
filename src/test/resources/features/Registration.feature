@Regression
Feature: Registering for the application

#  Bug in Validation of Test 2,3,4 / 1 & 5 Look good
  Scenario Outline: Verify name fields validation on submit
  Given I go to "http://demoqa.com/registration/"
  When I enter "<firstName>" as my first name and "<lastName>" as my last name
  And I click the submit button
  Then the validation warning is "<validationStatus>"

  Examples:
    | firstName  |  lastName    | validationStatus  |
    | Conor      |  McLoughlin  |   not displayed   |
    |            |  McLoughlin  |   displayed       |
    | !@£$£@     |  McLoughlin  |   displayed       |
    | Conor      |  4334        |   displayed       |
    |            |              |   displayed       |


  Scenario Outline: Verify relationship status can be tiggled
    Given I go to "http://demoqa.com/registration/"
    When I enter "<firstName>" as my first name and "<lastName>" as my last name
    When I toggle the "<relationshipStatus>" radio button
    When I click the submit button
    Then the radio button should be selected


  Examples:
    | firstName  |  lastName     | relationshipStatus |
    | Conor      |   McLoughlin  | Single             |
    | Conor      |   McLoughlin  | Married            |
    | Conor      |   McLoughlin  | Divorced           |










