package Day03;
import  static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class Path_And_Query_Parameters {
	
	//https://reqres.in/api/users?page=2&id=5
	@Test
	public void testPathAndQueryParameters()
	{
		//Pass Path & query parameters
		given()
		.contentType("application/json")
		.pathParam("myPath","users ")//path parameter 
		.queryParam("page", 2)//query parameter It will filter the data
		.queryParam("id",5)//query Parameter it will go along with request automatically
		
		
		.when()
		.get("https://reqres.in/api/{myPath}")
		
		
		.then()
		.statusCode(200)
		.log().all();
	}

}
