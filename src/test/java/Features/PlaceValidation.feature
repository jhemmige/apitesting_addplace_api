Feature: Validating the Add feature of the Place API
 
 @AddPlace @Regression
  Scenario Outline: Verifying if a new place got addedd successfully
    Given 	I have the baseURI with the payload containing the place to be added using AddPlaceAPI that has "<name>" "<language>" "<Phone_number>" "<address>"
    When 		user calls "AddPlaceAPI" with "POST" http request
   	Then 		The place should get added successfully with the response lines with status code 200
    And 		Response "status" in the  Response body should be "OK"
    And 		Response "scope" in the Response body should be "APP"
    And 		Verify if placeID maps to "<name>" given using "GetPlaceAPI"
    
  
 Examples:
 
 	|name|language|Phone_number|address|
	#|Mike|English|5532229999|20, rockfellarcenter, ny|
	|Matthews|spanish|9945226767|273, echelonglenaparments, voorhees, NJ|
	#|Frontline house|French-IN|(+91) 983 893 3937|29, side layout, cohen 09|

@DeletePlace @Regression
	
	Scenario: Validating DeletePlaceAPI
	
	Given 	I have the DeletePlaceAPI payload
	When 		user calls "DeletePlaceAPI" with "POST" http request
  Then 		The place should get deleted successfully with the response lines with status code 200
  And 		Response "status" in the  Response body should be "OK"
	
	