package com.test.pom.page;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Post_Delete_Put_Example_Delete {

    @Test
    public void test(){
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        Response response = request.delete("http://localhost:3000/posts/2");

         int code = response.getStatusCode();
        Assert.assertEquals(code, 200);
    }

}
