package Day07;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Faker_DataGenerator {
	@Test
	public void createDummyData()
	{
		Faker faker=new Faker();
		String fullname=faker.name().fullName();
		String FirstName=faker.name().firstName();
		String LastName=faker.name().lastName();
		String userName=faker.name().username(); 
		String password=faker.internet().password();
		String phone=faker.phoneNumber().cellPhone();
		String email=faker.internet().emailAddress();
		
		System.out.println("FullName "+fullname);
		System.out.println("FirstName "+FirstName);
		System.out.println("LastName "+LastName);
		System.out.println("userName "+userName);
		System.out.println("password "+password);
		System.out.println("phone "+phone);
		System.out.println("email "+email);
	}

}
