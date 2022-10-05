
@tag
Feature: Summer Dress Shopping
  
  @tag1
  Scenario: Successfuly Search Summer Dress
    Given User Launch Chrome browser
    Then User opens URL "http://automationpractice.com/index.php"
    And Enter "summer dress" in search box
    Then Click on Search icon
    Then Page Title should be "Search - My Store"
    


