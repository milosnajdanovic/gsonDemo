package com.htec.models.users.common;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

public class Support implements Serializable
{

    @SerializedName("url")
    private String url;
    @SerializedName("text")
    private String text;
    private final static long serialVersionUID = 6610212252643509681L;

    public Support() {
    }

    public Support(String url, String text) {
        super();
        this.url = url;
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
