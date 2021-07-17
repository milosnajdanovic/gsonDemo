package com.htec.setup;

import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAssuredApiRequests {

    //create generic restAssured methods for http request you will reuse
    public static Response get(String uri) {
        return given().contentType(ContentType.JSON).when().get(uri).then().extract().response();
    }

    //we will provide an object from our class model as body and by using Gson convert it to Json
    public static Response post(Object body, String uri) {
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(body);
        return given().contentType(ContentType.JSON).body(json).when().post(uri).then().extract().response();
    }

    public static Response put(Object body, String uri) {
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(body);
        return given().contentType(ContentType.JSON).body(json).when().put(uri).then().extract().response();
    }

    public static Response delete(String uri) {
        return given().contentType(ContentType.JSON).when().delete().then().extract().response();
    }

    //if you need authorization here is an example, just add header
    public static Response post(Object body, String token, String uri) {
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(body);
        return given().contentType(ContentType.JSON).header("AUTHORIZATION", "Bearer " + token)
                .body(json).when().post(uri).then().extract().response();
    }
}
