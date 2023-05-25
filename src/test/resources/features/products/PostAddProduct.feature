Feature: Add a new product

  @Test @PositiveCase @Products
  Scenario: Post add a new product with valid json body
    Given Post add a new product with valid json body
    When Send post add new product
    Then Status code should be 201 Created
    And Response body title should be "Huawei P80"
    And Validate post add new product JSON Schema

  @Test @NegativeCase @Products
  Scenario: Post add a new product with blank json body
    Given Post add a new product with blank json body
    When Send post add new product
    Then Status code should be 400 Bad Request
    And Validate error message JSON Schema

  @Test @NegativeCase @Products
  Scenario: Post add a new product with invalid json body
    Given Post add a new product with invalid json body
    When Send post add new product
    Then Status code should be 400 Bad Request
    And Validate error message JSON Schema