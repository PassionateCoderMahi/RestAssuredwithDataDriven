package com.restassured.lmsapi;

import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.restaaured.utilis.RestApiPath;
import com.restaaured.utilis.newExcel2;
import com.restaaured.utilis.newExcel3;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostWithHasMap {
	
	@DataProvider(name="post")
	 public Object[][] getdatafromdataproviderforPOST2() throws IOException
	 {
	
	  Object[][] datafromexcel = newExcel3.read(".\\TestData\\postnew.xlsx", "Sheet1");
	 
	 return datafromexcel;	
	 }
	
	@Test(priority=5,dataProvider ="post") 
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

}
