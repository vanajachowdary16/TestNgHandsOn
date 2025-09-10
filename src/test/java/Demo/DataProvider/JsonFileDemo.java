package Demo.DataProvider;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JsonFileDemo {
	
	@DataProvider(name="json_parsing")
	public String[] jsonReader() throws IOException, ParseException {
		//parsing the file
		JSONParser jsonParser = new JSONParser();
		FileReader fileReader = new FileReader("/framework/testdata/logintest.json");
		Object obj = jsonParser.parse(fileReader);
		JSONObject jsonObj = (JSONObject) obj;
		JSONArray array = (JSONArray) jsonObj.get("userlogins");
		
		String arr[] = new String[array.size()];
		for(int i=0; i< array.size(); i++) {
			JSONObject users = (JSONObject) array.get(i);
			String username= (String) users.get("username");
			String password= (String) users.get("password");
			
			arr[i] = username + "," + password;
		}
		return arr; 
	}
	
	@Test(dataProvider ="json_parsing")
	public void reader(String data) {
		String user[] = data.split(",");
		System.out.println("user name from json file is: " +user[0]);
		System.out.println("user password from json file is: " +user[1]);
		
	}

}
