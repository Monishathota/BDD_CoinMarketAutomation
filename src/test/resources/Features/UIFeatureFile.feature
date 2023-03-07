Feature: Coinmarketcap page 

Scenario: Coinmarketcap page activities     
Given User opens the coinmarketcap application
When User selects 20 rows
Then User capture the content of the page
When User applies filter on Algorithm as PoW
And User clicks on ADDFilter
Then User compares the filtered page content with previously captured page content

