package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User userpayload;
	@BeforeClass
 public void setupData() {
		faker=new Faker();
		userpayload=new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setPassword(faker.internet().password());
		userpayload.setPassword(faker.phoneNumber().cellPhone());
		
	}
	
	@Test(priority=1)
	public void testPostUser() throws InterruptedException {
		Response response =UserEndPoints.creatUser(userpayload);
	
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
	
	Thread.sleep(3000);
	}
	@Test(priority=2)
	public void testGestUserByName() {
		Response response=UserEndPoints.readUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void testUpdateUserByName() {
		//update data using payload
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setEmail(faker.internet().emailAddress());
		Response response=UserEndPoints.updateUser(this.userpayload.getUsername(), userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=4)
	public void testDeleteUserByName() {
		Response response=UserEndPoints.deleteUser(this.userpayload.getUsername());
		response.then().statusCode(200);
	}
}
