package tests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetBookingIds_RestfulBookerUsingBDDStyle {

	@Test
	public void GetBookingIds_VerifyStatusCode() {

		// Given
		Response response = RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
				// When
				.when().get("/booking");
		System.out.println(response.asString());
		System.out.println("test");
		ValidatableResponse valRes = response.then();
		valRes.statusCode(200);
		valRes.statusLine("HTTP/1.1 200 OK");
				// Then
				//.then().statusCode(200).statusLine("HTTP/1.1 200 OK").
				// To verify booking count
				//.body("bookingid", Matchers.hasSize(10))
			// To verify booking id at index 3
				//.body("bookingid[3]", Matchers.equalTo(1))
				//.extract().asString();

	}
}
