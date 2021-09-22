package com.crm.autodesk.GenericLibrary;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

/**
 * This class contains methods to read data from JSON file
 * @author SHRUTHI
 *
 */
public class JSONFileUtilities
{
	/**
	 * This method reads data from JSON file
	 * @throws Throwable
	 */
	public String readDataFromJSON(String key) throws Throwable
	{
		//read the data from JASON file
		FileReader file=new FileReader("./commonData.json");
		
		//convert the JSON file into JAVA object
		JSONParser jsonobj = new JSONParser();
		Object javaobj = jsonobj.parse(file);
		
		//type cast JAVA object to hashmap
		HashMap map = (HashMap)javaobj;
		String value =map.get(key).toString();
		
		// return the value
		return value;	
	}
}
