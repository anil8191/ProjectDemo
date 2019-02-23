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

public class GoogleApiTest {

    @Test(groups = "Demo")
    public void googleApiTest() {
    RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
    requestSpecification.queryParam("q", "turing");
    new RestAssuredConfiguration().getResponse(requestSpecification, EndPoint.GOOGLE_API);
}
}
