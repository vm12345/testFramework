Feature: Check random address in google maps

  Scenario Outline: Visit google maps, check address in search field
    And find random value "<value>" with category "<category>"
    And find random value "<value>" with category "<category>"

    Examples:
      | value  | category |
      | Moscow | Russia   |
      | Moskva | Russia   |
      | Tallin | Russia   |
