Feature: PATCH Update a Cart
  @Test @PositiveCase @Carts
  Scenario Outline: Patch update a cart with valid parameter id and valid body json should success then return 200 response code
    Given Patch update a cart with valid parameter id <cart> and valid body json
    When Send request patch update a cart
    Then Should return status code 200 OK
    And Response body data user id was <id> and product quantity was <quantity>
    And Validate json schema patch update a cart with valid parameter id and valid body json
    Examples:
      | cart | id | quantity |
      | 1    | 1  | 1        |

  @Test @NegativeCase @Carts
  Scenario Outline: Patch update a cart with valid parameter id and invalid body id should failed then return 400 response code
    Given Patch update a cart with valid parameter id <cart> and invalid body id
    When Send request patch update a cart
    Then Should return status code 400 Bad Request
    And Response body message "<responseBody>"
    Examples:
      | cart | responseBody                              |
      | 1    | Unexpected token % in JSON at position 39 |

  @Test @NegativeCase @Carts
  Scenario Outline: Patch update a cart with exceed parameter id and valid body json should failed then return 404 response code
    Given Patch update a cart with exceed parameter id <cart> and valid body json
    When Send request patch update a cart
    Then Should return status code 404 Not Found
    And Response body message "<responseBody>"
    Examples:
      | cart | responseBody                  |
      | 9999 | Cart with id '9999' not found |