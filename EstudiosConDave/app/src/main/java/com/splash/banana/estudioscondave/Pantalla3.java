package com.splash.banana.estudioscondave;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Pantalla3 extends AppCompatActivity {

    Spinner spinner;

    private Campeon[] campeones = new Campeon[]{
            new Campeon("Braum", R.drawable.braum),
            new Campeon("Fernando", R.drawable.fer),
            new Campeon("Makoa", R.drawable.mako),
            new Campeon("Bardo", R.drawable.bard),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);

        final TextView textView = (TextView)findViewById(R.id.textoSpinner);
        final ImageView imageView = (ImageView)findViewById(R.id.imagen);



        spinner = (Spinner)findViewById(R.id.spiner);
        ArrayList<String> campeonesNombre = nombresCampeones(campeones);
        ArrayAdapter<String> contenidoSpinner= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, campeonesNombre);
        spinner.setAdapter(contenidoSpinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(campeones[position].getNombre());
                imageView.setImageResource(campeones[position].getImagen());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    public static ArrayList<String> nombresCampeones(Campeon[] campeones){
        ArrayList<String> nombres= new ArrayList<String>();
        for(int i=0;i<campeones.length;i++){
            nombres.add(campeones[i].getNombre());
        }
        return nombres;
    }
}
