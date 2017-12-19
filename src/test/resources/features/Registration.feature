@Regression
Feature: Dummy feature for project set up

  Scenario Outline: Verify name fields
  Given I go to "http://demoqa.com/registration/"
  When I enter "<firstName>" as my first name and "<lastName>" as my last name
  And I click the submit button
  Then the validation warning is "<validationStatus>"




  Examples:
    | firstName  |  lastName    | validationStatus  |
    | Conor      |  McLoughlin  |   not displayed   |
    |            |  McLoughlin  |   displayed       |



