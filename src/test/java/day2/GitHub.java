package day2;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GitHub {
	@BeforeTest
	public void beforeTest() {
		baseURI="https://api.github.com/user/repos";
		authentication=oauth2("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");
	}
  @Test(enabled = true)
  public void gettingAllRepositories() {
	
	 ExtractableResponse<Response>res= when()
	  		.get()
	  .then()
	  		.log()
	  		.body()
	  		.statusCode(200)
	  		.extract();
	 
	 System.out.println(res.path("name"));
	 System.out.println(res.path("visibility"));
	  	
  }
  
  @Test(enabled = true)
  public void createRepositories() {
	  JSONObject data=new JSONObject();
	  data.put("name","RestAssuredCreationNew1");
	  data.put("description", "New Repository");
	  data.put("homepage", "https://github.com/Karthik2299");
	  given()
	  		.header("Content-Type","application/json")
	  		.body(data.toJSONString())
	  .when()
	  			.post()
	  .then()
	  		.log()
	  		.body()
	  		.statusCode(201);
	  		//.time(Matchers.lessThan(2000L),TimeUnit.SECONDS);
	  	
  }
}
