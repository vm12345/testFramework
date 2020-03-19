Feature: Check tap to screen

# This test checks location marker to be present on the map and correct content of text view with location name on the bar at the bottom of the screen

  Scenario: Visit google maps, check address in search field and tap to points
    And find first value "Moscow" with category "Russia"

  # This test tap to selected point on the screen

    And tap to screen 100, 100
