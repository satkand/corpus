package pages.marketplace.common;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class MyJSONParser {

	//temporary location
	private static final String filePath = "/Users/u204485/Documents/Automation/productCatalogue.json";

	
	public JSONArray parseJson() {
		JSONArray brandList = null;
		try {			
			
			// read the json file
			FileReader reader = new FileReader(filePath);	    
		    
			JSONObject rootJSON = (JSONObject) new JSONParser().parse(reader);
			JSONObject dataJSON = (JSONObject) rootJSON.get("data");
			JSONObject attributeJSON = (JSONObject) dataJSON.get("attributes");
			brandList = (JSONArray) attributeJSON.get("brands");
			
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		return brandList;
	}

}
