package com.restassured.lmsapi;

import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.restaaured.utilis.ReadExcel;
import com.restaaured.utilis.RestApiPath;
import com.restaaured.utilis.newExcel;
import com.restaaured.utilis.newExcel2;
import com.restaaured.utilis.newExcel3;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetPostPutDelete {

	
	public void f()
	 {
	   Reporter.log("Using Restassured for GET/POST/PUT/DELETE method for LMS API");
	 }
	  
	
	
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
	// Object[][] datafromexcel = ReadExcelcopy2.testData(".\\TestData\\GetApiTestdata (1).xlsx", "Sheet1");
	  Object[][] datafromexcel = ReadExcel.read(".\\TestData\\Get (1).xlsx", "Sheet1");
	  //Object[][] datafromexcel = copy4.testData(".\\TestData\\Get (1).xlsx", "Sheet1");
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
	
	
	@DataProvider(name="post")
	 public Object[][] getdatafromdataproviderforPOST() throws IOException
	 {
	
	  Object[][] datafromexcel = newExcel2.read(".\\TestData\\postnew.xlsx", "Sheet1");
	 
	 return datafromexcel;	
	 }
	
	@Test(priority=4,dataProvider ="post") 
	public void testPostspecificPrograms(String programName,String programDescription,String online )
	{
	
		//Intializing base uri from another java class;
				RestAssured.baseURI= RestApiPath.BASE_URL;
				
				//Request Object
				RequestSpecification httpRequest = RestAssured.given().auth().basic("admin","password");
				
				//Request payload(body value) sending along with post request
				
				JSONObject requestParams = new JSONObject();
				/*requestParams.put("programId",4000);
				requestParams.put("programName","SDET18");
				requestParams.put("programDescription","AutomationMahi");
				requestParams.put("online",true);*/
				
				
				//requestParams.put("programId",programId);
				requestParams.put("programName",programName);
				requestParams.put("programDescription",programDescription);
				requestParams.put("online",online);
				
				
				
				
			/*	requestParams.put("{\r\n"
				   		+ "  \"online\": true,\r\n"
				   		+ "  \"programDescription\": \"NumpyNinja1\",\r\n"
				   		+ "  \"programId\": 4000,\r\n"
				   		+ "  \"programName\": \"SDET100\"\r\n"
				   		+ "}", requestParams);*/
				
				httpRequest.header("Content-Type","application/json");
				httpRequest.body(requestParams.toJSONString());
				
				//Response Object
				  Response response=httpRequest.request(Method.POST,"/programs");
				  
				  //Retrieving Status Code of response
				    int status = response.getStatusCode();
				    System.out.println("Status code for Posting new program is :"+ status);
				    Assert.assertEquals(status, 200);
				    

					//Retrieving Status Line
				    String statusLine = response.getStatusLine();
					System.out.println("Status line is: "+ statusLine);
					 Assert.assertEquals(statusLine,"HTTP/1.1 200 ");
					 
					 //Success code validation
				   String SucessCode=response.jsonPath().get("SuccessCode");
				   System.out.println("SuccessCode is:"+SucessCode);
				   
				   
				
				    // Retrieving Body of response and printing on the console
				    System.out.println(response.asPrettyString());
				    String responseBody = response.getBody().asString();
				    //System.out.println("Response Body is:" + responseBody);
				    Reporter.log("response Body" + responseBody);
				    

	}
	
	
	@DataProvider(name="post2")
	 public Object[][] getdatafromdataproviderforPOST2() throws IOException
	 {
	
	  Object[][] datafromexcel = newExcel3.read(".\\TestData\\postnew.xlsx", "Sheet1");
	 
	 return datafromexcel;	
	 }
	
	@Test(priority=5,dataProvider ="post2") 
	public void testPostspecificProgramsWithHashMap(String programName,String programDescription,Boolean online )
	{
	
		//Intializing base uri from another java class;
				RestAssured.baseURI= RestApiPath.BASE_URL;
				
				//Request Object
				RequestSpecification httpRequest = RestAssured.given().auth().basic("admin","password");
				
				//Request payload(body value) sending along with post request
				
				HashMap requestParams = new HashMap();
				requestParams.put("programName",programName);
				requestParams.put("programDescription",programDescription);
				requestParams.put("online",online);
				
				httpRequest.header("Content-Type","application/json");
				httpRequest.body(requestParams);
				
				//Response Object
				  Response response=httpRequest.request(Method.POST,"/programs");
				  
				  //Retrieving Status Code of response
				    int status = response.getStatusCode();
				    System.out.println("Status code for Posting new program using HashMap :"+ status);
				    Assert.assertEquals(status, 200);
				    

					//Retrieving Status Line
				    String statusLine = response.getStatusLine();
					System.out.println("Status line is: "+ statusLine);
					 Assert.assertEquals(statusLine,"HTTP/1.1 200 ");
					 
					 //Success code validation
				   String SucessCode=response.jsonPath().get("SuccessCode");
				   System.out.println("SuccessCode is:"+SucessCode);
				   
				   
				
				    // Retrieving Body of response and printing on the console
				    System.out.println(response.asPrettyString());
				    String responseBody = response.getBody().asString();
				    //System.out.println("Response Body is:" + responseBody);
				    Reporter.log("response Body" + responseBody);
				    

	}
	
	@DataProvider(name="put")
	 public Object[][] getdatafromdataproviderforPut() throws IOException
	 {
	
	  Object[][] datafromexcel = newExcel2.read(".\\TestData\\put (1).xlsx", "Sheet1");
	 
	 return datafromexcel;	
	 }
	
	
	@Test(priority=6,dataProvider ="put") 
	public void testPUTbylistingspecificProgramID(String programId,String programName,String programDescription,String online )
	{

		//---------GET method--------	

 //Intializing base uri from another java class;
  RestAssured.baseURI= RestApiPath.BASE_URL;
		
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given().auth().basic("admin","password");
		
		
		//Response Object
		  Response response=httpRequest.request(Method.GET,"/programs/"+programId);
		  
		  //Retrieving Status Code of response
		    int status = response.getStatusCode();
		    System.out.println("Status code for GET Specific Program ID "+ status);
		    Assert.assertEquals(status, 200);
		    
		
		    // Retrieving Body of response and printing on the console
		    System.out.println(response.asPrettyString());
		    String responseBody = response.getBody().asString();
		    //System.out.println("Response Body is:" + responseBody);
		    Reporter.log("response Body" + responseBody);
		
		
		
	}
	
	
	
	@Test(priority=7,dataProvider ="put") 
	public void testPUTspecificProgramID(String programId,String programName,String programDescription,String online )
	{
		    
		//---------put method--------	
				    
				  //Intializing base uri from another java class;
					RestAssured.baseURI= RestApiPath.BASE_URL;
				    
				  //Request Object
					RequestSpecification httpRequest = RestAssured.given().auth().basic("admin","password");
					
				
				
				//Request payload(body value) sending along with post request
				
				JSONObject requestParams = new JSONObject();
		
				requestParams.put("programId",programId);
				requestParams.put("programName",programName);
				requestParams.put("programDescription",programDescription);
				requestParams.put("online",online);
				
				
				httpRequest.header("Content-Type","application/json");
				httpRequest.body(requestParams.toJSONString());
				
				//Response Object
				  Response response=httpRequest.request(Method.PUT,"/programs/"+programId);
				  
				  //Retrieving Status Code of response
				    int status = response.getStatusCode();
				    System.out.println("Status code for PUT Method with existing program is :"+ status);
				    Assert.assertEquals(status, 200);
				    

					//Retrieving Status Line
				    String statusLine = response.getStatusLine();
					System.out.println("Status line is: "+ statusLine);
					 Assert.assertEquals(statusLine,"HTTP/1.1 200 ");
					 
				
				   
				
				    // Retrieving Body of response and printing on the console
				    System.out.println(response.asPrettyString());
				    String responseBody = response.getBody().asString();
				    //System.out.println("Response Body is:" + responseBody);
				    Reporter.log("response Body" + responseBody);
				    
				    
				    

	}
	
	
	
	
	
	
	
	
	
	
	@Test(priority=8) //,dataProvider ="SearchProvider") 
	public void testDeleteSpecificPrograms() //String programId
	{
	
		//Intializing base uri from another java class;
				RestAssured.baseURI= RestApiPath.BASE_URL;
				
				//Request Object
				RequestSpecification httpRequest = RestAssured.given().auth().basic("admin","password");
				
				String programId="2854";
				
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
