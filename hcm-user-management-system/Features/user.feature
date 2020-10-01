Feature: register 
Scenario: successful register with valid credentails
Given  user is on register page
When user enters personal details
And user clicks on register button
Then message displayed "Successful register"