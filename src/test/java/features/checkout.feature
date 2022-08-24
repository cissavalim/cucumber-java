Feature: Place the order for Products

  @PlaceOrder
  Scenario Outline: Search experience for product search in home and offers page

    Given user is on GreenKart landing page
    When user searches with shortname "<Name>" and extract actual name of product
    And adds 3 items of the selected product to cart
    Then proceeds to checkout and validate the "<Name>" items in checkout page
    And verify if user has ability to enter promo code and place order

    Examples:
    | Name  |
    | Tom   |
