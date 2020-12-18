Feature: Oraganization

  Scenario: I want to create an organization by using mandatory fields
   
    When I want to click on organization link in homepage
    And I will click on create oraganization link
    And I create an orgnaziation using mandatory fileds and click on save
    |OrganizationName|
    |Testyantra|
    Then I navigate to organization information and verify 
    

  
