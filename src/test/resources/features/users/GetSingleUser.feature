Feature: GET
  @Test @PositiveCase @Users
  Scenario Outline: Get a single users with valid parameter id
    Given Get single  with valid id <id>
    When Send request get single users
    Then Status Code should be 200 OK
    And Response body id should be <id>
    And Validate json schema get single users with valid parameter id
    Examples:
      | id |
      | 1  |
      | 2  |

    @Test @NegativeCase @Users
  Scenario Outline: Get a single users with invalid parameter id
    Given Get a single with invalid id <id>
    When Send request get single users invalid
    Then Status Code should be 404 Not Found
    And Validate json schema get single users with invalid parameter id
    Examples:
      | id  |
      | 888 |
      | 214 |
