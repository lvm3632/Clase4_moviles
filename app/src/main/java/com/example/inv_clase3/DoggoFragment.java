package com.example.inv_clase3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DoggoFragment extends Fragment {



    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "nombre";
    private static final String ARG_PARAM2 = "apellido";

    private String nombre;
    private String apellido;

    public DoggoFragment() {
        // Required empty public constructor
    }

    public static DoggoFragment newInstance(String nombre, String apellido) {

        DoggoFragment fragment = new DoggoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, nombre);
        args.putString(ARG_PARAM2, apellido);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nombre = getArguments().getString(ARG_PARAM1);
            apellido = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_doggo, container, false);

        TextView textito1 = v.findViewById(R.id.textView);
        TextView textito2 = v.findViewById(R.id.textView3);

        textito1.setText(nombre);
        textito2.setText(apellido);

        return v;
    }

    public void saludar(String saludo) {

        Toast.makeText(getActivity(), "HOLA: " + saludo, Toast.LENGTH_SHORT).show();
    }
}