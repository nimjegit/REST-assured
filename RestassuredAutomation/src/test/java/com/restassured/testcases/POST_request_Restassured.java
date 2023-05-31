package com.restassured.testcases;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class POST_request_Restassured {
	
	
	
@Test
public void testpostrequest() {
	
	//RestAssured.baseURI="https://demoqa.com/Account/v1/User";
	JSONObject request = new JSONObject();
			request.put("id", "6543");
			request.put("username","Rsh");
			request.put("firstName","raj");
			request.put("lastName","shekar");
			request.put("email","Rrajasekhar@test.com");
			request.put("password","Rrajasekhar!23");
			request.put("phone","3844476541");
			request.put("userStatus","1");
			
	System.out.println(request);
	System.out.println(request.toJSONString());
	
	given().
		body(request.toJSONString()).
	when().
		post("https://petstore.swagger.io/v2/user").
	then().
		statusCode(200);
}


@SuppressWarnings("unchecked")
@Test
public void testpostorder() {
	String url="https://petstore.swagger.io/v2/store/order";
	JSONObject request = new JSONObject();
	request.put("id", "54");
	request.put("petId", "0");
	request.put("quantity", "0");
	request.put("shipDate", "2023-02-10T20:57:33.590Z");
	request.put("status", "placed");
	request.put("complete", "true");
	
	given().
		body(request.toJSONString()).
	
	when().
		post(url).
		
	then().statusCode(200);
	
	
	System.out.println("Time taken to fetch the response: " +get(url).timeIn(TimeUnit.MILLISECONDS));
	
	
}

}


