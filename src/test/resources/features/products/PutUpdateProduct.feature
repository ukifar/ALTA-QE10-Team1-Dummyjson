Feature: Put update a product

  @Test @PositiveCase @Products
  Scenario Outline: Put update a product with valid id and json body
    Given Put update a product with valid <id> and json body
    When Send put update product
    Then Status code should be 200 OK
    And Response body id should be <id> and title should be "Huawei Novaria"
    And Validate put update product JSON Schema
  Examples:
    | id |
    | 1  |
    | 2  |

  @Test @NegativeCase @Products
 Scenario Outline: Put update a product with blank json body
    Given Put update a product with <id> blank json body
    When Send put update product
    Then Status code should be 400 Bad Request
    And Validate error message JSON Schema
  Examples:
    | id |
    | 1  |
    | 2  |

  @Test @NegativeCase @Products
  Scenario Outline: Put update a product with invalid json body
    Given Put update a product with <id> invalid json body
    When Send put update product
    Then Status code should be 400 Bad Request
    And Validate error message JSON Schema
  Examples:
   | id |
   | 1  |
   | 2  |