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
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;

public class restassuredGETLMS {

	public void f()
	 {
	   Reporter.log("Using Restassured for get method");
	 }
	  
	@DataProvider(name="SearchProvider")
	 public Object[][] getdatafromdataprovider() throws IOException
	 {
	 Object[][] datafromexcel = ReadExcel.read(".\\TestData\\GetApiTestdata.xlsx", "Sheet1");
	 return datafromexcel;	
	 }
	
	
	@Test                    //(priority=1, dataProvider ="SearchProvider") 
	public void testGetallPrograms() {
		
	Response response =	given().auth().basic("admin","password").
		when().get(RestApiPath.BASE_URL+"/programs");
	
	Assert.assertEquals(response.getStatusCode(),200,"Response received successfully");
		//System.out.println("Response received successfully");
		
	String programId=response.jsonPath().getString("programId[0]");
	Reporter.log("First retreived program id : "+programId);
	System.out.println("First retreived program id : "+programId);
	Assert.assertNotNull(programId);
	}

	@Test(priority=1, dataProvider ="SearchProvider") 
	public void testGetSpecificPrograms(String programId,String programName,String programDescription,Boolean isOnline) {
		
	Response response =	given().auth().basic("admin","password").
		when().get(RestApiPath.BASE_URL+"/programs/"+programId);
	
	System.out.println(response.asString());
	
	JsonPath JsonpathEvaluvator =response.jsonPath();
	
	String apiprogramId=JsonpathEvaluvator.get("programID");
	
	Reporter.log("ProgramID received from response :"+apiprogramId);
	
	Assert.assertNotNull(apiprogramId);
	//Assert.ass
	
	//Assert.assertTrue(Integer.parseInt(programId) == apiprogramId);
	
	
	}	
}
