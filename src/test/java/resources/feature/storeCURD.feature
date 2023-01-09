Feature: Testing different request on store section of Bestbuy

  Scenario: CURD TEST
    Given Bestbuy Application is running in the background
    When User insert name, type, address, address2, city, state,zip, lat, lng, hours
    And I should get store ID
    And I send a PUT request to update store name
    And I send a DELETE request
    And Store detail should be deleted successfully
    Then I verify store has been deleted





