package com.example.mati.ejercicio1;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text = (TextView)findViewById(R.id.fondo);
        final RadioGroup rg = (RadioGroup)findViewById(R.id.RadGroup);
        final Button botonSet = (Button)findViewById(R.id.boton1);
        final Button botonBorrar = (Button)findViewById(R.id.boton2);
        final Context context = this;

        rg.clearCheck();

        //Cuando se pulsa el boton que compruebe el check seleccionado y aplique el color
        botonSet.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rg.getCheckedRadioButtonId() == R.id.button1)
                    text.setBackgroundColor(Color.RED);
                if (rg.getCheckedRadioButtonId() == R.id.button2)
                    text.setBackgroundColor(Color.GREEN);
                if (rg.getCheckedRadioButtonId() == R.id.button3)
                    text.setBackgroundColor(Color.BLUE);
            }
        });

        //Cuando se pulse el boton que elimine el background del TextView
        botonBorrar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                rg.clearCheck();
                //text.setBackgroundColor(Color.WHITE); //Esta línea es poniendo un color definido
                text.setBackgroundColor(ContextCompat.getColor(context, R.color.background)); //Aqui cogemos el color del fondo y lo aplicamos al texto
            }
        });

    }
}
