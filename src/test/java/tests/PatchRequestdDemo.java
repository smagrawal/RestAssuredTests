package tests;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PatchRequestdDemo {


	@Test
	public void PatchRequest() {
		String json = "{\r\n"
				+ "    \"firstname\": \"testing\",\r\n"
				+ "    \"lastname\": \"patch request\" \r\n"
				+ "}";
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://restful-booker.herokuapp.com/booking/4956");
		request.contentType(ContentType.JSON);
		request.cookie("token","0143792e60beec5");
		request.body(json);

		Response response = request.patch();

		// Printing Response as string
		System.out.println(response.asString());
		// Get Validatable response to perform validation
		ValidatableResponse validatableResponse = response.then();

		// Validate status code as 200
		validatableResponse.statusCode(200);

		// Validate value of firstName is updated
		validatableResponse.body("firstname", Matchers.equalTo("testing"));

		// Validate value of lastName is updated
		validatableResponse.body("lastname", Matchers.equalTo("patch request"));
	}
}
