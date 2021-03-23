## Trend Micro UI Coding challenge

This UI Framework was developed using below components
 * Maven
 * TestNG
 * Page Object Model(Design pattern)

## Installation (Pre-requisites)
* jdk1.8 or higher
* Maven
* IntelliJ IDEA(preferred)

## How to run tests
* Import project as Maven project in intellijIdea or any editor
* Create a Maven Runner - New -edit configuration - Maven -add command line as - clean test
* Or use mvn clean test from mvn command line.

## Result
* On completion of maven command (mvn clean test),reports will be generated in folder
<path-to-project-folder>/test-output/screenshots/AutomationReport.html

## Things to improve 
* More efficient way of identifying UI objects
* Before Test should handle login as we want the test to not rely on each other 
* Test data management 
* Add to cart could be implemented better way , currently just clicking first item and add to cart
* Adding tags to tests to run them based on demand etc.
