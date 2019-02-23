package com.test.pom.page;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Post_Delete_Put_Example {

    @Test
    public void test(){
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "02");
        jsonObject.put("title", "API Testing");
        jsonObject.put("author", "Anil");

        request.body(jsonObject.toString());
        Response response = request.post("http://localhost:3000/posts");

         int code = response.getStatusCode();
        Assert.assertEquals(code, 201);
    }

}
