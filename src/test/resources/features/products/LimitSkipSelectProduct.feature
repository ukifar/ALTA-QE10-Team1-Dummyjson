Feature: Limit, skip, and select products

  @Test @PositiveCase @Products
  Scenario Outline: Limit, skip, and select products with valid parameter page
    Given Limit <limit>, skip <skip>, and select <select> products with invalid parameter page
    When Send get limit skip select
    Then Status code should be 200 OK
    And Response body limit should be <limit> skip should be <skip>
  Examples:
    | limit | skip | select         |
    | 10    | 10   | title,price    |
    | 67    | 20   | title,category |

  @Test @NegativeCase @Products
  Scenario: Limit, skip, and select products with blank parameter page
    Given Limit '', skip '', and select '' products with blank parameter page
    When Send get limit skip select
    Then Status code should be 400 Bad Request
    And Validate error message JSON Schema

  @Test @NegativeCase @Products
  Scenario Outline: Limit, skip, and select products with invalid parameter page
    Given Limit <limit>, skip <skip>, and select <select> products with invalid parameter page
    When Send get limit skip select
    Then Status code should be 400 Bad Request
    And Validate error message JSON Schema
  Examples:
    | limit | skip | select         |
    | satu  | 10   | title,price    |
    | 10    | satu | title,category |
    | 10    | 10   | harga          |