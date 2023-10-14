 package Day01;

import org.testng.annotations.Test;
import  static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Logging {
	@Test(priority=1)
	public void log_Test() {
		given()
		.when()
		.get("https://reqres.in/api/users?page=2&id=5")
		.then()
		//.log().cookies();
		.log().headers();
		
	}

}
