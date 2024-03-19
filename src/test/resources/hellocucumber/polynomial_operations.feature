


Feature: Polynomial Mathematical Operations

  Scenario: Adding two polynomials
    Given I have polynomial P: "3x^2 + 2x + 1"
    And I have polynomial Q: "4x^3 - x^2"
    When I add polynomials P and Q
    Then the result is: "1.0 + 2.0x + 2.0x^2 + 4.0x^3"

  Scenario: Subtracting two polynomials
    Given I have polynomial P: "3x^2 + 2x + 1"
    And I have polynomial Q: "4x^3 - x^2"
    When I subtract polynomials P and Q
    Then the result is: "1.0 + 2.0x + 4.0x^2 - 4.0x^3"

  Scenario: Multiplying two polynomials
    Given I have polynomial P: "3x^2 + 2x + 1"
    And I have polynomial Q: "4x^3 - x^2"
    When I multiply polynomials P and Q
    Then the result is: " - x^2 + 2.0x^3 + 5.0x^4 + 12.0x^5"

  Scenario: Dividing two polynomials
    Given I have polynomial P: "x^3 - 2x^2 + 6x - 5"
    And I have polynomial Q: "x^2 - 1"
    When I divide polynomials P and Q
    Then the result is: "Câtul este:  - 2.0 + x și restul este:  - 7.0 + 7.0x"

  Scenario: Derivative of a polynomial
    Given I have polynomial P: "3x^2 + 2x + 1"
    When I take the derivative of polynomial P
    Then the result is: "2.0 + 6.0x"

  Scenario: Integration of a polynomial
    Given I have polynomial P: "3x^2 + 2x + 1"
    When I integrate polynomial P
    Then the result is: "x + x^2 + x^3"
