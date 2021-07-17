package com.htec.tests;

import com.htec.api.UserAPI;
import com.htec.models.users.common.Data;
import com.htec.models.users.create.CreateUserRequest;
import com.htec.models.users.create.CreateUserResponse;
import com.htec.models.users.byId.GetUserById;
import com.htec.setup.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDateTime;

public class UserTests extends TestBase {

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

    @Test
    public void verifyFindUserInTheList() {
        GetUserById userById = UserAPI.getUserById("2");

        Data actualResponse = UserAPI.findUserByIdFromTheList(2);
        Data expectedResponse = Data.parseUserData(userById.getData());

        SoftAssert softAssert = new SoftAssert();
        if (actualResponse == null) {
            Assert.fail("Actual response is null");
        }
        softAssert.assertEquals(actualResponse.getId(), expectedResponse.getId(), "Id didn't match");
        softAssert.assertEquals(actualResponse.getEmail(), expectedResponse.getEmail(), "Email didn't match");
        softAssert.assertEquals(actualResponse.getAvatar(), expectedResponse.getAvatar(), "Avatar didn't match");
        softAssert.assertEquals(actualResponse.getFirstName(), expectedResponse.getFirstName(), "firstName didn't match");
        softAssert.assertEquals(actualResponse.getLastName(), expectedResponse.getLastName(), "lastName didn't match");
        softAssert.assertAll();
    }

    @Test
    public void verifyTestWillReturnError() {
        UserAPI.getUserById("55");
    }

    @Test
    public void verifyAssertWillFail() {
        GetUserById userById = UserAPI.getUserById("2");

        Data actualResponse = UserAPI.findUserByIdFromTheList(2);
        Data expectedResponse = Data.parseUserData(userById.getData());
        //I added hardcoded data to fail assert on purpose
        expectedResponse.setFirstName("Made up name");

        SoftAssert softAssert = new SoftAssert();
        if (actualResponse == null) {
            Assert.fail("Actual response is null");
        }
        softAssert.assertEquals(actualResponse.getId(), expectedResponse.getId(), "Id didn't match");
        softAssert.assertEquals(actualResponse.getEmail(), expectedResponse.getEmail(), "Email didn't match");
        softAssert.assertEquals(actualResponse.getAvatar(), expectedResponse.getAvatar(), "Avatar didn't match");
        softAssert.assertEquals(actualResponse.getFirstName(), expectedResponse.getFirstName(), "firstName didn't match");
        softAssert.assertEquals(actualResponse.getLastName(), expectedResponse.getLastName(), "lastName didn't match");
        softAssert.assertAll();
    }

    @Test
    public void verifySerializationFails() {
        UserAPI.fakeResource();
    }
}
