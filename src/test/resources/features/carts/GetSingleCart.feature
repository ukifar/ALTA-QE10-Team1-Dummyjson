Feature: GET a Single Cart
  @Test @PositiveCase @Carts
  Scenario Outline: Get a single cart with valid parameter id should success then return 200 response code
    Given Get single cart with valid id <id>
    When Send request get single cart
    Then Should return status code 200 OK
    And Response body id should be <id>
    And Validate json schema get single cart with valid parameter id
    Examples:
      | id |
      | 1  |

  @Test @NegativeCase @Carts
  Scenario Outline: Get a single cart with invalid parameter id should failed then return 404 response code
    Given Get single cart with invalid id "<id>"
    When Send request get single cart
    Then Should return status code 404 Not Found
    And Response body message "Cart with id 'JVytUX' not found"
    Examples:
      | id     |
      | JVytUX |

  @Test @NegativeCase @Carts
  Scenario Outline: GET a single cart with exceed parameter id should failed then return 404 response code
    Given Get single cart with exceed parameter id <id>
    When Send request get single cart
    Then Should return status code 404 Not Found
    And Response body message "Cart with id '7777' not found"
    Examples:
      | id   |
      | 7777 |

  @Test @NegativeCase @Carts
  Scenario Outline: GET a single cart with blank parameter id should failed then return 404 response code
    Given Get a single cart with blank parameter id "<id>"
    When Send request get single cart
    Then Should return status code 404 Not Found
    Examples:
      |id|
      |  |

