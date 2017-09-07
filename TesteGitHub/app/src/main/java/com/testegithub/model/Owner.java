package com.testegithub.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by vitoralencars on 07/09/17.
 */

public class Owner implements Serializable{

    @SerializedName("login")
    private String login;
    @SerializedName("avatar_url")
    private String avatarUrl;

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
