package com.example.ruben.mascotas.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ruben.mascotas.R;
import com.example.ruben.mascotas.adapter.MascotasAdaptador;
import com.example.ruben.mascotas.pojo.DataSet;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    private ArrayList<DataSet> mascotas;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container,false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public MascotasAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new MascotasAdaptador(mascotas,getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<DataSet>();

        mascotas.add(new DataSet("Perro con hueso","3",R.drawable.perros_uno));
        mascotas.add(new DataSet("San Bernardo","4",R.drawable.perros_dos));
    }
}
