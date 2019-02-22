/**
 * 
 */
package com.test.util;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

/**
 * @author anikumar11
 *
 */
public class CommanUtil {
	
	public static Response RESPONSE;
	public static JSONObject JSON_OBJECT;

	public HashMap<String, String> hmap = new HashMap<String, String>();

	public HashMap<String, String> addQueryParam(String key, String value) {

		hmap.put(key, value);
		return hmap;

	}

	//http://ci.opensearch.dev.api.here.com/opensearch/geocode?q=frankfurt&at=50.11511%2C%208.6853&maxresults=20&language=en_us
	
	public void addQueryParamDemo() {

		//hmap.put(key, value);
		String url = "http://ci.opensearch.dev.api.here.com/opensearch/geocode?q=frankfurt&at=50.11511%2C%208.6853&maxresults=20&language=en_us";
		char[] ch = url.toCharArray();
		
		if(url.contains("?")) {
			System.out.println("this is query param...");
			
			for(char output : ch) {
				System.out.println("hello : "+output);
			}
			
		}
		
		
		//return hmap;

	}

}
