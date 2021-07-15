Feature: A sum of two or more values
  We need to sum values

  Scenario Outline: A positive value will sum
    Given A calculator with initial value of 0.0
    When Try to sum a value <value>
    Then The result should be <value>
    Examples:
      | value |
      | 5.4   |
      | 7.2   |
      | 50.1  |

  Scenario: A sum of multiple values
    Given A calculator with initial value of 1.0
    When Try to sum a value 3.0
    And Try to sum a value 6.0
    Then The result should be 10.0

  Scenario: A null value will throw error
    Given A calculator with initial value of 0.0
    When Try to sum a null value
    Then The error should be a NullPointerException

  Scenario Outline: A negative value will throw error
    Given A calculator with initial value of 0.0
    When Try to sum a value <value>
    Then The error should be an IllegalArgumentException
    Examples:
      | value |
      | -5.4  |
      | -7.2  |
      | -0.1  |
