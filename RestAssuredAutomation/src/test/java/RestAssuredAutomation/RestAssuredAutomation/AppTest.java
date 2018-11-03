package RestAssuredAutomation.RestAssuredAutomation;

import org.testng.annotations.Test;

import Configuration.Functions;
import Configuration.ExtentReports.ExtentReportsClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private String POST = "POST";
	private String GET = "GET";
	private ExtentReportsClass report = new ExtentReportsClass();
	private Functions stept;
	@Test
	public void firstTest() {
		report.startReport();
		Response response = RestAssured.given().header("Content-Type", "application/json").when().body("{	\"body\":\"as\"}")
		.post("https://postman-echo.com/post");
		
		
		System.out.println("Status Code:"+response.getStatusCode());
		response.prettyPrint();
		int statusGet = response.getStatusCode();
		if ( statusGet ==200 ) {
			report.passTest();
			
		}else{
			report.failTest();	
		}; 
		
		report.endTestNew(response.getBody().asString(), response.getStatusCode());
		report.endReport();
	}
	
	
	
	
	
}
