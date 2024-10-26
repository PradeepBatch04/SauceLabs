Feature: Dezlearn

  Background: 
    Given read the test data "<TestCase_ID>" "<Filename>" "Sheetname"

  @test1
  Scenario Outline: Verify Test Sync Example
    When click on Test Sync Example
    Then verify "Test Sync Example" displayed
    When fill the details "Firstname", "Lastname", "Email"
    Then click on Submit button
    And verify the ticket number

    Examples: 
      | TestCase_Id | FileName | SheetName |
      | TC_DEZ_002  | DEZ.xlsx | DEZ1      |
      | TC_DEZ_003  | DEZ.xlsx | DEZ1      |
      | TC_DEZ_001  | DEZ.xlsx | DEZ1      |
