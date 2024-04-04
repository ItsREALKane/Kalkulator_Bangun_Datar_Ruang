package com.example.kalbangun.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kalbangun.AdapterBangun;
import com.example.kalbangun.R;
import com.example.kalbangun.bangunDatar.lingkaran;
import com.example.kalbangun.bangunDatar.persegi;
import com.example.kalbangun.bangunDatar.persegiPanjang;
import com.example.kalbangun.bangunDatar.segitiga;
import com.example.kalbangun.modelbangun;

import java.util.ArrayList;
import java.util.List;

public class fragment_datar extends Fragment implements AdapterBangun.ItemClickListener {

    RecyclerView rvBangunDatar;
    List<modelbangun> listDataBangunDatar;
    AdapterBangun adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_datar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvBangunDatar = view.findViewById(R.id.rvBangun);
        listDataBangunDatar = new ArrayList<>();

        modelbangun persegi = new modelbangun();
        persegi.setNamaBangun("Persegi");
        persegi.setDesc("S x S ");
        persegi.setImageBangun("https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/512x512/plain/shape_square.png");
        listDataBangunDatar.add(persegi);

        modelbangun segitiga = new modelbangun();
        segitiga.setNamaBangun("Segitiga");
        segitiga.setDesc("L = 1/2 x a x t");
        segitiga.setImageBangun("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTucVqf8jA0u8y19jFtZbJy_3nWSeT-Lzwzom6I7JZoWQ&s");
        listDataBangunDatar.add(segitiga);

        modelbangun PersegiPanjang = new modelbangun();
        PersegiPanjang.setNamaBangun("Persegi Panjang");
        PersegiPanjang.setDesc("P x L x T");
        PersegiPanjang.setImageBangun("https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/512x512/plain/shape_rectangle.png");
        listDataBangunDatar.add(PersegiPanjang);

        modelbangun lingkaran = new modelbangun();
        lingkaran.setNamaBangun("Lingkaran");
        lingkaran.setDesc("Phi x r x r");
        lingkaran.setImageBangun("https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/512x512/plain/shape_circle.png");
        listDataBangunDatar.add(lingkaran);

        rvBangunDatar.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AdapterBangun(listDataBangunDatar, getContext());
        rvBangunDatar.setAdapter(adapter);
        adapter.setClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        if(adapter.getItem(position).getNamaBangun().equals("Persegi")){
            Intent intent = new Intent(getActivity(), persegi.class);
            startActivity(intent);
        }
        else if (adapter.getItem(position).getNamaBangun().equals("Segitiga")){
            Intent intent = new Intent(getActivity(), segitiga.class);
            startActivity(intent);
        }
        else if (adapter.getItem(position).getNamaBangun().equals("Persegi Panjang")){
            Intent intent = new Intent(getActivity(), persegiPanjang.class);
            startActivity(intent);
        }
        else if (adapter.getItem(position).getNamaBangun().equals("Lingkaran")){
            Intent intent = new Intent(getActivity(), lingkaran.class);
            startActivity(intent);
        }
    }
}