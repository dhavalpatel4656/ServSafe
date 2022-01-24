Feature: Scenarios 

Scenario: Create an account and activate account
	Given user open servsafe url in browser
	When user navigate to signup page
	And user enter an email address
	Then user should be reached on signup page
	When user fill required data for create a new account
	And user click on submit button
	Then verification code is sent to and email entered
	Given user fetch verification code from email
	And enter verification code
	Then new account should be created
	
Scenario: Invalid login
	Given user open servsafe url in browser
	When user navigate to login page
	Then user should be reached on login page
	When user enter invalid email and password
	And user click on login button
	Then user should not able to login

Scenario: Valid login
	Given user open servsafe url in browser
	When user navigate to login page
	Then user should be reached on login page
	When user enter valid email and password
	And user click on login button
	Then user should be able to login and reached to dashboard page
	
Scenario: Add product to cart
	Given user open servsafe url in browser
	When user navigate to login page
	Then user should be reached on login page
	When user enter valid email and password
	And user click on login button
	When user navigate to ServSafe Workplace
	And user click on buy now
	And user add last product to cart
	And user navigate to cart
	Then user should be able to see added product in cart