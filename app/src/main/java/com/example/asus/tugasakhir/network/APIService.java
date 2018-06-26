package com.example.asus.tugasakhir.network;

import com.example.asus.tugasakhir.models.LoginResult;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ASUS on 5/24/2018.
 */

public interface APIService {
   @FormUrlEncoded
    @POST("api/auth/login")
    Call<LoginResult> userLogin(
            @Field("email") String email,
            @Field("password") String password);
}
