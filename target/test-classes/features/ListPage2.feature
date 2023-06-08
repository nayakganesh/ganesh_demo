Feature: Asian Paints Product List page

Scenario Outline: Verify Find a store functionality with valid details
	Given Chrome is opened and Asian Paints app is opened
	When User searches the product
  Then User navigates to the Product List page
	When User enters Pincode "<pincode>"
	And User clicks on Go button
	Then Application shows the stores near you
	
	Examples:
	| pincode |
  | 700135  |
  | 761008  |

Scenario Outline: Verify Find a store functionality with invalid details
	Given Chrome is opened and Asian Paints app is opened
	When User searches the product
  Then User navigates to the Product List page
	When User enters Pincode "<pincode>"
	And User clicks on Go button
	Then Application displays a message to enter a valid Zip Code
	
	Examples:
	| pincode |
  | $$$$$$  |
  | 123@45  |
