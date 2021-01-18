package com.example.inv_clase3;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import javax.security.auth.callback.Callback;

public class HelloFragment extends Fragment {

    private Callback observador;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hello, container, false);

        Button b1 = v.findViewById(R.id.button3);
        Button b2 = v.findViewById(R.id.button4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "BOTON 1 PRESIONADO", Toast.LENGTH_SHORT).show();
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "BOTON 2 PRESIONADO", Toast.LENGTH_SHORT).show();
                observador.saludoEnActividad("SALUDINES");
            }
        });

        return v;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);


        if(context instanceof Callback){
            observador = (Callback)context;
        }else{

            throw new RuntimeException("FALTA IMPLEMENTAR LA INTERFAZ CALLBACK EN ACTIVIDAD QUE ANEXA FRAGMENTO");
        }

    }

    public interface Callback{
        public void saludoEnActividad(String saludo);
    }


}