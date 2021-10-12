package day1;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class NegativeContactListTest {
  @Test
  public void recordNotFound() {
 given()
	  .when()
	  		.get("http://3.13.86.142:3000/contacts/5")
	  .then()
	  .log()
	  .body()
	  .statusCode(404);
	 
  }



@Test(enabled = true,description = "adding contact with missing values")
public void addingContactMissingparameter() {
	  JSONObject details=new JSONObject();
	  JSONObject loc=new JSONObject();
	  JSONObject emp=new JSONObject();
	  
	  loc.put("city", "Hubli");
	  loc.put("country", "India");
	  emp.put("jobTitle", "QA");
	  emp.put("company", "LTI");
	  details.put("firstName", "");
	  details.put("lastName", "Morab");
	  details.put("email", "mkarthik2299@gmail.com");
	  details.put("location", loc);
	  details.put("employer", emp);
	  
	  
	String error= given()
	  		.header("Content-Type","application/json")
	  		.body(details.toJSONString())
	  	.when()
	  		.post("http://3.13.86.142:3000/contacts")
	  	.then()
	  		.log()
	  		.body()
	  		.statusCode(400)
	 .extract()
	  .path("err");
	 Assert.assertTrue(error.contains("firstName: First Name is required"));
	
	  		
	 
}



@Test(enabled = true,description = "adding contact with too many characters")
public void addingContactWithMaxLen() {
	  JSONObject details=new JSONObject();
	  JSONObject loc=new JSONObject();
	  JSONObject emp=new JSONObject();
	  
	  loc.put("city", "HubliHubliHubliHubliHubliHubliHubliHubliHubliHubliHubli");
	  loc.put("country", "India");
	  emp.put("jobTitle", "QA");
	  emp.put("company", "LTI");
	  details.put("firstName", "karthik");
	  details.put("lastName", "Morab");
	  details.put("email", "mkarthik2299@gmail.com");
	  details.put("location", loc);
	  details.put("employer", emp);
	  
	  
	String error= given()
	  		.header("Content-Type","application/json")
	  		.body(details.toJSONString())
	  	.when()
	  		.post("http://3.13.86.142:3000/contacts")
	  	.then()
	  		.log()
	  		.body()
	  		.statusCode(400)
	 .extract()
	  .path("err");
	 Assert.assertTrue(error.contains("is longer than the maximum allowed length (30)"));
	
	  		
	 
}


@Test(enabled = true,description = "adding contact with invalid values")
public void addingContactWithInvalidChar() {
	  JSONObject details=new JSONObject();
	  JSONObject loc=new JSONObject();
	  JSONObject emp=new JSONObject();
	  
	  loc.put("city", "Hubli");
	  loc.put("country", "India");
	  emp.put("jobTitle", "QA");
	  emp.put("company", "LTI");
	  details.put("firstName", "1234");
	  details.put("lastName", "5555");
	  details.put("email", "mkarthik2299@gmail.com");
	  details.put("location", loc);
	  details.put("employer", emp);
	  
	  
	String error= given()
	  		.header("Content-Type","application/json")
	  		.body(details.toJSONString())
	  	.when()
	  		.post("http://3.13.86.142:3000/contacts")
	  	.then()
	  		.log()
	  		.body()
	  		.statusCode(400)
	 .extract()
	  .path("err");
	
	//System.out.println(error);
	Assert.assertTrue(error.contains("Validator failed for path"));
	
	  		
	 
}



@Test(enabled = true,description = "adding contact with invalid format")
public void addingContactWithInvalidFormat() {
	  JSONObject details=new JSONObject();
	  JSONObject loc=new JSONObject();
	  JSONObject emp=new JSONObject();
	  
	  loc.put("city", "Hubli");
	  loc.put("country", "India");
	  emp.put("jobTitle", "QA");
	  emp.put("company", "LTI");
	  details.put("firstName", "1234");
	  details.put("lastName", "5555");
	  details.put("email", "mkarthik2299/gmail.com");
	  details.put("location", loc);
	  details.put("employer", emp);
	  
	  
	String error= given()
	  		.header("Content-Type","application/json")
	  		.body(details.toJSONString())
	  	.when()
	  		.post("http://3.13.86.142:3000/contacts")
	  	.then()
	  		.log()
	  		.body()
	  		.statusCode(400)
	 .extract()
	  .path("err");
	
	//System.out.println(error);
	Assert.assertTrue(error.contains("email: Validator failed for path `email`"));
	
	  		
	 
}

}