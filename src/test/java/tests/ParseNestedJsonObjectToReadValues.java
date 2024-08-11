package tests;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParseNestedJsonObjectToReadValues {
	@Test
	public void parseJsonObjectToReadValues() throws JsonMappingException, JsonProcessingException {
		String jsonObject = "{\r\n"
				+ "  \"firstName\": \"Amod\",\r\n"
				+ "  \"lastName\": \"Mahajan\",\r\n"
				+ "  \"married\": false,\r\n"
				+ "  \"salary\": 2000.54,\r\n"
				+ "  \"addressPin\": 45324,\r\n"
				+ "  \"skill\" :{\r\n"
				+ "    \"Java\" :\"Intermediate\",\r\n"
				+ "    \"Selenium\" :\"Intermediate\",\r\n"
				+ "    \"Javascript\" :\"Beginner\"\r\n"
				+ "  }\r\n"
				+ "}";
		// Creating an instance of ObjectMapper class
		ObjectMapper objectMapper = new ObjectMapper();
		// Get tree representation of json
		JsonNode jsonTree = objectMapper.readTree(jsonObject);

		// Using chaining of get() methods
		String javaLevel = jsonTree.get("skill").get("Java").asText();
		System.out.println(javaLevel);
		
		// Using chaining of get() methods
		int address = jsonTree.get("addressPin").asInt();
		System.out.println(address);

		// Using chaining of path() methods
		String javaLevel2 = jsonTree.path("skill").path("Selenium").asText();
		System.out.println(javaLevel2);

		// Using pattern expression with at()
		String javaLevel3 = jsonTree.at("/skill/Javascript").asText();
		System.out.println(javaLevel3);

	}
}
