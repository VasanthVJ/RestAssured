package com.api.OAuth;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//OAuth 2.0 login
		
		//Authroize
		
		Response response =  RestAssured.given().formParam("client_id", "Vasanth")
		.formParam("client_secret", "44292ad6519a9f64b13339f4aefbe879")
		.formParam("grant_type", "client_credentials")
		.when().post("http://coop.apps.symfonycasts.com/token");
		
		
		System.out.println(response.jsonPath().prettify());
		
		String token = response.jsonPath().get("access_token");
		
		System.out.println(token);
		
		
		
		//Get Call:
		
		Response resp = RestAssured
				.given()
				.auth()
				.oauth2(token)
				.post("http://coop.apps.symfonycasts.com/api/2315/barn-unlock");
		
		resp.getStatusCode();
		
		System.out.println(resp.jsonPath().prettify());
		 String suc = resp.jsonPath().getString("success");
		 System.out.println(suc);
		
		
			
		

	}

}
