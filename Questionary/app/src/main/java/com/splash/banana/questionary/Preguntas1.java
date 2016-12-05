package com.splash.banana.questionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Preguntas1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas1);

        Bundle miBundle = getIntent().getExtras();
        final Respuestas respuestas = (Respuestas)miBundle.getSerializable("Texto1");

        final CheckBox r1 = (CheckBox) findViewById(R.id.res11);
        final CheckBox r2 = (CheckBox) findViewById(R.id.res12);
        final CheckBox r3 = (CheckBox) findViewById(R.id.res13);
        final CheckBox r4 = (CheckBox) findViewById(R.id.res14);
        final CheckBox r5 = (CheckBox) findViewById(R.id.res15);
        final Button next = (Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r1.isChecked() && r2.isChecked() && r5.isChecked() && !r3.isChecked() && !r4.isChecked()){
                    respuestas.setP1(true);
                    Intent miIntent = new Intent(Preguntas1.this, Preguntas2.class);
                    Bundle miBundle = new Bundle();
                    miBundle.putSerializable("Texto1",respuestas);
                    miIntent.putExtras(miBundle);
                    startActivityForResult(miIntent,0);
                }else{
                    respuestas.setP1(false);
                    Intent miIntent = new Intent(Preguntas1.this, Preguntas2.class);
                    Bundle miBundle = new Bundle();
                    miBundle.putSerializable("Texto1",respuestas);
                    miIntent.putExtras(miBundle);
                    startActivityForResult(miIntent,0);
                }
            }
        });

    }
}
