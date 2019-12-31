package apitestrestassured;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TcGetRequest {

	@Test
	public void getweatherDetails() {
		//Specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//Request object
		RequestSpecification httpRepuest=RestAssured.given();
		
		//Response object
	    Response response= httpRepuest.request(Method.GET,"/hyderabad");
	    
	    //print response in console window
	   String responseBody= response.getBody().asString();
	   System.out.println("Response body is"+responseBody);
	  
	   //Status code validations
	  int statuscode= response.getStatusCode();
	  System.out.println("status code is "+statuscode);
	  Assert.assertEquals(statuscode, 200);
	  
	  //Status line validations
	 String statusline= response.getStatusLine();
	 System.out.println("status line is "+statusline);
	 Assert.assertEquals(statusline,"HTTP/1.1 200 OK");
	 
//	 //validating headers (how to validate headers)
//	 String contentType= response.header("Content-Type");//capture details of content-Type header
//	 System.out.println("content type is "+contentType);
//	 Assert.assertEquals(contentType, "application/xml; charset=uft-8");
//	 
//	 String contentEncoding= response.header("Content-Encoding");//capture details of content-Encoding header
//	 System.out.println("content type is "+contentEncoding);
//	 Assert.assertEquals(contentEncoding, "gzip");
//	 
//	 //How to capture all the headers
//	Headers allheaders= response.headers();//capture all the heders from response
//	 
//	for(Header header:allheaders) {
//		System.out.println(header.getName()+"  "+header.getValue());
//		//System.out.println(header.getValue());
//	}
	 
	 
	}
	
	
}
