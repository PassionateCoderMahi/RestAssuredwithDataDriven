package com.restassured.lmsapi;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.restaaured.utilis.RestApiPath;
import com.restaaured.utilis.newExcel2;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutLms {
	
	@DataProvider(name="put")
	 public Object[][] getdatafromdataproviderforPut() throws IOException
	 {
	
	  Object[][] datafromexcel = newExcel2.read(".\\TestData\\put (1).xlsx", "Sheet1");
	 
	 return datafromexcel;	
	 }
	
	
	@Test(priority=5,dataProvider ="put") 
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
	
	
	
	@Test(priority=6,dataProvider ="put") 
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
	
	
	

}
