Feature: Get All Products

  @Test @PositiveCase @Products
  Scenario: Get all products with valid parameter page
    Given Get all products with valid parameter page
    Then Status code should be 200 OK
    And Validate get all products JSON Schema

  @Test @NegativeCase @Products
  Scenario Outline: Get all products with invalid parameter page
    Given Get all products with invalid parameter page <page>
    When Send get all products
    Then Status code should be 404 Not Found
  Examples:
    | page   |
    | produk |
    | produc |