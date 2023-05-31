package com.restassured.tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
public class PutPatchDeleteTest {

	
	@SuppressWarnings("unchecked")
	@Test
	public void testPut() {
		
		baseURI = "https://reqres.in/api";
		JSONObject request = new JSONObject();
		request.put("name","morpheus");
		request.put("job", "zion resident");

		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).
			log().all();
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPatch() {
	
		baseURI="https://reqres.in/api";
		JSONObject request = new JSONObject();
		request.put("name","pheus");
		request.put("job", "resident");
	
		given().
			header("Content-Type","aplication/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/users/2").
		then().
		statusCode(200).log().all();	
}
	
	@Test
	public void testDelete() {
		baseURI="https://reqres.in/api";
		when().
			delete("/users/2").
		then().
			statusCode(204).
			log().all();	

	}
	
	
	
}
