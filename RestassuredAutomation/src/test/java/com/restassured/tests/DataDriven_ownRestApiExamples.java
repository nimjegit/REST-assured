package com.restassured.tests;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDriven_ownRestApiExamples extends DataForTests{

		
	@SuppressWarnings("unchecked")
	//@Test(dataProvider = "UsingDataProvider")
	public void dataDrivenEx(String firstName,String lastName,int subjectId) {
	
	
	JSONObject request= new JSONObject();
	request.put("firstName",firstName);
	request.put("lastName",lastName);
	request.put("subjectId",subjectId);
	
	
	baseURI="http://localhost:3000/";
	given().header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
	when().
		post("/users").
	then().
		statusCode(201).log().all();
	}
	
	
	
	//@Test(dataProvider="UsingForDelete")
	public void testDelete(int userId) {
		
		baseURI="http://localhost:3000/";
		given().
		
		when().
			delete("/users/" +userId).
		then().
			statusCode(200).
			log().all();
	}
	
		@Parameters({"userId"})
		@Test
		public void testDelete2(int userId) {
		
		System.out.println("Value of the userid is" +userId);
		baseURI="http://localhost:3000/";
		given().
		
		when().
			delete("/users/" +userId).
		then().
			statusCode(200).
			log().all();
	


}
		
}
		
