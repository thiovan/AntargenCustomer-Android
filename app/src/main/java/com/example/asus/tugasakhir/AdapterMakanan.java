package com.example.asus.tugasakhir;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ASUS on 5/24/2018.
 */

public class AdapterMakanan extends RecyclerView.Adapter<AdapterMakanan.ViewHolder> {

    private ArrayList<DataMakanan> datamakanan;
    private Context context;

    public AdapterMakanan(Context context, ArrayList<DataMakanan> datamakanan) {
        this.datamakanan = datamakanan;
        this.context = context;
    }

    @Override
    public AdapterMakanan.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.produk_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterMakanan.ViewHolder holder, int position) {
        holder.tnama.setText(datamakanan.get(position).getNama_produk());
        holder.tharga.setText(datamakanan.get(position).getHarga());
        holder.tstok.setText(datamakanan.get(position).getHarga());
        Picasso.with(context).load(datamakanan.get(position).getFoto());

        Log.d("data",datamakanan.get(position).getNama_produk());
    }

    @Override
    public int getItemCount() {
        return datamakanan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       private TextView tnama, tharga, tstok;
       ImageView ifoto;
        public ViewHolder(View itemView) {
            super(itemView);
            tnama = (TextView) itemView.findViewById(R.id.Nama_Produk);
            tharga = (TextView) itemView.findViewById(R.id.Harga);
            tstok = (TextView) itemView.findViewById(R.id.Stok);
            ifoto = (ImageView) itemView.findViewById(R.id.gambar);
        }

    }
}
