package com.example.demotask.webservice;


import com.example.demotask.webservice.apimodel.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiInterface {
    @GET("/posts")
    Call<List<PostModel>> getAllPosts();
}
