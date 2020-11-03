package com.example.ruben.mascotas.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ruben.mascotas.R;
import com.example.ruben.mascotas.adapter.MascotasAdaptador;
import com.example.ruben.mascotas.pojo.DataSet;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaPerroFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaPerroFragment extends Fragment {
    private ArrayList<DataSet> mascotas;
    private RecyclerView listaMascotas;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListaPerroFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaPerroFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaPerroFragment newInstance(String param1, String param2) {
        ListaPerroFragment fragment = new ListaPerroFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lista_perro, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvListaMascotas);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        //glm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(glm);

        inicializarListaMascotas();
        inicializarAdaptador();

        CircularImageView circularImageView = v.findViewById(R.id.circularImageView);
// Set Color
        circularImageView.setCircleColor(Color.WHITE);
// or with gradient
        circularImageView.setCircleColorStart(Color.BLACK);
        circularImageView.setCircleColorEnd(Color.RED);
        circularImageView.setCircleColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);

// Set Border
        circularImageView.setBorderWidth(10f);
        circularImageView.setBorderColor(Color.BLACK);
// or with gradient
        circularImageView.setBorderColorStart(Color.BLACK);
        circularImageView.setBorderColorEnd(Color.RED);
        circularImageView.setBorderColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);

// Add Shadow with default param
        circularImageView.setShadowEnable(true);
// or with custom param
        circularImageView.setShadowRadius(7f);
        circularImageView.setShadowColor(Color.RED);
        circularImageView.setShadowGravity(CircularImageView.ShadowGravity.CENTER);
        return v;

    }

    public MascotasAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new MascotasAdaptador(mascotas,getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<DataSet>();

        mascotas.add(new DataSet("","3",R.drawable.perros1));
        mascotas.add(new DataSet("","4",R.drawable.perros1));
        mascotas.add(new DataSet("","4",R.drawable.perros1));
        mascotas.add(new DataSet("","4",R.drawable.perros1));
        mascotas.add(new DataSet("","4",R.drawable.perros1));
    }


}