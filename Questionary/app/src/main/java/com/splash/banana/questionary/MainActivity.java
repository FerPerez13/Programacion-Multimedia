package com.splash.banana.questionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Respuestas respuestas = new Respuestas();

        final Button boton1 = (Button) findViewById(R.id.pregunta);
        final TextView textoPrueba = (TextView) findViewById(R.id.textoPrueba);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoPrueba.setText("Pulsado el boton 1");
                Intent miIntent = new Intent(MainActivity.this, Preguntas1.class);
                Bundle miBundle = new Bundle();
                miBundle.putSerializable("Texto1",respuestas);
                miIntent.putExtras(miBundle);
                startActivityForResult(miIntent,0);
            }
        });


    }
}
