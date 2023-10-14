package Day08;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
public class UpdateUser {
	@Test(priority=2)
	public void updateUser(ITestContext context)
	{
		
		Faker faker=new Faker();
		JSONObject data=new JSONObject();
		data.put("name",faker.name().fullName());
		data.put("gender","male");
		data.put("email",faker.internet().emailAddress());
		data.put("status","active");
		
		String BearerToken="f1e0936417652f46eae3626df33cfb00c85c6267b4b5c5e37a0fc944d47971a8";
		//int id=(int)context.getAttribute("user_id");
		//these variables are available at test level
		int id=(int)context.getSuite().getAttribute("user_id");
		//These variables are available at suite level
		given()
		.headers("Authorization","Bearer "+BearerToken)
		.contentType("application/json")
		.body(data.toString())
		.pathParam("id",id)
		
		.when()
		.put("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(200)
		.log().all();
		
		
	}

}
