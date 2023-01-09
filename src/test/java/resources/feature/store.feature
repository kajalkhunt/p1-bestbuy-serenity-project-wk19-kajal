Feature: Testing different request on store section of Bestbuy

  Scenario: Creating store data
    Given Bestbuy Application is running in the background
    When I send a POST request to to create new store
    And User insert name, type, address, address2, city, state,zip, lat, lng, hours
    Then I should be able to create store successfully
    And I should get store ID

  Scenario: Verify store is created by getting Store info by given Id
    Given Bestbuy Application is running in the background
    When I send a request to get id for newly created store
    Then  I should be able to get store detail successfully

  Scenario: Updating newly added store detail
    Given Bestbuy Application is running in the background
    When I send a PUT request to update store name
    Then I verify name has been updated successfully

  Scenario: Deleting store by given Id
    Given Bestbuy Application is running in the background
    When I send a DELETE request
    Then Store detail should be deleted successfully
    And I verify store has been deleted





