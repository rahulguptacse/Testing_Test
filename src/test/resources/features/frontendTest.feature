Feature: Selenium Test

  @FrontendTest
  Scenario: 1: Write an end-to-end test to fill in and submit a form
    Given I am on 'https://www.seleniumeasy.com/test/input-form-demo.html' website
    When user enter his details
      | FirstName| Rahul  |
      | LastName | Gupta  |
      | Email    | rahulguptacse@gmail.com|
      | Phone    | 1202002020 |
      | Address  | 16 canberra |
      | City     | Milton Keynes|
      | State    | Alabama      |
      | ZIPCode  |11009      |
      | Website  | www.test.com |
      | Hosting  | Yes           |
      | Description | Test project|
    And click on Send button
    Then Form is submitted

  @FrontendTest
  Scenario: 2: the average age of all the employees
    Given I am on 'https://www.seleniumeasy.com/test/table-sort-search-demo.html' website
    And I search for 'San Francisco'
    Then Average is '46'

  @FrontendTest
  Scenario: 3: Highest Salary
    Given I am on 'https://www.seleniumeasy.com/test/table-sort-search-demo.html' website
    And I search for 'Software Engineer'
    Then Highest Salary is '$206,850/y'