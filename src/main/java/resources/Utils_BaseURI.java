package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils_BaseURI {
	
private static RequestSpecification req;
	
	
	public io.restassured.specification.RequestSpecification RequestSpecification() throws IOException {
		
	//if (req==null)	{
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		PrintStream log =new PrintStream(new FileOutputStream("logging1.txt"+":"+timeStamp)); 
		
				req=new RequestSpecBuilder().setBaseUri(getGlobalvalues("BaseURI"))
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		
		//ResponseSpecification Resp= new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		
		return req;	
		
	}
		

	
	public static String getGlobalvalues(String keyvalue) throws IOException {
		
		
		Properties prop = new Properties(); // java class file that scans for .properties file
		
		String file ="/Users/jayashreehemmige/eclipse-workspace/Cucumber_API_Framework_Following_Udemy_Course/src/main/java/resources/Global.properties";
		
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);

		//keyvalue = prop.getProperty(keyvalue);
		return prop.getProperty(keyvalue);
		
	}
	
	
	public String getJsonPath(Response response, String key ) {
		
		
	String responseBody=response.getBody().asString();
		
		
		JsonPath jp = new JsonPath(responseBody);
		
		
		return jp.get(key).toString();
		
	}
	
	
	
public String getDeleteAPI(String placeID) {
		
		
		return "{\r\n    \"place_id\":\""+placeID+"\"\r\n}";
		
	}
	

	}
	
	

	

