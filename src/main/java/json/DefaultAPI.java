package json;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

/**
 * Following is the format of sample Json file used in this example,<br>
 * the actual .json file can be found on: ./resources folder.<br>
 * <pre>
 * {
 * 	"id":123,
 * 	"name":"Pankaj Kumar",
 * 	"permanent":true,
 * 	"address":{
 * 			"street":"El Camino Real",
 * 			"city":"San Jose",
 * 			"zipcode":95014
 * 		},
 * 	"phoneNumbers":[9988664422, 1234567890],
 * 	"role":"Developer"
 * 	}
 * </pre>
 * 
 * Speaking in general, Json content can be retireved by this flow:<br>
 * <b>FileInputStream -> Jsonreader -> Json Object </b><br>
 * <br>
 * 
 * 
 * 
 * 
 * 3 Types records exist on <b>JSON, Json Array, InnerObject and Object</b> <br>
 * Ref: http://www.journaldev.com/2315/java-json-example<br>
 * @author andykwok
 *
 */
public class DefaultAPI {
	
	public static final String JSON_FILE = "./resources/example.json";
	
	
	public static void main(String[] args) throws IOException {
		
		InputStream fis = new FileInputStream(JSON_FILE);
		
		JsonReader jsonReader = Json.createReader(fis);
		JsonObject jsonObject = jsonReader.readObject();
		
		jsonReader.close();
		fis.close();
		
		
		/*
		 * 1. As ID is floating on the top lv of the JSON content,
		 * hence can be retrieve straight by following call with appropriate method name (type).
		 */
		System.out.println(jsonObject.getInt("id"));
		
		/* 2. In this situation phoneNumbers is a decimal array,
		 * as type is non known in jvm perspective. It need JsonAarrray to 
		 * first carry the whole thing, then split it JsonValue and finally .toString( ) 
		 * to access it.
		 */
		JsonArray jsonArray = jsonObject.getJsonArray("phoneNumbers");
		
		for(JsonValue value : jsonArray){
			System.out.println( Long.parseLong(value.toString()) );
		}
		
		
		
		/*
		 * 3. Inner object
		 *  - which is a Json wrapped inside a Json field. 
		 */
		JsonObject innerJsonObject = jsonObject.getJsonObject("address");
		System.out.println(innerJsonObject.getString("city"));
	}

}
