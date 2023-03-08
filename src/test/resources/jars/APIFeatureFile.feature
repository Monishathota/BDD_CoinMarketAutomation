Feature: Conversion of currency

Scenario: API calls to double convert currencies
Given User wants the base URI
When User convert the price of Guatemalan Quetzal to British Pound 
Then User convert Received British Pound to doge coin
Then User validated the status code