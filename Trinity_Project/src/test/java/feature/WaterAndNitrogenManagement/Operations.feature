Feature: Sandy setup: Activate Services >> Setup - Water & Nitrogen Management: Arable >> Operations



   #####################################Add, edit and delete Single data for Operations######################

  @Test
  Scenario: Single Add, edit and delete Single data for Operations

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Water & Nitrogen Management"
    Then click manage data button for "Operations"
    And Select filter with data for operations
      | filter           | data           |
      | Select years     | 2022           |
      | Select farms     | ####Test_Farmm |
      | Select fields    | Test_Field     |
      | Select crops     | Alsike Clover  |
      | Select varieties | Lomiai         |
    Then click on button "Add records"
    And add required data for operations
      | field             | data                    |
      | Operation group   | Nutrition               |
      | Operation type    | Manufactured Fertiliser |
      | Product name      | BMW                     |
      | Quantity          | 5                       |
      | Unit              | g/ha                    |
      | Applied area (ha) | 6                       |
      | Applied date      | 2022                    |
      | Status            | In-Progress             |
    And click on button "Save"
    Then verify the success message as "Data added successfully!"
    And verify the below operations data in row "1"
      | field           | data                    |
      | Operation group | Nutrition               |
      | Operation type  | Manufactured Fertiliser |
      | Product name    | BMW                     |
    Then for row "1" operations data click on "Edit" action button
    And edit required data for operations
      | field           | data    |
      | Operation group | Seeding |
      | Operation type  | Seeding |
      | Product name    | AUDI    |
      | Quantity        | 4       |
      | Unit            | g/ha    |
    And click on button "Save"
    Then verify the success message as "Data edited successfully!"
    And verify the below operations data in row "1"
      | field           | data    |
      | Operation group | Seeding |
      | Operation type  | Seeding |
      | Product name    | AUDI    |
    Then for row "1" operations data click on "Delete" action button
    Then click on button "Delete record"
    Then no rows are displayed in general information



    #####################################Add, edit and delete Replicate Multiple data for Operations######################

  @Test11
  Scenario: Add, edit and delete Replicate Multiple data for Operations

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Water & Nitrogen Management"
    Then click manage data button for "Operations"
    And Select filter with data for operations
      | filter           | data           |
      | Select years     | 2022           |
      | Select farms     | ####Test_Farmm |
      | Select fields    | Test_Field     |
      | Select crops     | Alsike Clover  |
      | Select varieties | Lomiai         |
    Then click on button "Add records"
    And add required data for operations
      | field             | data                    |
      | Operation group   | Nutrition               |
      | Operation type    | Manufactured Fertiliser |
      | Product name      | BMW                     |
      | Quantity          | 5                       |
      | Unit              | g/ha                    |
      | Applied area (ha) | 6                       |
      | Applied date      | 2022                    |
      | Status            | In-Progress             |
    And click on button "Save"
    Then verify the success message as "Data added successfully!"
    And click on button "Bulk edit"
    Then click on Replicate records button
    And click on button "Select"
    Then check the data point checkbox for operations
    And choose the destination fields for operations
      | field            | value          |
      | Select years     | 2022           |
      | Select farms     | ####Test_Farmm |
      | Select fields    | Test_Field     |
      | Select crops     | Alsike Clover  |
      | Select varieties | Lomiai         |
    Then choose "Select all" checkbox for destination fields for operations
    Then click on Next: Check validations button
    And click on "Records to double-check" category to see records by their status
    Then click on "Duplicate record" warning type
    And verify the warning message displayed as "This entry matches an existing record. Duplicates are allowed but may affect results."
    Then click on Create records button
    And verify the success message displayed as "Your 1 new records was created successfully."
    And verify the below operations data in row "1"
      | field           | data                    |
      | Operation group | Nutrition               |
      | Operation type  | Manufactured Fertiliser |
      | Product name    | BMW                     |
    And verify the below operations data in row "2"
      | field           | data                    |
      | Operation group | Nutrition               |
      | Operation type  | Manufactured Fertiliser |
      | Product name    | BMW                     |
    And click on button "Bulk edit"
    Then click on Edit multiple button
    Then check the select all checkbox
    And click on button "Edit selected"
    And choose data to edit for operations data
      | field                        | data    |
      | Select operation group       | Seeding |
      | Select operation type        | Seeding |
      | Select or enter product name | AUDI    |
    Then click on Next: Check validations button
    Then click on Edit records button
    And verify the success message displayed as "Your 2 records have been successfully updated."
    And verify the below operations data in row "1"
      | field           | data    |
      | Operation group | Seeding |
      | Operation type  | Seeding |
      | Product name    | AUDI    |
    And verify the below operations data in row "2"
      | field           | data    |
      | Operation group | Seeding |
      | Operation type  | Seeding |
      | Product name    | AUDI    |
    And click on button "Bulk edit"
    Then click on Delete multiple button
    Then check the select all checkbox
    And click on button "Delete selected"
    And click on button "Delete record"
    Then no rows are displayed in general information










