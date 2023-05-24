Feature: PUT Update a Cart
  @Test @PositiveCase @Carts
  Scenario Outline: Put update a cart with valid parameter id and valid body json should success then return 200 response code
    Given Put update a cart with valid parameter id <cart> and valid body json
    When Send request put update a cart
    Then Should return status code 200 OK
    And Response body data user id was <id> and product quantity was <quantity>
    And Validate json schema update a cart with valid parameter id and valid body json
    Examples:
      | cart | id | quantity |
      | 1    | 1  | 1        |

  @Test @NegativeCase @Carts
  Scenario Outline: Put update a cart with invalid body json and valid parameter id should failed then return 400 response code
    Given Put update a cart with invalid body json and valid parameter id <cart>
    When Send request put update a cart
    Then Should return status code 400 Bad Request
    And Response body message "<responseBody>"
    Examples:
      | cart | responseBody                              |
      | 1    | Unexpected token % in JSON at position 39 |

  @Test @NegativeCase @Carts
    Scenario Outline: Put update a cart with valid body json and blank parameter id should failed then return 404 response code
    Given Put update a cart with valid body json and blank parameter id "<cart>"
    When Send request put update a cart
    Then Should return status code 404 Not Found
    Examples:
      | cart |
      |      |

  @Test @NegativeCase @Carts
  Scenario Outline: Put update a cart with blank body json and blank parameter id should failed then return 404 response code
    Given Put update a cart with blank body json and blank parameter id "<cart>"
    When Send request put update a cart
    Then Should return status code 404 Not Found
    Examples:
      | cart |
      |      |