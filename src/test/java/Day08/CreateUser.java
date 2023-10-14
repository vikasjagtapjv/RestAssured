package Day08;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
public class CreateUser {
	@Test(priority=0)
	void test_CreateUser(ITestContext context)
	{
		Faker faker=new Faker();
		JSONObject data=new JSONObject();
		data.put("name",faker.name().fullName());
		data.put("gender","male");
		data.put("email",faker.internet().emailAddress());
		data.put("status","inactive");
		
		String BearerToken="f1e0936417652f46eae3626df33cfb00c85c6267b4b5c5e37a0fc944d47971a8";
		int id=given()
		.headers("Authorization","Bearer "+BearerToken)
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("https://gorest.co.in/public/v2/users")
		.jsonPath().getInt("id");
		System.out.println("Generated Id is :"+id);
		//context.setAttribute("user_id",id);//variables are available only test level
		context.getSuite().setAttribute("user_id",id);
		//variables are available at suite level
		
	}

}
