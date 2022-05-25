Feature: Search and Place the order for Products

  Scenario: Search experience for product search in home and offers page
    Given user is on GreenKart landing page
    When user searches with shortname "Tom" and extract actual name of product
    Then user searches for "Tom" shortname in offers page to check if the product exists.
    And validate if products match.