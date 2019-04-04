package com.example.basicnetworkingapp;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
public interface InterfaceAPI {
    @GET("/")
    Call<Movie> getMovie(@Query("apikey") String apikey, @Query("t") String title);
}
