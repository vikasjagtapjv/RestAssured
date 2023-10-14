package Day06;

import org.testng.annotations.Test;
import  static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidation {
	
	//convert json to jsonschema
	//https://jsonformatter.org/json-to-jsonschema
	@Test
	public  void jsonschemaValidation() {
		
		given()
		
		.when()
		.get("http://localhost:3000/users")
		
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Demo.json"));
		
	}

}
 