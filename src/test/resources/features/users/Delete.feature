Feature: Delete Users
  @Test @PositiveCase @Users
  Scenario Outline: Delete user with valid parameter id
  Given Delete user with valid id <id>
  When Send delete user
  Then Status Code should be 200 OK
  Examples:
    | id |
    | 1  |
    | 2  |

  @Test @NegativeCase @Users
  Scenario Outline: Delete user with invalid parameter
  Given Delete user with invalid id <id>
  When Send delete user
  Then Status Code should be 404 Not Found
  Examples:
    | id  |
    | 888 |