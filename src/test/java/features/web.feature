Feature: Test Automation Web

  @web
  Scenario: Test login web normal
    Given open web login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    And user click login button
    And user will see icon cart in homepage

  @web
  Scenario: Test login web with locked user
    Given open web login page
    And user input username "locked_out_user"
    And user input password "secret_sauce"
    And user click login button
    And user will see error message "locked out"

  @web
  Scenario: Test login web with invalid password
    Given open web login page
    And user input username "locked_out_user"
    And user input password "secret_saur"
    And user click login button
    And user will see error message "do not match"

  @web
  Scenario: Test login web add to cart
    Given open web login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    And user click login button
    And user will see icon cart in homepage
    And user add item to cart
    And user add item to cart
    And user add item to cart
    Then verify cart item is match "3"

  @web
  Scenario: Test login web remove from cart
    Given open web login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    And user click login button
    And user will see icon cart in homepage
    And user add item to cart
    And user add item to cart
    And user add item to cart
    And user add item to cart
    Then verify cart item is match "4"
    And user remove item from cart
    And user remove item from cart
    Then verify cart item is match "2"

  @web
  Scenario: Test checkout order success
    Given open web login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    And user click login button
    And user will see icon cart in homepage
    And user add item to cart
    And user add item to cart
    And user add item to cart
    Then verify cart item is match "3"
    And number of item selected is "3"
    And collect item names
    And user click cart icon
    And get sum total price item list
    And user click checkout
    And user input first name "Adip"
    And user input last name "Sudip"
    And user input postal code "62088"
    And user click continue
    And collect item list checkout
    Then verify cart list same as selected item on previous page
    Then verify item total price matches total price product selected
#    Then verify item total price matches total price product selected "$55.97"