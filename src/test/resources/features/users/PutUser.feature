Feature: PUT user API Automation Testing
  @Test @PositiveCase @Users
  Scenario Outline: PUT User with valid parameter id
    Given PUT user with valid json and id <id>
    When Send put update user
    Then Status Code should be 200 OK
    And Response body lastName was "Owais"
    Examples:
      | id |
      | 1  |
      | 2  |

  @Test @NegativeCase @Users
  Scenario Outline: PUT user with invalid parameter
    Given Put user with invalid id <id>
    When Send put update user
    Then Status Code should be 404 Not Found
    And Validate put invalid JSON Schema
    Examples:
      | id  |
      | 888 |