Feature: nopcommerce
#hello busy people
  Scenario Outline: Login into nopcommerce and Logout
    When do login using "admin@yourstore.com" and "admin" credentials
    Then verify the dashboard displayed
    When Click the "Configuration" from the menu
    And Click on the "Customer roles" in Catalog
    And Click on the subItem "Settings" and subsubItem "Tax settings" in Catalog
    When fill the filter details of Product "<Productname>" "<Category>" "<Published>" "<SKU>"
    And Click on Search button
    Then Verify the record in Products table "<Productname>" "<SKU>" "<Price>" "<Stockquantity>" "<Published>" "checkbox"
    And Click on Logout

    Examples: 
      | Productname             | Category              | Published      | SKU       | Price | Stockquantity |
      | Build your own computer | Computers >> Desktops | Published only | COMP_CUST |  1200 |         10000 |
      
      
      
      #Search the table --vineesha

  Scenario Outline: Login into nopcommerce and verify the product in table in catalog and logout
    When do login using "admin@yourstore.com" and "admin" credentials
    Then verify the dashboard displayed
    When Click the "Catalog" from the menu
    And Click on the "Products" in Catalog
    When fill the filter details of Product "<Productname>" "<Category>" "<Published>" "<SKU>"
    And Click on Search button
    Then Verify the record in Products table "<Productname>" "<SKU>" "<Price>" "<Stockquantity>" "<Published>" "checkbox"
    And Click on Logout

    Examples: 
      | Productname             | Category              | Published      | SKU       | Price | Stockquantity |
      | Build your own computer | Computers >> Desktops | Published only | COMP_CUST |  1200 |         10000 |
