Feature: BioDiversity

  @Test
  Scenario: Verify biodiversity score

    Given User logins to the application
    When user clicks on biodiversity
    Then user navigates to "Dashboard"
    And verify year selected as "2024"
    Then verify biodiversity score is "2.0"



  @Test
  Scenario: Verify report is created and deleted successfully

    Given User logins to the application
    When user clicks on biodiversity
    Then user navigates to "Dashboard"
    Then click on button "Create report"
    Then user creates a report with name "AAA123"
    Then click on button menu "Reports"
    When user search for AAA123 report
    And verify report "AAA123" is displayed on reports page
    Then click on view report button "AAA123" report
    And verify the report name as "AAA123" and current created date
    Then click arrow back button
    When user search for AAA123 report
    Then delete the report "AAA123"
    And verify report "AAA123" is deleted

  @Test
  Scenario: Verify Historic performance comparison dropdown

    Given User logins to the application
    When user clicks on biodiversity
    Then user navigates to "Dashboard"
    And verify Historic performance comparison dropdown values
    |Values               |
    |Select all           |
    |Farmland wildlife    |
    |Conservation species |
    |Natural enemies      |
    |Pollinators          |
    |Soil biodiversity    |


  @Test
  Scenario: Verify filters of Detailed performance analysis is same as Biodiversity dashboard filters

    Given User logins to the application
    When user clicks on biodiversity
    Then user navigates to "Dashboard"
    And verify the filters in Detailed performance analysis is same as Biodiversity dashboard filters


  @Test
  Scenario: Verify recommendations filters  is same as Biodiversity performance filters

    Given User logins to the application
    When user clicks on biodiversity
    Then user navigates to "Dashboard"
    And capture the values of biodiversity performance filters
    And click on improve biodiversity score button
    Then verify recommendations filters  is same as Biodiversity performance filters

  @Test
  Scenario: Verify farm and field filter on recommendation filter

    Given User logins to the application
    When user clicks on biodiversity
    Then user navigates to "Dashboard"
    And capture first farm and field name from performance analysis table
    Then click on the rocket icon for the first farm name
    And verify the filters farm name and field name displayed same as performance analysis table


  @Test
  Scenario: Verify review impact

    Given User logins to the application
    When user clicks on biodiversity
    Then user navigates to "Dashboard"
    And click on improve biodiversity score button
    Then expand on "No insecticide" management practices
    And uncheck all the field names for "No insecticide" management practices
    Then click "Review Impact" banner button
    And verify the text on the banner as "Applying these practices can increase your biodiversity score to"


    





