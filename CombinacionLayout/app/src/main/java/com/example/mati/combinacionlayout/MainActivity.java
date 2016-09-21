package com.example.mati.combinacionlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected Button boton;
    protected TextView miTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton=(Button)findViewById(R.id.boton1);
        miTexto=(TextView)findViewById(R.id.texto1);

        boton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        miTexto.setText("No pasa absolutamente nada, pero has pulsado el botón");
                        //Intent miIntent
                    }
                }
        );

    }
}
