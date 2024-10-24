Feature: Enterprise Data

  @Test
  Scenario: Add new field, Edit and Delete

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to enterprise data page
    And user clicks on manage data for field "Fields"
    And user clicks on manage data for field "###Test_Farm"
    Then user clicks on add field button
    And enter the required data for Field
    |Field                | Data         |
    |Field name           | ATest_Field  |
    |Field size (ha)      | 10           |
    |Management type      | Organic      |
    |Is the soil peat?    | Yes          |
    |Land use change      | No           |
    |Add Primary land use | Arable       |
    Then user "Save" the added data
    And verify the success message as "Your records have been successfully added."
    Then edit the field "ATest_Field"
    And user set required data field "Management type" as "Conventional"
    Then user "Save" the added data
    And verify the success message as "Your records have been successfully updated."
    Then verify the field "ATest_Field" is having value as "Conventional"
    Then delete the field "ATest_Field"
    And verify the success message as "Record deleted successfully."


  @Test
  Scenario: Add two fields then multiple edit and delete

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to enterprise data page
    And user clicks on manage data for field "Fields"
    And user clicks on manage data for field "###Test_Farm"
    Then user clicks on add field button
    And enter the required data for Field
      |Field                | Data         |
      |Field name           | ATest_Field  |
      |Field size (ha)      | 10           |
      |Management type      | Organic      |
      |Is the soil peat?    | Yes          |
      |Land use change      | No           |
      |Add Primary land use | Arable       |
    Then user "Save" the added data
    And verify the success message as "Your records have been successfully added."
    Then user clicks on add field button
    And enter the required data for Field
      |Field                | Data         |
      |Field name           | BTest_Field  |
      |Field size (ha)      | 10           |
      |Management type      | Organic      |
      |Is the soil peat?    | Yes          |
      |Land use change      | No           |
      |Add Primary land use | Arable       |
    Then user "Save" the added data
    And verify the success message as "Your records have been successfully added."
    Then click on button "Edit multiple"
    And click on button "Select All"
    Then click on button "Edit selected"
    And user set required data field "Management type" as "Conventional"
    Then user "Save" the added data
    And verify the success message as "Updated successfully"
    Then verify the field "ATest_Field" is having value as "Conventional"
    Then verify the field "BTest_Field" is having value as "Conventional"
    Then delete the field "ATest_Field"
    Then delete the field "BTest_Field"












