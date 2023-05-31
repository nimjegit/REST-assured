package com.restassured.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Get_Request_Restassured {
	
	
	
	@Test
	public void testgetrequest() {
		
		RestAssured.baseURI="https://petstore.swagger.io/v2/store/order"; 
		
		//Request Object
		RequestSpecification httprequest =  RestAssured.given();
		
		//Response object
		Response response = httprequest.request(Method.GET,"/8");
		
		//Print response of the request
		String resBody = response.getBody().asString();
		System.out.println("Response body is " +resBody);
		
		//Get status code
		int statuscode = response.getStatusCode();
		System.out.println("Response code is " +statuscode);
		
		//Get response time
		long resTime= response.timeIn(TimeUnit.MILLISECONDS);
		System.out.println("Response time is" +resTime);
		
		System.out.println("Header of the request is" +response.headers());
		
		/*
		given().contentType("application/json")
		
		.when()
			.get("https://petstore.swagger.io/v2/store/inventory")
			
		.then().
			
			assertThat().
			
			body("sold", hasSize(7)).
			
			and(). 
			
			statusCode(200).
			
			and().
			
			header("Content-Type", "application/json");*/

	}

//@Test
public void postrequest() {
	
	
	HashMap<String,String> data=new HashMap<String, String>();
	data.put("id", "1234");
	data.put("username", "abcd");
	data.put("firstName", "tewq");
	data.put("email", "abcd@test.com");
	data.put("password", "Test1234");
	data.put("phone", "7346312345");
	data.put("userStatus","0");
	

		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://petstore.swagger.io/v2/user")
			
		.then().
		
			assertThat().
			
			body("code",equalTo(200)).
			
			and().
			
			statusCode(200).
			
			and().
			
			header("content-type","application/json");
		
}

@Test
public void getdetails() {
	
	
	RestAssured.baseURI =
		      "http://demo.guru99.com";
	given().
		queryParam("CUSTOMER_ID","68195").
		queryParam("PASSWORD", "1234").
		queryParam("Account_No", "1").
	
		when().
			get("/V4/sinkministatement.php").
		//System.out.println("Status code is: " +statusCode);
		then().log().all().assertThat().statusCode(200);
	
}
//@Test
public void getbody() {
	
	given().
		queryParam("CUSTOMER_ID","68195").
		queryParam("PASSWORD", "1234").
		queryParam("Account_No", "1").
	when().get("http://demo.guru99.com/V4/sinkministatement.php").
	
	then().log().all();
}
//@Test
public static void getResponseHeaders(){
	
	String url="http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";

	   System.out.println("The headers in the response "+
	                   get(url).then().extract()
	           .headers());
	}
//@Test
public static void getResponseTime(){
	String url="http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";
	  System.out.println("The time taken to fetch the response "+get(url)
	         .timeIn(TimeUnit.MILLISECONDS) + " milliseconds");
	}
//@Test
public void getcontenttype() {
	given().
	queryParam("CUSTOMER_ID","68195").
	queryParam("PASSWORD", "1234").
	queryParam("Account_No", "1").
when().get("http://demo.guru99.com/V4/sinkministatement.php").

then().extract().contentType();
}


}
