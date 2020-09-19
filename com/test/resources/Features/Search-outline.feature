Feature: Searching on Google using scenario outline

  Scenario Outline: Search Using scenario outline
    Given launch browser '<browsername>'
    When user navigates to '<url>'
    Then user enters search terms '<search>'
    And clicks on search button

    Examples: 
      | browsername | url                   | search         |
      | chrome      | http://www.google.com | whatsapp |
      | chrome     | http://www.google.com | yahoo       |
