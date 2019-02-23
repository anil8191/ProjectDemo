package com.test.assured.framework;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import static io.restassured.RestAssured.given;




public class RestAssuredConfiguration {


    @BeforeSuite(alwaysRun = true)
    public void configure(){
       RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
        //RestAssured.port = 8080;
        //RestAssured.basePath = "http://jsonplaceholder.typicode.com";*/

        RestAssured.baseURI = "https://www.googleapis.com";

        RestAssured.basePath = "/books";
    }

    public  static RequestSpecification getRequestSpecification(){
        return given().contentType(ContentType.JSON);

    }

    public Response getResponse(RequestSpecification requestSpecification, String endPoint) {

        Response response = requestSpecification.get(endPoint);
        Assert.assertEquals(response.getStatusCode(), 200);
        response.then().log().all();
        return response;
    }

}
