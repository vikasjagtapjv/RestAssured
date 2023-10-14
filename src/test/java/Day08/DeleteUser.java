package Day08;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;
public class DeleteUser {
	@Test(priority=3)
	public void deleteUser(ITestContext context)
	{
		String BearerToken="f1e0936417652f46eae3626df33cfb00c85c6267b4b5c5e37a0fc944d47971a8";

		//int id=(int)context.getAttribute("user_id");
		//these variables are available at test level
		int id=(int)context.getSuite().getAttribute("user_id");
		//These variables are available at suite level
	
		
		given()
		.headers("Authorization","Bearer "+BearerToken)
		.pathParam("id",id)
		.when()
		.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(204)
		.log().all();
	}
	

}
