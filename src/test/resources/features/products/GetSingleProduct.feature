Feature: Get a single product

  @Test @PositiveCase @Products
  Scenario Outline: Get a single product with valid id
    Given Get a single product with valid id <id>
    When Send get a single product
    Then Status code should be 200 OK
    And Response body should be id <id>
    And Validate get a single product JSON Schema
  Examples:
    | id |
    | 1  |
    | 34 |

  @Test @NegativeCase @Products
  Scenario: Get a single product with blank id
    Given Get a single product with '' id
    When Send get a single product
    Then Status code should be 200 OK
    And Validate get all products JSON Schema

  @Test @NegativeCase @Products
  Scenario Outline: Get a single product with invalid id
    Given Get a single product with invalid id <id>
    When Send get a single product
    Then Status code should be 404 Not Found
    And Validate error message JSON Schema
  Examples:
    | id   |
    | 1000 |
    | satu |
    | %    |