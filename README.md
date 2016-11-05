# Project Title

This project has the logic for creating and testing a java automated solver method that takes input of a start word and end word and prints a set of legal words present in the dictionary for the transformation to happen.

## Getting Started

Unzip the project file and open the project in Eclipse and install TestNGin Eclipse , if its not there.

## Prerequisites

TestNg needs to be installed for running the test cases.

## Installing

Steps for installing testNG can be found here in this link.
http://stackoverflow.com/questions/22328610/how-to-install-testng-in-eclipse-kepler

## Running the tests

The test can be executed from testng.xml file. After TestNg has been installed then right click on the project and select Run As TestNg suite.

## Break down into end to end tests

Data Provider has been provided for various test data and loaded the dictionary in the beginning of the test case and the test case has been parameterized.For words which can't be transformed from one to another due to unavailability of intermediate legal words in the dictionary , the test will fail with proper error message.

### Authors

Debarnab Banerjee