package com.restassured.lmsapi;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.restaaured.utilis.ReadExcel;
import com.restaaured.utilis.RestApiPath;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetLms {
	
	@Test  (priority=1)                  //(priority=1, dataProvider ="SearchProvider") 
	public void testGetallPrograms() 
	{
		
		//Response response =	given().auth().basic("admin","password").
			//	when().get(RestApiPath.BASE_URL+"/programs");
		
		//Intializing base uri from another java class;
		RestAssured.baseURI= RestApiPath.BASE_URL;
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given().auth().basic("admin","password");
		
		//Response Object
		  Response response=httpRequest.request(Method.GET,"/programs");
		
		    // Retrieving Body of response and printing on the console
		    System.out.println(response.asPrettyString());
		    String responseBody = response.getBody().asString();
		    System.out.println("Response Body is:" + responseBody);
		    Reporter.log("response Body" + responseBody);
		    
		
		    //Retrieving Status Code of response
		    int status = response.getStatusCode();
		    System.out.println("Status code is "+ status);
		    Assert.assertEquals(status, 200);
			
		    
			//Retrieving Status Line
		    String statusLine = response.getStatusLine();
			System.out.println("Status line is "+ statusLine);
				
		
	}
	
	@Test(priority=2) //,dataProvider ="SearchProvider") 
	public void testGetSpecificPrograms() //String programId
	{
	
		//Intializing base uri from another java class;
				RestAssured.baseURI= RestApiPath.BASE_URL;
				
				//Request Object
				RequestSpecification httpRequest = RestAssured.given().auth().basic("admin","password");
				
				String programId="2401";
				//String programName="Hyperion";
				
				//Response Object
				  Response response=httpRequest.request(Method.GET,"/programs/"+programId);
				
				    // Retrieving Body of response and printing on the console
				    System.out.println(response.asPrettyString());
				    String responseBody = response.getBody().asString();
				    System.out.println("Response Body is:" + responseBody);
				    Reporter.log("response Body" + responseBody);
				    
				
				    //Retrieving Status Code of response
				    int status = response.getStatusCode();
				    System.out.println("Status code for Specific Program ID "+ status);
				    Assert.assertEquals(status, 200);
					
				    
					//Retrieving Status Line
				    String statusLine = response.getStatusLine();
					System.out.println("Status line is "+ statusLine);
	

	}
	
	@DataProvider(name="SearchProvider")
	 public Object[][] getdatafromdataprovider() throws IOException
	 {
	
	  Object[][] datafromexcel = ReadExcel.read(".\\TestData\\Get (1).xlsx", "Sheet1");
	  
	 return datafromexcel;	
	 }
	
	
	@Test(priority=3,dataProvider ="SearchProvider") 
	public void testGetSpecificProgramswithExcel(String programId) 
	{
	
		//Intializing base uri from another java class;
				RestAssured.baseURI= RestApiPath.BASE_URL;
				
				//Request Object
				RequestSpecification httpRequest = RestAssured.given().auth().basic("admin","password");
				
				//String programId="2401";
				//String programName="Hyperion";
				
				//Response Object
				  Response response=httpRequest.request(Method.GET,"/programs/"+programId);
				  
				  //Retrieving Status Code of response
				    int status = response.getStatusCode();
				    System.out.println("Status code for Specific Program ID "+ status);
				    Assert.assertEquals(status, 200);
				    

					//Retrieving Status Line
				    String statusLine = response.getStatusLine();
					System.out.println("Status line is: "+ statusLine);
				
				    // Retrieving Body of response and printing on the console
				    System.out.println(response.asPrettyString());
				    String responseBody = response.getBody().asString();
				    //System.out.println("Response Body is:" + responseBody);
				    Reporter.log("response Body" + responseBody);
				    

	}
	
	

}
