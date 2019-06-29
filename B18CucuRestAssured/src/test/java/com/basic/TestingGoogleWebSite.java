package com.basic;


import org.junit.Assert;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestingGoogleWebSite {

	/* with rest assured u can test the app without ui*/
	
//	public static void main(String args[]){
//		
//		Response res = RestAssured.given().get("https://www.google.com/");
//		int statCode = res.statusCode();
//		System.out.println("status code is "+statCode);
//		
//	}
	
	
	public void testGoogle(){
		Response res = RestAssured.given().get("https://www.google.com/");
		int statCode = res.statusCode();
		System.out.println("status code is "+statCode);
		Assert.assertEquals(200, statCode);  
	}
}
