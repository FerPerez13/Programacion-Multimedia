package com.example.mati.ejercicio2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button botonRojo = (Button)findViewById(R.id.BotonRojo);
        final Button botonAmarillo = (Button)findViewById(R.id.BotonAmarillo);
        final Button botonAzul = (Button)findViewById(R.id.BotonAzul);
        final Button botonLimpiar = (Button)findViewById(R.id.BotonLimpiar);
        final TableLayout tableLayout = (TableLayout)findViewById(R.id.TableLayout);

        botonRojo.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                tableLayout.setBackgroundColor(Color.RED);
            }
        });

        botonAmarillo.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                tableLayout.setBackgroundColor(Color.YELLOW);
            }
        });

        botonAzul.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                tableLayout.setBackgroundColor(Color.BLUE);
            }
        });

        botonLimpiar.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                tableLayout.setBackgroundColor(Color.WHITE);
            }
        });

    }
}
