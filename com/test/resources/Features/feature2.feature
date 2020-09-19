Feature: Feature 2
  
  Scenario: Feature
    Given launch browser 'chrome'
    When user navigates to 'http://www.google.com'
    Then user enters search terms 'Teqsar'
    And clicks on search button
    