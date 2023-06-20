Feature: Exam

Scenario: Register New User
Given User opens the Application
When User enters valid school "Cranium Cafe - Test" into the Search inbox field
When User click take me there button 
When User click guest registration button
When User click on register here button
When User enters the details into below fields
|fullName|Juan Ponce											|
|email|youquoussomiddo-6034@yopmail.com
|password|Welcome1									|
And User click on register button
Then User account should be created successfully


Scenario: Login
Given User opens the Application
When User enters valid school "Cranium Cafe - Test" into the Search inbox field
When User click take me there button 
When User click guest registration button
When User enters valid email "pubauquoiddoinnau-1154@yopmail.com" into the email field
When User enters valid password "Welcome1" into the password field
And User click on login button
Then User should successfully logged in