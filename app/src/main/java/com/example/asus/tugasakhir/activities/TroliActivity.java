package com.example.asus.tugasakhir.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.example.asus.tugasakhir.R;
import com.example.asus.tugasakhir.adapter.TroliAdapter;
import com.example.asus.tugasakhir.models.Troli;
import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.List;

public class TroliActivity extends AppCompatActivity {

    //Deklarasi variabel global
    private RecyclerView recyclerView;
    private TroliAdapter adapter;
    List<Troli> trolis = new ArrayList<>();
    private TextView mTotal;
    private Button mButtonPengiriman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troli);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Menampilkan icon panah kembali di action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Mengganti judul action bar
        getSupportActionBar().setTitle("Troli Saya");

        //Memanggil fungsi initView
        initView();

        //Deklarasi dan konfigurasi recyclerview
        recyclerView = (RecyclerView) findViewById(R.id.recycler_troli);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        //Ambil data dari tabel Troli di sqlite
        SugarContext.init(TroliActivity.this);
        trolis = Troli.listAll(Troli.class);

        //Tampilkan item troli di recyclerview
        adapter = new TroliAdapter(trolis);
        recyclerView.setAdapter(adapter);

        //Hitung total keseluruhan harga item
        Integer total = 0;
        for (int l = 0; l < trolis.size(); l++) {
            Troli item = trolis.get(l);
            total = total + Integer.parseInt(item.getJumlah()) * Integer.parseInt(item.getHarga());
        }
        mTotal.setText("Rp. " + total);

    }

    //Fungsi deklarasi view yang ada pada layout
    private void initView() {
        mTotal = (TextView) findViewById(R.id.total);
        mButtonPengiriman = (Button) findViewById(R.id.button_pengiriman);
    }

    //Fungsi update total keseluruhan
    //Fungsi ini wajib dipanggil ketika hapus item dari recyclerview
    public void updateTotal(List<Troli> troliList){
        Integer total = 0;
        for (int l = 0; l < troliList.size(); l++) {
            Troli item = troliList.get(l);
            total = total + Integer.parseInt(item.getJumlah()) * Integer.parseInt(item.getHarga());
        }
        mTotal.setText("Rp. " + total);
    }

    //Fungsi ketika icon panah kembali ditekan
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
