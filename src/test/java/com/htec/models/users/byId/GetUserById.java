package com.htec.models.users.byId;

import com.google.gson.annotations.SerializedName;
import com.htec.models.users.common.Data;
import com.htec.models.users.common.Support;

import java.io.Serializable;

public class GetUserById implements Serializable {

    private final static long serialVersionUID = -6694416097884854936L;
    @SerializedName("data")
    private Data data;
    @SerializedName("support")
    private Support support;

    public GetUserById() {
    }

    public GetUserById(Data data, Support support) {
        super();
        this.data = data;
        this.support = support;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

}
