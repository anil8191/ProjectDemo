package com.test.pom.page;

import com.test.assured.framework.RestAssuredConfiguration;
import com.test.comman.EndPoint;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import org.json.JSONArray;
import org.json.JSONObject;

public class Employee extends RestAssuredConfiguration {

    //@Test
    /*public void validateEmployee(){
       given().get("http://jsonplaceholder.typicode.com/posts").then().statusCode(200).log().all();
    }*/

    @Test(groups = "Demo")
    public void validateEmployee2(){

        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
        requestSpecification.queryParam("userId", 1).log().all();
        Response response = given().spec(requestSpecification).get(EndPoint.postUrl);

        response.then().log().all();
        //response.then().body("title",equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));

        /*response.then().contentType(ContentType.JSON);
        Assert.assertEquals(response.getStatusCode(),200);

        JSONObject jsonObject=new JSONObject(response.asString());      //this is for read the JSONObject from the response
        JSONArray jsonArray = jsonObject.getJSONArray("title");*/

        JSONArray JSONResponseBody = new JSONArray(response.body().asString());     //this is for read the JSONArray from response
        int userId=JSONResponseBody.getJSONObject(0).getInt("userId");
        System.out.println("User Id >> : " +userId);
        Assert.assertEquals(userId,1);

        int id = JSONResponseBody.getJSONObject(0).getInt("id");
        System.out.println("ID >> : " +id);
        Assert.assertEquals(id,1);

        //JSONObject jsonObject=new JSONObject();

        given().get(EndPoint.postUrl).then().statusCode(200).log().all();
    }

}
