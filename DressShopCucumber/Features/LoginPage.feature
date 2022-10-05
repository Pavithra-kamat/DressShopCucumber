Feature: Login page feature

Scenario: Login page title
Given user is on login page "http://automationpractice.com/index.php?controller=authentication&back=my-account"
When user gets the tiltle of the page
Then page title should be "Login - My Store"

Scenario: Forgot Password link
Given user is on login page "http://automationpractice.com/index.php?controller=authentication&back=my-account"
Then forgot your password link should be displayed

Scenario: Login with correct credentials
Given user is on login page "http://automationpractice.com/index.php?controller=authentication&back=my-account"
When user enters username "test@gmail.com"
And user enters password "test123"
And user clicks on Login button
Then user gets the title of the home page
And page title should be "My account - MY Store"