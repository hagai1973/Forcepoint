Feature: Test Google local

  Scenario: Check the Google Local by label
    Given open Google Chrome and go to Google.com
    When Verify the lable of local
    Then Quit browser

  Scenario: Check the Google local by Maps
    Given open Google Chrome and go to Google.com
    When Open Application and select Maps
    Then Verify the coordinate
    Then Quit browser after check

  Scenario: Check the Google local by Laguage offered
    Given open Google Chrome and go to Google.com
    When Verify the lagauge offered by Google
    Then Quit browser after check
