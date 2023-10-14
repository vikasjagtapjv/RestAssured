package Day06;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Day01.Create_POJO;

public class Serilalization_De_Serialization {
	/*
	 * pojo--Serialization-->jsonObject-->De_Serialization --->pojo
	 */
	
	
	//converting poio to json
	//@Test
	public void convertpojo2Json() throws JsonProcessingException 
	{
		
		//creating java object using pojo class
		Studentpojo data=new Studentpojo();//pojo
			data.setName("scott");
			data.setLocation("France");
			data.setPhone("123456");
			
			String coursesarr []= {"c","python"};
			//data.Courses(coursesarr)
			data.setCourses(coursesarr);
			
			//converting java object to json object(serialization)
			ObjectMapper objectMapper=new ObjectMapper();
			String jsonData=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
			System.out.println(jsonData);
			
			
	}
	
	//deSerialization
	@Test
	public void convertjson2poja() throws JsonMappingException, JsonProcessingException
	
	{
		String jsonData="{\r\n"
				+ "  \"name\" : \"scott\",\r\n"
				+ "  \"location\" : \"France\",\r\n"
				+ "  \"phone\" : \"123456\",\r\n"
				+ "  \"courses\" : [ \"c\", \"python\" ]\r\n"
				+ "}";
		//converting json data into java object
		ObjectMapper objectMap=new ObjectMapper();
		Studentpojo stu=objectMap.readValue(jsonData,Studentpojo.class);
		System.out.println("name:"+stu.getName());
		System.out.println("location:"+stu.getLocation());
		System.out.println("phone:"+stu.getPhone());
		System.out.println("courses 1:"+stu.getCourses()[0]);
		System.out.println("courses 2:"+stu.getCourses()[1]);
	}

}
