package com.test.pom.page;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Post_Delete_Put_Example_Put {

    @Test
    public void test(){
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "02");
        jsonObject.put("title", "API Testing Demo");
        jsonObject.put("author", "Anil Kumar");

        request.body(jsonObject.toString());
        Response response = request.put("http://localhost:3000/posts/02");

         int code = response.getStatusCode();
        System.out.println("Response code: " +code);
        Assert.assertEquals(code, 200);
    }

}
