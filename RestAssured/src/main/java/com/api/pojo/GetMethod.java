package com.api.pojo;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.List;


public class GetMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "http://localhost:3000/";

  RequestSpecification res=  new RequestSpecBuilder().addHeader("Content-Type", "application.json").build();
  
		
			Courses gc  = given()
			.spec(res)
				.when().log().all().get("/courses")
					.as(Courses.class);
			
			//gc.getCourses().getApi().get(1).getPrice();
			
			List<Api> api = gc.getCourses().getApi();
			
			for(int i =0; i<api.size(); i++) {
				
				if(api.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
					
					System.out.println(api.get(i).getPrice());
					
				}
				 	
			}
			
			System.out.println("Below prints the course title of WebAutomation");
			
			List<WebAutomation> web =  gc.getCourses().getWebAutomation();	
			
			for(int j=0; j<web.size(); j++) {
				
				System.out.println("Course Title: " +web.get(j).getCourseTitle());
			
				
			}
			
			
			

	}

}
