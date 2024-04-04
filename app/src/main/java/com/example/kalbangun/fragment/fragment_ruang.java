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

import com.example.kalbangun.bangunRuang.balok;
import com.example.kalbangun.bangunRuang.bola;
import com.example.kalbangun.bangunRuang.kubus;
import com.example.kalbangun.bangunRuang.tabung;
import com.example.kalbangun.modelbangun;

import java.util.ArrayList;
import java.util.List;

public class fragment_ruang extends Fragment implements AdapterBangun.ItemClickListener  {

    RecyclerView rvBangun;
    List<modelbangun> modelbangunList;
    AdapterBangun adapterRuang;

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
        return inflater.inflate(R.layout.fragment_ruang, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvBangun = view.findViewById(R.id.rvBangunRuang);
        modelbangunList = new ArrayList<>();

        modelbangun kubus = new modelbangun();
        kubus.setNamaBangun("Kubus");
        kubus.setDesc("6 x s²");
        kubus.setImageBangun("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSMXG7dv00sSNjnNTh6Oo6F_RL4vPWdvd8jtbBCkyi3Bw&s");
        modelbangunList.add(kubus);

        modelbangun bola = new modelbangun();
        bola.setNamaBangun("Bola");
        bola.setDesc("Luas Permukaan = 4 x Luas Lingkaran (π x r²)");
        bola.setImageBangun("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTMC2iCN0nsqYK215y3eCBvsmLEIzuw0fS9ZsRreJLkFyGMc3mIYIYIYfhY3W0gENIFbC8&usqp=CAU");
        modelbangunList.add(bola);

        modelbangun tabung = new modelbangun();
        tabung.setNamaBangun("Tabung");
        tabung.setDesc("Luas permukaan = 2 x Luas alas + Luas selimut tabung");
        tabung.setImageBangun("https://www.shutterstock.com/image-vector/tube-mathematical-geometry-shape-design-260nw-1494989834.jpg");
       modelbangunList.add(tabung);

        modelbangun balok = new modelbangun();
        balok.setNamaBangun("Balok");
        balok.setDesc("L = 2 x [(p x l) + (p x t) + (l x t)]");
        balok.setImageBangun("https://cdn-icons-png.flaticon.com/512/9215/9215492.png");
       modelbangunList.add(balok);

        rvBangun.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterRuang = new AdapterBangun(modelbangunList, getContext());
        rvBangun.setAdapter(adapterRuang);
        adapterRuang.setClickListener(this);


    }
    @Override
    public void onItemClick(View view, int position) {
        if(adapterRuang.getItem(position).getNamaBangun().equals("Kubus")){
            Intent intent = new Intent(getActivity(), kubus.class);
            startActivity(intent);
        }
        else if (adapterRuang.getItem(position).getNamaBangun().equals("Bola")){
            Intent intent = new Intent(getActivity(), bola.class);
            startActivity(intent);
        }
        else if (adapterRuang.getItem(position).getNamaBangun().equals("Tabung")){
            Intent intent = new Intent(getActivity(), tabung.class);
            startActivity(intent);
        }
        else if (adapterRuang.getItem(position).getNamaBangun().equals("Balok")){
            Intent intent = new Intent(getActivity(), balok.class);
            startActivity(intent);
        }
    }
}