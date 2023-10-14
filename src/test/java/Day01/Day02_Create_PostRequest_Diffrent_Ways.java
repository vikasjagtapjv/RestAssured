package Day01;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import  static io.restassured.RestAssured.*;
 import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day02_Create_PostRequest_Diffrent_Ways {
	/*
	 * Many ways we create the request Body
using Hash Map
using org.json
using POJO(plain old java object)
using external json file
	 */
	//@Test(priority=1)
	public void testPostUsingHashMap()
	{
		HashMap data=new HashMap();
		data.put("Name", "scott");
		data.put("Location", "France");
		data.put("Phone","123456");
		 
		String CourseArr[]= {"c","python"};
		data.put("Courses", CourseArr);
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/users")
		
		
		
		.then()
		.statusCode(201)
		.body("Name",equalTo( "scott"))
		.body("Location",equalTo("France"))
		.body("Phone",equalTo("123456"))
		.body("Courses[0]",equalTo("c"))
		.body("Courses[1]",equalTo("python"))
		.header("Content-Type","application/json; charset=utf-8")
		.log()
		.all();
	}
	
	//@Test(priority=1)
	public void create_post_orgjson_Library()
	{
		JSONObject data=new JSONObject();
		data.put("Name", "scott");
		data.put("Location", "France");
		data.put("Phone","123456");
		 
		String coursesar[]= {"c","python"};
		data.put("Courses",coursesar );
		
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/users")
		
		.then()
		.statusCode(201)
		.body("Name",equalTo("scott"))
		.body("Location",equalTo("France"))
		.body("Phone",equalTo("123456"))
		.body("Courses[0]",equalTo("c"))
		.body("Courses[1]",equalTo("python"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();
		
	}
	//@Test(priority=1)
	public void createPost_POJO()
	{
		Create_POJO data=new Create_POJO();
		data.setName("scott");
		data.setLocation("France");
		data.setPhone("123456");
		
		String coursesarr []= {"c","python"};
		//data.Courses(coursesarr)
		data.setCourses(coursesarr);
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/users")
		
		.then()
		.statusCode(201)
		.body("Name",equalTo("scott"))
		.body("Location",equalTo("France"))
		.body("Phone",equalTo("123456"))
		.body("Courses[0]",equalTo("c"))
		.body("Courses[1]",equalTo("python"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();
		
	}
	@Test(priority=1)
	public void create_Post_External_File() throws IOException {
		File fe=new File("E:\\MyProject00\\body.json");
		FileReader fr=new FileReader(fe);
		JSONTokener jt=new JSONTokener(fr);
		JSONObject data=new JSONObject(jt);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/users")
		
		.then()
		.statusCode(201)
		.body("Name",equalTo("Scott"))
		.body("Location",equalTo("France"))
		.body("Phone",equalTo("123456"))
		.body("Courses[0]",equalTo("c"))
		.body("Courses[1]",equalTo("python"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();
		
	}
	
	@Test(priority=02)
	public void delete()
	{
		given()
		
		.when()
		.delete("http://localhost:3000/users/26")
		
		.then()
		.statusCode(200);
		
		
	}
	

}
