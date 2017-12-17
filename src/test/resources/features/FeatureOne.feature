@Regression
Feature: Dummy feature for project set up

  Scenario Outline: Test for VSW
  Given I go to "https://www.facebook.com"
  And I enter "<username>" as my username



  Examples:
    | username |
    | Conor    |
    | Conor!@£$£SDDD |



