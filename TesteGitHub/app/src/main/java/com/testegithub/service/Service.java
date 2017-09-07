package com.testegithub.service;

import com.testegithub.model.UserRepos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by vitoralencars on 06/09/17.
 */

public interface Service {

    @GET("{username}/repos")
    Call<List<UserRepos>> getUserRepositories(@Path("username") String username);

}
