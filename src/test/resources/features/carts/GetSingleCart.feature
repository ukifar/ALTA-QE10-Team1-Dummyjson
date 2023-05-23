Feature: GET a Single Cart
  @Test @PositiveCase @Carts
  Scenario Outline: Get a single cart with valid parameter id should success then return 200 response code
    Given Get single cart with valid id <id>
    When Send request get single cart
    Then Should return status code 200 OK
    And Response body id should be <id>
    And Validate json schema get single cart with valid parameter id
    Examples:
      | id |
      | 1  |

