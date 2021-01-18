package com.example.inv_clase3;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PerritosAdapter extends RecyclerView.Adapter<PerritosAdapter.PerritoViewHolder>{

    // definir un view holder
    // para administrar una lista necesitamos un viewfolder
    // - un objeto que se encarga de administrar una vista de renglón

    public class PerritoViewHolder extends RecyclerView.ViewHolder {

        public TextView texto1,texto2;
        // Aqui se puede manipular lo del reglon
        public PerritoViewHolder(@NonNull View itemView) {
            super(itemView);

            texto1 = itemView.findViewById(R.id.textView4);
            texto2 = itemView.findViewById(R.id.textView5);
        }
    }

    // extremadamente común, casi regla
    // referencia a fuente de datos (JSON, Objectos, XML lo que sea).
    private ArrayList<String> perritos;

    // Click en el renglon y click en el button
    private View.OnClickListener listener;

    public PerritosAdapter(ArrayList<String> perritos, View.OnClickListener listener){
        this.perritos = perritos;
        this.listener = listener;
    }






    @NonNull
    @Override
    public PerritoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Cuando necesite crear un nuevo
        // Y conforme va cambiando va reciclando y los que no use los destruye
        // Se invoca al inicio para todos, y despues cuando agregmamos nuevas viewholders
        // Se asocian por ubicación

        // Crear view específica de renglón
        // La actividad que lo use le decimos dame el contexto

        // Solo existe en la memoria esta abstracto
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        Button b = v.findViewById(R.id.button6);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.wtf("BOTONAZO", "BOTON PRESIONADO");
            }
        });

        v.setOnClickListener(listener);

        PerritoViewHolder pvh = new PerritoViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull PerritoViewHolder holder, int position) {

        // Asocia datos en una posición específica con un ViewHolder


        // Se necesita lógica para sacar algún dato en este método

        // Si cambia datos por ejemplo en la base de datos

        // asocia un viewholder con datos en particular
        holder.texto1.setText(perritos.get(position));
        holder.texto2.setText(perritos.get(position));


    }

    @Override
    public int getItemCount() {
        // Aqui regresa por ejemplo una query de sql del tamaño de una lista
        return perritos.size();
    }



}
