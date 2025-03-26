Feature: Sandy setup: Activate Services >> Setup - Water & Nitrogen Management: Arable >> Cropping data



   #####################################Add, edit and delete Single data for Cropping Data######################

  @Test
  Scenario: Single Add, edit and delete Single data for Cropping Data

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Water & Nitrogen Management"
    Then click manage data button for "Cropping data"
    And Select filter with data for cropping data
      | filter        | data           |
      | Select years  | 2024           |
      | Select farms  | ####Test_Farmm |
      | Select fields | Test_Field     |
    Then click on button "Add records"
    And add required data for cropping data
      | field             | data          |
      | Crop type         | Main crop     |
      | Crop name         | Alsike Clover |
      | Crop variety      | Aurora        |
      | Tillage method    | Full          |
      | Working area (ha) | 3             |
      | Yield (t/ha)      | 5             |
    Then set "Planting date" for year "2024"
    Then set "Harvest date" for year "2024"
    And click on button "Save"
    Then verify the success message as "Data added successfully!"
    And verify the below cropping data in row "1"
      | field        | data          |
      | Crop type    | Main Crop     |
      | Crop name    | Alsike Clover |
      | Crop variety | Aurora        |
    Then for row "1" data click on "Edit" action button
    And add required data for cropping data
      | field             | data       |
      | Crop type         | Cover crop |
      | Crop name         | Blue Lupin |
      | Crop variety      | Azuro      |
      | Tillage method    | Min till   |
      | Working area (ha) | 2          |
      | Yield (t/ha)      | 4          |
    And click on button "Save"
    Then verify the success message as "Data edited successfully!"
    And verify the below cropping data in row "1"
      | field        | data       |
      | Crop type    | Cover Crop |
      | Crop name    | Blue Lupin |
      | Crop variety | Azuro      |
    Then for row "1" data click on "Delete" action button
    Then click on button "Delete record"
    Then no rows are displayed in general information

    #####################################Add, edit and delete Multiple data for Cropping Data######################

  @Test11
  Scenario: Multiple Add, edit and delete Single data for Cropping Data

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Water & Nitrogen Management"
    Then click manage data button for "Cropping data"
    And Select filter with data for cropping data
      | filter        | data           |
      | Select years  | 2024           |
      | Select farms  | ####Test_Farmm |
      | Select fields | Test_Field     |
    Then click on button "Add records"
    And add required data for cropping data
      | field             | data          |
      | Crop type         | Main crop     |
      | Crop name         | Alsike Clover |
      | Crop variety      | Aurora        |
      | Tillage method    | Full          |
      | Working area (ha) | 3             |
      | Yield (t/ha)      | 5             |
    Then set "Planting date" for year "2024"
    Then set "Harvest date" for year "2024"
    And click on button "Save"
    Then verify the success message as "Data added successfully!"
    And click on button "Bulk edit"
    Then click on Replicate records button
    And click on button "Select"
    Then check the data point checkbox
    And select the destination fields
      | field         | value          |
      | Select years  | 2024           |
      | Select farms  | ####Test_Farmm |
      | Select fields | F2             |
    Then choose "Select all" checkbox for destination fields
    Then click on Next: Check validations button
    Then click on Create records button
    And verify the success message displayed as "Your 1 new records was created successfully."
    And remove "Test_Field" value from filter
    Then open "Select fields" filter dropdown and select below values
      | values     |
      | F2         |
      | Test_Field |
    And verify the below cropping data in row "1"
      | field        | data          |
      | Crop type    | Main Crop     |
      | Crop name    | Alsike Clover |
      | Crop variety | Aurora        |
    And verify the below cropping data in row "3"
      | field        | data          |
      | Crop type    | Main Crop     |
      | Crop name    | Alsike Clover |
      | Crop variety | Aurora        |
    And click on button "Bulk edit"
    Then click on Edit multiple button
    Then check the select all checkbox
    And click on button "Edit selected"
    And choose data to edit for cropping data
      | field                 | data       |
      | Select crop type      | Cover crop |
      | Select crop name      | Blue Lupin |
      | Select crop variety   | Azuro      |
      | Select tillage method | Min till   |
    Then click on Next: Check validations button
    Then click on Edit records button
    And verify the success message displayed as "Your 2 records have been successfully updated."
    And verify the below cropping data in row "1"
      | field        | data       |
      | Crop type    | Cover Crop |
      | Crop name    | Blue Lupin |
      | Crop variety | Azuro      |
    And verify the below cropping data in row "3"
      | field        | data       |
      | Crop type    | Cover Crop |
      | Crop name    | Blue Lupin |
      | Crop variety | Azuro      |
    And click on button "Bulk edit"
    Then click on Delete multiple button
    Then check the select all checkbox
    And click on button "Delete selected"
    And click on button "Delete record"
    Then no rows are displayed in general information
















#    Then click on button "Add records"
#    And add required data for cropping data
#      | field             | data       |
#      | Crop type         | Cover crop |
#      | Crop name         | Blue Lupin |
#      | Crop variety      | Azuro      |
#      | Tillage method    | Min till   |
#      | Working area (ha) | 2          |
#      | Yield (t/ha)      | 4          |
#    Then set "Planting date" for year "2024"
#    Then set "Harvest date" for year "2024"
#    And click on button "Save"
#    Then verify the success message as "Data added successfully!"
#    Then click on button "Bulk edit"
#    And click on "Edit multiple" button
#    Then check the select all checkbox
#    And click on button "Edit selected"











