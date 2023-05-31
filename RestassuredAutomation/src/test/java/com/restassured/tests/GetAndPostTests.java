package com.restassured.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class GetAndPostTests {

	
	@Test
	public void testGet() {
		
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data.first_name[3]" ,equalTo("Byron")).
			body("data.first_name",hasItems("George","Rachel")).
			log().all();
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPostreq() {
		
		baseURI="https://reqres.in/api";
		JSONObject request = new JSONObject();
		request.put("name","vina");
		request.put("job","QA Automation tester");
		
		given().
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).log().all();
	
	}
	
}
