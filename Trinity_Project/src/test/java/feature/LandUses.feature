Feature: LandUses single and multiple


   #####################################Add, edit and delete Single data for Land Uses for (Field level)######################

  @Test
  Scenario: Single Add, edit and delete Single data for Land Uses for Field level

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Carbon"
    Then click manage data button for "Land uses"
    Then click on  Field level button
    And select land use data year as "2024"
    And Select filter with data for land use
      | filter       | data           |
      | Select farms | ####Test_Farmm |
      | Select field | Test_Field     |
    Then click on button "+ Add land use"
    And add required encouraged data for land use
      | field      | data           |
      | Type       | Linear feature |
      | Name       | Flower margin  |
      | Area (ha)  | 5              |
      | Length (m) | 10             |
    And click on button "Save"
    Then verify the success message as "Data successfully added"
    And verify the below land uses data in row "1"
      | field | data           |
      | Type  | Linear feature |
      | Name  | Flower margin  |
    And for row "1" data for land uses click on "Edit" button
    And add required encouraged data for land use
      | field         | data                     |
      | Type          | Point feature            |
      | Name          | Timber tree (individual) |
      | Area (ha)     | 6                        |
      | Number (tree) | 11                       |
    And click on button "Save"
    Then verify the success message as "Data successfully updated"
    And verify the below land uses data in row "1"
      | field | data          |
      | Type  | Point feature |
      | Name  | Timber tree   |
    And for row "1" data for land uses click on "Delete" button
    Then click on button "Yes, delete"
    Then verify the success message as "Record deleted successfully"
    Then verify after deleting all data No records are present text is displayed


    #####################################Add, edit and delete Multiple (Replicate) data for Land Uses for (Field level)######################

  @Test11
  Scenario: Add, edit and delete multiple (replicate) data for Land Uses for Field level

    Given User logins to the application
    When user clicks on sandy setup
    Then user navigates to activate each service
    And click manage data button for "Carbon"
    Then click manage data button for "Land uses"
    Then click on  Field level button
    And select land use data year as "2024"
    And Select filter with data for land use
      | filter       | data           |
      | Select farms | ####Test_Farmm |
      | Select field | Test_Field     |
    Then click on button "+ Add land use"
    And add required encouraged data for land use
      | field      | data           |
      | Type       | Linear feature |
      | Name       | Flower margin  |
      | Area (ha)  | 5              |
      | Length (m) | 10             |
    And click on button "Save"
    Then verify the success message as "Data successfully added"
    Then click on button "Replicate records"
    And click on button "Select"
    Then click on select all button for "Select data to replicate" field on Replicate records page
    And select filters on replicate records page
      | field        | data           |
      | Select farms | ####Test_Farmm |
      | Select years | 2024           |
      | Select field | Test_Field     |
    Then expand the "Test_Field" field on replicate records to select year "2024"
    And user clicks on "Save" button on replicate page
    And user clicks on "Ok" button on replicate page
    And verify the below land uses data in row "1"
      | field | data           |
      | Type  | Linear feature |
      | Name  | Flower margin  |
    And verify the below land uses data in row "2"
      | field | data           |
      | Type  | Linear feature |
      | Name  | Flower margin  |
    Then click on button "Edit multiple"
    And click on button "Select All"
    Then click on button "Edit selected"
    And add required encouraged data for land use
      | field         | data                    |
      | Type          | Point feature           |
      | Name          | Fruit tree (individual) |
      | Area (ha)     | 3                       |
      | Number (tree) | 15                      |
    And click on button "Save"
    And verify the below land uses data in row "1"
      | field | data                    |
      | Type  | Point feature           |
      | Name  | Fruit tree (individual) |
    And verify the below land uses data in row "2"
      | field | data                    |
      | Type  | Point feature           |
      | Name  | Fruit tree (individual) |
    Then click on button "Delete multiple"
    And click on button "Select All"
    Then click on button "Delete selected"
    Then click on button "Yes, delete"
    Then verify the success message as "Record(s) deleted successfully"
    Then verify after deleting all data No records are present text is displayed



























