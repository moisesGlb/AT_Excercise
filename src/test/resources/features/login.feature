@smokeTest @loginTest
Feature: Login And Registration Scenarios

  @test1
  Scenario Outline: Register with valid Credentials
    Given a customer navigates to the registration page of OWASP Juice Shop
    And the registration page should be displayed
    And the customer complete the user required field "<email>"
    And the customer complete the "<password>" and repeat password required fields
    And the customer select a required  security question
    And the customer complete the "<security_answer>" required field
    And the customer click on the register button
    And the customer input the user "<email>"
    And the customer input the password "<password>"
    And the customer click on the Login button
    Then the Home Page should be displayed
    Examples:
      | email               | password | security_answer |
      | moises@test.com   | Test1234 | mother          |
      | moises@change.com | Test1234 | mother          |

  @test2
  Scenario: Forgot Password
    Given a customer navigates to the Forgot Password page of OWASP Juice Shop
    And the customer input the user "moises@change.com"
    And The customer answer the security question: "mother"
    And the customer enter the "NewPass1234"
    And the customer click on the change Button
    Then the page should show a success message "Your password was successfully changed."

  @test3
  Scenario Outline: Login with valid credentials
    Given a customer navigates to the home page of OWASP Juice Shop
    When the customer navigates to the login page
    And the customer input the user "<email>"
    And the customer input the password "<password>"
    And the customer click on the Login button
    Then the Home Page should be displayed
    Examples:
      | email             | password    |
      | moises@change.com | NewPass1234 |
      | moises@test.com   | Test1234    |

  @test4
  Scenario Outline: Login with invalid credentials
    Given a customer navigates to the home page of OWASP Juice Shop
    When the customer navigates to the login page
    And the customer input the user "<email>"
    And the customer input the password "<password>"
    And the customer click on the Login button
    Then the error message is displayed and contains the text "<error>"
    Examples:
      | email                 | password    | error                      |
      | invalidUser@gmail.com | invalidPass | Invalid email or password. |
