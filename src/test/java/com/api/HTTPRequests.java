package com.api;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import com.PostApi.PojoClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.internal.support.FileReader;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/*
 * given()
     content type, set cookies, add auth, add parameter, set header info etc....
     
   *  when()
      get, post, put, delete
      
     * then()
      validate status code, extract response, extract header cookies and Response body..
 */

/*
 * Different way to create POST body
 * 1. Post request body using HashMap
 * 2. Post request body creation using JSONobject
 * 3. Post request body creation using POJO class
 * 4. Post request body using external json file
 */

public class HTTPRequests {

	//@Test(priority=-2)
	public void getUser() {
		given()

				.when().get("https://3.111.130.216.nip.io/customer/cart").then().statusCode(200)// body("page",
																								// equalTo(2))
				.log().all();

	}

	//@Test(priority=-3)
	public void postRequestUsingHashMap() {
		HashMap data = new HashMap();
		data.put("name", "sibu");
		data.put("location", "india");
		data.put("phone", "123456");
		String courseArry[] = { "c", "java" };
		data.put("course", courseArry);

		given().contentType("application/json").body(data)

				.when().post("https://localhost:3000/students")

				.then().statusCode(200).body("name", equalTo("sibu")).body("location", equalTo("india"))
				.body("phone", equalTo("123456")).body("course[0]", equalTo("c")).body("course[1]", equalTo("java"))
				.header("Content-Type", "appliction/json; charset=utf-8").log().all();

	}

	//@Test
	public void postRequestUsingJSONLibrary() {

		JSONObject data = new JSONObject();
		data.put("name", "sibu");
		data.put("location", "india");
		data.put("phone", "123456");
		String courseArry[] = { "c", "java" };
		data.put("course", courseArry);

		 Response response= given().contentType("application/json").body(data.toString())

				.when().post("https://localhost:3000/students");

				response.then().statusCode(200).body("name", equalTo("")).body("location", equalTo("india"))
				.body("phone", equalTo("123456")).body("course[0]", equalTo("c")).body("course[1]", equalTo("java"))
				.cookie("").header("Content-Type", "appliction/json; charset=utf-8").log().all();

	}

	@Test(priority=1)
	public void postRequestUsingPojo() throws JsonProcessingException {

		PojoClass data = new PojoClass();
		data.setName("sibu");
		data.setLocation("india");
		data.setPhone("123456");
		String courseArry[] = { "c", "java" };
		data.setCourses(courseArry);
//Here use serialization concept to convert object data to json data
	ObjectMapper obj=new ObjectMapper();
	String s=obj.writerWithDefaultPrettyPrinter().writeValueAsString(data);
	
	System.out.println(s);
	
	
	
	
	}

		/*given().contentType("application/json").body(data)

				.when().post("http://localhost:3000/students")

				.then().statusCode(201).body("name", equalTo("sibu")).body("location", equalTo("india"))
				.body("phone", equalTo("123456")).body("course[0]", equalTo("c")).body("course[1]", equalTo("java"))
				.header("Content-Type", "appliction/json; charset=utf-8").log().all();
	}*/

	//@Test(priority=2)
	public void postRequestUsingExternalJSONfile() throws Throwable {
		File f = new File(".\\body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		data.put("name", "sibu");
		data.put("location", "india");
		data.put("phone", "123456");
		String courseArry[] = { "c", "java" };
		data.put("course", courseArry);

		given().contentType("application/json").body(data.toString())

				.when().post("https://localhost:3000/students")

				.then().statusCode(200).body("name", equalTo("sibu")).body("location", equalTo("india"))
				.body("phone", equalTo("123456")).body("course[0]", equalTo("c")).body("course[1]", equalTo("java"))
				.header("Content-Type", "appliction/json; charset=utf-8").log().all();

	}
	@Test
       public void setBaseUri() {
		
    	   RestAssured.baseURI="";
    	   System.out.println(baseURI);
    	   
    	   
       }
}
