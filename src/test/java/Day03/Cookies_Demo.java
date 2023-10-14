package Day03;
import  static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Cookies_Demo {
	//@Test(priority=1)
	public void testCookies()
	{
		given()
		
		.when()
		.get("https://www.google.com/")
		
		.then()
		.cookie("AEC","Ad49MVE4Ob09DjPgneSP5jzdxhQj4AA2HxNt42i6BujFmLRuqrMjLZZJsJs")
		.log().all();
	}
	@Test(priority=2)
	public void getCookiesInfo()
	
	{
		Response res=given()
		.when()
		.get("https://www.google.com/");
		
		//get single cookie information
		// String Cookie_Value=res.getCookie("AEC");
		//System.out.println("The value of single cookie is:"+Cookie_Value);
		
		//Capture of all the cookies generated
		Map<String,String> CookiesValue=res.getCookies();
		System.out.println("Values of cookies are:"+CookiesValue);

		//Print only keys
		//System.out.println(CookiesValue.keySet());
		for(String k:CookiesValue.keySet())
		{
			 String Cookie_Value=res.getCookie(k);
			 System.out.println(k+"    "+Cookie_Value);
			
		}
		
		
	}

}
