#Author: Swarnaparvathi
@Sanity @Regression
Feature: Verify the App functions

  Background: Launch the Zomato App
    Given Launch the App

  @Login
  Scenario: User login to the app
    Then Verify the "Landing" Page
    And User clicks on "Mobile Number Field"
    And User enters the "Mobile Number"
    And User clicks on "Continue"
    Then Verify the "OTP" Page
    And User enters the "OTP"
    Then Verify the "Home" Page
    Then User closes the App

  @Cart
  Scenario: User Add Food To Cart
    Then Verify the "Home" Page
    And User clicks on "Search Field"
    And User enters the "Restaurant Name"
    Then Verify the "Restaurant Search" Page
    And User clicks on "Restaurant Name"
    And User clicks on "Add To Cart"
    And User clicks on "Add Item"
    And User clicks on "Next"
    Then Verify the "Cart" Page
    And User clicks on "Add Payment Method"
    And Verify the "Payment" Page
    And User clicks on "Add New UPI"
    And User enters the "UPI ID"
    And User clicks on "Save UPI"
    And User clicks on "Back Button"
    Then Verify the "Cart" Page
    And User clicks on "Back Button"
    Then Verify the "Restaurant" Page
    And User clicks on "Back Button"
    Then Verify the "Home" Page
    Then User closes the App