Feature: POST Login User
  @Test @PositiveCase @Carts
  Scenario Outline: : Login user with valid username and password should success then return 200 response code
    Given Login with valid JSON
    When Send request post to login
    Then Should return status code 200 OK
    And And Response body email should be "<email>"
    And Validate json schema success login with valid username and password
    Examples:
      | email             |
      | kminchelle@qq.com |

  @Test @NegativeCase @Carts
  Scenario Outline: Login with valid username and blank password should failed then return 400 response code
    Given Login with invalid JSON
    When Send request post to login
    Then Should return status code 400 Bad Request
    And Response body message "<responseBody>"
    And Validate json schema failed login
    Examples:
      | responseBody        |
      | Invalid credentials |