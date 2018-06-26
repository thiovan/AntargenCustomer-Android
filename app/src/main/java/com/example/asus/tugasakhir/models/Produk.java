package com.example.asus.tugasakhir.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Produk {
    @SerializedName("nama_produk")
    @Expose
    public String namaProduk;
    @SerializedName("kategori")
    @Expose
    public String kategori;
    @SerializedName("stok")
    @Expose
    public String stok;
    @SerializedName("harga")
    @Expose
    public String harga;

    public String getNamaProduk() {
        return namaProduk;
    }

    public String getKategori() {
        return kategori;
    }

    public String getStok() {
        return stok;
    }

    public String getHarga() {
        return harga;
    }
}
