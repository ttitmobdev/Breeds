package com.example.user.breeds;

import retrofit2.Retrofit;

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL="https://dog.ceo/";
    public static Api getApiService()
    {
        return RetrofitClient.getClient(BASE_URL).create(Api.class);
    }
}
