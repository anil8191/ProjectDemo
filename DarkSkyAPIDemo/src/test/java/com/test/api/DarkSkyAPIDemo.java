/**
 * 
 */
package com.test.api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.stepDefination.EndPoint;

import bsh.util.Util;
import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.get;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.HashMap;

/**
 * @author anikumar11
 *
 */
public class DarkSkyAPIDemo {
	
	public static Response RESPONSE;
	public static JSONObject JSON_OBJECT;
	
	public static Logger log = Logger.getLogger(DarkSkyAPIDemo.class.getName());
	 
	 // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
	
	@SuppressWarnings("deprecation")
	@Test
	public void validateJson() throws JSONException {
		//configure log4j properties file
		PropertyConfigurator.configure("Properties/Log4j.properties");
		log.info("------------- Execution started --------------- ");
		HashMap<String, String> hmap = new HashMap<String, String>();
		/*hmap.put("q", "frankfurt");
		hmap.put("at", "50.11511, 8.6853");
		hmap.put("maxresults", "20");
		hmap.put("language", "en_us");*/

		RestAssured.baseURI = EndPoint.URLs;
		RESPONSE = RestAssured.given().log().all()
				   //.queryParams(hmap).log().all()
				   .get(EndPoint.GET_REQUESTs);
				 
		RESPONSE.then().log().all();
		
		int statusCode = RESPONSE.getStatusCode();
		System.out.println("Status code : " +statusCode);
		log.info("Status code : " +statusCode);
		Assert.assertEquals(statusCode, 200);
		
		JSONObject JSON_Object = new JSONObject(RESPONSE.asString());
		String latitude = JSON_Object.getString("latitude");
		System.out.println("Latitude : "+latitude);
		log.info("Latitude : "+latitude);
		
		String longitude = JSON_Object.getString("longitude");
		System.out.println("Longitude : "+longitude);
		log.info("Longitude : "+longitude);
		
		String timezone = JSON_Object.getString("timezone");
		System.out.println("Timezone : "+timezone);
		log.info("Timezone : "+timezone);
		
		String offset = JSON_Object.getString("offset");
		System.out.println("Offset : "+offset);
		log.info("Offset : "+offset);
		
		Assert.assertEquals(latitude, "37.8267");
		Assert.assertEquals(longitude, "-122.4233");
		Assert.assertEquals(timezone, "America/Los_Angeles");
		Assert.assertEquals(offset, "-8");
		
		JSONObject currently_Object = JSON_Object.getJSONObject("currently");
		String summary = currently_Object.getString("summary");
		System.out.println("Currently Summary : " +summary);
		log.info("Currently Summary : " +summary);
		Assert.assertEquals(summary, "Clear");
		
		JSONObject minutely_Object = JSON_Object.getJSONObject("minutely");
		String minutelySummary = minutely_Object.getString("summary");
		System.out.println("Minutely Summary : " +minutelySummary);
		log.info("Minutely Summary : " +minutelySummary);
		Assert.assertEquals(minutelySummary, "Clear for the hour.");
		
		JSONArray minutely_data_Object = minutely_Object.getJSONArray("data");
		int minutelyDataSize = minutely_data_Object.length();
		System.out.println("Size of the Minutely data arrays : " +minutelyDataSize);
		log.info("Size of the Minutely data arrays : " +minutelyDataSize);
		
		JSONObject hourly_Object = JSON_Object.getJSONObject("hourly");
		String hourlySummary = hourly_Object.getString("summary");
		System.out.println("Hourly Summary : " +hourlySummary);
		log.info("Hourly Summary : " +hourlySummary);
		//Assert.assertEquals(hourlySummary, "Partly cloudy starting tomorrow morning, continuing until tomorrow afternoon.");
		
		JSONArray hourly_data_Object = hourly_Object.getJSONArray("data");
		int hourlySize = hourly_data_Object.length();
		System.out.println("Size of the hourly data arrays : " +hourlySize);
		log.info("Size of the hourly data arrays : " +hourlySize);
		
		JSONObject daily_Object = JSON_Object.getJSONObject("daily");
		String dailySummary = daily_Object.getString("summary");
		System.out.println("Daily Summary : " +dailySummary);
		log.info("Daily Summary : " +dailySummary);
		//Assert.assertEquals(dailySummary, "No precipitation throughout the week, with high temperatures falling to 58°F on Monday.");
		
		JSONArray daily_data_Object = daily_Object.getJSONArray("data");
		int dailySize = daily_data_Object.length();
		System.out.println("Size of the hourly data arrays : " +dailySize);
		log.info("Size of the hourly data arrays : " +dailySize);
		
		JSONArray alert_Object = JSON_Object.getJSONArray("alerts");
		JSONObject zero_Object = alert_Object.getJSONObject(0);
		String title = zero_Object.getString("title");
		System.out.println("Title : " +title);
		log.info("Title : " +title);
		Assert.assertEquals(title, "Beach Hazards Statement");
				
		JSONObject flags_Object = JSON_Object.getJSONObject("flags");
		//JSONObject sources_Object = flags_Object.getJSONObject("sources");
		String nearestStation = flags_Object.getString("nearest-station");
		System.out.println("Nearest-Station : " +nearestStation);
		log.info("Nearest-Station : " +nearestStation);
		Assert.assertEquals(nearestStation, "1.839");
		
		String units = flags_Object.getString("units");
		System.out.println("Units : " +units);
		log.info("Units : " +units);
		Assert.assertEquals(units, "us");
		

		/*JSONObject flags_data_Object = flags_Object.getJSONObject("flags");
		int flagsSize = flags_data_Object.length();
		System.out.println("Size of the flags data arrays : " +flagsSize);*/
		
		
		System.out.println("---- Successfully completed validation -----");
		log.info("-------------- Execution finished ---------------------");
	}

}