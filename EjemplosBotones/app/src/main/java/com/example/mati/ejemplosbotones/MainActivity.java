package com.example.mati.ejemplosbotones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text = (TextView)findViewById(R.id.text);
        final Button boton1 = (Button)findViewById(R.id.boton1);
        final ToggleButton boton2 = (ToggleButton)findViewById(R.id.boton2);
        final ImageButton boton3 = (ImageButton)findViewById(R.id.boton3);
        final ToggleButton boton4 = (ToggleButton)findViewById(R.id.boton4);

        boton1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                text.setText("Boton1 Pulsado");
            }
        });

        boton2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (boton2.isChecked())
                    text.setText("Boton2 ON");
                else
                    text.setText("Boton2 OFF");
            }
        });

        boton3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                text.setText("Boton3 Pulsado");
            }
        });

        boton4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (boton4.isChecked())
                    text.setText("Boton4 ON");
                else
                    text.setText("Boton4 OFF");
            }
        });
    }
}
