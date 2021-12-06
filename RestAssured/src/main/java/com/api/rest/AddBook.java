package com.api.rest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

import com.api.payload.payload;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class AddBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Properties prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:/Users/vasanthakumar.j/eclipse-workspace/RestAssured/src/main/resources/com/api/resources/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SessionFilter session = new SessionFilter();
		
		RestAssured.baseURI = prop.getProperty("uri");
		
		String response = given().log().all().header("Content-Type", "application/json").body("{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\"abc\",\r\n"
				+ "\"aisle\":\"1324\",\r\n"
				+ "\"author\":\"John hej\"\r\n"
				+ "}").filter(session)
		.when().post("Library/Addbook.php")
			.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("JSOn Response: " +response);
		JsonPath js = new JsonPath(response);
		
		String id_No = js.getString("ID");
		System.out.println(id_No);
		
		Assert.assertEquals(id_No, "abc1324");
		
		
		Response resp = RestAssured.given().log().all().header("Content-Type", "application/json").body("{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\"abc\",\r\n"
				+ "\"aisle\":\"1324\",\r\n"
				+ "\"author\":\"John hej\"\r\n"
				+ "}").filter(session)
		.when().post("Library/Addbook.php");
		
		resp.jsonPath().get("isbn");
		
		
		
		
		
	}

}
