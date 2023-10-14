package Day01;

import org.testng.annotations.Test;
import  static io.restassured.RestAssured.*;
 import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

/* given():{We can put here prerequisite}content Type,cookies,add auth, add param,set Headers info etc.....
 * 
 * when():we have to put here Request Type OR request URL we can put here 
 * get,put ,post,delete,patch etc......
 * 
 * then():All validation we have to keep here 
 * validate status code,extract response,extract headers,cookies and headers body ,etc....
*/

public class HTTPRequest {
	int id;
	@Test(priority=1)
	void getUsers()
	{
		given()
		
		.when()
		 .get("https://reqres.in/api/users?page=2")
		
		
		.then()
		 .statusCode(200)
		 .body("page",equalTo(2))
		 .log().all();
	}
	@Test(priority=2)
	void createUser()
	{
		HashMap data =new HashMap();
		data.put("Name","Vikas");
		data.put("Job","Learner");
		
		id=given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
//		.then()
//		.statusCode(201)
//		.log().all();
	}
	@Test(priority=3,dependsOnMethods= {"createUser"})
	void updateUser()
	
	{
		HashMap data=new HashMap();
		data.put("Name","viky");
		data.put("Job","Student");
		
		given()
		.contentType("application/json ")
		.body(data)
		
		.when()
		.put("https://reqres.in/api/users/"+id)
		
		
		.then()
		.statusCode(200)
		.log()
		.all();
		
	}
	@Test(priority=4)
	void deleteUser()
	{
		when()
		.delete("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(204)
		.log()
		.all();
	}
	 

}
