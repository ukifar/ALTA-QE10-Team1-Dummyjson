Feature: Delete a product

  @Test @PositiveCase @Products
  Scenario Outline: Delete a product with valid id
    Given Delete a product with valid id <id>
    When Send delete product
    Then Status code should be 200 OK
    And Response body id should be <id> and deleted is true
    And Validate delete product JSON Schema
  Examples:
    | id |
    | 1  |
    | 56 |

  @Test @NegativeCase @Products
  Scenario: Delete a  product with blank id
    Given Delete a  product with '' id
    When Send delete product
    Then Status code should be 400 Bad Request
    And Validate error message JSON Schema

  @Test @NegativeCase @Products
  Scenario Outline: Delete a  product with invalid id
    Given Delete a product with invalid id <id>
    When Send delete product
    Then Status code should be 404 Not Found
    And Validate error message JSON Schema
  Examples:
    | id   |
    | 167  |
    | satu |
    | %    |