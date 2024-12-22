Feature: Activate service application

  ##################### Sandy setup: Activate Services>> Setup – Carbon >> Cropping Data (Single) ############
  @Test
  Scenario: Add new crop, Edit and Delete for Cropping data

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Carbon"
    Then click manage data button for "Cropping Data"
    And Select filter with data
    |filter        | data       |
    |Select farms  | Grapes     |
    |Select field  | GP1        |
    |Select years  | 2024       |
    |remove data   | 2025       |
    Then click on add crop buttonn
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


##################### Sandy setup: Activate Services>> Setup – Carbon >> Cropping Data (Multiple) ############
  @Test
  Scenario: Add new crop, Replicate Data, Edit multiple, Delete Multiple for cropping data

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
    Then click on + Add crop button
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
    And verify the success message as "2 out of 2 selected records were updated."
    And verify tillage type as "Full" is displayed
    Then click on button "Delete multiple"
    Then click on button "Select All"
    Then click on button "Delete selected"
    And user clicks on "Yes" delete button


###### Sandy setup: Activate Services>> Setup – Carbon >> Operational Data , Field Level (Single) ############
  @Test
  Scenario: Add new crop, Edit and Delete for Operational Data, Field Level

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Carbon"
    Then click manage data button for "Operational Data"
    Then click on Field level button
    And select operational data year as "2024"
    And Select filter with data for Operational data
      |filter        | data           |
      |Select farms  | ####Test_Farmm |
      |Select field  | Test_Field     |
    Then click on button "+ Add operations"
    And add required field for Operational Data
      |field             | data                 |
      |Crop name         | Amateur Veg Beetroot |
      |Variety           | Orange Boy           |
      |Operation group   | Crop Protection      |
      |Operation type    | Adjuvants            |
      |Product name      | Test_Prod            |
      |Quantity          | 5                    |
      |Unit              |g/ha                  |
      |Date              |0                     |
    And click on button "Save"
    Then verify the success message as "Data successfully added"
    And verify the product name displayed as "Test_Prod"
    Then "Edit" the data on general information section
    And add product in required data section
      |Product name      | Test_Prod1            |
    And click on button "Save"
    Then verify the success message as "Data successfully updated"
    And verify the product name displayed as "Test_Prod1"
    And "Delete" the data on general information section
    Then click on button "Yes, delete"
    Then verify the success message as "Data successfully deleted"



    ### Sandy setup: Activate Services>> Setup – Carbon >> Operational Data, Field Level (Multiple - Replicate Data) ############
  @Test
  Scenario: Add new crop, Edit and Delete for Operational Data, Field Level (Replicate - Multiple Data)

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Carbon"
    Then click manage data button for "Operational Data"
    Then click on Field level button
    And select operational data year as "2024"
    And Select filter with data for Operational data
      |filter        | data           |
      |Select farms  | ####Test_Farmm |
      |Select field  | Test_Field     |
    Then click on button "+ Add operations"
    And add required field for Operational Data
      |field             | data                 |
      |Crop name         | Amateur Veg Beetroot |
      |Variety           | Orange Boy           |
      |Operation group   | Crop Protection      |
      |Operation type    | Adjuvants            |
      |Product name      | Test_Prod            |
      |Quantity          | 5                    |
      |Unit              |g/ha                  |
      |Date              |0                     |
    And click on button "Save"
    Then verify the success message as "Data successfully added"
    And verify the product name displayed as "Test_Prod"
    Then click on button "Replicate records"
    And click on button "Select"
    Then click select all button for "Select data to replicate" field on Replicate records page
    And replicate filters for farm and fields
      |field         | data           |
      |Select farms  | ####Test_Farmm |
      |Select years  | 2024           |
      |Select crop   | Amateur Veg Beetroot |
    Then click select all button for "Selected fields:" field on Replicate records page
    And user "Save" the added data
    Then user "Ok" the added data
    Then click on button "Edit multiple"
    Then click on button "Select All"
    Then click on button "Edit selected"
    And add product in required data section
      |Product name      | Test_Prod1            |
    And click on button "Save"
    Then verify the success message as "Data updated successfully"
    And verify the product name displayed as "Test_Prod1"
    Then click on button "Delete multiple"
    Then click on button "Select All"
    Then click on button "Delete selected"
    Then click on button "Yes, delete"
    Then verify the success message as "Data successfully deleted"

    ###### Sandy setup: Activate Services>> Setup – Carbon >> Operational Data , Crop Level (Single) ############
  @Test
  Scenario: Add new crop, Edit and Delete for Operational Data, Crop Level

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Carbon"
    Then click manage data button for "Operational Data"
    Then click on Crop level button
    And select operational data year as "2024"
    And Select filter with data for Operational data
      |filter        | data                 |
      |Select farms  | ####Test_Farmm       |
      |Select crop   | Amateur Veg Beetroot |
    Then click on button "+ Add operations"
    And add required field for Operational Data for Crop level
      |field             | data                 |
      |Operation group   | Crop Protection      |
      |Operation type    | Adjuvants            |
      |Product name      | Test_Prod            |
      |Quantity          | 5                    |
      |Unit              |g/ha                  |
      |Date              |0                     |
    And click on button "Save"
    Then verify the success message as "Data added successfully"
    And verify the product name displayed as "Test_Prod"
    Then "Edit" the data on general information section
    And add product in required data section
      |Product name      | Test_Prod1            |
    And click on button "Save"
    Then verify the success message as "Data updated successfully"
    And verify the product name displayed as "Test_Prod1"
    And "Delete" the data on general information section
    Then click on button "Yes, delete"
    Then verify the success message as "Data successfully deleted"


     ### Sandy setup: Activate Services>> Setup – Carbon >> Operational Data , Crop Level (Replicate - Multiple) ############
  @Test
  Scenario: Add new crop, Edit and Delete for Operational Data, Crop Level

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Carbon"
    Then click manage data button for "Operational Data"
    Then click on Crop level button
    And select operational data year as "2024"
    And Select filter with data for Operational data
      |filter        | data                 |
      |Select farms  | ####Test_Farmm       |
      |Select crop   | Amateur Veg Beetroot |
    Then click on button "+ Add operations"
    And add required field for Operational Data for Crop level
      |field             | data                 |
      |Operation group   | Crop Protection      |
      |Operation type    | Adjuvants            |
      |Product name      | Test_Prod            |
      |Quantity          | 8                    |
      |Unit              |g/ha                  |
      |Date              |0                     |
    And click on button "Save"
    Then verify the success message as "Data added successfully"
    And verify the product name displayed as "Test_Prod"
    Then click on button "Replicate records"
    And click on button "Select"
    Then select "Product" checkbox to replicate records
    And replicate filters for farm and fields
      |field         | data           |
      |Select farms  | ####Test_Farmm |
      |Select years  | 2024           |
    Then select first crop to replicate records
    And user "Save" the added data
    Then user "Ok" the added data
    Then click on button "Edit multiple"
    Then click on button "Select All"
    Then click on button "Edit selected"
    And add product in required data section
      |Product name      | Test_Prod1            |
    And click on button "Save"
    Then verify the success message as "Data updated successfully"
    And verify the product name displayed as "Test_Prod1"
    Then click on button "Delete multiple"
    Then click on button "Select All"
    Then click on button "Delete selected"
    Then click on button "Yes, delete"
    Then verify the success message as "2 of 2 record(s) deleted."


