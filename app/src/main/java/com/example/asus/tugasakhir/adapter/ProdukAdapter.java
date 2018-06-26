package com.example.asus.tugasakhir.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.tugasakhir.R;
import com.example.asus.tugasakhir.models.Produk;

import java.util.List;

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.MyViewHolder>{
    private List<Produk> produkList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tnama, tharga, tstok;

        public MyViewHolder(View view) {
            super(view);
            tnama = (TextView) itemView.findViewById(R.id.Nama_Produk);
            tharga = (TextView) itemView.findViewById(R.id.Harga);
            tstok = (TextView) itemView.findViewById(R.id.Stok);
        }
    }

    public ProdukAdapter(List<Produk> produkList) {
        this.produkList = produkList;
    }

    @Override
    public ProdukAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.produk_item, parent, false);

        return new ProdukAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ProdukAdapter.MyViewHolder holder, final int position) {
        Produk produk = produkList.get(position);
        holder.tnama.setText(produk.getNamaProduk());
        holder.tharga.setText("Rp. " + produk.getHarga());
        holder.tstok.setText("Stok: " + produk.getStok());
    }

    @Override
    public int getItemCount() {
        return produkList.size();
    }
}
