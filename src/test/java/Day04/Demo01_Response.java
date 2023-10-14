package Day04;
import  static io.restassured.RestAssured.*;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class Demo01_Response {
	//@Test
	public void response() 
	{
		Response Res=  
				given()
				.contentType(ContentType.JSON)
				.when()
				.get("https://reqres.in/api/users");
		
		JSONObject jo=new JSONObject(Res.asString());
		
		for(int i=0;i<jo.getJSONArray("data").length();i++)
		      { 
			
			 String email=jo.getJSONArray("data").getJSONObject(i).get("email").toString();
			 System.out.println(email);
		       }
		
		
		
		
	
	}
	@Test
	public void response01()
	{
	Response res=	given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("http://localhost:3000/store");
		JSONObject jo=new JSONObject(res.asString());
		/*for(int i=0;i<jo.getJSONArray("book").length();i++)
		{
			 String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			 System.out.println(bookTitle);
		}*/
		
		//Search for title of book
		boolean status=false;
		for(int i=0;i<jo.getJSONArray("book").length();i++) {
		
		String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
		if(bookTitle.equals("Sayings of the Century"))
		{
			status=true;
		break;
		}
		
		}
		Assert.assertEquals(status,true);
		
		//Validate total price of book
		
		double totalprice=0;
		for (int i=0;i<jo.getJSONArray("book").length();i++)
		{
			String price=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
			totalprice=totalprice+Double.parseDouble(price);
			
		}
		System.out.println("Total price of book is :"+totalprice);
	}
				
	}


