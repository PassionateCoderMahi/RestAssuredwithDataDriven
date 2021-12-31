package com.restassured.lmsapi;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.restaaured.utilis.DummyExcel;

import org.testng.Reporter;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import java.io.IOException;



public class Dummy {

  @Test(dataProvider="GetAPIData")
  public void GetAPI(String username,String pwd,String endpoint, String path) throws IOException {
	  

	  PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
      authScheme.setUserName(username);
      authScheme.setPassword(pwd);
      RestAssured.authentication = authScheme;
   

      
      // Using Rest-Assured class to setup a request
      RestAssured.baseURI = endpoint;   
     
    
      // Getting the RequestSpecification of the request
      RequestSpecification httpRequest = RestAssured.given();
      
      Response response = httpRequest.request(Method.GET,path);
      
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
	


  }
  @DataProvider(name="GetAPIData")
	public String [][] getData() throws IOException
	{

		
		//get the data from excel
		String path=".\\TestData\\GetApiTestdata4.xlsx";
		
		DummyExcel xlutil=new DummyExcel(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);	
				
		String apiData[][]=new String[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				apiData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
				
		}
		
		return apiData;
	}
 
}