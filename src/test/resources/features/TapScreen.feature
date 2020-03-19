Feature: Check tap to screen

  Scenario: Visit google maps, check address in search field and tap to points
    And find first value "Moscow" with category "Russia"
    And tap to screen 100, 100
