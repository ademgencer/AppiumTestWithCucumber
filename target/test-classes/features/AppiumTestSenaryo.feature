Feature: Appium Test

  Scenario: Apidemos Test

    Given user opens "APIDEMOS" on the phone "SAMSUNG_GALAXY_FAN"
    When user clicks "Views"
    And user clicks "Popup Menu"
    * user clicks "MAKE A POPUP!"
    Then "Add" should be visible
    When user clicks "Add"
    Then "Clicked popup menu item Add" should be visible


