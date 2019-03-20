package com.example.user.breeds;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("/api/breeds/list/all")
    Call<BreedResponse> getBreeds();
}
