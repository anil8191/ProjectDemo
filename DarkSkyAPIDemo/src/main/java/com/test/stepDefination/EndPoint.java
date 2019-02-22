/**
 * 
 */
package com.test.stepDefination;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.test.util.CommanUtil;


/**
 * @author anikumar11
 *
 * Jul 31, 2018
 */
public class EndPoint extends CommanUtil{
	
	final public static String POST_REQUEST = "/post";
	final public static String URL = "http://ci.opensearch.dev.api.here.com/";
	final public static String GET_REQUEST = "opensearch/geocode";
	
	final public static String URLs = "https://api.darksky.net/";
	final public static String GET_REQUESTs = "forecast/20f82236564a7fc674a3f2f43f8ab844/37.8267,-122.4233";
	
	
	/*@BeforeSuite		//If we want the report separate class wise then we need to use @BeforeClas annotation method
	public static ExtentReports launch() throws IOException{
		//browser.failcreatefolder(); //Creating folder for fail execution
		
		String destFile=null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH-mm-ss");
		destFile = "Report/";
		String destDir = dateFormat.format(new Date()) + ".html";
		
		report = new ExtentReports(destFile + "\\" +destDir, true);
		
		// Detail of the Report Title, Name and HeadLine
		//logger.addScreencast(destFile + "\\" +destDir); this is for video recording
		report.config().documentTitle("API extent Report");			 //This is Report Title
		report.config().reportName("API report");				//This is Report Name
		report.config().reportHeadline("[ Dark sky API ]");	//This is Report Headline
		
		
		return report;

	}
	
	@AfterMethod
	public void reportclosewindows() throws IOException, InterruptedException{
		report.endTest(logger);
		report.flush();

	}*/
	

}
