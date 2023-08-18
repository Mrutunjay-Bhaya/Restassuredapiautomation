package com.api;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import jdk.internal.net.http.common.Log;

public class ValidateCoockies {

	// @Test
	public void validateCoockies() {

		Response res = given().when().get("https://google.com");
		System.out.println(res.getCookie("AEC"));

		Map<String, String> coockiess = res.getCookies();
		// System.out.println(coockiess);
		for (String s : coockiess.keySet()) {
			String coockies = res.getCookie(s);
			System.out.println(s + "  " + coockies);
		}

	}

	@Test
	public void response() {
		when().get("https://google.com").then().log().status().log().headers().log().cookies().log().body().log().all();
	}

	@Test
	public void validate() {
		RequestSpecification rs=RestAssured.given();
	
		Response res = given().contentType("ContentType.JSON").when().get("https://google.com");

		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("content-Type"), "text/html; charset=ISO-8859-1");
		String name = res.jsonPath().get("").toString();
		Assert.assertEquals(name, "hari");
 
	}
	@Test
	public void validate_UsingLoop() {
		  Response res=given().when().get("http://localhost:3000/students");
		 JSONArray j=new JSONArray(res.asString());
		  boolean status=false;
		  for(int i=0;i<j.getJSONObject(i).length();i++) {
			String s= j.getJSONObject(i).get("name").toString();
			 System.out.println(s);
			 if(s.equals("Martin Miller")) {
				 status=true;
				 break;
			 }
		  }
		  Assert.assertEquals(status, true);
		 System.out.println(res.headers()); 
		
		  
	}
}
