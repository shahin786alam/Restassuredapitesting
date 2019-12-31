package apitestrestassured;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TcGetRequeast003 {
	
	@Test
	public void getweatherDetails() {
		//Specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//Request object
		RequestSpecification httpRepuest=RestAssured.given();
		
		//Response object
	    Response response= httpRepuest.request(Method.GET,"/Delhi");
	    
	    //print response in console window
	   String responseBody= response.getBody().asString();
	   System.out.println("Response body is"+responseBody);
	   
	   //how to validate json response body from the request
	  Assert.assertEquals(responseBody.contains("Delhi"), true);
	}

}
