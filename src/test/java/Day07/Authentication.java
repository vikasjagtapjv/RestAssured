package Day07;

import org.testng.annotations.Test;

import io.opentelemetry.api.trace.StatusCode;

import  static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Authentication {
	//@Test(priority=1)
	void testBasicAuthentication()
	{
		//we can put here prerequest
		//basic authentication we can put here
		given()
		.auth().basic("postman","password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
	}
//	@Test(priority=2)
	public void digestAuthentication()
	{
		given()
		.auth().digest("postman","password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
	}
	
//	@Test(priority=3)
	public void preemptiveAuthentication()
	{
		//It is combination of basic and digest
		given()
		.auth().preemptive().basic("postman","password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
	}
	//@Test(priority=4)
	public void bearerTokenAuthhenticaton() {
		String bearerToken="f1e0936417652f46eae3626df33cfb00c85c6267b4b5c5e37a0fc944d47971a8";
		
		given()
		.headers("Authorization","Beares"+bearerToken)
		
		.when()
		.get("https://gorest.co.in/public/v2/users")
		.then()
		.statusCode(200)
		.log().all();
		
	}
	//@Test(priority=5)
	public void testoauth1Authenticationo() {
		given()
		.auth().oauth("consumerKey","consumerSecrat","accessToken","tokenSecrat" )
		.when()
		.get("")
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	//@Test(priority=6)
	public void testoauth2Authentication()
	{
		given()
		.auth().oauth2("f1e0936417652f46eae3626df33cfb00c85c6267b4b5c5e37a0fc944d47971a8")
		.when()
		.get("https://gorest.co.in/public/v2/users")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test(priority=7)
	public void apiKeyAuthentivation()
	{
		//method
//		given()
//		.queryParam("appid", "5521b12ccf3e188e475d4fb3f4dd4b64")
//		.when()
//		.get("https://api.openweathermap.org/data/2.5/weather?q=delhi&units=metric&cnt=7")
//		.then()
//		.statusCode(200)
//		.log().all(); 
		
		given()
		.queryParam("appid", "5521b12ccf3e188e475d4fb3f4dd4b64")
		.pathParam("myPath", "data/2.5/weather")
		.queryParam("q", "delhi")
		.queryParam("units", "metric")
		.queryParam("cnt", "7")
		.when()
		.get("https://api.openweathermap.org/{myPath}")
		.then()
		.statusCode(200)
		.log().all();
	}
	

}
