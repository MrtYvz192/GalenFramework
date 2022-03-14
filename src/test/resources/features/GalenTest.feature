Feature: First test of Galen
@wip
  Scenario: testapp galen verification
    Given the user is on the testapp page
    And the page layout is checked
    When the user clicks on the Login button
    And the user provides username and password
    Then the user should be able to login
    And the layout should be valid