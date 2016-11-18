package com.splash.banana.estudioscondave;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView textView = (TextView)findViewById(R.id.texto2);
        final Button back = (Button)findViewById(R.id.back);

        //Creamos el bundle de recogida
        Bundle bundle = getIntent().getExtras();

        //Recogemos el objeto del bundle
        Texto textoMostrar = (Texto)bundle.getSerializable("Text");

        textView.setText(textoMostrar.texto);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Boton atras
                Intent intent = new Intent(Pantalla2.this, Pantalla3.class);
                startActivity(intent);
            }
        });



    }
}
