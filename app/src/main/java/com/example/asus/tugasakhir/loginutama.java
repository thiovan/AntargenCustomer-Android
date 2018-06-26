package com.example.asus.tugasakhir;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.tugasakhir.models.Login;
import com.example.asus.tugasakhir.models.LoginResult;
import com.example.asus.tugasakhir.network.APIService;
import com.example.asus.tugasakhir.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class loginutama extends AppCompatActivity {
    TextView email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginutama);
        email=(TextView)findViewById(R.id.txt_email);
        password=(TextView) findViewById(R.id.txt_password);

    }

    public void MainActivity (View view) {
        login(email.getText().toString(),password.getText().toString());
    }

    public void login(String email,String password) {
        APIService service = RetrofitClient.getClient().create(APIService.class);
        Call<LoginResult> userCall = service.userLogin(email, password);

        userCall.enqueue(new Callback<LoginResult>() {
            @Override
            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {

                if (response.code()==401) {


                    Toast.makeText(loginutama.this, "Login Gagal", Toast.LENGTH_SHORT).show();

                } else {
                    Login login = response.body().getData();
                    SharedPreferences sharedPreferences = getSharedPreferences("SESSION", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("USER", login.getEmail());
                    editor.apply();  
                    Intent intent = new Intent(loginutama.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<LoginResult> call, Throwable t) {
                Toast.makeText(loginutama.this, "Gagal Terhubung ke Server", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void saveSession(String ID){
        SharedPreferences.Editor editor = getSharedPreferences("SESSION", MODE_PRIVATE).edit();
        editor.putString("ID_USER", ID );
        editor.apply();
    }

    public String isLogin (){
        SharedPreferences preferences = getSharedPreferences("SESSION",MODE_PRIVATE);
        return preferences.getString("ID_USER", null);
    }


}
