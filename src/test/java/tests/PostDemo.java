package tests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PostDemo {
	@Test
	public void test() {
		String jsonString = "{\r\n"
				+ "    \"firstname\" : \"test\",\r\n"
				+ "    \"lastname\" : \"user\",\r\n"
				+ "    \"totalprice\" : 1000,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";

		// Create a request specification
		RequestSpecification request = RestAssured.given();
		request.contentType(ContentType.JSON);
		request.baseUri("https://restful-booker.herokuapp.com");
		request.basePath("/booking");
		request.body(jsonString);

		// Calling POST method on URI. After hitting we get Response
		Response response = request.post();

		// Printing Response as string
		System.out.println(response.asString());

		// Get Validatable response to perform validation
		ValidatableResponse validatableResponse = response.then();

		// Validate status code as 200
		validatableResponse.statusCode(200);

		// Validate token field is null
		// SInce response is one to one mapping so passing key name will give you value.
		// Below method validates that value of token is not null.
		//validatableResponse.body("token", Matchers.notNullValue());

		// Validate token length is 15
		//validatableResponse.body("token.length()", Matchers.is(15));

		// Validate token is an alphanumeric value
		//validatableResponse.body("token", Matchers.matchesRegex("^[a-z0-9]+$"));
	}


}
