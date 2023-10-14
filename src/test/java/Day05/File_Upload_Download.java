package Day05;
import  static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;


public class File_Upload_Download {
	
	//@Test
	public void singleFileUpload()
	{
		File myFile =new File("C:\\Users\\Vikas\\Documents\\restAssured.txt"); 
		given()
		.multiPart("file",myFile)
		.contentType("multipart/form-data")
		
		
		.when()
		.post(" http://localhost:3000/store")
		
		
		.then()
		.statusCode(201)
		.body("fileName", equalTo("restAssured.txt"))
		.log().all();
		
	}

	@Test
	public void multifilesUpload()
	{
		File myFile=new File("C:\\Users\\Vikas\\Documents\\restAssured.txt");
		File myFile01=new File("C:\\Users\\Vikas\\Documents\\api.txt");
		
		given()
		.multiPart("file01",myFile)
		.multiPart("filep2",myFile01)
		.contentType("multipart/form-data")
		
		.when()
		.post("http://localhost:3000/store")
		
		.then()
		.statusCode(201)
		.body("[0].fileName",equalTo("restAssured.txt"))
		.body("[1].fileName",equalTo("api.txt"))
		.log().all();
	}

}
