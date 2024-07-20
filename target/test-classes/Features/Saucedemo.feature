@tag
Feature: SauceDemo

  @Filter @Regression
  Scenario: Verify the filter
    When do login using "standard_user" and "secret_sauce" Sauce Demo credentials
    When Collect the Prices of all products before filter
    When Select filter dropdown "Price (low to high)"
    Then verify the Prices of the products after filter

  @AddProdutstocart @Regression
  Scenario: Verify the filter
    When do login using "standard_user" and "secret_sauce" Sauce Demo credentials
    And add products to cart
      | Products                          |
      | Sauce Labs Backpack               |
      | Sauce Labs Fleece Jacket          |
      | Test.allTheThings() T-Shirt (Red) |
    Then Click on Cart
    Then verify sum product price and total shoudl be matched
