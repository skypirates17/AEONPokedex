package com.aeon.pokedex.utilities;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public final class JSONReadFromFile {

	public static JSONArray getArrayObject(String filePath) {
		JSONParser parser = new JSONParser();
		InputStream fileIs = JSONReadFromFile.class.getResourceAsStream(filePath);
		
		Object obj = null;
		try {
			obj = parser.parse(new BufferedReader(new InputStreamReader(fileIs, "utf-8")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (JSONArray) obj;
	}
}

/**
 * Resources from src/main/resources will be put onto the root of the classpath,
 * so you'll need to get the resource as: 
 * new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/config.txt"))); 
 * You can verify by looking at the JAR/WAR file produced by maven as you'll find
 * config.txt in the root of your archive.
 */