#####################################Input data For Crop Protection ######################

  @Test11
  Scenario: Add new crop and verify input data for crop protection

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Carbon"
    Then click manage data button for "Operational Data"
    Then click on Crop level button
    And select operational data year as "2024"
    And Select filter with data for Operational data
      |filter        | data                 |
      |Select farms  | ####Test_Farmm       |
      |Select crop   | Amateur Veg Beetroot |
    Then click on button "+ Add operations"
    And add required field for Operational Data for Crop level
      |field             | data                 |
      |Operation group   | Crop Protection      |
      |Operation type    | Adjuvants            |
      |Product name      | ABC11                |
      |Quantity          | 8                    |
      |Unit              |g/ha                  |
      |Date              |0                     |
    And click on button "Save"
    Then verify the success message as "Data added successfully"
    And verify the product name displayed as "ABC11"
    Then click the 'Setup – Carbon: Arable' breadcrumb item
    Then click manage data button for "Input"
    And click on setup button for 'Crop protection'
    Then select the year as '2024'
    And click edit button for product 'ABC11'
    Then add required data for field 'Active ingredient concentration' as '10.00' for crop protection
    And click on button "Save"
    Then verify the success message as "Your records have been successfully updated."
    And verify the crop protection product details for product 'ABC11' as value '10.00'
    Then click the 'Setup – Carbon: Arable' breadcrumb item
    Then click manage data button for "Operational Data"
    Then click on Crop level button
    And select operational data year as "2024"
    And Select filter with data for Operational data
      |filter        | data                 |
      |Select farms  | ####Test_Farmm       |
      |Select crop   | Amateur Veg Beetroot |
    Then click on button "Delete multiple"
    Then click on button "Select All"
    Then click on button "Delete selected"
    Then click on button "Yes, delete"
    Then verify the success message as "1 of 1 record(s) deleted."

























    

























































































#########################BioDiversity Test Cases (Needs to be moved to another feature file)#########################################

  @Test
  Scenario: Add new single biodiversity crop[ed area, edit and delete

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Biodiversity"
    Then click manage data button for "Cropped area"
    And click on Add records button
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

  @Test
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
      |Select farm       | Grapes         |
      |Select field      | GP2            |
      |Land use type     | Agroforestry   |
      |Land use name     | Fuel wood trees         |
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


  @Test
  Scenario: Add new single biodiversity Natural capital features (non-cropped area), edit and delete

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Biodiversity"
    Then click manage data button for "Management practices"
    And Select filter with data for Management practices
      |Select farm     | Grapes        |
      |Select field    | GP2           |
      |Select land use | Alsike Clover |
    Then click management practice "Apply to" action button
    And select Apply to filter
      |Select farm   | Grapes |
      |Select field  | GP2    |
      |Select year   | 2023   |
    Then click on 2023 button
    And click on SELECT ALL button
    Then click on Apply button
    And verify the success message as "2 out of 2 records saved successfully."



























































