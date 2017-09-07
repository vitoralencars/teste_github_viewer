package com.testegithub.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by vitoralencars on 06/09/17.
 */

public class UserRepos implements Serializable{

    @SerializedName("name")
    private String reposName;
    @SerializedName("owner")
    private Owner owner;
    @SerializedName("language")
    private String language;

    public String getReposName() {
        return reposName;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getLanguage() {
        return language;
    }
}
