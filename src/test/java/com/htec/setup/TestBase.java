package com.htec.setup;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    @BeforeSuite
    public static void initializeTest() {
        RestAssured.baseURI = "https://test-api.k6.io/";
    }

}
