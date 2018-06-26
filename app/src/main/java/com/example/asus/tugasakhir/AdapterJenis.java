package com.example.asus.tugasakhir;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ASUS on 5/24/2018.
 */

public class AdapterJenis extends RecyclerView.Adapter<AdapterJenis.ViewHolder> {

    private ArrayList<Jenis> jenis;
    private Context context;

    public AdapterJenis(Context context, ArrayList<Jenis> jeniss) {
        this.jenis = jeniss;
        this.context = context;
    }

    @Override
    public AdapterJenis.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.produk_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterJenis.ViewHolder holder, int position) {
        holder.tnama.setText(jenis.get(position).getId_jenis());
        holder.tharga.setText(jenis.get(position).getJenis());
        holder.tstok.setText(jenis.get(position).getJenis());
       // Picasso.with(context).load(datamakanan.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return jenis.size();
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
