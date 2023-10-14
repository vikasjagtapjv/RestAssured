package Day05;
import  static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsingXML_response {
	
	//Parsing =Extracting the data whatever data we want from response 
	//we can extract it and we can compare with expected values that is called parsing.
//	@Test
	public void testXML_Response() {
		/*given()
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		
		.then()
		.statusCode(200)
		.header("Content-Type", "application/xml; charset=utf-8")
		.body("TravelerinformationResponse.page",equalTo("1"))
		.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"))
		;
		*/
		
		//Approach 02 to capture the variables
		//we follow mostly this approach
		Response res=given()
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"),"application/xml; charset=utf-8");
        String pageNO=res.xmlPath().get("TravelerinformationResponse.page").toString();
        Assert.assertEquals(pageNO, "1");
		/*
		 * And for JSONParsing
		 * String pageNo=res.jsonPath().get("page").toString();
		 * Assert.assertEquals(pageNO,"1");
		 */
        
        //for Name
      String Name= res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
        Assert.assertEquals(Name, "Developer");
        /*
         * String=Name=res.jsonPath().get("name").toString();
         * Assert.assertEquals(Name,"Developer");
         */
       
		
	}
	 @Test
     public void testXml_response_Body()
     {
		 Response res1= given()
				 
				 .when()
				 .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		 XmlPath xmlObj= new XmlPath(res1.asString());
		 List<String> Travellers=xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation");
		 Assert.assertEquals(Travellers.size(),10);
		 
		 //Verify traveller name present in response
		 
		 boolean status=false;
		 List <String> TravellersName=xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
     	
		 for( String tName:TravellersName)
		 {
			 System.out.println(tName);
			 if(tName.equals("Developer"))
			 {
				 status=true;
				 break;
				 
			 }
		 }
		 Assert.assertEquals(status, true); 
     }

}
