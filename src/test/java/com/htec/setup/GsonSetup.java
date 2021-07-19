package com.htec.setup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import io.restassured.response.Response;
import org.testng.Assert;

import java.lang.reflect.Type;

public class GsonSetup {

    //method will be reused to convert any json response into class
    public static <T> T convertJsonToClass(Response jsonResponse, Class<T> classOfT) {
        //use try and catch block to handle exception
        try {
            String prettyJsonString = new GsonBuilder().setPrettyPrinting().create().toJson(new JsonParser().parse(jsonResponse.body().asString()));
            //if you want to make sure the response is as expected in model, one way to go is to assert status code
            if (jsonResponse.getStatusCode() >= 400 && jsonResponse.getStatusCode() < 600) {
                //You can use TestNG assert to stop execution and print out the error that was received
                Assert.fail(classOfT + "\n returned error: " + prettyJsonString);
            } else {
                //return json converted into object (your class)
                return new Gson().fromJson(prettyJsonString, (Type) classOfT);
            }
        } catch (JsonSyntaxException|IllegalStateException e) {
            //return exception api returned during serialization
            Assert.fail(classOfT + "\n returned serialization exception error: " + e.getMessage());
        }
        return null;
    }

}
