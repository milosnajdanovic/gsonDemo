package com.htec.api;

import com.htec.models.users.common.Data;
import com.htec.models.users.create.CreateUserRequest;
import com.htec.models.users.create.CreateUserResponse;
import com.htec.models.users.byId.GetUserById;
import com.htec.models.users.list.ListUsersResponse;
import com.htec.setup.GsonSetup;
import com.htec.setup.RestAssuredApiRequests;
import org.testng.Assert;

public class UserAPI {

    public static CreateUserResponse registerUser(CreateUserRequest createUserRequest) {
        return GsonSetup.convertJsonToClass
                (RestAssuredApiRequests.post(createUserRequest, "api/users"), CreateUserResponse.class);
    }

    public static GetUserById getUserById(String userId) {
        return GsonSetup.convertJsonToClass(RestAssuredApiRequests.get("api/users/" + userId), GetUserById.class);
    }

    public static GetUserById fakeResource() {
        return GsonSetup.convertJsonToClass(RestAssuredApiRequests.get("api/made_up"), GetUserById.class);
    }

    public static ListUsersResponse getListOfUsers() {
        return GsonSetup.convertJsonToClass(RestAssuredApiRequests.get("api/users/"), ListUsersResponse.class);
    }

    public static Data findUserByIdFromTheList(Integer userId) {
        ListUsersResponse listUsersResponse = getListOfUsers();
        for (int i = 0; i < listUsersResponse.getData().size(); i++) {
            if (listUsersResponse.getData().get(i).getId().equals(userId)) {
                return listUsersResponse.getData().get(i);
            }
        }
        Assert.fail("User with id: " + userId + " was not found in the list");
        return null;
    }
}
