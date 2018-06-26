package com.example.asus.tugasakhir;

import android.os.StrictMode;

/**
 * Created by ASUS on 5/24/2018.
 */

public class DataMakanan {
    private String id;
    private String nama_produk;
    private String harga;
    private String stok;
    private String foto;

    public DataMakanan(String id, String nama_produk, String harga, String stok, String foto) {
        this.id = id;
        this.nama_produk = nama_produk;
        this.harga = harga;
        this.stok = stok;
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
