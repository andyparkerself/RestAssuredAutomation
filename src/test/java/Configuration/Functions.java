package Configuration;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Functions {
	private Response response ; 
	public void sendRequest(String method, String url, String body) {
		
		if (method =="POST") {
			response=	RestAssured.given().header("Content-Type", "application/json").when().body(body)
			.post(url);
		}else {
			response=	RestAssured.given().header("Content-Type", "application/json").when()
			.get(url);	
		}
		
	}

	public void checkStatus(int status) {
		// TODO Auto-generated method stub
		Assert.assertEquals(response.getStatusCode(), status); 
	}
	
}
