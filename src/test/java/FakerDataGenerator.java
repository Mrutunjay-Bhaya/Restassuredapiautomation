import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {
@Test
void testGenerateDummyData() {
	
	//for the generate fake data "javafaker" dependency need to add in pom.xml file
	
	Faker fak=new Faker();
	String fname=fak.name().fullName();
	String firstname= fak.name().firstName();
	String lastname= fak.name().lastName();
	String username =fak.name().username();
	String pass=fak.internet().password();
	String phnum= fak.phoneNumber().phoneNumber();
	String email= fak.internet().safeEmailAddress();
	
	System.out.println(fname);
	System.out.println(firstname);
	System.out.println(lastname);
	System.out.println(username);
	System.out.println(pass);
	System.out.println(phnum);
	System.out.println(email);
	
}}
