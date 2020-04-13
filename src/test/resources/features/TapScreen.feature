Feature: Check tap to screen

# This test checks location marker to be present on the map and correct content of text view with location name on the bar at the bottom of the screen

  Scenario Outline: Visit google maps, check address in search field and tap to points
    Given find first value "<value>" with category "<category>"
  # This test tap to selected point on the screen
    Then tap to screen <height>, <width>
    Examples:
      | value  | category | height | width |
      | Moscow | Russia   | 100    | 100   |