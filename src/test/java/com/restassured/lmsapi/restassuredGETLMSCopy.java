package com.restassured.lmsapi;
import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.restaaured.utilis.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

public class restassuredGETLMSCopy {

	public void f()
	 {
	   Reporter.log("Using Restassured for get method");
	 }
	  
	@DataProvider(name="SearchProvider")
	 public Object[][] getdatafromdataprovider() throws IOException
	 {
	Object[][] datafromexcel = ReadExcelcopy2.testData(".\\TestData\\GetApiTestdata (1).xlsx", "Sheet1");
	 // Object[][] datafromexcel = copy3.testData(".\\TestData\\Get.xlsx", "Sheet1");
	 return datafromexcel;	
	 }
	
	
	@Test  (priority=1)                  //(priority=1, dataProvider ="SearchProvider") 
	public void testGetallPrograms() {
		
	Response response =	given().auth().basic("admin","password").
		when().get(RestApiPath.BASE_URL+"/programs");
	
	//Assert.assertEquals(response.getStatusCode(),200,"Response received successfully");
	//System.out.println("Response received successfully");
	
    /*Retrieving Body of response and printing on the console
    System.out.println(response.asPrettyString());
    String responseBody = response.getBody().asString();
    System.out.println("Response Body is:" + responseBody);
    Reporter.log("response Body" + responseBody);
*/
    //Retrieving Status Code of response
    int status = response.getStatusCode();
    System.out.println("Status code is "+ status);
    Assert.assertEquals(status, 200);
	
	//Retrieving Status Line
    String statusLine = response.getStatusLine();
	System.out.println("Status line is "+ statusLine);
		
	/*String programId=response.jsonPath().getString("programId[0]");
	Reporter.log("First retreived program id : "+programId);
	System.out.println("First retreived program id : "+programId);
	Assert.assertNotNull(programId);*/
	}

	@Test(priority=1, dataProvider ="SearchProvider") 
	public void testGetSpecificPrograms(String programId,String programName,String programDescription,String isOnline)
	{
		
	Response response =	given().auth().basic("admin","password").
		when().get(RestApiPath.BASE_URL+"/programs/"+programId);
	
	System.out.println(response.getBody().asString());
	
	//System.out.println(response.contentType());
	
	//System.out.println(response.

	
	JsonPath JsonpathEvaluvator =response.jsonPath();
	
	int apiprogramId=JsonpathEvaluvator.get("programID");
	
	Reporter.log("ProgramID received from response :"+apiprogramId);
	
	Assert.assertNotNull(apiprogramId);
	
	
	Assert.assertTrue(Integer.parseInt(programId) == apiprogramId);
	
	
	}	
	
	@Test(priority=2, dataProvider ="SearchProvider") 
	public void testGetSpecificPrograms(String programId)
	{
		
	Response response =	given().auth().basic("admin","password").
		when().get(RestApiPath.BASE_URL+"/programs/"+programId);
	
	//Retrieving Body of response and printing on the console
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
	
	/*JsonPath JsonpathEvaluvator =response.jsonPath();
	
	int apiprogramId=JsonpathEvaluvator.get("programID");
	
	Reporter.log("ProgramID received from response :"+apiprogramId);
	
	Assert.assertNotNull(apiprogramId);
	
	
	Assert.assertTrue(Integer.parseInt(programId) == apiprogramId);
	*/
	
	}	
}
