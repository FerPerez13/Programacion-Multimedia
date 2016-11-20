package com.example.mati.ejemploexamen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Destino[] destinos = new Destino[]{
            new Destino("Zona A", "Asia y Oceania", 30),
            new Destino("Zona B", "America y Africa", 20),
            new Destino("Zona C", "Europa", 10)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText text = (EditText)findViewById(R.id.text);
        final TextView titulo = (TextView)findViewById(R.id.titulo);
        Button boton = (Button)findViewById(R.id.boton);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        ArrayList<String> nombresDestinos = nombresDestinos(destinos);
        ArrayAdapter<String> contenidoSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, nombresDestinos);
        spinner.setAdapter(contenidoSpinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Destino destinoSeleccionado = new Destino(destinos[position].getZona(),destinos[position].getContinente(),destinos[position].getPrecio());
                titulo.setText(destinos[position].toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public static ArrayList<String> nombresDestinos(Destino[] destinos){
        ArrayList<String> nombres = new ArrayList<String>();
        for(int i=0;i<destinos.length;i++)
            nombres.add(destinos[i].toString());
        return nombres;
    }

}
