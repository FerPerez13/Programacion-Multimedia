package com.example.mati.pasarobjetos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView persona = (TextView)findViewById(R.id.persona);
        final ImageView imagen = (ImageView)findViewById(R.id.imagen);

        Bundle miBundle = getIntent().getExtras();
        Persona persona1 = (Persona)miBundle.getSerializable("Texto1"); //Aqui recogemos el objeto del MainActivity

        imagen.setImageResource(persona1.getImagen());

        persona.setText(persona1.toString());

    }
}
