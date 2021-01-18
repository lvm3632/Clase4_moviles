package com.example.inv_clase3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements HelloFragment.Callback{

    private static final String TAG_FRAGMENTO = "fragmento";
    private DoggoFragment doggo;
    private HelloFragment helloFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doggo = DoggoFragment.newInstance("Firulais", "Hernandez");
        helloFragment = new HelloFragment();

    }

    public void cambiarFragmento(Fragment nuevo){



        // como obtener referencia a un fragmento ya agregado
        FragmentManager manager = getSupportFragmentManager();
        Fragment f = manager.findFragmentByTag(TAG_FRAGMENTO);
        FragmentTransaction transaction = manager.beginTransaction();

        // si el fragmento que queremos agregar es el que ya está
        if(nuevo == f)
            return;

        if(f != null){
            transaction.remove(f);
        }

        transaction.add(R.id.contenedor, nuevo, TAG_FRAGMENTO);
        transaction.commit();
    }

    public void fragmentoA(View v){

        cambiarFragmento(doggo);
    }

    public void fragmentoB(View v){

        cambiarFragmento(helloFragment);
    }

    public void saludoFragmentito(View v){

        doggo.saludar("MEMO");
    }

    @Override
    public void saludoEnActividad(String saludo) {
        Toast.makeText(this, "El saludo recibido " + saludo, Toast.LENGTH_SHORT).show();
    }

    public void cambiarARecycler(View v){
        Intent i = new Intent(this, RecyclerActivity.class);
        startActivity(i);

    }
}