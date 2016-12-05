package com.splash.banana.questionary;

import android.support.annotation.BoolRes;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Preguntas2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas2);
/*
        Bundle miBundle = getIntent().getExtras();
        final Respuestas respuestas2 = (Respuestas)miBundle.getSerializable("Texto1");

        final TextView textView = (TextView)findViewById(R.id.pregunta);
        Boolean marca = respuestas2.getP1();
        textView.setText(marca.toString());
*/
    }
}
