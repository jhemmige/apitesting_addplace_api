package StepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	
/**	@Before("@Deleteplaceapi")
	public void hookSteps() throws IOException {
		
		
		Steps s = new Steps();
		
	 if (Steps.place_id== null) { // we use class name since the variable is static . If it is not static , then we use the object of the className
		 
		 s.add_Place_Payload_with("Chinnalampattu", "Odiya", "himachalperadesh");
		 s.user_calls_with_http_request("AddPlaceAPI","POST");
		 s.verify_place_Id_created_maps_to_using("Chinnalampattu", "GetPlaceAPI");
		 
	 }
	 
	}**/
	
	@Before("@DeletePlace")
	public void hookSteps() throws IOException {
		
		
		Steps s = new Steps();
		
	 if (Steps.placeID== null) { // we use class name since the variable is static . If it is not static , then we use the object of the className
		 
		 
		 s.i_have_the_base_uri_with_the_payload_containing_the_place_to_be_added_using_add_place_api_that_has("kanchipuram", "Odiya", "1231231234", "himachalperadesh");
		 s.user_calls_with_http_request("AddPlaceAPI", "POST");
		 
		 s.verify_if_place_id_maps_to_given_using("kanchipuram", "GetPlaceAPI");
		 
		 
	 }
	 
	}
	
	
	

}
