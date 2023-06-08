Feature: Asian Paints Product List page

Scenario Outline: Verify Find a store functionality with valid details
	Given Chrome is opened and Asian Paints app is opened
	When User searches the product
  Then User navigates to the Product List page
	When User fills the pincode from given sheetname "<SheetName>" and rownumber <RowNumber>
	And User clicks on Go button
	Then Application shows the stores near you
	
	Examples:
	| SheetName | RowNumber |
  | Sheet1    | 0         |
  | Sheet1    | 1         |