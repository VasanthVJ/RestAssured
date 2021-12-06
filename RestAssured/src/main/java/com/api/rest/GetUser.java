package com.api.rest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class GetUser {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "https://reqres.in";
		
		String  responseBody = given().queryParam("page", 2).expect().defaultParser(Parser.JSON)
		.when().get("/api/users")
		.then().log().all().assertThat().statusCode(200)
			.body("data[0].id", equalTo(7)).extract().response().asString();
		
		System.out.println(responseBody);
		JsonPath js = new JsonPath(responseBody);
		
		String total = js.getString("data[1].email");
		
		System.out.println(total);

	}

}
