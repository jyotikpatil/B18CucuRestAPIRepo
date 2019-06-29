package com.basic.getRequestSD;


import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class GetRequestSD {
	
	Response resp;
	
	@Given("^user start the rest assured test$")
	public void user_start_the_rest_assured_test() throws Throwable {
		System.out.println("Starting of the GET request");
	}

	@When("^user hit the get request$")
	public void user_hit_the_get_request() throws Throwable {
	    resp = RestAssured.given().relaxedHTTPSValidation().when().
	    		get("http://ergast.com/api/f1/2017/circuits.json");
	    
	    //print response in string
	    String respString = resp.asString();
	    System.out.println("Response String is  "+respString);
	    
	    //get all headers
	    Headers heads = resp.getHeaders();
	    System.out.println("Get all Headers "+heads);
	}
//
//	@Then("^user check the (\\d+) status code$")
//	public void user_check_the_limit(int expStatusCode) throws Throwable {
//	    //get status from the response
//		int statusCode = resp.getStatusCode();
//		Assert.assertTrue(expStatusCode==statusCode);
//	}

	@Then("^user checks the count or size$")
	public void user_checks_the_count_or_size() throws Throwable {
	     String limitValue = resp.getBody().jsonPath().getString("MRData.limit");
	     Assert.assertEquals("30", limitValue);
	     
	}

}
