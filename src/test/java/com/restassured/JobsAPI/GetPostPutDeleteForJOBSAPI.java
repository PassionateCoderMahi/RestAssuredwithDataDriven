package com.restassured.JobsAPI;

import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.restaaured.utilis.JobsApiPath;
import com.restaaured.utilis.RestApiPath;
import com.restaaured.utilis.newExcel2;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetPostPutDeleteForJOBSAPI {

	
	public void f()
	 {
	   Reporter.log("Using Restassured for GET/POST/PUT/DELETE method for JOBS API");
	 }
	  
	
	
	@Test  (priority=1)                  //(priority=1, dataProvider ="SearchProvider") 
	public void testGetallJobs() 
	{
		
		;
		
		//Intializing base uri from another java class;
		RestAssured.baseURI=JobsApiPath.BASE_URL;
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		  Response response=httpRequest.request(Method.GET,"/Jobs");
		
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
	
	
	@DataProvider(name="post")
	 public Object[][] getdatafromdataproviderforPOST() throws IOException
	 {
	
	  Object[][] datafromexcel = newExcel2.read(".\\TestData\\PostJob.xlsx", "Sheet1");
	 
	 return datafromexcel;	
	 }
	
	@Test(priority=2,dataProvider ="post") 
	public void testPOSTaJob(String JobTitle,String JobCompanyName,String JobLocation,String JobType,
			String JobPostedtime,String JobDescription,String JobId)
	
	{
	
		     //Intializing base uri from another java class;
		       RestAssured.baseURI=JobsApiPath.BASE_URL;
				
				//Request Object
				RequestSpecification httpRequest = RestAssured.given();
				
				//Request payload(body value) sending along with post request
				
				JSONObject requestParams = new JSONObject();
				
				
				requestParams.put("Job Title",JobTitle);
				requestParams.put("Job Company Name",JobCompanyName);
				requestParams.put("Job Location",JobLocation);
				requestParams.put("Job Type",JobType);
				requestParams.put("Job Posted time",JobPostedtime);
				requestParams.put("Job Description",JobDescription);
				requestParams.put("Job Id",JobId);
				
				httpRequest.header("Content-Type","application/json");
				httpRequest.body(requestParams.toJSONString());
				
				//Response Object
				  Response response=httpRequest.request(Method.POST,"/Jobs");
				  
				  //Retrieving Status Code of response
				    int status = response.getStatusCode();
				    System.out.println("Status code for Posting new Job is :"+ status);
				    //Assert.assertEquals(status, 200);
				    

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
	
	@Test(priority=3)
	public void testPostspecificJobsWithHashMap()
	
	{
	
		
		      RestAssured.baseURI=JobsApiPath.BASE_URL;
				
		      RequestSpecification httpRequest = RestAssured.given();
		      
				//JSON payload can also be sent by creating a HashMap 
		    
		      HashMap requestParams = new HashMap();
				
				
				requestParams.put("Job Title","SDET18");
				requestParams.put("Job Company Name","Beckman");
				requestParams.put("Job Location","Fullerton,California");
				requestParams.put("Job Type","Fulltime");
				requestParams.put("Job Posted time","10.20am");
				requestParams.put("Job Description","dumy");
				requestParams.put("Job Id","1601");
				
			
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

	
	
	@DataProvider(name="put")
		 public Object[][] getdatafromdataproviderforPUT() throws IOException
		 {
		
		  Object[][] datafromexcel = newExcel2.read(".\\TestData\\putjob.xlsx", "Sheet1");
		 
		 return datafromexcel;	
		 }
		
		@Test(priority=4,dataProvider ="put") 
		public void testPUT(String JobTitle,String JobLocation,String JobId)
		
		{
		
			     //Intializing base uri from another java class;
			       RestAssured.baseURI=JobsApiPath.BASE_URL;
					
					//Request Object
					RequestSpecification httpRequest = RestAssured.given();
					
					//Request payload(body value) sending along with post request
					
					JSONObject requestParams = new JSONObject();
					
					
					requestParams.put("Job Title",JobTitle);
					 //requestParams.put("Job Company Name",JobCompanyName);
					requestParams.put("Job Location",JobLocation);
					 //requestParams.put("Job Type",JobType);
					 //requestParams.put("Job Posted time",JobPostedtime);
					 //requestParams.put("Job Description",JobDescription); 
					 //We cannot update job description for this api
					requestParams.put("Job Id",JobId);
					
					httpRequest.header("Content-Type","application/json");
					httpRequest.body(requestParams.toJSONString());
					
					//Response Object
					  Response response=httpRequest.request(Method.PUT,"/Jobs");
					  
					  //Retrieving Status Code of response
					    int status = response.getStatusCode();
					    System.out.println("Status code for PUT Method is :"+ status);
					    //Assert.assertEquals(status, 200);
					    

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
		
		@DataProvider(name="Delete")
		 public Object[][] getdatafromdataproviderforDelete() throws IOException
		 {
		
		  Object[][] datafromexcel = newExcel2.read(".\\TestData\\deleteJob.xlsx", "Sheet1");
		 
		 return datafromexcel;	
		 }
		
		@Test(priority=5,dataProvider="Delete")
		public void testDELETE(String JobId)
		
		{
		
			     //Intializing base uri from another java class;
			       RestAssured.baseURI=JobsApiPath.BASE_URL;
					
					//Request Object
					RequestSpecification httpRequest = RestAssured.given();
					
					//Request payload(body value) sending along with post request
					
					JSONObject requestParams = new JSONObject();
					

					requestParams.put("Job Id",JobId);
					
					httpRequest.header("Content-Type","application/json");
					httpRequest.body(requestParams.toJSONString());
					
					//Response Object
					  Response response=httpRequest.request(Method.DELETE,"/Jobs");
					  
					  //Retrieving Status Code of response
					    int status = response.getStatusCode();
					    System.out.println("Status code for DELETE Method is :"+ status);
					    //Assert.assertEquals(status, 200);
					    

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
