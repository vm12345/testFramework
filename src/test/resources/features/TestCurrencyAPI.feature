Feature: test for currency rates UI and API

  Scenario Outline: currency rates UI and API
    Then do requests "<source>" and "<target>"

    Examples:
      | source | target |
      | USD    | JPY    |
      | USD    | EUR    |
      | USD    | KRW    |