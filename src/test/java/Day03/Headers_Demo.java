package Day03;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import  static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Headers_Demo {
	@Test(priority=1)
	public void testHeaders()
	{
		given()
				.when()
				.get("https://www.google.com/")
				
				.then()
				.header("Content-Type", "text/html; charset=ISO-8859-1")
				.and()
				
				.header("Cache-Control", "private, max-age=0");
		
	}
	@Test(priority=2)
	public void capture_multiple_header_Values()
	{
		Response res =given()
				.when()
				.get("https://www.google.com/");
		
		String Header_Value=res.getHeader("Content-Type");
		System.out.println("Single Hesder value is :"+Header_Value);
		
		//capture Multiple header value
		
		  Headers Header_Values=res.getHeaders();
		  for (Header hd:Header_Values)
		  {
			   System.out.println(hd.getName()+""+hd.getValue());
		  }
		
				
	}

}
