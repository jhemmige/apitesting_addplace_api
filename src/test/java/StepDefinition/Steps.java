package StepDefinition;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
import resources.ResourceAPIs;
import resources.TestDataResource;
import resources.Utils_BaseURI;

public class Steps extends Utils_BaseURI {

	RequestSpecification requestspec;
	ResponseSpecification Respspec;
	Response response;
	JsonPath jp;
	TestDataResource tdr = new TestDataResource();
	ResourceAPIs resapi;
	static String placeID;

	@Given("I have the baseURI with the payload containing the place to be added using AddPlaceAPI that has {string} {string} {string} {string}")
	public void i_have_the_base_uri_with_the_payload_containing_the_place_to_be_added_using_add_place_api_that_has(
			String name, String language, String Phone_number, String address) throws IOException {

		requestspec = RestAssured.given().log().all().spec(RequestSpecification())
				.body(tdr.getTestData(name, address, language));

	}
	
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String httpmethod) {
		
		Respspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		resapi = ResourceAPIs.valueOf(resource);
		System.out.println(resapi.getresourceApi());

		if (httpmethod.equalsIgnoreCase("POST")) {

			response = requestspec.request(Method.POST, resapi.getresourceApi()).then().spec(Respspec).extract()
					.response();

		} else if

		(httpmethod.equalsIgnoreCase("GET")) {

			response = requestspec.request(Method.GET, resapi.getresourceApi()).then().spec(Respspec).extract()
					.response();

		}
	   
	}


	@SuppressWarnings("deprecation")
	@Then("The place should get added successfully with the response lines with status code {int}")
	public void the_place_should_get_added_successfully_with_the_response_lines_with_status_code(Integer int1) {

		int scode = response.getStatusCode();
		Assert.assertEquals(scode, 200);

	}

	@Then("Response {string} in the  Response body should be {string}")
	public void response_in_the_response_body_should_be(String key, String keyvalue) {

		String resbody = response.getBody().asString();

		//System.out.println("THIS IS RESPONSEBODY" + resbody);

		long time = response.getTimeIn(TimeUnit.MILLISECONDS);
		// jp= new JsonPath(resbody);
		System.out.println(time);
		System.out.println("YOLO STATUS" + getJsonPath(response, "status"));
		String status = getJsonPath(response, "status");

		System.out.println("This is the value of " + status);
		Assert.assertEquals(status, keyvalue);
	}

	@Then("Response {string} in the Response body should be {string}")
	public void response_in_the_response_body_should_be1(String key, String keyvalue) {
		String resbody = response.getBody().asString();

		// String resbody= response.getBody().asString();
		String scope = (getJsonPath(response, "scope"));

		System.out.println("This si the value of " + scope);
		Assert.assertEquals(scope, keyvalue);

	}

	@Then("Verify if placeID maps to {string} given using {string}")
	public void verify_if_place_id_maps_to_given_using(String expectedName, String resource) throws IOException {

		placeID = (getJsonPath(response, "place_id"));
		System.out.println("this is the placID" + placeID);

		requestspec = given().log().all().spec(RequestSpecification()).queryParam("place_id", placeID);

		user_calls_with_http_request(resource, "GET");

		String actualName = getJsonPath(response, "name");
		System.out.println("ActualName: " + actualName);
		String location = getJsonPath(response, "location.longitude");
		System.out.println("LONGITUDE: " + location);


	//String[] l1=	location.split(",");
	//System.out.println("lalala"+ l1[0]);

	}
	
	@Given("I have the DeletePlaceAPI payload")
	public void i_have_the_delete_place_api_payload( ) throws IOException {
		requestspec = given().log().all().spec(RequestSpecification()).body(getDeleteAPI(placeID));
		//user_calls_with_http_request(resource, "POST");
		System.out.println(placeID);
	   
	}
	
	@Then("The place should get deleted successfully with the response lines with status code {int}")
	public void the_place_should_get_deleted_successfully_with_the_response_lines_with_status_code(Integer int1) {
	    
		int stcode=response.getStatusCode();
		
		System.out.println("I have converted response to string"+ response.asString());
	    
	    Assert.assertEquals(stcode, 200);
	    System.out.println("YIPEE");
	    
	}
	
	
	
	
}