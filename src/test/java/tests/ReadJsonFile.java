package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJsonFile {

	@Test(dataProvider = "getData")
	public void testMethod(Book data) {
		System.out.println(data);
	}

	@DataProvider
	public Object[][] getData() throws JsonParseException, JsonMappingException, IOException {
//	        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/45146523.json"));
//	        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
//	        List<TestData> testData = new Gson().fromJson(dataSet, new TypeToken<List<TestData>>() {
//	        }.getType());
		ObjectMapper mapper = new ObjectMapper();

		// convert JSON array to list of books
		List<Book> books = Arrays.asList(mapper.readValue(Paths.get("books.json").toFile(), Book[].class));
		Object[][] returnValue = new Object[books.size()][1];
		int index = 0;
		for (Object[] each : returnValue) {
			each[0] = books.get(index++);
		}
		return returnValue;
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		try {
//		    // create object mapper instance
//		    ObjectMapper mapper = new ObjectMapper();
//
//		    // convert JSON array to list of books
//		    List<Book> books = Arrays.asList(mapper.readValue(Paths.get("books.json").toFile(), Book[].class));
//
//		    // print books
//		    books.forEach(System.out::println);
//
//		} catch (Exception ex) {
//		    ex.printStackTrace();
//		}
//	}

}
