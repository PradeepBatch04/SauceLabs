@OrangeHRM
Feature: OrangeHRM
  I want to use this template for my feature file

  @Login
  Scenario Outline: Login into OrangeHRM and Logout
    When login using username as "Admin" and password "admin123"
    Then Verify that Dashboard is dispalyed
    When Click on the "Leave" from the menu
    When Click on the "Admin" from the menu
    Then Verify "<Username>", "<User Role>", "<Employee Name>" and "<Status>"  fields are displayed
    #And fill "Admin" field
    Then click on the search
    And Verify record "<Username>", "<User Role>", "<Employee Name>" and "<Status>"
    When click on the "Logout"
    Then Loginpage should be redisplayed

    Examples: 
      | Username | User Role | Employee Name | Status   |
      | Admin  | Admin       | manda user | Enabled|

  @User
  Scenario: Create new user and verify the user
    When login using username as "Admin" and password "admin123"
    Then Verify that Dashboard is dispalyed
    Then Click on the "Recruitment" from the menu
    And click on the Add button to add user
    Then Verify that Recruitment page is dispalyed
    When Fill mandatory fields "First Name", "Last Name", "Email"
      | First Name | Last Name | Email              |
      | v          | vineesha  | vineesha@gmail.com |
    Then click on the "Save" button
    When Click on the "Recruitment" from the menu
    Then Fill "Candidate Name" field
    And Click on "Search"
    Then Verify the record
    When click on the "Logout"
    Then Loginpage should be redisplayed
