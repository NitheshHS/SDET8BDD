

Feature: DataDriven
  @SmokeTest
  Scenario: Read the data using list
  When user want to fill the registration form
  |user|user@gmail.com|user123|12345|
  
    
  Scenario: read the data using map
   When user want to fill the registration form in application
  |username|email|password|phNo|
  |user|user@gmail.com|user123|12345|