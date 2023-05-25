Feature: Post a new user
  @Test @PositiveCase @Users
  Scenario: Add a new user with valid json
    Given Post create user with valid json
    When Send post create user
    Then Status Code should be 200 OK
    And Response body fistName was "Muhammad" lastName was "Ovi" age was "250"
    And Validate post create user JSON Schema


@Test @NegativeCase @Users
  Scenario: add a new user with invalid parameter
  Given Post create new user with invalid parameter
  When Send post create user
  Then Status code should be 400 Bad Request
  And Validate post create new user JSON Schema