Feature: Check address in google maps

# This test checks location marker to be present on the map and correct content of text view with location name on the bar at the bottom of the screen

  Scenario: Visit google maps, check address in search field
    And find first value "Moscow" with category "Russia"
    And find first value "Moskva" with category "Russia"
