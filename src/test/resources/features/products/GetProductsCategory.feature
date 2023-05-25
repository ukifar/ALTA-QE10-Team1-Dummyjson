Feature: Get products of a category

  @Test @PositiveCase @Products
  Scenario Outline: Get products of a category with valid parameter page
    Given Get products of a category with valid parameter page <page>
    When Send Get products of a category
    Then Status code should be 200 OK
    And Response body category should be <page>
  Examples:
    | page        |
    | smartphones |
    | laptops     |

  @Test @NegativeCase @Products
  Scenario: Get products of a category with blank parameter page
    Given Get products of a category with '' parameter page
    When Send Get products of a category
    Then Status code should be 404 Not Found
    And Validate error message JSON Schema


  @Test @NegativeCase @Products
  Scenario Outline: Get products of a category with invalid parameter page
    Given Get products of a category with invalid parameter page <page>
    When Send Get products of a category
    Then Status code should be 404 Not Found
    And Validate error message JSON Schema
  Examples:
    | page    |
    | laptops |
    | 12      |
    | %       |