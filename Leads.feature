Feature: Leads in Leaftaps
Background:
Given open the chrome browser and load the url
And Enter the username as demosalesmanager and password as crmsfa
And Click the login button
And Click the CRMSFA link
And Click the Leads link

Scenario: Positive flow to create a lead
And Click the createlead link
And Enter the company name as Testleaf
And Enter the first name as Balaji
And Enter the last name as C
When Click on the create lead button
Then verify the lead creation
Then close the browser  

Scenario: Positive flow to delete the lead
Given Click the Findlead link
And Click Phone tab and Enter the Phone number as 99
And Click on the find leads button
And Click on the first resulted lead and store it in a string 'leadID'
And Click on the delete lead button
And Click on the find leads button again
And In the name tab, pass the string 'leadID'
When Click on the find leads button to recheck
Then verify that no match with the leadID is found
Then close the browser 

Scenario: Positive flow to duplicate the lead
Given Click the Findlead link
And Click Phone tab and Enter the Phone number as 99
And Click on the find leads button
And Click on the first resulted lead 
And Click on the duplicate lead button
When Click on the Submit button
Then verify duplicate lead is created 
Then close the browser

Scenario: Positive flow to Edit the lead
Given Click the Findlead link
And Click Phone tab and Enter the Phone number as 99
And Click on the find leads button
And Click on the first resulted lead 
And Click on the Edit button
And In Company name tab,Enter the company name as CTS
When Click on Submit button
Then verify the lead company name is Edited successfully
Then close the browser

Scenario: Positive flow to Merge the lead
Given Click the Merge lead link
And Click on Widget of From lead
And Enter First name as Balaji and Click on First Resulting lead
And Click on Widget of To lead 
And Enter fname as Dhivya and Click on First Resulting lead
And Click on Merge button
When Accept the Alert
Then Verify the title of the page
Then close the browser
