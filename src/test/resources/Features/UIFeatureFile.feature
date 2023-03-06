Feature: Coinmarketcap page 

Scenario: Coinmarketcap page activities     
Given User want to open the coinmarketcap url 
When User clicks on the element 20 
Then User capture the content of the page
When User filter the Algoritham to POW
And User clicks on ADDFilter
Then User Compare the page content with previous page content

