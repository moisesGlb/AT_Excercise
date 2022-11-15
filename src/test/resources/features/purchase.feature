@smokeTest @purchaseTest
Feature: Purchase And Basket Scenarios

  Background: User is logged in
    Given a customer navigates to the home page of OWASP Juice Shop
    When the customer navigates to the login page
    And the customer input the user "moises@test11.com"
    And the customer input the password "Test1234"
    And the customer click on the Login button
    Then the Home Page should be displayed

  @test5
  Scenario: Test the behavior of the basket
    Given a customer that add a product to the basket "1"
    And  a customer that add a product to the basket "3"
    And the customer goes to the basket
    And the customer modify the product quantity "Apple Juice"
    And the customer click on the checkout button
    And the address page should be displayed

  @test6
   Scenario: Purchase Products
     Given a customer that add a product to the basket "1"
     And  a customer that add a product to the basket "3"
     And the customer goes to the basket
     And the customer click on the checkout button
     And the user click on add new address
     And the user add a new address
     And the user select the new address
     And the user select a delivery speed "0"
     And the user add a new card
     And the user select the card to pay
     And the checkout page is displayed
     And the user place the order and Pay
     And the confirmation page is displayed




