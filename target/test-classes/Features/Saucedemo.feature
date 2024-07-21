@tag
Feature: SauceDemo

  Scenario: Verify the filter
    When do login using "standard_user" and "secret_sauce" Sauce Demo credentials
    When Collect the Prices of all products before filter
    When Select filter dropdown "Price (low to high)"
    Then verify the Prices of the products after filter

  @AddProdutstocart
  Scenario Outline: Add mutiple products to cart
    When do login using "standard_user" and "secret_sauce" Sauce Demo credentials
    And add products to cart
      | Products                          |
      | Sauce Labs Backpack               |
      | Sauce Labs Fleece Jacket          |
      | Test.allTheThings() T-Shirt (Red) |
    Then verify number of products in the cart
    And click on the cart
    Then verify the products in the cart which are added
    And click on the checkout
    Then fill the checkout information "First Name","Last Name", "Zip/Postal Code"
    And click on continue
    When verify the item total in the Checkout: Overview page
    Then Click on the Finish
    And click on the Back Home

    Examples: 
      | First Name | Last Name | Zip/Postal Code |
      | name1      | b         |           12345 |
