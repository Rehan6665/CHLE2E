package chl;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.RestAssured;

public class ApiDemo {
	

	
	@Test
	public void demo() {
		
		Response res = RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(res.asString());
		System.out.println(res.getStatusCode());
		
	}

}
