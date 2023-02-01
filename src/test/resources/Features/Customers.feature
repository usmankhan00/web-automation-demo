Feature: Customers


  Scenario Outline: Delete all existing customers from Bank
    Given I Login as a Bank Manager
    When I clicked on Customers Tab
    And I searched the Customer "<Last name>"
    And If "<Last name>" customer is present then I delete that customer
    Then Customer "<Last name>" should deleted
    Examples:
      | Last name   |
      | Connely     |
      | Christopher |
      | Minka       |
      | Jackson     |
      | Frank       |
      | A897N450    |
      | Connely     |


  @Smoke
  Scenario Outline: Add customers in bank
    Given I Login as a Bank Manager
    When I clicked on Add Customer
    And I added the customer by entering First Name: "<First name>", Last Name: "<Last name>", Post Code: "<Post code>"
    And I clicked on Customers Tab
    And I searched the Customer "<Last name>"
    Then Customer "<Last name>" should created
    Examples:
      | First name  | Last name   | Post code |
      | Christopher | Connely     | L789C349  |
      | Frank       | Christopher | A897N450  |
      | Christopher | Minka       | M098Q585  |
      | Connely     | Jackson     | L789C349  |
      | Jackson     | Frank       | L789C349  |
      | Minka       | A897N450    | A897N450  |
      | Jackson     | Connely     | L789C349  |

  @Smoke
  Scenario Outline: Delete specific customers from Bank
    Given I Login as a Bank Manager
    When I clicked on Customers Tab
    And I searched the Customer "<Last name>"
    And If "<Last name>" customer is present then I delete that customer
    Then Customer "<Last name>" should deleted
    Examples:
      | Last name   |
      | Frank     |
      | Connely |