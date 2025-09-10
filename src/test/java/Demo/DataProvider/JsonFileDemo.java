package Demo.DataProvider;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

public class JsonFileDemo {
	
	@DataProvider(name="json_parsing")
	public String[] jsonReader() throws IOException, ParseException {
		//parsing the file
		JSONParser jsonParser = new JSONParser();
		FileReader fileReader = new FileReader("/framework/testdata/logintest.json");
		Object obj = jsonParser.parse(fileReader);
		JSONObject jsonObj = (JSONObject) obj;
		JSONArray array = (JSONArray) jsonObj.get("userlogins");
		
		return null; 
	}

}
