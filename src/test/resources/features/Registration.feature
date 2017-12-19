@Regression
Feature: Dummy feature for project set up

#  Bug in Validation of Test 2,3,4 / 1 & 5 Look good
  Scenario Outline: Verify name fields
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



