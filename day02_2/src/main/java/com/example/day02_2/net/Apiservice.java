package com.example.day02_2.net;

import com.example.day02_2.User;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Apiservice {
    String BASE_URL = "http://gank.io/api/";

    @GET("data/%E7%A6%8F%E5%88%A9/30/1")
    Observable<User> getData1();
}
