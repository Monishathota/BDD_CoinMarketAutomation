## Table of contents
Requirements
Recommended modules
Installation
Configuration
Page Object
Utility
Property
Logs
Execution Process

## Requirements
cucumber(Version 7.11.1)
Java(Version 1.11)
junit(Version 4.11)
log4j(Version 1.2.17)

## Recommended module
https://coinmarketcap.com/
https://pro-api.coinmarketcap.com/

## Installation
Add all the required dependencies in POM.xml file

##  Configuration
Kept all module wise scenarios in src/test/resources/Features/UIFeatureFile.feature and APIFeatureFile.feature file
created Step defination on src/test/java/StepDefination/APIStepDefination.java and UIStepDefination.java with the help for feature file's skeleton structure

## Page Object
All locators will be written on src/test/java/PageObject/CoinMarketPage.java

## Utility
src/test/java/Utility/Util.java used as common methods for both Scenarios
src/test/java/Utility/PriceCoversion.java used only for Api Scenario

## Property
All the data kept as key and value format in src/test/resources/Property/PropertyFile.property file

## Logs
All captured data will be written in src/test/resources/Log/Coinmarket.txt file under Log folder

## Execution Process
Both the scenarios will be executed parallel from the Runner class

