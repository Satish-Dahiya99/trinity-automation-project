Feature: Activate service application

  @Test
  Scenario: Add new crop, Edit and Delete

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Carbon"
    Then click manage data button for "Cropping Data"
    #And click on carbon manage data
    #Then click on Manage data for cropping
    And Select filter with data
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



  @Test
  Scenario: Add new crop, Replicate Data, Edit multiple, Delete Multiple

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Carbon"
    Then click manage data button for "Cropping Data"
    #And remove data "2025" for pre-selected filter
    And Select filter with data
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


  @Test
  Scenario: Add new single biodiversity crop[ed area, edit and delete

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Biodiversity"
    Then click manage data button for "Cropped area"
    And click on add records button
    Then enter cropped area details to calculate the impact of productive land
      |field             | data           |
      |Select year       | 2024           |
      |Select farm       | Grapes |
      |Select field      | GP2            |
      |Crop name         | Alsike Clover  |
      |Crop variety      | Aurora         |
      |Working area (ha) | 5              |
    And click on button "Save"
    And verify the success message as "Data added successfully!"
    And Select filter with data for biodiversity
      |filter           | data           |
      |Select years     | 2024           |
      |Select farms     | Grapes |
      |Select fields    | GP2            |
     # |Select crops     | Alsike Clover  |
    Then verify "Farm name" as "Grapes" is displayed in general information
    Then verify below Crop name and crop variety and working area are displayed in first row
      |Crop name         | Alsike Clover |
      |Crop variety      | Aurora        |
      |Working area (ha) | 5              |
    And "Edit" the data on general information section
    Then update the fields with below data
      |Crop name         | Amateur Veg Asparagus  |
      |Crop variety      | Connovers Colossal     |
      |Working area (ha) | 10                     |
    And click on button "Save"
    And verify the success message as "Data edited successfully!"
    Then verify below Crop name and crop variety and working area are displayed in first row
      |Crop name         | Amateur Veg Asparagus  |
      |Crop variety      | Connovers Colossal     |
      |Working area (ha) | 10                     |
    And "Delete" the data on general information section
    Then click on button "Delete record"
    Then no rows are displayed in general information

  @Test11
  Scenario: Add new single and replicate biodiversity cropped area, edit and delete multiple

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Biodiversity"
    Then click manage data button for "Cropped area"
    And click on add records buttonn
    Then enter cropped area details to calculate the impact of productive land
      |field             | data           |
      |Select year       | 2024           |
      |Select farm       | Grapes |
      |Select field      | GP2            |
      |Crop name         | Alsike Clover  |
      |Crop variety      | Aurora         |
      |Working area (ha) | 5              |
    And click on button "Save"
    And verify the success message as "Data added successfully!"
    And Select filter with data for biodiversity
      |filter           | data           |
      |Select years     | 2024           |
      |Select farms     | Grapes |
      |Select fields    | GP2            |
      #|Select crops     | Alsike Clover  |
    Then verify "Farm name" as "Grapes" is displayed in general information
    Then verify below Crop name and crop variety and working area are displayed in first row
      |Crop name         | Alsike Clover |
      |Crop variety      | Aurora        |
      |Working area (ha) | 5              |
    And click bulk edit button
    Then click on Replicate records button
    And click on button "Select"
    Then select the filters of the records on replicate page
      |Select years  | 2024   |
      |Select farms  | Graped |
      |Select fields | GP2    |
    And select all checkbox for field
    Then click on Save button
    Then verify below Crop name and crop variety and working area are displayed in second row
      |Crop name         | Alsike Clover |
    And click bulk edit button
    Then click on Edit multiple button
    And select all checkbox for general information
    Then click on Edit selected button
    And enter required cropping data for edit multiple
      |Crop name         | Amateur Veg Asparagus  |
      |Crop variety      | Connovers Colossal     |
      |Working area (ha) | 10                     |
    Then click on Save button
    Then verify below Crop name and crop variety and working area are displayed in first row
      |Crop name         | Amateur Veg Asparagus |
      |Crop variety      | Connovers Colossal        |
      |Working area (ha) | 10              |
    Then verify below Crop name and crop variety and working area are displayed in second row
      |Crop name         | Amateur Veg Asparagus |
      |Crop variety      | Connovers Colossal        |
      |Working area (ha) | 10              |
    And click bulk edit button
    Then click on Delete multiple button
    And select all checkbox for general information
    Then click on Delete selected button
    Then click on button "Delete record"
    Then no rows are displayed in general information


  @Test
  Scenario: Add new single biodiversity Natural capital features (non-cropped area), edit and delete

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Biodiversity"
    Then click manage data button for "Natural capital features (non-cropped area)"
    And click on Add records button
    Then enter cropped area details to calculate the impact of productive land
      |field             | data           |
      |Select year       | 2024           |
      |Select farm       | Grapes |
      |Select field      | GP2            |
      |Land use type         | Agroforestry  |
      |Land use name      | Fuel wood trees         |
      |Working area (ha) | 5              |
    And click on button "Save"
    And verify the success message as "Data added successfully!"
    And Select filter with data for biodiversity
      |filter           | data           |
      |Select years     | 2024           |
      |Select farms     | Grapes |
      |Select fields    | GP2            |
     # |Select crops     | Alsike Clover  |
    Then verify "Farm name" as "Grapes" is displayed in general information
    Then verify below Crop name and crop variety and working area are displayed in first row
      |Land use type         | Agroforestry  |
      |Land use name      | Fuel wood trees         |
      |Working area (ha) | 5              |
    And "Edit" the data on general information section
    Then update the fields with below data
      |Land use type         | Linear feature  |
      |Land use name      | Hedgerows     |
      |Working area (ha) | 10                     |
    And click on button "Save"
    And verify the success message as "Data edited successfully!"
    Then verify below Crop name and crop variety and working area are displayed in first row
      |Land use type         | Linear feature  |
      |Land use name      | Hedgerows     |
      |Working area (ha) | 10                     |
    And "Delete" the data on general information section
    Then click on button "Delete record"
    Then no rows are displayed in general information



  @Test
  Scenario: Add new single and replicate biodiversity Natural capital features (non-cropped area), edit and delete multiple data

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Biodiversity"
    Then click manage data button for "Natural capital features (non-cropped area)"
    And click on Add records button
    Then enter cropped area details to calculate the impact of productive land
      |field             | data           |
      |Select year       | 2024           |
      |Select farm       | Grapes |
      |Select field      | GP2            |
      |Land use type         | Agroforestry  |
      |Land use name      | Fuel wood trees         |
      |Working area (ha) | 5              |
    And click on button "Save"
    And verify the success message as "Data added successfully!"
    And Select filter with data for biodiversity
      |filter           | data           |
      |Select years     | 2024           |
      |Select farms     | Grapes |
      |Select fields    | GP2            |
      #|Select crops     | Alsike Clover  |
    Then verify "Farm name" as "Grapes" is displayed in general information
    Then verify below Crop name and crop variety and working area are displayed in first row
      |Land use type         | Agroforestry  |
      |Land use name      | Fuel wood trees         |
      |Working area (ha) | 5              |
    And click bulk edit button
    Then click on Replicate records button
    And click on button "Select"
    Then select the filters of the records on replicate page
      |Select years  | 2024   |
      |Select farms  | Graped |
      |Select fields | GP2    |
    And select all checkbox for field
    Then click on Save button
    Then verify below Crop name and crop variety and working area are displayed in second row
      |Land use type         | Agroforestry  |
    And click bulk edit button
    Then click on Edit multiple button
    And select all checkbox for general information
    Then click on Edit selected button
    And enter required cropping data for edit multiple
      |Land use type         | Linear feature  |
      |Land use name      | Hedgerows     |
      |Working area (ha) | 10                     |
    Then click on Save button
    Then verify below Crop name and crop variety and working area are displayed in first row
      |Land use type         | Linear feature  |
      |Land use name      | Hedgerows     |
      |Working area (ha) | 10                     |
    Then verify below Crop name and crop variety and working area are displayed in second row
      |Land use type         | Linear feature  |
      |Land use name      | Hedgerows     |
      |Working area (ha) | 10                     |
    And click bulk edit button
    Then click on Delete multiple button
    And select all checkbox for general information
    Then click on Delete selected button
    Then click on button "Delete record"
    Then no rows are displayed in general information



















































