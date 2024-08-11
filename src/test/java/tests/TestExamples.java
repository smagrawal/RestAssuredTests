package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class TestExamples {

	@Test
	public void Test1() {
		Response res = get("https://reqres.in/api/users?page=2");
		
		System.out.println(res.getStatusCode());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());
		System.out.println(res.getStatusLine());
		System.out.println(res.getHeader("content-type"));
		System.out.println(res.getTime());
	}
	
	@Test
	public void Test2() {

		baseURI = "https://reqres.in/api";
		given().
		get("/users?page=2").
		then().statusCode(200).
		body("data[1].first_name",equalTo("Lindsay"), "data.id", hasItems(7, 8, 9, 10, 11, 12));
		

	}

	@Test
	@Ignore
   public void Test3() {
		
		baseURI = "https://reqres.in/api";
	   Map<String, Object> map = new HashMap<String, Object>();
	   map.put("name", "Sumit");
	   map.put("job", "sofware tester");
	   System.out.println(map);
	   JSONObject request = new JSONObject(map);
	   given().
	   headers("content-type", "application/json").
	   contentType(ContentType.JSON).accept(ContentType.JSON).
	   body(request.toJSONString()).
	   when().
	   post("/api/users").
	   then().
	   statusCode(201);

	   
   }
}
