Feature: Farm Setup

  @Test
  Scenario: Add new farm, Edit and Delete

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to Farm setup page
    And user clicks on add farm
    #Then enter the required data
    #|Farm Name     | Farm Address               |
    #|###Test_Farm  |United Center, West Madison |
    And user select coordinate as
    | Latitude  | Longitude  |
    | 54.906101 | -1.381130  |
    And user select Enterprises data as
    | Enterprise                |
    | Arable & Horticulture     |
    | Transport                 |
    Then "add" last "1" year data
    And "add" data for next year
    Then user enter farm name as "###ATest_Farm"
    Then user "Save" the added data
    And verify the success message as "Record inserted successfully"
    Then edit the farm details for "###ATest_Farm"
    Then user enter farm name as "###BTest_Farm"
    Then user "Save" the added data
    And verify the success message as "Farm Updated Successfully."
    Then delete the farm details for "###BTest_Farm"
    And verify the success message as "Farm deleted successfully."



