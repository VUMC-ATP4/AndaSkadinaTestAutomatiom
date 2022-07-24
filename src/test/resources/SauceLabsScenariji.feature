Feature: 10th house work scenarios


  Scenario: Operations with placing the product in the cart and completing the cart
    Given user is loged in
    Then user sees inventory page
    When user clicks Add to cart  Sauce labs backpack
    And user clicks Cart link
    Then user sees in Cart product 'Sauce Labs Backpack'
    When user clicks Checkout button
    And user enters  'Anda', 'Skadina','LV3018'
    And user clicks continue button
    Then user sees product 'Sauce Labs Backpack'
    And user sees payment text 'Payment information:'
    And user sees in the next row payment detal ext 'SauceCard#31337'
    And user sees shiping text 'Shipping information:'
    And user sees in the next row shipingdetal text 'FREE PONY EXPRESS DELIVERY!'
    And user sees in the next row  item total sum text 'Item total: $29.99'
    And user sees in the next row  tax sum text 'Tax: $2.40'
    And user sees in the next row  total sum text 'Total: $32.39'
    When user clicks FINISH button
    Then user sees page 'CHECKOUT: COMPLETE!'
    When user clicks BACK HOME button
    Then user sees inventory page


#  Scenario: Checkout all empty
#    Given user navigates to 'https://www.saucedemo.com'
#    And user sees page title 'Swag Labs'
#    And user enters 'standard_user' and 'secret_sauce'
#    And user clicks login button
#    Then user sees inventory page
#    When user clicks Cart link
#    And user clicks Checkout button
#    Then user sees checkout page
#    When user clicks continue button
#    Then user sees error message  'Error: First Name is required'
#
#  Scenario Outline: Checkout by changing the parameters
#    Given user is loged in
#    When user enter '<First Name>','<LastName>','<Ptostal Code>'
#    Then user sees error message '<Error>'
#    Examples:
#      | First Name | LastName | Postal Code | Error                          |
#      | Anda       |          | LV3018      | Error: Last Name is required   |
#      |            | Skadina  | LV3018      | Error: First Name is required  |
#      | Anda       | Skadina  |             | Error: Postal Code is required |
#      |            |          | LV3018      | Error: First Name is required  |


