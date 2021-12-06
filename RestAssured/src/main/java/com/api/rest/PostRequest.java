package com.api.rest;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.sun.xml.bind.v2.runtime.Name;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class PostRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://reqres.in";
		
		String body = "{\r\n"
				+ "    \"name\": \"Vasanth\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		
		String response = given().log().all().header("Content-Type", "application/json").body(body)
			.when().post("/api/users").then().log().all().assertThat().statusCode(201).extract().response().asString();
		
		
		JsonPath js = new JsonPath(response);
		String job = js.getString("job");
		System.out.println(job);
	
		
		
		
		
		
		
	}

}
