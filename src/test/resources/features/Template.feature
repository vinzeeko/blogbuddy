Feature: A test feature

  Scenario: A test scenario to show generic step calls (OrderSteps)
    Given I set the state of order '1' to 'STARTED'
    When I change the state of order '1' to 'FINISHED'
    Then I should see the state of order '1' as 'FINISHED'

  Scenario: A test scenario to show specific calls for this feature (FeatureSteps)
    Given I start with the number '7'
    When I multiply by '60'
    Then I should have the result '420'

  Scenario: A test scenario to show a mix of step calls (both step files)
    Given I start with the number '9'
    And I set the state of order '2' to 'STARTED'
    When I multiply by '8'
    And I change the state of order '2' to 'FINISHED'
    Then I should have the result '72'
    And I should see the state of order '2' as 'FINISHED'
