Feature: Coinmarketcap page 
Scenario: Coinmarketcap page application

Given User opens the coinmarketcap application
When User selects 20 rows
Then User capture the content of the page
 When User applies filter on Algorithm as PoW
And User applies other additional filters
Then User compares the filtered page content with previously captured page contents