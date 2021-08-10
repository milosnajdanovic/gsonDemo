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

    //We created a function that combines RestAssured and Gson functions
    //We can send a Java Object and get a response as a Java Object with libraries taking care of the JSON conversion
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
}
