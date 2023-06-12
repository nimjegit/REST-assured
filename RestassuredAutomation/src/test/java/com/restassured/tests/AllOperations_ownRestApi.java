package com.restassured.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class AllOperations_ownRestApi {
	
	//@Test
	public void getTest() {
		
		baseURI="http://localhost:3000/";
		given().
			header("Content-Type","application/json").
			param("firstName", "Vina").
			get("/users").
		then().
			statusCode(200).
			log().all();
	}
	
	//@Test
	public void testPost() {
		
		baseURI = "http://localhost:3000/";
		JSONObject request = new JSONObject();
		request.put("firstName","Roy");
		request.put("lastName","Test");
		request.put("subjectId","3");
		
		
		given().header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201);
		
		
		
	}
	
	
	
	//@Test
	public void testPatch() {
		
		baseURI = "http://localhost:3000/";
		JSONObject request = new JSONObject();
		request.put("lastName","Cooper");
	
		
		given().header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/users/5").
		then().
			statusCode(200).
			log().all();
		
	}
	//@Test
	public void testPut() {
		baseURI="http://localhost:3000/";
		JSONObject request= new JSONObject();
		request.put("firstName","Mary");
		request.put("lastName","Jane");
		request.put("subjectId","1");
		
		
		given().
			body(request.toJSONString()).
		when().
			put("/users/4").
		then().
			statusCode(200).
		log().all();
	}
	
	
	
	@Test
	public void testDelete() {
		
		baseURI="http://localhost:3000/";
		given().
		
		when().
			delete("/users/6").
		then().
			statusCode(200).
			log().all();
	}
	
	
}
