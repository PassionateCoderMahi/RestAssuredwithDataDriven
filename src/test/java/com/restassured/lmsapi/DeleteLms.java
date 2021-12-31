package com.restassured.lmsapi;

import org.junit.Test;
import org.testng.Assert;
import org.testng.Reporter;

import com.restaaured.utilis.RestApiPath;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteLms {
	
	@Test//,dataProvider ="SearchProvider") 
	public void testDeleteSpecificPrograms() //String programId
	{
	
		//Intializing base uri from another java class;
				RestAssured.baseURI= RestApiPath.BASE_URL;
				
				//Request Object
				RequestSpecification httpRequest = RestAssured.given().auth().basic("admin","password");
				
				String programId="2987";
				
				//Response Object
				  Response response=httpRequest.request(Method.DELETE,"/programs/"+programId);
				

				    //Retrieving Status Code of response
				    int status = response.getStatusCode();
				    System.out.println("Status code for Specific Program ID "+ status);
				    Assert.assertEquals(status, 200);
					
				    
					//Retrieving Status Line
				    String statusLine = response.getStatusLine();
					System.out.println("Status line is "+ statusLine);
				    // Retrieving Body of response and printing on the console
				    System.out.println(response.asPrettyString());
				    String responseBody = response.getBody().asString();
				    System.out.println("Response Body is:" + responseBody);
				    Reporter.log("response Body" + responseBody);
				    
				
	

	}

}
