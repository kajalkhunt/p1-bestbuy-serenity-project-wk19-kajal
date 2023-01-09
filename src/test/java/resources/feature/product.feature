Feature: Testing different request on product section of Bestbuy

  Scenario: Creating new product
    Given Bestbuy Application is running in the background
    When I send a POST request to to create new product
    And I insert name, type, price, shipping, upc, description, manufacture, model, url, image
    Then I should be able to create product successfully
    And I should get product ID

  Scenario: Verify product is created by getting product info by given Id
    Given Bestbuy Application is running in the background
    When I send a request to get id for newly created product
    Then  I should be able to get product detail successfully

  Scenario: Updating newly added product detail
    Given Bestbuy Application is running in the background
    When I send a PUT request to update product detail
    And I update name, type, price, shipping, upc, description, manufacture, model, url, image
    Then I verify product has been updated successfully

  Scenario: Deleting store by given Id
    Given Bestbuy Application is running in the background
    When I send a DELETE request to delete product
    Then product detail should be deleted successfully
    And I verify product has been deleted






