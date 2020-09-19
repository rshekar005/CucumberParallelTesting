Feature: Feature 3
  
  Scenario: Direct Search using chrome
    Given launch browser 'chrome'
    When user navigates to 'http://www.google.com'
    Then user enters search terms 'mfino'
    And clicks on search button
    