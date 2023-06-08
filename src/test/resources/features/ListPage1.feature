Feature: Asian Paints Product List page
 
Scenario: Validate User navigates onto the Product list page
	Given Chrome is opened and Asian Paints app is opened
	When User searches the product
  Then User navigates to the Product List page

Scenario: Validate the Product list page UI
	Given Chrome is opened and Asian Paints app is opened
	When User searches the product
  Then User navigates to the Product List page
	Then Product List page fields are visible to the User
	
Scenario: Validate Filter By field in the Product list page
	Given Chrome is opened and Asian Paints app is opened
	When User searches the product
  Then User navigates to the Product List page
	When User clicks on Filter By field
	And Selects the options in Price
	And User clicks on apply 
	Then Application page shows the prioritized Product List