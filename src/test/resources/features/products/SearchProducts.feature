Feature: Search Products

  @Test @PositiveCase @Products
  Scenario Outline: Search products with valid attribute
    Given Search products with valid attribute <search>
    When Send search products
    Then Status code should be 200 OK
  Examples:
    | search |
    | phone  |
    | 12     |
    | @      |
    | %      |

  @Test @NegativeCase @Products
  Scenario: Search products with blank
    Given Search products with '' search
    When Send search products
    Then Status code should be 400 Bad Request
    And Validate error message JSON Schema