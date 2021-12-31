package com.restassured.JobsAPI;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.restaaured.utilis.JobsApiPath;
import com.restaaured.utilis.RestApiPath;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postJob {
	
	
	@Test
	public void testPostspecificJobs()
	
	{
	
		//Intializing base uri from another java class;
		RestAssured.baseURI=JobsApiPath.BASE_URL;
				
				//Request Object
				RequestSpecification httpRequest = RestAssured.given();
				
				//Request payload(body value) sending along with post request
				
				JSONObject requestParams = new JSONObject();
				
				
				requestParams.put("Job Title","ge");
				requestParams.put("Job Company Name","numpy");
				requestParams.put("Job Location","La");
				requestParams.put("Job Type","fulltime");
				requestParams.put("Job Posted time","10.20");
				requestParams.put("Job Description","dumy");
				requestParams.put("Job Id","1501");
				
			
				httpRequest.header("Content-Type","application/json");
				httpRequest.body(requestParams.toJSONString());
				
				//Response Object
				  Response response=httpRequest.request(Method.POST,"/Jobs");
				  
				  //Retrieving Status Code of response
				    int status = response.getStatusCode();
				    System.out.println("Status code for Posting new Job is :"+ status);
				   // Assert.assertEquals(status, 200);
				    

					//Retrieving Status Line
				    String statusLine = response.getStatusLine();
					System.out.println("Status line is: "+ statusLine);
					// Assert.assertEquals(statusLine,"HTTP/1.1 200 ");
					 
				      
				
				    // Retrieving Body of response and printing on the console
				    System.out.println(response.asPrettyString());
				    String responseBody = response.getBody().asString();
				    //System.out.println("Response Body is:" + responseBody);
				    Reporter.log("response Body" + responseBody);
				    

	}

	
	@Test
	public void testPostspecificJobsWithHashMap()
	
	{
	
		
		      RestAssured.baseURI=JobsApiPath.BASE_URL;
				
		      RequestSpecification httpRequest = RestAssured.given();
		      
				//JSON payload can also be sent by creating a HashMap 
		      //hahmap is an collection of javathat uses <key, value> pair, where one acts as a index 
		      //while other as the value. It always has a unique <key,value> pair and implements the map interface.
				
		      HashMap requestParams = new HashMap();
				
				
				requestParams.put("Job Title","ge");
				requestParams.put("Job Company Name","numpy");
				requestParams.put("Job Location","La");
				requestParams.put("Job Type","fulltime");
				requestParams.put("Job Posted time","10.20");
				requestParams.put("Job Description","dumy");
				requestParams.put("Job Id","1600");
				
			
				httpRequest.header("Content-Type","application/json");
				httpRequest.body(requestParams);
				
				//Response Object
				  Response response=httpRequest.request(Method.POST,"/Jobs");
				  
				  //Retrieving Status Code of response
				    int status = response.getStatusCode();
				    System.out.println("Status code for Posting new Job using HashMap :"+ status);
				   // Assert.assertEquals(status, 200);
				    

					//Retrieving Status Line
				    String statusLine = response.getStatusLine();
					System.out.println("Status line is: "+ statusLine);
					// Assert.assertEquals(statusLine,"HTTP/1.1 200 ");
					 
				      
				
				    // Retrieving Body of response and printing on the console
				    System.out.println(response.asPrettyString());
				    String responseBody = response.getBody().asString();
				    //System.out.println("Response Body is:" + responseBody);
				    Reporter.log("response Body" + responseBody);
				    

	}

	
}
