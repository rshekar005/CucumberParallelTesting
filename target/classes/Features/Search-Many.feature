Feature: Direct Search
  
  Scenario: Direct Search using firefox
    Given launch browser 'chrome'
    When user navigates to 'http://www.google.com'
    Then user enters search terms 'way2automation'
    And clicks on search button
    
    Scenario: Direct Search Using google
    Given launch browser 'chrome'
    When user navigates to 'http://www.google.com'
    Then user enters search terms 'facebook'
    And clicks on search button
