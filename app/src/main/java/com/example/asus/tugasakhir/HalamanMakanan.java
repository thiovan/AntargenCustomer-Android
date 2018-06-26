package com.example.asus.tugasakhir;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HalamanMakanan extends Fragment {


    private RecyclerView recyclerView; //recyleview hampir sama spt listview
    private ArrayList<DataMakanan> dataMakanans; //objek DataMakanan yg menampung data dari database
    private AdapterMakanan adapter;//adapter untuk mengatur isi recycleview
    SwipeRefreshLayout swipeRefreshLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.activity_halaman_makanan, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Makanan");
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swiperefresh);

        recyclerView = (RecyclerView)view.findViewById(R.id.card_recycle_view);
        //LinearLayout
        RecyclerView.LayoutManager linearLayoutManager =new LinearLayoutManager(getActivity());

        //GridLayout
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        gridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);

        recyclerView.setLayoutManager(linearLayoutManager);
//        loadJSON();
    }

//    private void loadJSON() {
//        swipeRefreshLayout.setRefreshing(true);
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(UtilsApi.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        APIService request = retrofit.create(APIService.class);
//        Call<JSONResponse> call = request.getMakanan();
//        call.enqueue(new Callback<JSONResponse>() {
//            @Override
//            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
//               swipeRefreshLayout.setRefreshing(false);
//                JSONResponse jsonResponse = response.body();
//                dataMakanans = new ArrayList<>(Arrays.asList(jsonResponse.getDataproduk()));
//                adapter = new AdapterMakanan(getActivity(), dataMakanans);
//                recyclerView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<JSONResponse> call, Throwable t) {
//                swipeRefreshLayout.setRefreshing(false);
//                Log.d("Error", t.getMessage());
//            }
//        });
//    }

}
