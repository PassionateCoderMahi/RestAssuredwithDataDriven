package com.restassured.JobsAPI;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import java.util.concurrent.TimeUnit;

public class FirstGetPost {
	
	@BeforeTest 
	public static void bfrtest()
	{
		RestAssured.baseURI = "https://numpyninja-joblistapi.herokuapp.com";
	}
	
	
	@Test 
	public void testGet()
	{
		
		// the below code is to fetch all the records
		given().
			get("/Jobs").
		then().
			statusCode(200).log().body();
		
		// The below code is to get the time taken 
		System.out.println("Time Taken: "+ get("/Jobs").timeIn(TimeUnit.MILLISECONDS)+"in milliSec");
		
		//the below code is for get a specific response but for this api it is giving the entire set of records
		/*
		 * given(). get("/Jobs"). then().
		 * statusCode(200).body("data[\"Job Title\"].1",equalTo("SDET")). log().all();
		 */
		   // .body("data[\"Job Title\"]"),hasItems("SDET","SDET10"));
	}
	@Test
		  public void testpost()
	  { 
		  JSONObject jsobj = new JSONObject();
		  jsobj.put("Job Title", "API Tester");
		  jsobj.put("Job Company Name", "Pensky");
		  jsobj.put("Job Location", "St.Louis");
		  jsobj.put("Job Type", "Full Time");
		  jsobj.put("Job Posted time", "12:07");
		  jsobj.put("Job Description", "Cool Trendy Job");
		  jsobj.put("Job Id", "3333398");
		  
		  System.out.println(jsobj.toString());
		  given().
		  	header("Content-type", "application/json").
		  	body(jsobj.toJSONString()).
		  when().
		  	post("/Jobs").
		  then().statusCode(200).extract().response();
	  
	  }
		  // As of now put method is not working for everybody
	@Test
	public void testput()
	{
		 JSONObject jsobj = new JSONObject();
		  jsobj.put("Job Title", "API Tester");
		  jsobj.put("Job Company Name", "GE");
		  jsobj.put("Job Location", "Wild Wood, MO");
		  jsobj.put("Job Type", "Full Time");
		  jsobj.put("Job Posted time", "12:07");
		 // jsobj.put("Job Description", "Cool Trendy Job"); // Description can not be updated 
		  jsobj.put("Job Id", "1017");
		  
		  System.out.println(jsobj.toString());
		  given().
		  	header("Content-type", "application/json").
		  	body(jsobj.toJSONString()).
		  when().
		  	put("/Jobs").
		  then().statusCode(200).extract().response();
		
	}
	//@Test
	public void testdelete()
	{
		given().
		 when().
		  	delete("/Jobs?Job Id=1019").
		  then().statusCode(200).extract().response();
		
	}
	 

}
