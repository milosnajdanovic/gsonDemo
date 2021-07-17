package com.htec.models.users.common;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Data implements Serializable {

    private final static long serialVersionUID = -2659014833864276105L;
    @SerializedName("id")
    private Integer id;
    @SerializedName("email")
    private String email;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("avatar")
    private String avatar;

    public Data() {
    }

    public Data(Integer id, String email, String firstName, String lastName, String avatar) {
        super();
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
    }

    public static Data parseUserData(Data userById) {
        Data data = new Data();
        data.setId(userById.getId());
        data.setEmail(userById.getEmail());
        data.setFirstName(userById.getFirstName());
        data.setLastName(userById.getLastName());
        data.setAvatar(userById.getAvatar());
        return data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
