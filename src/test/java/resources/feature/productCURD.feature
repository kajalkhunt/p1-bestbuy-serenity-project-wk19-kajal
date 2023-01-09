Feature: Testing different request on product section of Bestbuy

  Scenario: CURD TEST
    Given Bestbuy Application is running in the background
    When I send a POST request to to create new product
    And I insert name, type, price, shipping, upc, description, manufacture, model, url, image
    And I should get product ID
    And I send a request to get id for newly created product
    And I send a PUT request to update product detail
    And I update name, type, price, shipping, upc, description, manufacture, model, url, image
    And I send a DELETE request to delete product
    Then I verify product has been deleted





