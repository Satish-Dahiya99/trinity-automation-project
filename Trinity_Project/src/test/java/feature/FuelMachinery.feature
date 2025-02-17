Feature: FuelMachinery


   #####################################Add, edit and delete Multiple data for Fuel Machinery for Field level (Recommended, higher level of accuracy)######################

  @Test
  Scenario: Multiple Add edit and delete data for Fuel Machinery for Field level (Recommended, higher level of accuracy)

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Carbon"
    Then click manage data button for "Fuel - Machinery"
    And select level as "Field level" to record machinery fuel data
    And click on button "Continue"
    Then select filter on field level page
      | filter        | data          |
      | Select years  | 2024          |
      | Select farms  | Grapes        |
      | Select fields | GP3           |
      | Select crops  | Alsike Clover |
    Then click on button "Add fuel data"
    And select the crop variety as "Aurora"
    Then select Encouraged Data for Exact Method
      | field             | data        |
      | Select fuel type  | Bio ethanol |
      | Fuel amount       | 5           |
      | Select unit       | litres      |
      | Select fuel usage | Subsoiling  |
    Then select Encouraged Data for Estimated Method
      | field             | data         |
      | Select fuel type  | Bio petrol   |
      | Select operation  | Flat lifting |
      | No. of operation  | 4            |
      | Select fuel usage | Subsoiling   |
    And click on button "Save"
    Then verify the success message as "Data added successfully"
    And verify data for "Exact" method
      | Fuel Type | Bio ethanol |
      | Usages    | Subsoiling  |
    And verify data for "Estimate" method
      | Fuel Type | Bio Petrol |
      | Usages    | Subsoiling |
    Then for "Exact" method click on "Edit" action button
    Then edit Encouraged Data for Exact Method
      | field             | data         |
      | Select fuel type  | Biodiesel    |
      | Fuel amount       | 5            |
      | Select unit       | litres       |
      | Select fuel usage | Flat lifting |
    And click on button "Save"
    Then verify the success message as "Data updated successfully"
    And verify data for "Exact" method
      | Fuel Type | Biodiesel    |
      | Usages    | Flat lifting |
    When click on button "Delete multiple"
    Then click on select all rows checkbox
    When click on button "Delete selected"
    And click on Yes, Delete button
    Then no rows are displayed in general information


    #####################################Add, edit and delete Multiple data for Fuel Machinery for Crop level (Recommended, higher level of accuracy)######################

  @Test
  Scenario: Add edit and delete data for Fuel Machinery for Crop level

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Carbon"
    Then click manage data button for "Fuel - Machinery"
    And select level as "Crop level" to record machinery fuel data
    And click on button "Continue"
    Then select filter on crop level page
      | filter       | data          |
      | Select years | 2024          |
      | Select farms | Grapes        |
      | Select crop  | Alsike Clover |
    Then click on button "+ Add fuel data"
    And add required data for Carbon Field
      | field            | data        |
      | Select fuel type | Bio ethanol |
      | Amount           | 5           |
    And click on button "Save"
    Then verify the success message "Fuel  data added successfully"
    And click on button "Okay"
    Then verify the added farm level data in row "1"
      | field            | data        |
      | Select fuel type | Bio ethanol |
      | Amount           | 5           |
    And for row "1" data click on "Edit" button
    Then edit the row "1" data for the below fields
      | field     | data      |
      | Fuel type | Biodiesel |
      | Amount    | 8         |
    And click on button "Save"
    Then verify the success message "Fuel data updated successfully"
    And click on button "Okay"
    Then verify the added farm level data in row "1"
      | field            | data        |
      | Select fuel type | Biodiesel   |
      | Amount           | 8           |
    And for row "1" data click on "Delete" button
    And click on Yes, delete button
    Then verify the success message as "Data successfully deleted"
    Then verify after deleting all data No records are present text is displayed



    #####################################Add, edit and delete Single data for Fuel Machinery for Farm level (Arable Enterprise)######################

  @Test
  Scenario: Single Add edit and delete data for Fuel Machinery for Farm level (Arable Enterprise)

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Carbon"
    Then click manage data button for "Fuel - Machinery"
    And select level as "Farm level" to record machinery fuel data
    And click on button "Continue"
    Then select filter on farm level page
      | filter       | data   |
      | Select years | 2024   |
      | Select farms | Grapes |
    Then click on button "+ Add fuel data"
    And add required data for Carbon Field
      | field            | data        |
      | Select fuel type | Bio ethanol |
      | Amount           | 5           |
    And click on button "Save"
    Then verify the success message "Fuel data added"
    And click on button "Okay"
    Then verify the added farm level data in row "1"
      | field            | data        |
      | Select fuel type | Bio ethanol |
      | Amount           | 5           |
    And for row "1" data click on "Edit" button
    Then edit the row "1" data for the below fields
      | field     | data      |
      | Fuel type | Biodiesel |
      | Amount    | 8         |
    And click on button "Save"
    Then verify the success message "Fuel data updated"
    And click on button "Okay"
    Then verify the added farm level data in row "1"
      | field            | data        |
      | Select fuel type | Biodiesel   |
      | Amount           | 8           |
    And for row "1" data click on "Delete" button
    And click on Yes, delete button
    Then verify the success message as "Data successfully deleted"
    Then verify after deleting all data No records are present text is displayed

    #####################################Add, edit and delete Multiple data for Fuel Machinery for Farm level (Arable Enterprise)######################

  @Test
  Scenario: Multiple Add edit and delete data for Fuel Machinery for Farm level (Arable Enterprise)

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Carbon"
    Then click manage data button for "Fuel - Machinery"
    And select level as "Farm level" to record machinery fuel data
    And click on button "Continue"
    Then select filter on farm level page
      | filter       | data   |
      | Select years | 2024   |
      | Select farms | Grapes |
    Then click on button "+ Add fuel data"
    And add required data for Carbon Field
      | field            | data        |
      | Select fuel type | Bio ethanol |
      | Amount           | 5           |
    And click on button "Save"
    Then verify the success message "Fuel data added"
    And click on button "Okay"
    Then click on button "+ Add fuel data"
    And add required data for Carbon Field
      | field            | data        |
      | Select fuel type | Bio Petrol |
      | Amount           | 4           |
    And click on button "Save"
    Then verify the success message "Fuel data added"
    And click on button "Okay"
    Then verify the added farm level data in row "1"
      | field            | data        |
      | Select fuel type | Bio ethanol |
      | Amount           | 5           |
    Then verify the added farm level data in row "2"
      | field            | data        |
      | Select fuel type | Bio Petrol |
      | Amount           | 4           |
    And for row "1" data click on "Edit" button
    Then edit the row "1" data for the below fields
      | field     | data      |
      | Fuel type | Biodiesel |
      | Amount    | 8         |
    And click on button "Save"
    Then verify the success message "Fuel data updated"
    And click on button "Okay"
    Then verify the added farm level data in row "1"
      | field            | data        |
      | Select fuel type | Biodiesel   |
      | Amount           | 8           |
    When click on button "Delete multiple"
    When click on button "Select All"
    When click on button "Delete selected"
    And click on Yes, delete button
    Then verify the success message as "Data successfully deleted"
    Then verify after deleting all data No records are present text is displayed



























