Feature: GET Carts of User
  @Test @PositiveCase @Carts
  Scenario Outline: Get carts of user with valid parameter id should success then return 200 response code
    Given Get carts of user with valid id <id>
    When Send request get carts of user
    Then Should return status code 200 OK
    And Response body data carts id should be [19]
    And Validate json schema get carts of user with valid parameter id
    Examples:
      | id |
      | 5  |

  @Test @NegativeCase @Carts
  Scenario Outline: Get carts of user with invalid parameter id should failed then return 400 response code
    Given Get carts of user with invalid id "<id>"
    When Send request get carts of user
    Then Should return status code 400 Bad Request
    And Response body message "<responseBody>"
    Examples:
      | id        | responseBody                |
      | $*^(&^%%$ | Invalid user id '$*^(&^%%$' |

  @Test @NegativeCase @Carts
  Scenario Outline: Get carts of user with exceed parameter id should failed then return 404 response code
    Given Get carts of user with exceed id <id>
    When Send request get carts of user
    Then Should return status code 404 Not Found
    And Response body message "<responseBody>"
    Examples:
      | id   | responseBody                  |
      | 9999 | User with id '9999' not found |

  @Test @NegativeCase @Carts
  Scenario Outline: Get carts of user with blank parameter id should failed then return 404 response code
    Given Get carts of user with blank parameter id "<id>"
    When Send request get carts of user
    Then Should return status code 404 Not Found
    And Response body message "<responseBody>"
    Examples:
      | id | responseBody                  |
      |    | Cart with id 'user' not found |