package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializationUsingJacksonDemo {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
		String jsonString = "{\r\n"
				+ "  \"firstName\" : \"Ross\",\r\n"
				+ "  \"lastName\" : \"Krupnic\",\r\n"
				+ "  \"gender\" : \"F\",\r\n"
				+ "  \"age\" : 29,\r\n"
				+ "  \"salary\" : 1055987.77,\r\n"
				+ "  \"married\" : true\r\n"
				+ "}";
		
		ObjectMapper objectMapper = new ObjectMapper();
			Employee employee =	objectMapper.readValue(jsonString, Employee.class);
			System.out.println("Get First name: " + employee.getFirstName() );
			System.out.println("Get last name: " + employee.getLastName() );
			System.out.println("Get gender: " + employee.getGender() );
			System.out.println("Get Age: " + employee.getAge() );
			System.out.println("Get Salary: " + employee.getSalary() );
			System.out.println("Is person married: " + employee.isMarried() );
	}

}
