package Day06;
import  static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
public class XMLSchemaValidation {
	//convert xml-->xsd
	//https://www.convertsimple.com/convert-xml-to-xsd-xml-schema/
	@Test
	public void xmlSchemaValidation()
	{
		given()
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler")
		
		.then()
		.statusCode(200)
		.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("Traveller.xsd"));
	}
	

}
