Feature: BioDiversity

  @Test
  Scenario: Verify biodiversity score

    Given User logins to the application
    When user clicks on biodiversity
    Then user navigates to "Dashboard"
    And verify year selected as "2024"
    Then verify biodiversity score is "4.6"



  @Test1
  Scenario: Verify biodiversity score

    Given User logins to the application
    When user clicks on biodiversity
    Then user navigates to "Dashboard"
    Then click on button "Create report"
    Then user creates a report with name "aaabbcc"
    When user clicks on biodiversity
    Then click on button menu "Reports"
    And verify report "aaabbcc" is displayed on reports page
    Then delete the report "aaabbcc"
    And verify report "aaabbcc" is deleted

