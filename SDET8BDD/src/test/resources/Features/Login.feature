#Author: your.email@your.domain.com
Feature: Login feature

  Background: 
    Given I want to launch the browser
    And I enter the url "http://localhost:8888/"

@SmokeTest
  Scenario: I want to login to vtiger application using valid credentials
    When Login page is displayed enter the username and password and click on login
    Then Home page should be displayed
@RegressionTest
  Scenario: I want to login to vtiger application using invalid credentials
    When Login page is displayed enter the username "admin123" and password "manager123" and click on login
    Then Home page should be not be displayed and error messege should be displayed
@End2End
  Scenario Outline: I want to login to application with multiple invalid credentials
    When login page is diplayed enter "<username>" and "<password>" and click on login button
    Then Home page should be not be displayed and error messege should be displayed

    Examples: 
      | username | password |
      | admin    | admin123 |
      | admin123 | manager  |
