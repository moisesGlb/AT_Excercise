@smokeTest @loginTest
Feature: Login And Registration Scenarios

  @test1
  Scenario Outline: Register with valid Credentials
    Given a customer navigates to the registration page of OWASP Juice Shop
    #When the customer navigates to the login page
    #And the customer click on Not yet a customer link
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
      | email           | password | security_answer |
      | moises@test.com | Test1234 | mother          |
      | moises@change.com | Test1234 | mother          |

  @test2
  Scenario: Login with valid credentials
    Given a customer navigates to the home page of OWASP Juice Shop
    When the customer navigates to the login page
    And the customer input the user "moises@test.com"
    And the customer input the password "Test1234"
    And the customer click on the Login button
    Then the Home Page should be displayed

  @test3
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

  @test4
  Scenario Outline: Forgot Password
    Given a customer navigates to the Forgot Password page of OWASP Juice Shop
    #When the customer navigates to the login page
    #And the customer click on Forgot Your Password link
    And the customer input the user "<email>"
    And The customer answer the security question: "<security_answer>"
    And the customer enter the "<new_password>"
    And the customer click on the change Button
    Then the page should show a success message "Your password was successfully changed."
    Examples:
      | email             | security_answer | new_password |
      | moises@change.com | mother          | NewPass1234  |