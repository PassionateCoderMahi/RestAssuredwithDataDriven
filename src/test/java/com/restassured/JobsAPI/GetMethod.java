package com.restassured.JobsAPI;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetMethod {
  @Test
  public void GetListOfJobs_verifyStatusCode() 
  {
	  
	// Given
			given()
				.baseUri("https://jobs123.herokuapp.com")
			// When
			.when()
				.get("/Jobs")
			// Then
			.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK");
				// To verify booking count
				//.body("bookingid", hasSize(10))
				// To verify booking id at index 3
				//.body("bookingid[3]", equalTo(1));			
			
	 
	  
	
		
  }


}
