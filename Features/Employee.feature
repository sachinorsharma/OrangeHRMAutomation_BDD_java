Feature: Scenarios related to Employee

  Background: Background steps
    Given User Launch Chrome browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/index.php/auth/login"
    And User Enters username as "Admin" and Password as "admin123"
    And Click on Login

  @AddEmp
  Scenario Outline: Add new Employee
    When User hover over PIM menu
    And clicks on Add Employee menu item
    Then User fills info of new Employee <First name> <Middle name> <Last name>
    And clicks on Save button
    Then User is added successfully
    Then close the browser

    Examples: 
      | First name | Middle name | Last name |
      | "Akshay"   | "Vijay"     | "More"    |

  @SearchEmp
  Scenario Outline: Search for a given employee
    When User hover over PIM menu
    And Clicks on Employee List menu item
    When User searchs for this employee <Employee name>
    And clicks on Search button
    Then it displays results
    Then close the browser

    Examples: 
      | Employee name |
      | "Admin"       |

  @DeleteEmp
  Scenario Outline: Search for a given employee
    When User hover over PIM menu
    And Clicks on Employee List menu item
    When User searchs for this employee <Employee name>
    And clicks on Search button
    Then it displays results
    When User clicks on select all
    And clicks on delete button
    Then confirmation pop up will appear
    And record will be deleted
    Then close the browser

    Examples: 
      | Employee name |
      | "Ananya Dash" |
