Feature: Transactions

  @Smoke
  Scenario Outline: Validate balance after depositing the amount
    Given I Login as a Customer
    When I select the customer "Hermoine Granger" from dropdown
    And I clicked on Customer Login button
    And I select the customer account "1003" from dropdown
    And I "<Transaction type>" "<Amount>"
    Then I validated the balance "<Expected Balance>" on home page
    Examples:
      | Transaction type | Amount | Expected Balance |
      | Deposit          | 50000  | 50000            |
      | Withdrawl        | 3000   | 47000            |
      | Withdrawl        | 2000   | 45000            |
      | Deposit          | 5000   | 50000            |
      | Withdrawl        | 10000  | 40000            |
      | Withdrawl        | 15000  | 25000            |
      | Deposit          | 1500   | 26500            |

