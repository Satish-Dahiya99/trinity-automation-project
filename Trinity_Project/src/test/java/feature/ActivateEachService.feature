Feature: Activate service application

  @Test
  Scenario: Add new crop, Edit and Delete

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click on carbon manage data
    Then click on Manage data for cropping
    And Select filter with data to add crop
    |filter        | data       |
    |Select farms  | Grapes     |
    |Select field  | GP1        |
    |Select years  | 2024       |
    |remove data   | 2025       |
    Then click on add crop button
    And add required data for crop
    |field          | data           |
    |Crop type      | Main crop      |
    |Crop name      | Alsike Clover  |
    |Variety        | Aurora         |
    |Tillage method | Min till       |
    |Yield (t/ha)   | 1              |
    |Straw yield    | 0              |
    |Harvest yield  | 1              |
    Then set date to add crop
    | field       | no of prior days |
    |Planting date|3                 |
    |Harvest date |0                 |
    And user "Save" the added data
    Then verify the data "added" message
    And verify tillage type as "Min till" is displayed
    When user clicks on edit button
    And Edit single required data for crop
    |field          | data           |
    |Tillage method | Full           |
    Then user "Save" the added data
    Then verify the data "updated" message
    And verify tillage type as "Full" is displayed
    Then user clicks on delete button
    Then verify the data "deleted" message



  @Test1
  Scenario: Add new crop, Replicate Data, Edit multiple, Delete Multiple

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click on carbon manage data
    Then click on Manage data for cropping
    #And remove data "2025" for pre-selected filter
    And Select filter with data to add crop
      |filter        | data       |
      |Select farms  | Grapes     |
      |Select field  | GP1        |
      |Select years  | 2024       |
      |remove data   | 2025       |
    Then click on add crop button
    And add required data for crop
      |field          | data           |
      |Crop type      | Main crop      |
      |Crop name      | Alsike Clover  |
      |Variety        | Aurora         |
      |Tillage method | Min till       |
      |Yield (t/ha)   | 1              |
      |Straw yield    | 0              |
      |Harvest yield  | 1              |
    Then set date to add crop
      | field       | no of prior days |
      |Planting date|3                 |
      |Harvest date |0                 |
    And user "Save" the added data
    Then verify the data "added" message
    Then click on button "Replicate records"
    And click on button "Select"
    Then click select all button for "Select data to replicate" field on Replicate records page
    And replicate filters for farm and fields
      |field             | data    |
      |Select farms      | Grapes  |
      |Select field      | GP1     |
    Then click select all button for "Selected fields:" field on Replicate records page
    And user "Save" the added data
    Then user "Ok" the added data
    And verify tillage type as "Min till" is displayed
    Then click on button "Edit multiple"
    Then click on button "Select All"
    Then click on button "Edit selected"
    And Edit single required data for crop
      |field          | data           |
      |Tillage method | Full           |
    And user "Save" the added data
    And verify the success message as "1 out of 1 selected records were updated."
    And verify tillage type as "Full" is displayed
    Then click on button "Delete multiple"
    Then click on button "Select All"
    Then click on button "Delete selected"
    And user clicks on "Yes" delete button
























