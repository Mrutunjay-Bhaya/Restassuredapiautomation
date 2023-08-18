package com.api;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Authentication {
	
@Test
	void testBasicAuthentication() {
		Logger logger=LogManager.getLogger(this.getClass());
		logger.info("info start");
		logger.trace("trace start");
		logger.debug("debug start");
		logger.error("error");
		logger.warn("warn");
		logger.fatal("fatal");
		
		given()
		//.auth().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
		
	}
@Test
void testDigestAuthentication() {
	
	
	given().auth().digest("postman", "password")
	.when().get("https://postman-echo.com/basic-auth")
	.then().statusCode(200)
	.body("authenticated", equalTo(true))
	.log().all();
	
}
@Test
void testPreemptiveAuthentication() {
	
	
	given().auth().preemptive().basic("postman", "password")
	.when().get("https://postman-echo.com/basic-auth")
	.then().statusCode(200)
	.body("authenticated", equalTo(true))
	.log().all();
	
}
@Test
void testBearerTokenAuthentication() {
	
	String token="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";
	given().headers("Authorization","Bearer "+token)
	.when()
	.get("https://api.github.com/user/repos")
	.then()
	.statusCode(200)
	.log().all();


}
@Test
void testOAuth1_Authentication() {
	
String consumerKey="";
String consumerSecret="";
String accessToken="";
String secretToken="";


	given()
	.auth().oauth(consumerKey, consumerSecret, accessToken, secretToken)
	.when()
	.get("url")
	.then()
	.statusCode(200)
	.log().all();
}
@Test
void testOAuth2_Authentication() {
	
	String token="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";
	given()
	.auth().oauth2(token)
	.when()
	.get("https://api.github.com/user/repos")
	.then()
	.statusCode(200)
	.log().all();

}
@Test
void testAPIKeyAuthentication() {
	
	
	given()
	.queryParam("appid", "fe9cfdsdsudsysgduyrq467r3rrgyfgw")// appid is API key
	
	.pathParam("mypath", "data/2.5/forecast/daily")
	
	.queryParam("q", "Delhi")
	
	.queryParam("units", "matrics")
	
	.queryParam("cnt", "7")
	
	.when()
	.get("https://api.openweathermap.org/{mypath}")
	.then()
	.statusCode(200)
	.log().all();
}}
