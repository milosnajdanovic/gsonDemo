package com.htec.setup;

import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAssuredApiRequests {

    //We will create generic RestAssured methods for HTTP requests we can reuse
    public static Response get(String uri) {
        return given().contentType(ContentType.JSON).when().get(uri).then().extract().response();
    }

    //We will provide an Object from our Class as a body and, by using Gson, convert it to JSON
    public static Response post(Object body, String uri) {
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(body);
        return given().contentType(ContentType.JSON).body(json).when().post(uri).then().extract().response();
    }

    //If you need authorization, here is an example — just add a header
    public static Response post(Object body, String token, String uri) {
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(body);
        return given().contentType(ContentType.JSON).header("AUTHORIZATION", "Bearer " + token)
                .body(json).when().post(uri).then().extract().response();
    }
}
