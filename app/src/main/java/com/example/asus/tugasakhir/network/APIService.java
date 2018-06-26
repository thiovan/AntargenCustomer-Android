package com.example.asus.tugasakhir.network;

import com.example.asus.tugasakhir.models.LoginResponse;
import com.example.asus.tugasakhir.models.ProdukResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by ASUS on 5/24/2018.
 */

public interface APIService {
    @FormUrlEncoded
    @POST("api/auth/login")
    Call<LoginResponse> userLogin(
            @Field("email") String email,
            @Field("password") String password);

    @GET("api/makanan")
    Call<ProdukResponse> getMakanan();
}
