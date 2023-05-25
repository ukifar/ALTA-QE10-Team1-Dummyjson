Feature: POST Add a Cart
  @Test @PositiveCase @Carts
    Scenario Outline: Post add a cart with valid json should success then return 201 response code
    Given Post add a cart with valid json
    When Send request post add a cart
    Then Should return status code 200 OK
    And Response body data user id was <userId> and product title was "<title>"
    And Validate json schema add a cart with valid json
    Examples:
      | userId | title    |
      | 1      | iPhone 9 |

  @Test @NegativeCase @Carts
  Scenario Outline: Post add a cart with blank body id should failed then return 400 response code
    Given Post add a cart with blank body id
    When Send request post add a cart
    Then Should return status code 400 Bad Request
    And Response body message "<responseBody>"
    Examples:
      | responseBody        |
      | User id is required |

  @Test @NegativeCase @Carts
  Scenario: Post add a cart with extra body category should failed then return 400 response code
    Given Post add a cart with extra body category
    When Send request post add a cart
    Then Should return status code 400 Bad Request