package com.example.asus.tugasakhir.network;

import com.example.asus.tugasakhir.models.KurirResponse;
import com.example.asus.tugasakhir.models.LoginResponse;
import com.example.asus.tugasakhir.models.ProdukResponse;
import com.google.gson.JsonObject;

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

    @GET("api/produk")
    Call<ProdukResponse> getProduk();

    @GET("api/makanan")
    Call<ProdukResponse> getMakanan();

    @GET("api/minuman")
    Call<ProdukResponse> getMinuman();

    @GET("api/kesehatan")
    Call<ProdukResponse> getKesehatan();

    @GET("api/krt")
    Call<ProdukResponse> getKrt();

    @FormUrlEncoded
    @POST("api/pesanan")
    Call<JsonObject> addPesanan(
            @Field("id_user") String id_user,
            @Field("id_kurir") String id_kurir,
            @Field("id_produk") String id_produk,
            @Field("alamat_pesanan") String alamat_pesanan,
            @Field("total") String total,
            @Field("status_pesanan") String status_pesanan,
            @Field("telp_pesanan") String telp_pesanan,
            @Field("jumlah") String jumlah);

    @GET("api/kurir")
    Call<KurirResponse> getAllKurir();
}
