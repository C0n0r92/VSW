@Regression
Feature: Registering for the application

#  Bug in Validation of Test 2,3,4 / 1 & 5 Look good
  Scenario Outline: Verify name fields validation on submit
  Given I go to "http://demoqa.com/registration/"
  When I enter "<firstName>" as my first name and "<lastName>" as my last name
  And I click the submit button
  Then the validation warning is "<validationStatus>" for names

  Examples:
    | firstName  |  lastName    | validationStatus  |
    | Conor      |  McLoughlin  |   not displayed   |
    |            |  McLoughlin  |   displayed       |
    | !@£$£@     |  McLoughlin  |   displayed       |
    | Conor      |  4334        |   displayed       |
    |            |              |   displayed       |


  Scenario Outline: Verify relationship status can be toggled is saved
    Given I go to "http://demoqa.com/registration/"
    When I toggle the "<relationshipStatus>" radio button
    When I click the submit button
    Then the radio button should be selected

  Examples:
  | relationshipStatus |
  | Single             |
  | Married            |
  | Divorced           |


  Scenario Outline: Verify Hobby section validation on submit
    Given I go to "http://demoqa.com/registration/"
    When I toggle the "<hobbyRadioBtn>" radio button
    When I click the submit button
    Then the validation warning is "<validationStatus>" for hobbies

  Examples:
    | hobbyRadioBtn | validationStatus|
    | Dance         | not displayed   |
    | Reading       | not displayed   |
    | Cricket       | not displayed   |
    | Leave Blank   |   displayed     |


  Scenario Outline: Verify Entering validation on dates
    Given I go to "http://demoqa.com/registration/"
    When I enter "<day>" as the day
    When I enter "<month>" as the month
    When I enter "<year>" as the year
    When I click the submit button
    Then the validation warning is "<validationStatus>" for dates

  Examples:
    | day | month| year | validationStatus |
    | 25  |  2  | 1992  | not displayed    |
    | 1   |  1  | 2018  | displayed        |
    | 4   |  3  |       | displayed        |
    |     |  2  | 1992  | displayed        |
    | 13  |     | 2000  | displayed        |







