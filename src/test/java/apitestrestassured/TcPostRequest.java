package apitestrestassured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TcPostRequest {
	
	@Test
	public void RegistrationSuccessful() {
		//Specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		//Request object
		RequestSpecification httpRepuest=RestAssured.given();
		
		//Request payload sending alon with post request
		JSONObject requestparams = new JSONObject();
		requestparams.put("FirstName","AlexXYZ");
		requestparams.put("LastName","AlexXYZ");
		requestparams.put("UserName","AlexXYZ");
		requestparams.put("Password","AlexXYZ");
		requestparams.put("Email","AlexXYZ@gmail.com");
	   
		httpRepuest.header("Content-Type","application/json");
		httpRepuest.body(requestparams.toJSONString());//attach above data to the request
		
		//Response object
	    Response response= httpRepuest.request(Method.POST,"/register");
	    
	    
	    //print response in console window
	   String responseBody= response.getBody().asString();
	   System.out.println("Response body is"+responseBody);
	  
	   //Status code validations
	  int statuscode= response.getStatusCode();
	  System.out.println("status code is "+statuscode);
	  Assert.assertEquals(statuscode, 201);
	  
	  //Success code validations
	  String successcode=response.jsonPath().get("SuccessCode");
	  System.out.println("success code is "+successcode);
	  Assert.assertEquals(successcode, "OPERATION_SUCCESS");
	
	}
	

}
