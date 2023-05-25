Feature: Get all products category

  @Test @PositiveCase @Products
  Scenario: Get all products category with valid parameter page
    Given Get all products category with valid parameter page
    Then Status code should be 200 OK
    And Validate get all products category JSON Schema

  @Test @NegativeCase @Products
  Scenario: Get all products category with invalid parameter page
    Given Get all products category with invalid parameter page
    Then Status code should be 404 Not Found
    And Validate error message JSON Schema