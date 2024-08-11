package tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonFromFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader("JSONExample1.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONObject employeeList = (JSONObject) obj;
            System.out.println(employeeList);
            
            String firstName = (String) employeeList.get("firstName");    
	      
	        
	        JSONArray array = (JSONArray)employeeList.get("phoneNumbers");
	        JSONObject phoneNumber = (JSONObject)array.get(0);
	        System.out.println(phoneNumber.get("type"));
	        System.out.println(phoneNumber.get("number"));
            //Iterate over employee array
           // employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
	/*
	 * private static void parseEmployeeObject(JSONObject employee) { //Get employee
	 * object within list JSONObject employeeObject = (JSONObject)
	 * employee.get("employee");
	 * 
	 * //Get employee first name String firstName = (String)
	 * employeeObject.get("firstName"); System.out.println(firstName);
	 * 
	 * //Get employee last name String lastName = (String)
	 * employeeObject.get("lastName"); System.out.println(lastName);
	 * 
	 * //Get employee website name String website = (String)
	 * employeeObject.get("age"); System.out.println(website); }
	 */
}
