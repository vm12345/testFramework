Feature: Check address in google maps

# This test checks location marker to be present on the map and correct content of text view with location name on the bar at the bottom of the screen

  Scenario Outline: Visit google maps, check address in search field
    Given find first value "<value>" with category "<category>"
    Then find first value "<value>" with category "<category>"
    Examples:
      | value  | category |
      | Moscow | Russia   |
      | Moskva | Russia   |
      | Tallin | Estonia  |
