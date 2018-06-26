package com.example.asus.tugasakhir.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 6/4/2018.
 */

public class LoginResult {
    @SerializedName("data")
    @Expose
    public Login data;

    public Login getData() {
        return data;
    }
}
