package com.htec.tests;

import com.htec.api.UserAPI;
import com.htec.models.users.create.CreateUserRequest;
import com.htec.models.users.create.CreateUserResponse;
import com.htec.setup.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDateTime;

public class UserTests extends TestBase {

    @Test
    public void verifyCanCreateUser() {
        LocalDateTime date = LocalDateTime.now();
        //We will use the constructor from the Class to create a request body
        CreateUserRequest createUserRequest = new CreateUserRequest("milos" + date, "QA Engineer");

        //We will pass the request as a Java Object, Gson will convert it to JSON
        //RestAssured will fetch the response from the server as a JSON, and Gson will convert it to a Java Object
        CreateUserResponse actualResponse = UserAPI.registerUser(createUserRequest);

        //We will create an expected response by creating a new Object with the data we have from the request
        CreateUserResponse expectedResponse = CreateUserResponse.parseCreatedUser(createUserRequest);

        //We can use TestNG's SoftAssert to compare expected data to the actual one we fetched from the server
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResponse.getName(), expectedResponse.getName(), "name didn't match");
        softAssert.assertEquals(actualResponse.getJob(), expectedResponse.getJob(), "job didn't match");
        softAssert.assertNotNull(actualResponse.getCreatedAt(), "createdAt is null");
        softAssert.assertNotNull(actualResponse.getId(), "id is null");
        softAssert.assertAll();
    }

    @Test
    //We will send the wrong user id on purpose to get a 404 error from the server
    public void verifyTestWillReturnError() {
        UserAPI.getUserById("55");
    }

    @Test
    public void verifyAssertWillFail() {
        LocalDateTime date = LocalDateTime.now();
        CreateUserRequest createUserRequest = new CreateUserRequest("milos" + date, "QA Engineer");
        CreateUserResponse actualResponse = UserAPI.registerUser(createUserRequest);
        CreateUserResponse expectedResponse = CreateUserResponse.parseCreatedUser(createUserRequest);

        //We added hardcoded data to fail the assertion on purpose
        expectedResponse.setName("Made up name");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResponse.getName(), expectedResponse.getName(), "name didn't match");
        softAssert.assertAll();
    }

    @Test
    //We added a fake API Route on purpose to fail serialization
    public void verifySerializationFails() {
        UserAPI.fakeResource();
    }
}
