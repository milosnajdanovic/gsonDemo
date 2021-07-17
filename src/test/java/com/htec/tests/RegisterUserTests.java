package com.htec.tests;

import com.htec.api.UserAPI;
import com.htec.models.users.CreateUserRequest;
import com.htec.models.users.CreateUserResponse;
import com.htec.setup.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDateTime;

public class RegisterUserTests extends TestBase {

    @Test
    public void verifyCanCreateUser() {
        LocalDateTime date = LocalDateTime.now();
        CreateUserRequest createUserRequest = new CreateUserRequest("milos" + date, "QA Engineer");

        CreateUserResponse actualResponse = UserAPI.registerUser(createUserRequest);
        CreateUserResponse expectedResponse = CreateUserResponse.parseCreatedUser(createUserRequest);

        SoftAssert softAssert = new SoftAssert();
        if (actualResponse == null) {
            Assert.fail("Actual response is null");
        }
        softAssert.assertEquals(actualResponse.getName(), expectedResponse.getName(), "name didn't match");
        softAssert.assertEquals(actualResponse.getJob(), expectedResponse.getJob(), "job didn't match");
        softAssert.assertNotNull(actualResponse.getCreatedAt(), "createdAt is null");
        softAssert.assertNotNull(actualResponse.getId(), "id is null");
        softAssert.assertAll();
    }
}
