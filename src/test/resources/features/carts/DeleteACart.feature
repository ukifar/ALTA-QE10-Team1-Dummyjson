Feature: DELETE a Cart
  @Test @PositiveCase @Carts
  Scenario Outline: Delete a cart with valid parameter id should success then return 204 response code
    Given Delete a cart with valid parameter id <id>
    When Send request delete a cart
    Then Should return status code 200 OK
    Examples:
      | id |
      | 1  |

  @Test @NegativeCase @Carts
  Scenario Outline: Delete a cart with invalid parameter id should failed then return 404 response code
    Given Delete a cart with invalid parameter id "<id>"
    When Send request delete a cart
    Then Should return status code 404 Not Found
    And Response body message "<responseBody>"
    Examples:
      | id     | responseBody                    |
      | JVytUX | Cart with id 'JVytUX' not found |

  @Test @NegativeCase @Carts
  Scenario Outline: Delete a cart with exceed parameter id should failed then return 404 response code
    Given Delete a cart with exceed parameter id <id>
    When Send request delete a cart
    Then Should return status code 404 Not Found
    And Response body message "<responseBody>"
    Examples:
      | id   | responseBody                  |
      | 7777 | Cart with id '7777' not found |

  @Test @NegativeCase @Carts
  Scenario Outline: Delete a cart with blank parameter id should failed then return 404 response code
    Given Delete a cart with blank parameter id "<id>"
    When Send request delete a cart
    Then Should return status code 404 Not Found
    Examples:
      | id |
      |    |