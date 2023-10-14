package Day04;
import  static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Parsing_JSON_Response_Data {
	@Test(priority=1)
	public void test_JSON_Response()
	{
		/*given()
		
		.pathParam("mypath","users")
		.contentType("ContentType.JSON")
		
		.when()
		.get("http://localhost:3000/{mypath}/2")
		
		.then()
		.statusCode(200)
		.header("Content-Type","application/json; charset=utf-8")
		.body("first",equalTo("vilast"))
		;
		*/
		Response res =given()
				.contentType(ContentType.JSON)
	 			.pathParams("myPath","users")
				.when()
				.get("http://localhost:3000/{myPath}/2");
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
		  String personName=res.jsonPath().get("first").toString();
		  Assert.assertEquals(personName,"vilast");
	}
	@Test(priority=2)
	public void test_JSON_Response_Body()
	{
		Response res=given()
				.contentType("application/json")
				//.pathParams("myPath","users")
				.when()
				.get("http://localhost:3000/users");
		JSONObject js=new JSONObject(res.asString());//converting response to JSONObject type
		for (int i=0;i<js.getJSONArray("users").length();i++)
		{
			
			 //we index with i
			 //js first we are getting JSONObject that representing entire json response
			 //In that we have  JSONArray
			 //js.JSONArray("users"):
			 //In that we have multiple JSONObjects
			 // we are extracting the (i) zero JSONObject 
			 //from that we are extracting the "first"
			 //Then converting to the String
			String firstNAME=js.getJSONArray("users").getJSONObject(i).get("first").toString();
			 System.out.println(firstNAME );
		}
	}

}
