package com.htec.models.users;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CreateUserRequest implements Serializable {

    private final static long serialVersionUID = 4786416348386584004L;
    @SerializedName("name")
    private String name;
    @SerializedName("job")
    private String job;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String name, String job) {
        super();
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

}
