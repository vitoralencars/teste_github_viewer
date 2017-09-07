package com.testegithub.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vitoralencars on 06/09/17.
 */

public class Builder {

    private Retrofit retrofit;
    private Service service;

    public Builder(String baseURL){
        retrofit = initRetrofit(baseURL);
        service = initService(retrofit);
    }

    private Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private Retrofit initRetrofit(String baseURL){
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    private Service initService(Retrofit retrofit){
        return retrofit.create(Service.class);
    }

    public Service getService(){
        return this.service;
    }

}
