package day1;

import java.util.HashMap;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class WeatherAPI {
  @Test(enabled = false,description = "Getting weather information of specific city")
  public void getWeather() {
	  RestAssured.given()  //some precondition like authentication
	  			.when()		//perform some steps
	  				.get("api.openweathermap.org/data/2.5/weather?q=Mumbai&appid=129ee4eca779bee5f07940dc500c5847")
	  			.then()   //some post condition like verification
	  			.log()	//print data in console
	  			.body() 
	  			.statusCode(200);
  }
  
  
  @Test(enabled = false,description = "Getting weather information of specific city")
  public void getWeather2() {
	  Response res=RestAssured.given()  //some precondition like authentication
	  			.when()		//perform some steps
	  			.get("https://api.openweathermap.org/data/2.5/weather?q=Hubli&appid=e77451f5cac44f070e7e68f3a16f80e2");
	  
	  	System.out.println(res.prettyPrint());
	  	System.out.println(res.getTime());
	  	System.out.println(res.getStatusCode());
	  	System.out.println(res.getContentType());
	  	Assert.assertEquals(res.getStatusCode(), 200);
	  			
  }
  
  @Test(enabled = false,description = "Getting weather information of specific city")
  public void getWeather3() {
	  Response res=RestAssured.given()
			  .queryParam("q", "Hubli")
			  .queryParam("appid", "e77451f5cac44f070e7e68f3a16f80e2")//some precondition like authentication
	  			.when()		//perform some steps
	  			.get("https://api.openweathermap.org/data/2.5/weather");
	  
	  	System.out.println(res.prettyPrint());
	  	System.out.println(res.getTime());
	  	System.out.println(res.getStatusCode());
	  	System.out.println(res.getContentType());
	  	Assert.assertEquals(res.getStatusCode(), 200);
	  			
  }
  
  @Test(enabled = true,description = "Getting weather information of specific city")
  public void getWeather4() {
	  Map<String,String> map=new HashMap<String, String>();
	  map.put("q", "Hubli");
	  map.put("appid", "e77451f5cac44f070e7e68f3a16f80e2");
	  Response res=RestAssured.given()   //some precondition like authentication
			  .queryParams(map)
	  			.when()		//perform some steps
	  			.get("https://api.openweathermap.org/data/2.5/weather");
	  
	  	System.out.println(res.prettyPrint());
	  	System.out.println(res.getTime());
	  	System.out.println(res.getStatusCode());
	  	System.out.println(res.getContentType());
	  	Assert.assertEquals(res.getStatusCode(), 200);
	  			
  }
}
