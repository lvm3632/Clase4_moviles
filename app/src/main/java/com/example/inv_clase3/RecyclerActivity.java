package com.example.inv_clase3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private ArrayList<String> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        // obtener referencia al widget de recycler view (GUI)
        recyclerView = findViewById(R.id.recycler);

        // obtener fuente de datos
        datos = new ArrayList<>();

        datos.add("Fido");
        datos.add("Firulais");
        datos.add("Fifi");
        datos.add("Kaiser");
        datos.add("Max");

        // crear adapter
        PerritosAdapter adapter = new PerritosAdapter(datos, this);

        // layout manager
        // dine cómo se van a organizar los elementos en el recycler view
        LinearLayoutManager llm = new LinearLayoutManager(this);

        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //GridLayoutManager glm = new GridLayoutManager(this,2);


        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);


        // 2da opción
        /*PerritosAdapter adapter = new PerritosAdapter(datos, new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/


    }

    @Override
    public void onClick(View v) {
        //Ejemplo obtener el id del correo
        int pos = recyclerView.getChildLayoutPosition(v);

        Toast.makeText(this, datos.get(pos), Toast.LENGTH_SHORT).show();

    }
}