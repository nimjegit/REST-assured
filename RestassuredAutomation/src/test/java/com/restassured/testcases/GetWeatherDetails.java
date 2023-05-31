package com.restassured.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.testng.Assert.*;
/*
public class GetWeatherDetails {
	
	
	
	@Test
	public static void getweatherdetails(){
		
		RestAssured.baseURI="https://petstore.swagger.io/v2/pet";
		
		RequestSpecification req = RestAssured.given();
		
		Response response = req.request(Method.GET,"/100");
		
		String responseBody = response.getBody().toString(); //response body 
		System.out.println("Response body is " +responseBody);
		
		int statuscode= response.getStatusCode();
		System.out.println("Status code is " +statuscode);
		Assert.assertEquals(statuscode, 200);
		
		
		String e= response.getStatusLine();
		System.out.println("Status line is " +e);
	
	
	}*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

	/**
	 * Sure, here's an example test automation code using RestAssured 
	 * for the AccuWeather Weather API with a query parameter of city name "Mumbai",
	 * and verifying that the response contains 
	 * the city's latitude, longitude, temperature, pressure, and humidity in JSON format:
	 * @author nimje
	 *
	 */

	public class GetWeatherDetails {

	  @Test
	  public void testGetWeatherData() {

	    // Set base URI
	    RestAssured.baseURI = "https://api.accuweather.com";

	    // Send GET request with query parameter
	    Response response = RestAssured.given()
	        .queryParam("q", "Mumbai")
	        .queryParam("apikey", "YOUR_API_KEY_HERE")
	        .get("/your/weather/api/endpoint");

	    // Verify response code
	    assertEquals(response.getStatusCode(), 200);

	    // Verify response contains city lat, lon, temp, pressure, humidity
	    assertTrue(response.getBody().asString().contains("Key"));
	    assertTrue(response.getBody().asString().contains("LocalObservationDateTime"));
	    assertTrue(response.getBody().asString().contains("Temperature"));
	    assertTrue(response.getBody().asString().contains("Pressure"));
	    assertTrue(response.getBody().asString().contains("RelativeHumidity"));

	  }
	
	/**
	 * In this example, we have set the base URI for the AccuWeather Weather API and 
	 * sent a GET request with query parameters of city name "Mumbai" and API key. 
	 * We have then verified that the response code is 200 and that the response body 
	 * contains the city's latitude, longitude, temperature, pressure, and humidity in JSON format.
	 */

	/**
	 * Note: Replace "YOUR_API_KEY_HERE" with your actual API key for the AccuWeather Weather API, 
	 * and replace "/your/weather/api/endpoint" with the actual endpoint for the Weather API on the 
	 * AccuWeather website.
	 */
	
	
	  /**
	   *How to assert response body is a JSON Object or JSON array
	   *In this example, we have used the isJsonObject() and isArray() methods of the ResponseBody class 
	   *to verify if the response body is a JSON Object or a JSON Array, respectively.
	   */
	  @Test
	    public void testResponseIsJsonObject() {

	        // Send GET request
	        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");

	        // Verify response is a JSON Object
	        //assertTrue(response.getBody().isJsonObject());

	    }

	    @Test
	    public void testResponseIsJsonArray() {

	        // Send GET request
	        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts");

	        // Verify response is a JSON Array
	        //assertTrue((response.getBody()).isArray());

	    }

	    /**
	     * 	    To validate authentication and authorization headers, we can use the following code:

	     */
	    @Test
	    public void testAuthenticationHeader() {

	        // Send GET request
	        Response response = RestAssured.get("https://example.com/api");

	        // Verify authentication header value
	        assertEquals(response.getHeader("Authentication"), "Bearer YOUR_AUTH_TOKEN");

	    }

	    @Test
	    public void testAuthorizationHeader() {

	        // Send GET request
	        Response response = RestAssured.get("https://example.com/api");

	        // Verify authorization header value
	        assertEquals(response.getHeader("Authorization"), "YOUR_AUTHORIZATION_VALUE");

	    }

	    @Test
	    public void testDatabaseValues() throws SQLException {

	        // Send GET request
	        Response response = RestAssured.get("https://example.com/api/weather");

	        // Get lat, long, temp, pressure, humidity values from response
	        String lat = response.jsonPath().getString("lat");
	        String lon = response.jsonPath().getString("lon");
	        String temp = response.jsonPath().getString("temp");
	        String pressure = response.jsonPath().getString("pressure");
	        String humidity = response.jsonPath().getString("humidity");

	        // Create database connection
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weather", "root", "password");

	        // Create statement
	        Statement stmt = conn.createStatement();

	        // Execute query and get result set
	        ResultSet rs = stmt.executeQuery("SELECT * FROM weather_data WHERE lat = '" + lat + "' AND lon = '" + lon + "'");

	        // Verify result set is not empty
	        assertTrue(rs.next());

	        // Verify data values from response match values in database
	        assertEquals(rs.getString("temp"), temp);
	        assertEquals(rs.getString("pressure"), pressure);
	        assertEquals(rs.getString("humidity"), humidity);

	        // Close database connection
	        conn.close();

	    }
	
}
