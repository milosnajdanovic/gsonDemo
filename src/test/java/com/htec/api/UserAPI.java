package com.htec.api;

import com.htec.models.users.CreateUserRequest;
import com.htec.models.users.CreateUserResponse;
import com.htec.setup.GsonSetup;
import com.htec.setup.RestAssuredApiRequests;

public class UserAPI {

    public static CreateUserResponse registerUser(CreateUserRequest createUserRequest) {
        return GsonSetup.convertJsonToClass
                (RestAssuredApiRequests.post(createUserRequest, "api/users"), CreateUserResponse.class);
    }
}
